
/**
 * A squarelotron is a two dimensional array.
 * You can manipulate the array by rotating every element in the array
 * or by rotating specific rings in the array
 */

public class Squarelotron {
    int[][] squarelotron;
    int size;

    /*
     * Fill the two dimensional array with numbers from 1 to n
     * Set the size instance variable equal to n
     */
    public Squarelotron(int n) {
        size = n;
        squarelotron = new int[size][size];

        int counter = 1;
        if (size <= 0) {
            //don't do anything because there's nothing to rotate
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    squarelotron[i][j] = counter;
                    counter++;
                }
            }
        }
    }

    // Default constructor
    public Squarelotron() {}

    /*
     * A helper method to determine if a square is inside the given ring
     */
    public boolean isOnRing(int i, int j, int ring) {
        boolean isOn = (i == ring - 1 || j == ring - 1 || i == size - ring || j == size - ring);
        boolean isOut = (i <= ring - 2 || j <= ring - 2 || i > size - ring || j > size - ring);
        return isOn && !isOut;
    }

    /*
     * This method performs the Upside-Down Flip of the squarelotron and returns the new squarelotron.
     * The original squarelotron should not be modified.
     */
    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron newSquarelotron = new Squarelotron(size);

        if (ring > size / 2) { // Handle the case when ring is > the number of rings in the squarlotron
            return newSquarelotron;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isOnRing(i, j, ring)) {
                    newSquarelotron.squarelotron[i][j] = squarelotron[size - i - 1][j]; // Flip the squarlotron
                }
            }
        }
        return newSquarelotron;
    }

    /*
     * This method performs the Main Diagonal Flip of the squarelotron and returns the new squarelotron.
     * The original squarelotron should not be modified.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron newSquarlotron = new Squarelotron(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isOnRing(i, j, ring)) {
                    newSquarlotron.squarelotron[i][j] = squarelotron[j][i];
                }
            }
        }
        return newSquarlotron;
    }

    /*
     * The argument numberOfTurns indicates the number of times the entire squarelotron should be rotated 90° clockwise.
     * Any integer, including zero and negative integers, is allowable as the argument. A value of -1 indicates a 90°
     * counterclockwise rotation.
     * This method modifies the internal representation of the squarelotron; it does not create a new squarelotron.
     */
    public void rotateRight(int numberOfTurns) {

        numberOfTurns = Math.abs(numberOfTurns % 4); // Handle counterclockwise turns

        while (numberOfTurns > 0) {
            Squarelotron newSquarelotron = new Squarelotron(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    newSquarelotron.squarelotron[i][j] = squarelotron[size - j - 1][i];
                }
            }
            numberOfTurns--;
            squarelotron = newSquarelotron.squarelotron;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Squarelotron rotateRight = new Squarelotron(n);
        rotateRight.rotateRight(1);

        for (int i = 0; i < n; i++) { // Test the rotate right method
            for (int j = 0; j < n; j++) {
                System.out.print(rotateRight.squarelotron[i][j]);
            }
            System.out.println();
        }

    }
}
