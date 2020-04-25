package lab1_Introduction;

public class RussianPeasants {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
	    System.out.println(russianMultiply(10000, 10000));
	    final long elapsedTime = System.currentTimeMillis() - startTime;
	    System.out.println("The time taken was " + elapsedTime);
    }

    /**
     * Takes two integer values and computes their product using the russian peasants algorithm.
     * @param n First integer value to be multiplied
     * @param m Second integer value to be multiplied
     * @return Product of n and m
     */
    public static int russianMultiply(int n, int m) {
        int accumulator = 0;
        while (n != 0) {
            if(n%2 != 0) {
                accumulator += m;
            }
            n /= 2;
            m *= 2;
        }
        return accumulator;
    }

}
