public class GameBoard {
    private int size;
    private Cell[][] cells;

    // Constructor for board size
    public GameBoard(int size) {
        this.size = size;
        createCells();
    }

    // Get board size
    public int getSize() {
        return size;
    }

    // Get cell from board
    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    // Display the current game board
    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            printBorder();
            for (int j = 0; j < size; j++) {
                // Get the current cell from the board using row and column index
                Cell cell = cells[i][j];
                // if cell hasnt selected, hide content
                if (!cell.isSelected()) {
                    System.out.print("|   ");
                    // if selected && has mine print *
                } else if (cell.hasMine()) {
                    System.out.print("| * ");
                } else {
                    // if selected && no mines, shows count of neighbor mines
                    System.out.print("| " + cell.getMineCount() + " ");
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

    // Select a cell
    public boolean selectCell(int i, int j) {
        Cell cell = cells[i][j];
        cell.select();

        // check if selected cell has mine
        if (cell.hasMine()) {
            return false;
        }

        return true;
    }

    // Check winning condition
    public boolean hasWon() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = cells[i][j];
                if (!cell.hasMine() && !cell.isSelected()) {
                    return false;
                }
            }
        }
        return true;
    }
}