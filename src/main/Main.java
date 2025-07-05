package main;

import controller.MainController;

public class Main {
    public static void main(String[] args) {
        Parameters parameters = new Parameters();
        MainController controller = new MainController(parameters.width, parameters.height, parameters.spreadingProbability);

        while (controller.isRunning) {
            controller.run();
        }
    }
}