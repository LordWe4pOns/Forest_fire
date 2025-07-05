package model;

import java.util.ArrayList;
import java.util.Random;

public class Forest {
    public final int HEIGHT;
    public final int WIDTH;
	public final Tree[][] trees;
    public final ArrayList<Tree> burningTrees;


    public Forest(int height, int width) {
        this.HEIGHT = height;
        this.WIDTH = width;
        this.trees = new Tree[width][height];
        this.burningTrees = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.trees[i][j] = new Tree(i, j);
            }
        }
    }

    public Tree getTree(int x, int y) {
        return this.trees[x][y];
    }

    private void igniteTree(int x, int y) {
        Tree newBurningTree = this.getTree(x, y);
        newBurningTree.ignite();
        this.burningTrees.add(newBurningTree);
    }

    private void extinguishTree(Tree tree) {
        tree.extinguish();
        this.burningTrees.remove(tree);
    }

    private void spreadUp(Tree tree, float probability) {
        Random rand = new Random();
        final int newBurningTreeX = tree.x;
        final int newBurningTreeY = tree.y + 1;
        if (newBurningTreeY < this.HEIGHT && rand.nextFloat() - probability <= 0.0) {
            this.igniteTree(newBurningTreeX, newBurningTreeY);
        }
    }

    private void spreadDown(Tree tree, float probability) {
        Random rand = new Random();
        final int newBurningTreeX = tree.x;
        final int newBurningTreeY = tree.y - 1;
        if (newBurningTreeY >= 0 && rand.nextFloat() - probability <= 0.0) {
            this.igniteTree(newBurningTreeX, newBurningTreeY);
        }
    }

    private void spreadLeft(Tree tree, float probability) {
        Random rand = new Random();
        final int newBurningTreeX = tree.x - 1;
        final int newBurningTreeY = tree.y;
        if (newBurningTreeX >= 0 && rand.nextFloat() - probability <= 0.0) {
            this.igniteTree(newBurningTreeX, newBurningTreeY);
        }
    }

    private void spreadRight(Tree tree, float probability) {
        Random rand = new Random();
        final int newBurningTreeX = tree.x + 1;
        final int newBurningTreeY = tree.y;
        if (newBurningTreeX < this.WIDTH && rand.nextFloat() - probability <= 0.0) {
            this.igniteTree(newBurningTreeX, newBurningTreeY);
        }
    }

    public void spreadLocally(Tree tree, float probability) {
        if (tree.isBurning()) {
            this.spreadUp(tree, probability);
            this.spreadDown(tree, probability);
            this.spreadLeft(tree, probability);
            this.spreadRight(tree, probability);
            this.extinguishTree(tree);
        }
    }

    public void spread(float probability) {
        for (Tree tree : burningTrees) {
            this.spreadLocally(tree, probability);
        }
    }
}
