package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            String output;
            while (!(input = br.readLine().toUpperCase()).equals("ESC")) {
                try {
                    ExpressionDTO expr = ExpressionParser.parse(input);
                    output = Calculator.calc(expr);
                    System.out.println("Результат: " + output);
                    System.out.println("Введите арифмитическое выражение n или тип \"ESC<CR>\" чтобы закончить программу");
                } catch (CustomException e) {
                    System.out.println(e.toString());
                    System.out.println("Попробуйте снова");
                }
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
