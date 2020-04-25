package lab3_Recursion;

public class Hanoi {

    /**
     * A recursive algorithm that computes and prints the instructions to solving the Towers of Hanoi Puzzle.
     * @param disk The number of disks in the puzzle
     * @param source The original pile that the tower is on.
     * @param dest The destination pile that the tower should be moved to.
     * @param auxiliary The spare pile that is used as an intermediate for moving disks.
     */
    public static void towersOfHanoi(int disk, char source, char dest, char auxiliary) {
        if (disk == 0) {
            System.out.println("Move from " + source + " to " + dest + ".");
        } else {
            towersOfHanoi(disk-1, source, auxiliary, dest);
            towersOfHanoi(disk-1, auxiliary, dest, source);
        }
    }

    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        towersOfHanoi(100, 'A', 'B', 'C');
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("The time taken for towersOfHanoi was: " + elapsedTime);
    }

}