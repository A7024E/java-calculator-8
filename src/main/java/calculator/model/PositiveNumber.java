package calculator.model;

public class PositiveNumber {

    private final long number;
    private static final long MIN_POSITIVE_NUMBER = 1L;
    private static final String INVALID_NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "숫자는 양수만 입력 가능합니다";

    private PositiveNumber(long number) {
        validatePositiveNumber(number);
        this.number = number;
    }

    public static PositiveNumber of(long number) {
        return new PositiveNumber(number);
    }

    private void validatePositiveNumber(long number) {
        if (isPositiveNumberRange(number)) {
            throw new IllegalArgumentException(INVALID_NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private boolean isPositiveNumberRange(long number) {
        return number < MIN_POSITIVE_NUMBER;
    }

    public long sumNumbers(long sum) {
        return sum + number;
    }
}
