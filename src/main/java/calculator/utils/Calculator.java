package calculator.utils;

import calculator.model.PositiveNumber;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public static void main(String[] args) {
        String input =Console.readLine();

        int i = splitCalculator(input);
        System.out.println(i);
    }

    public static int splitCalculator(String input) {
        if(isNull(input) || isEmpty(input)){
            return 0;
        }
        validateCalculator(input);
        return calculateSum(Separator.splitByDelimiter(input));
    }

    private static void validateCalculator(String input) {
        if(input.contains(" ")){
            throw new IllegalArgumentException("공백을 포함할 순 없습니다");
        }
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static int calculateSum(String[] splitInput){
        int sum = 0;
        for (String input : splitInput) {
            PositiveNumber positiveNumber = PositiveNumber.generatePositiveNumber(convertNumeric(input));
            sum = positiveNumber.sumNumbers(sum);
        }
        return sum;
    }

    private static int convertNumeric(String input) {
        return Integer.parseInt(input);
    }

}
