package calculator.model;

public class PositiveNumber {

    private final int number;
    private static final int MIN_POSITIVE_NUMBER = 1;
    private static final String INVALID_NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "숫자는 양수만 입력 가능합니다";

    private PositiveNumber(int number) {
        validatePositiveNumber(number);
        this.number = number;
    }

    public static PositiveNumber of(int number) {
        return new PositiveNumber(number);
    }

    private void validatePositiveNumber(int number) {
        if (isPositiveNumberRange(number)) {
            throw new IllegalArgumentException(INVALID_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private boolean isPositiveNumberRange(int number) {
        return number < MIN_POSITIVE_NUMBER;
    }

    public int sumNumbers(int sum) {
        return sum + number;
    }
}
