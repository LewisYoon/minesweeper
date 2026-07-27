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
                    System.out.print("|   ");
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
}