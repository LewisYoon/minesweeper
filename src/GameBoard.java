public class GameBoard {
    private int size;

    // Constructor for board size
    public GameBoard(int size) {
        this.size = size;

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
}