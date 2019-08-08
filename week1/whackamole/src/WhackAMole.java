import java.util.Scanner;

public class WhackAMole {

    // Instance variables
    public int score;
    public int molesLeft;
    public int attemptsLeft;
    public char[][] moleGrid;

    // Constructors
    public WhackAMole(int numAttempts, int gridDimension) {
        attemptsLeft = numAttempts;
        moleGrid = new char[gridDimension][gridDimension];
        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                moleGrid[i][j] = '*';
            }
        }
    }

    public WhackAMole() {
        super();
    }

    // Methods
    public boolean place (int x, int y) {

        // Put a mole at the location of x and y (row and column)
        if (x > 0 && x < moleGrid.length) {
            if (y > 0 && y < moleGrid.length) {
                if (moleGrid[x][y] == '*') {
                    moleGrid[x][y] = 'M';
                    molesLeft++;
                    return true;
                }
                return false;
            }
        }
        return false; // out of bounds
    }

    // Take the users input and take a whack to see if you hit the mole
    public void whack (int x, int y) {

        // Figure out whether the user input matches the location of a mole
        if (moleGrid[x][y] == 'M') {
            moleGrid[x][y] = 'W';
            score++;
            attemptsLeft--;
            molesLeft--;
        } else {
            attemptsLeft--;
        }
        printGridToUser();
    }

    public void printGridToUser() {

        // Print the grid without showing the user where the moles are
        for (int i = 0; i < moleGrid.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < moleGrid.length; j++) {
                if (moleGrid[i][j] != 'W') {
                    System.out.print("*");
                } else {
                    System.out.print(moleGrid[i][j]);
                }
            }
        }
    }

    public void printGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < moleGrid.length; j++) {
                System.out.print(moleGrid[i][j]);
            }
        }
    }

    public static void main(String[] args) {

        // Create a reference to the WhackAMole game and initialize the board
        WhackAMole game = new WhackAMole(50, 10);

        // Place the moles onto the board
        for (int i = 0; i < 10; i++) {
            int row = (int) (Math.random() * 10);
            int col = (int) (Math.random() * 10);
            System.out.format("\nrow: %d, col: %d", row, col);
            game.place(row, col);
        }

        // Get the x and y coordinates from the user for where they want to whack
        Scanner scanner = new Scanner(System.in);
        playGame: while (true) {
            game.printGrid();

            System.out.println("\nYou have " + game.attemptsLeft + " remaining");
            System.out.print("Enter your guess for the row: ");
            int row = scanner.nextInt();

            System.out.print("Enter your guess for the column: ");
            int col = scanner.nextInt();

            game.whack(row, col);

            if (row == -1 && col == -1) { // Check the exit condition
                System.out.println("You have endend the game");
                break playGame;
            } else if (game.molesLeft == 0) { // Check the win condition
                System.out.println("You win!");
                break playGame;
            } else if (game.attemptsLeft == 0) { // Check lose condition
                System.out.println("You lost");
            }
        }

        System.out.println("Game over");
        game.printGrid();
        scanner.close();
    }
}
