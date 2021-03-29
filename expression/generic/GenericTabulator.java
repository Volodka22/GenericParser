package expression.generic;

import expression.exceptions.EvaluateException;
import expression.exceptions.ParseException;
import expression.generic.genericOperator.GenericModifyExpression;
import expression.generic.genericType.*;

import java.util.Map;

public class GenericTabulator implements Tabulator {
    private final static Map<String, BaseOperations<?>> TYPE = Map.of(
            "i", new CheckedInteger(),
            "d", new UncheckedDouble(),
            "bi", new BigInt(),
            "u", new UncheckedInteger(),
            "p", new ModInteger(),
            "b", new UncheckedByte()
    );

    private <T> Object[][][] makeTabulator(BaseOperations<T> operations, String expression, int x1, int x2,
                                           int y1, int y2, int z1, int z2) {
        ExpressionGenericParser<T> parser = new ExpressionGenericParser<>();
        GenericModifyExpression<T> expr = parser.parse(expression);
        Object[][][] ans = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        for (int i = 0; i <= x2 - x1; i++) {
            for (int j = 0; j <= y2 - y1; j++) {
                for (int k = 0; k <= z2 - z1; k++) {
                    try {
                        ans[i][j][k] = expr.evaluate(operations.getValueFromInteger(i + x1),
                                operations.getValueFromInteger(j + y1), operations.getValueFromInteger(k + z1), operations);
                    } catch (EvaluateException e) {
                        ans[i][j][k] = null;
                    } catch (ParseException e) {
                        System.err.println("Incorrect expression");
                    }
                }
            }
        }
        return ans;
    }

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2,
                                 int y1, int y2, int z1, int z2) {
        return makeTabulator(TYPE.get(mode), expression, x1, x2, y1, y2, z1, z2);
    }

}
