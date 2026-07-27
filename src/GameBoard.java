public class GameBoard {
    private int size;
    private Cell[][] cells;

    // Constructor for board size
    public GameBoard(int size) {
        this.size = size;
        createCells();

    }

    // Display the current game board
    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            printBorder();
            for (int j = 0; j < size; j++) {
                // Empty cell placeholder
                System.out.print("| x ");
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

}