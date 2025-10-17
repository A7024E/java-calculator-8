package calculator.utils;

import calculator.model.PositiveNumber;

public class Calculator {
    private static final int ZERO_VALUE = 0;
    private static final String DELIMITER_INPUT_ERROR_MESSAGE = "커스텀 구분자 및 기본 구분자를 정확하게 확인 후 다시 입력해 주세요";
    private static final String INVALID_WHITESPACE_EXCEPTION_MESSAGE = "공백을 포함할 순 없습니다.";
    private static final String BLANK_VALUE =" ";

    public static int splitSumCalculator(String input) {
        if (isNull(input) || isEmpty(input)) {
            return ZERO_VALUE;
        }
        validateCalculator(input);
        return calculateSum(Separator.splitByDelimiter(input));
    }

    private static void validateCalculator(String input) {
        if (isBlankContains(input)) {
            throw new IllegalArgumentException(INVALID_WHITESPACE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isBlankContains(String input) {
        return input.contains(BLANK_VALUE);
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static int calculateSum(String[] splitInput) {
        int sum = ZERO_VALUE;
        for (String input : splitInput) {
            PositiveNumber positiveNumber = PositiveNumber.of(convertNumeric(input));
            sum = positiveNumber.sumNumbers(sum);
        }
        return sum;
    }

    private static int convertNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(DELIMITER_INPUT_ERROR_MESSAGE);
        }
    }
}
