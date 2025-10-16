package calculator.Controller;

import calculator.utils.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculateController {
    private final InputView inputView;
    public final OutputView outputView;

    public CalculateController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run(){
        processCalculation(insertInputs());
    }

    private void processCalculation(String input) {
        outputView.printSumResult(calculateSum(input));
    }

    private String insertInputs() {
        return inputView.inputStrings();
    }

    private int calculateSum(String input) {
        return Calculator.splitSumCalculator(input);
    }
}
