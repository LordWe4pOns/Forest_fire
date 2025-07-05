package controller;

import model.*;
import view.*;

public class MainController {
    public boolean isRunning;
    private final double spreadingProbability;

    private final Forest model;
    private final TextView view;

    public MainController(int width, int height, double spreadingProbability, int[][] burningTreesCoords) {
        this.isRunning = true;
        this.spreadingProbability = spreadingProbability;

        this.model = new Forest(height, width);
        this.view = new TextView();

        for (int[] burningTreeCoords : burningTreesCoords) {
            this.model.igniteTree(burningTreeCoords[0], burningTreeCoords[1]);
        }

        this.print();
    }

    private void print() {
        String[][] forest = new String[model.WIDTH][model.HEIGHT];
        for (Tree[] treeLine : this.model.trees) {
            for (Tree tree : treeLine) {
                forest[tree.x][tree.y] = tree.toString();
            }
        }
        this.view.printForest(forest);
    }

    public void run() {
        this.model.spread(spreadingProbability);
        System.out.println(this.model.burningTrees);
        this.print();
        this.isRunning = this.model.hasBurningTrees();
    }
}
