package calculator.utils;

import calculator.model.PositiveNumber;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public static int splitCalculator(String input) {
        if(isNull(input) || isEmpty(input)){
            return 0;
        }
        return calculateSum(Separator.splitByDelimiter(input));
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
