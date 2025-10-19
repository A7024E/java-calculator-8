package calculator.model;

public class PositiveNumber {

    private final long number;
    private static final long MIN_POSITIVE_NUMBER = 1L;
    private static final String INVALID_NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "숫자는 양수만 입력 가능합니다";
    private static final String CALCULATION_OVERFLOW_ERROR_MESSAGE = "계산의 범위를 초과하였습니다.";

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
        validateOverFlow(sum);
        return sum + number;
    }

    private void validateOverFlow(long sum) {
        if (isAdditionOverflow(sum)) {
            throw new IllegalArgumentException(CALCULATION_OVERFLOW_ERROR_MESSAGE);
        }
    }

    private boolean isAdditionOverflow(long sum) {
        return sum > calculateWithoutOverflow();
    }

    private long calculateWithoutOverflow() {
        return Long.MAX_VALUE - number;
    }

}
