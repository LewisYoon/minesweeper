import java.util.Random;

public class GameBoard {
    private int size;
    private Cell[][] cells;
    private int mineTotal;

    // Constructor for board size
    public GameBoard(int size) {
        this.size = size;
        this.mineTotal = 10;
        createCells();
        placeMine();
        displayMineCount();
    }

    // Display the current game board
    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            printBorder();
            for (int j = 0; j < size; j++) {
                // Empty cell placeholder
                if (cells[i][j].isMine()) {
                    System.out.print("| * ");
                } else {
                    System.out.print("| " + cells[i][j].getMineCount() + " ");
                }
            }
            System.out.println("|");
        }
        printBorder();
    }

    // Print horizontal border line
    private void printBorder() {
        System.out.print("+");

        for (int i = 0; i < size; i++) {
            System.out.print("---+");
        }

        System.out.println();
    }

    // Create Cell objects for every position
    private void createCells() {
        cells = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    // Randomly place mines on the board
    private void placeMine() {
        Random random = new Random();
        int placedMine = 0;
        // get random i(row) j(column) coordinates to place mine using while loop
        while (placedMine < mineTotal) {
            int i = random.nextInt(size);
            int j = random.nextInt(size);

            Cell cell = cells[i][j];

            // check if mine is already placed on that cell
            if (!cell.isMine()) {
                cell.setMine(true);
                placedMine++;
            }
        }
    }

    // Calculate surrounding mine count for every cell
    private void displayMineCount() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Skip mine cells
                if (cells[i][j].isMine()) {
                    continue;
                }
                int count = countNeighborMines(i, j);
                cells[i][j].setMineCount(count);
            }
        }
    }

    // Count mines around a specific cell
    private int countNeighborMines(int row, int col) {
        int count = 0;

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
                if (cells[i][j].isMine()) {
                    count++;
                }
            }
        }

        return count;
    }

    // Select a cell
    public void selectCell(int row, int col) {
        cells[row][col].select();
    }
}