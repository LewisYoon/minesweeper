import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private GameBoard board;
    private Scanner scanner;

    // Constructor creates game
    public Game() {
        scanner = new Scanner(System.in);
    }

    // Start game loop
    public void start() {
        setupGame();
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

    // Setup game configuration from user input
    private void setupGame() {
        int size;
        int mines;

        while (true) {
            try {
                System.out.print("Enter board size (e.g 5 = 5x5 grid): ");
                size = scanner.nextInt();

                System.out.print("Enter number of mines: ");
                mines = scanner.nextInt();

                if (size <= 0) {
                    System.out.println("Board size must be greater than 0.");
                    continue;
                }

                if (mines <= 0 || mines >= size * size) {
                    System.out.println("Mine count must be greater than 0 and less than total cells.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter numbers only.");
                scanner.nextLine();
            }
        }
        board = new GameBoard(size);
        Mine mine = new Mine(board, mines);
        mine.placeMine();
        mine.calculateMineCount();
    }

    // Check if coordinate is inside the board
    private boolean checkCoordinate(int i, int j) {
        int size = board.getSize();
        return i >= 0 && i < size && j >= 0 && j < size;
    }
}