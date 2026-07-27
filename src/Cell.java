public class Cell {
    private boolean mine;
    private boolean selected;
    private int mineCount;

    // Constructor creates an empty cell
    public Cell() {
        mine = false;
        selected = false;
        mineCount = 0;
    }

    // Check if this cell has a mine
    public boolean isMine() {
        return mine;
    }

    // Set mine status
    public void setMine(boolean mine) {
        this.mine = mine;
    }

    // Check if this cell is selected
    public boolean isSelected() {
        return selected;
    }

    // Reveal this cell
    public void select() {
        selected = true;
    }

    // Get surrounding mine count
    public int getMineCount() {
        return mineCount;
    }

    // Set surrounding mine count
    public void setMineCount(int count) {
        mineCount = count;
    }
}