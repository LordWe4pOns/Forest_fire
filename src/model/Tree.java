package model;

enum TreeState {
    ALIVE,
    BURNING,
    ASHES,
}

public class Tree {
    public final int x;
    public final int y;
    private TreeState state;
    

    public Tree (int x, int y) {
        this.x = x;
        this.y = y;
        this.state = TreeState.ALIVE;
    }


    public boolean isAlive() {
        return this.state.equals(TreeState.ALIVE);
    }

    public boolean isBurning() {
        return this.state.equals(TreeState.BURNING);
    }

    public boolean isAshes() {
        return this.state.equals(TreeState.ASHES);
    }

    public void ignite() {
        if (this.isAlive()) {
            this.state = TreeState.BURNING;
        }
    }

    public void extinguish() {
        if (this.isBurning()) {
            this.state = TreeState.ASHES;
        }
    }

    @Override
    public String toString() {
        switch (this.state) {
            case ALIVE:
                return "T";
            case BURNING:
                return "X";
            case ASHES:
                return "_";
            default:
                return "";
        }
    }
}
