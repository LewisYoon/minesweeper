import java.util.Scanner;

public class Game {

    // intialise game board size of 10
    private GameBoard board = new GameBoard(10);
    private Scanner scanner = new Scanner(System.in);

    // Start the game loop
    public void start() {
        while (true) {
            board.displayBoard();
            // Get coordinate input from user
            System.out.print("Enter coordinate (row column): ");
            int i = scanner.nextInt() - 1;
            int j = scanner.nextInt() - 1;
            if (!board.selectCell(i, j)) {
                board.displayBoard();
                System.out.println("Boom!");
                break;

            }
        }
    }
}