import java.util.Random;

public class Mine {
    private GameBoard board;
    private int mineTotal;

    // Constructor for mine generator
    public Mine(GameBoard board, int mineTotal) {
        this.board = board;
        this.mineTotal = mineTotal;
    }

    // Randomly place mines on the board
    public void placeMine() {
        Random random = new Random();
        int size = board.getSize();
        int placedMine = 0;
        // get random i(row) j(column) coordinates to place mine using while loop
        while (placedMine < mineTotal) {
            int i = random.nextInt(size);
            int j = random.nextInt(size);
            Cell cell = board.getCell(i, j);
            // check if mine is already placed on that cell
            if (!cell.hasMine()) {
                cell.setMine(true);
                placedMine++;
            }
        }
    }

    // Calculate surrounding mine count for every cell
    public void calculateMineCount() {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Skip mine cells
                if (board.getCell(i, j).hasMine()) {
                    continue;
                }
                int count = countNeighborMines(i, j);
                board.getCell(i, j).setMineCount(count);
            }
        }
    }

    // Count mines around a specific cell
    private int countNeighborMines(int row, int col) {
        int count = 0;
        int size = board.getSize();
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                // Skip cells outside the board
                if (i < 0 || i >= size || j < 0 || j >= size) {
                    continue;
                }
                // Skip the current cell
                if (i == row && j == col) {
                    continue;
                }
                if (board.getCell(i, j).hasMine()) {
                    count++;
                }
            }
        }
        return count;
    }
}