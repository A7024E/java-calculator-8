package calculator;

import calculator.Controller.CalculateController;
import calculator.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        CalculateController  calculateController = new CalculateController();
        calculateController.run();

    }
}
