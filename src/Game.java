import java.util.Scanner;

public class Game {

    // intialise game board size of 10
    private GameBoard board = new GameBoard(10);
    private Scanner scanner = new Scanner(System.in);

    // Start the game loop
    public void start() {
        while (true) {
            board.displayBoard();
            // get the user input for row and column
            System.out.print("Enter a row: ");
            int row = scanner.nextInt();
            System.out.print("Enter a column: ");
            int col = scanner.nextInt();
            board.selectCell(row, col);
        }
    }
}