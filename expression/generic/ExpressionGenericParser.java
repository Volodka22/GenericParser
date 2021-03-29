package expression.generic;


import expression.parser.PriorityConst;
import expression.exceptions.*;
import expression.generic.genericOperator.*;
import expression.parser.BaseParser;
import expression.parser.CharSource;
import expression.parser.StringSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class ExpressionGenericParser<T> {
    public GenericModifyExpression<T> parse(final String source) {
        return new Parser<T>(new StringSource(source)).parseExpression();
    }


    private static class Parser<T> extends BaseParser {

        private String lastOp = "";
        private PriorityConst priorityLastOp = null;
        private final List<PriorityConst> priorityList = Arrays.asList(PriorityConst.values());

        List<String> variableName = List.of("x", "y", "z");
        List<Character> simpleBinaryOperators = List.of('+', '-', '*', '/');
        List<String> binaryOperators = List.of("lcm", "gcd", "mod");

        Map<String, PriorityConst> priorityFromString = Map.of(
                "+", PriorityConst.ADD,
                "-", PriorityConst.ADD,
                "*", PriorityConst.MUL,
                "/", PriorityConst.MUL,
                "mod", PriorityConst.MUL,
                "^", PriorityConst.XOR,
                "&", PriorityConst.AND,
                "|", PriorityConst.OR,
                "gcd", PriorityConst.GCD,
                "lcm", PriorityConst.GCD
        );

        public Parser(final CharSource source) {
            super(source);
            nextChar();
        }

        public GenericModifyExpression<T> parseExpression() {
            GenericModifyExpression<T> expression = parse(0);
            skipWhitespace();
            if (!eof()) {
                throw new UnexpectedSymbolException(getPosition(), "EOF", ch);
            }
            return expression;
        }

        private GenericModifyExpression<T> parse(int priority) {
            skipWhitespace();
            if (priority == priorityList.size()) {
                return parseNext();
            }
            GenericModifyExpression<T> current = parseNext();
            for (int i = priorityList.size() - 1; i >= priority; i--) {
                while (priorityLastOp == priorityList.get(i)) {
                    current = buildBinaryOperation(lastOp, current, parse(i + 1));
                }
            }
            return current;
        }

        private GenericModifyExpression<T> parseUnaryOperation() {
            skipWhitespace();
            if (test('-')) {
                if (isDigit()) {
                    return parseNumber(true);
                }
                return new GenericNegate<>(parseNext());
            } else if(test("abs")) {
                return new GenericAbs<>(parseNext());
            } else if (test("square")) {
                return new GenericSquare<>(parseNext());
            }
            return null;
        }

        private GenericModifyExpression<T> buildBinaryOperation(String op, GenericModifyExpression<T> a, GenericModifyExpression<T> b) {
            switch (op) {
                case "+":
                    return new GenericAdd<>(a, b);
                case "/":
                    return new GenericDivide<>(a, b);
                case "*":
                    return new GenericMultiply<>(a, b);
                case "-":
                    return new GenericSubtract<>(a, b);
                case "mod":
                    return new GenericMod<>(a, b);
                default:
                    throw new OperationNotFoundException();
            }
        }

        private void parseNextBinaryOperation() {
            skipWhitespace();
            for (char i : simpleBinaryOperators) {
                if (test(i)) {
                    lastOp = String.valueOf(i);
                    priorityLastOp = priorityFromString.get(lastOp);
                    return;
                }
            }
            for (String i : binaryOperators) {
                if (test(i)) {
                    lastOp = i;
                    priorityLastOp = priorityFromString.get(lastOp);
                    return;
                }
            }
            throw new OperationNotFoundException();
        }

        private GenericModifyExpression<T> parseNext() {
            skipWhitespace();
            GenericModifyExpression<T> unaryOperation = parseUnaryOperation();
            if (unaryOperation != null) {
                return unaryOperation;
            } else if (test('(')) {
                GenericModifyExpression<T> parseExpression = parse(0);
                skipWhitespace();
                expect(')');
                readOperation();
                return parseExpression;
            } else if (isDigit()) {
                return parseNumber(false);
            } else if (isChar()) {
                return parseVariable();
            } else {
                throw new UnexpectedSymbolException(getPosition(), "Variable, number, '(' or unary operator", ch);
            }
        }

        private boolean isChar() {
            return between('a', 'z') || between('A', 'Z');
        }

        private boolean isDigit() {
            return between('0', '9');
        }

        private void readOperation() {
            skipWhitespace();
            if (eof()) {
                priorityLastOp = null;
                lastOp = "";
                return;
            }
            if (ch == ')') {
                priorityLastOp = null;
                lastOp = "";
                return;
            }
            parseNextBinaryOperation();
        }

        private GenericModifyExpression<T> parseVariable() {
            skipWhitespace();
            final StringBuilder sb = new StringBuilder();
            while (isChar()) {
                sb.append(ch);
                nextChar();
            }

            if (!variableName.contains(sb.toString())) {
                throw new UnsupportedVariableNameException(getPosition());
            }
            readOperation();
            return new GenericVariable<>(sb.toString());
        }

        private GenericModifyExpression<T> parseNumber(boolean isNegative) {
            skipWhitespace();
            final StringBuilder sb = new StringBuilder();
            if (isNegative) sb.append("-");
            copyInteger(sb);
            readOperation();
            try {
                return new GenericConst<>(sb.toString());
            } catch (NumberFormatException e) {
                throw new VeryBigNumberException(getPosition());
            }
        }

        private void copyDigits(final StringBuilder sb) {
            while (isDigit()) {
                sb.append(ch);
                nextChar();
            }
        }

        private void copyInteger(final StringBuilder sb) {
            if (test('0')) {
                sb.append('0');
            } else if (between('1', '9')) {
                copyDigits(sb);
            }
        }
    }
}