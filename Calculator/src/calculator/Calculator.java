package calculator;

public class Calculator {

    public static String calc(ExpressionDTO expression) throws CustomException {
        int res = switch (expression.operator) {
            case "+" -> expression.firstOperand + expression.secondOperand;
            case "-" -> expression.firstOperand - expression.secondOperand;
            case "*" -> expression.firstOperand * expression.secondOperand;
            case "/" -> (int) (expression.firstOperand / expression.secondOperand);
            default -> 0;
        };
        if (expression.type == TypeOfExpression.ARABIC) {
            return Integer.toString(res);
        } else if (res <= 0) {

            throw new CustomException("Результат меньше нуля. Римские цифры не могут быть отрицательными или равны нулю");
        } else {
            return Converter.arabicToRoman(res);
        }
    }
}
