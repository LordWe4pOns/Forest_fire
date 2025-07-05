package view;

public class TextView {
    public void printForest(String[][] forest) {
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[i].length; j++) {
                System.out.print("|" + forest[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("\n\n\n");
    }
}
