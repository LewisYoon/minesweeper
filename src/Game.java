import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private GameBoard board;
    private Scanner scanner;

    // Constructor creates game
    public Game() {
        board = new GameBoard(10);
        scanner = new Scanner(System.in);
        Mine mine = new Mine(board, 10);
        mine.placeMine();
        mine.calculateMineCount();
    }

    // Start game loop
    public void start() {
        while (true) {
            board.displayBoard();
            int i;
            int j;
            System.out.print("Enter coordinate (row column): ");
            try {
                i = scanner.nextInt() - 1;
                j = scanner.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("Please enter numbers only.");
                scanner.nextLine();
                continue;
            }
            if (!checkCoordinate(i, j)) {
                System.out.println("Invalid coordinate. Please enter between 1 and " + board.getSize());
                continue;
            }
            if (board.selectCell(i, j)) {
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

    // Check if coordinate is inside the board
    private boolean checkCoordinate(int i, int j) {
        int size = board.getSize();
        return i >= 0 && i < size && j >= 0 && j < size;
    }

}