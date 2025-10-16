package calculator.utils;

import calculator.model.PositiveNumber;

public class Calculator {

    public static int splitSumCalculator(String input) {
        if (isNull(input) || isEmpty(input)) {
            return 0;
        }
        validateCalculator(input);
        return calculateSum(Separator.splitByDelimiter(input));
    }

    private static void validateCalculator(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백을 포함할 순 없습니다");
        }
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static int calculateSum(String[] splitInput) {
        int sum = 0;
        for (String input : splitInput) {
            PositiveNumber positiveNumber = PositiveNumber.generatePositiveNumber(convertNumeric(input));
            sum = positiveNumber.sumNumbers(sum);
        }
        return sum;
    }

    private static int convertNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("커스텀 구분자 및 기본 구분자를 정확하게 확인 후 다시 입력해 주세요");
        }
    }

}
