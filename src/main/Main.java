package main;

import controller.MainController;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Parameters parameters = new Parameters();

        MainController controller = new MainController(parameters.width, parameters.height, parameters.spreadingProbability, parameters.burningTreesCoords);

        while (controller.isRunning) {
            controller.run();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}