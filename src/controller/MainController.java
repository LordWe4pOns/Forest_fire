package controller;

import model.*;

public class MainController {
    public boolean isRunning;
    private final Forest model;
    private final double spreadingProbability;

    public MainController(int width, int height, double spreadingProbability) {
        this.isRunning = true;
        this.model = new Forest(height, width);
        this.spreadingProbability = spreadingProbability;
    }

    public void run() {
        this.model.spread(spreadingProbability);
        this.isRunning = this.model.hasBurningTrees();
    }
}
