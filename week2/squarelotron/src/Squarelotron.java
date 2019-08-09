public class Squarelotron {
    //instance variables
    int[][] squarelotron;
    int size;

    //custom constructor
    public Squarelotron(int n) {
        size = n;
        squarelotron = new int[size][size];

        int counter = 1;
        if (size <= 0) {
            //don't do anything because there's nothing to rotate
        } else { //build the array filling each element with the numbers 1 to n
            System.out.println("Original array is: ");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    squarelotron[i][j] = counter;
                    counter++;
                    System.out.print(squarelotron[i][j]);
                }
                System.out.println();
            }
        }
    }

    //default constructor
    public Squarelotron() {}

    //methods
//    public Squarelotron upsideDownFlip(int ring) {
//        Squarelotron squarelotron = new Squarelotron(size); //create a new squarlotron instead of modifying the original
//
//    }
//
//    public Squarelotron mainDiagonalFlip(int ring) {
//
//    }

    public void rotateRight(int numberOfTurns) {
        int[][] tempArray = new int[size][size];
        while (numberOfTurns > 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    tempArray[i][j] = squarelotron[size - j - 1][i];
                }
            }
            numberOfTurns--;
        }
        squarelotron = tempArray;
    }

    public static void main(String[] args) {
        Squarelotron squarelotron = new Squarelotron(4);
        squarelotron.rotateRight(1);

    }
}
