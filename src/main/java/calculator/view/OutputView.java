package calculator.view;

public class OutputView {
    
    private static final String RESULT_OUTPUT_MESSAGE = "결과 : ";

    public void printSumResult(int result) {
        System.out.println(RESULT_OUTPUT_MESSAGE + result);
    }
}
