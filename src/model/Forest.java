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

    public boolean hasBurningTrees() {
        return !this.burningTrees.isEmpty();
    }

    public void igniteTree(Tree tree) {
        tree.ignite();
        this.burningTrees.add(tree);
    }

    public void igniteTree(int x, int y) {
        Tree newBurningTree = this.getTree(x, y);
        newBurningTree.ignite();
        this.burningTrees.add(newBurningTree);
    }


    private void extinguishTree(Tree tree) {
        tree.extinguish();
        this.burningTrees.remove(tree);
    }

    private void spreadUp(Tree tree, double probability) {
        Random rand = new Random();
        final int newBurningTreeX = tree.x;
        final int newBurningTreeY = tree.y + 1;
        if (newBurningTreeY < this.HEIGHT && rand.nextFloat() - probability <= 0.0) {
            Tree newBurningTree = this.getTree(newBurningTreeX, newBurningTreeY);
            if (newBurningTree.isAlive()) {
                this.igniteTree(newBurningTree);
            }
        }
    }

    private void spreadDown(Tree tree, double probability) {
        Random rand = new Random();
        final int newBurningTreeX = tree.x;
        final int newBurningTreeY = tree.y - 1;
        if (newBurningTreeY >= 0 && rand.nextFloat() - probability <= 0.0) {
            Tree newBurningTree = this.getTree(newBurningTreeX, newBurningTreeY);
            if (newBurningTree.isAlive()) {
                this.igniteTree(newBurningTree);
            }
        }
    }

    private void spreadLeft(Tree tree, double probability) {
        Random rand = new Random();
        final int newBurningTreeX = tree.x - 1;
        final int newBurningTreeY = tree.y;
        if (newBurningTreeX >= 0 && rand.nextFloat() - probability <= 0.0) {
            Tree newBurningTree = this.getTree(newBurningTreeX, newBurningTreeY);
            if (newBurningTree.isAlive()) {
                this.igniteTree(newBurningTree);
            }
        }
    }

    private void spreadRight(Tree tree, double probability) {
        Random rand = new Random();
        final int newBurningTreeX = tree.x + 1;
        final int newBurningTreeY = tree.y;
        if (newBurningTreeX < this.WIDTH && rand.nextFloat() - probability <= 0.0) {
            Tree newBurningTree = this.getTree(newBurningTreeX, newBurningTreeY);
            if (newBurningTree.isAlive()) {
                this.igniteTree(newBurningTree);
            }
        }
    }

    private void spreadLocally(Tree tree, double probability) {
        if (tree.isBurning()) {
            this.spreadUp(tree, probability);
            this.spreadDown(tree, probability);
            this.spreadLeft(tree, probability);
            this.spreadRight(tree, probability);
        }
    }

    public void spread(double probability) {
        final int size = this.burningTrees.size();
        for (int i = 0; i < size; i++) {
            Tree tree = this.burningTrees.get(0);
            this.spreadLocally(tree, probability);
            this.extinguishTree(tree);
        }
    }
}
