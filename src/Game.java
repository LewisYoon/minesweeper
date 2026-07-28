import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    // intialise game board size of 10
    private GameBoard board = new GameBoard(10);
    private Scanner scanner = new Scanner(System.in);

    // Start the game loop
    public void start() {
        while (true) {
            board.displayBoard();
            System.out.print("Enter coordinate (row column): ");

            int i;
            int j;
            // validates user input to only integer using try catch
            try {
                i = scanner.nextInt() - 1;
                j = scanner.nextInt() - 1;

            } catch (InputMismatchException e) {
                System.out.println("Please enter numbers only.");
                scanner.nextLine();
                continue;
            }
            // Check coordinate range
            if (!checkCoordinate(i, j)) {
                System.out.println("Invalid coordinate. Please enter between 1 and " + board.getSize());
                continue;
            }
            if (!board.selectCell(i, j)) {
                board.displayBoard();
                System.out.println("Boom!");
                break;
            }
            if (board.hasWon()) {
                board.displayBoard();
                System.out.println("You Win!");
                break;
            }
        }
    }

    private boolean checkCoordinate(int i, int j) {
        int size = board.getSize();
        return i >= 0 && i < size && j >= 0 && j < size;
    }
}