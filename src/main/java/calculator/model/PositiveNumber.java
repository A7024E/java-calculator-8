package calculator.model;

public class PositiveNumber {

    private final int number;

    private PositiveNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static PositiveNumber generatePositiveNumber(int number) {
        return new PositiveNumber(number);
    }

    private void validateNumber(int number) {
        if(isPositiveNumberRange(number)) {
            throw new IllegalArgumentException("숫자는 양수만 입력 가능합니다");
        }
    }

    private boolean isPositiveNumberRange(int number){
        return number < 0;
    }

}
