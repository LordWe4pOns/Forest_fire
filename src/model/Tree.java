package model;

enum TreeState {
    ALIVE,
    BURNING,
    ASHES,
}

public class Tree {
    private TreeState state;
    

    public Tree () {
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

    public void extinguish() {
        if (this.isBurning()) {
            this.state = TreeState.ASHES;
        }
    }

    public void ignite() {
        if (!this.isAshes()) {
            this.state = TreeState.BURNING;
        }
    }
}
