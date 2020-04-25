package lab7_Pattern_Search;

import java.util.Random;

public class Benchmark {

    /** The starting text size for the benchmark series */
    private final static int N = 100;
    /** The starting pattern size for the benchmark series */
    private final static int M = 4;
    /** The ending text size for the benchmark series */
    private final static int LIMIT_OF_N = 100000;
    /** The factor that the text size should be incremented by for each benchmark */
    private final static double FACTOR_OF_N = 1.3;
    /** The amount that the pattern size should be incremented by for each benchmark */
    private final static double ADDITION_OF_M = 0;

    /**
     * Performs a series of BenchMarks on the sorting algorithms available in the {@code QuickSort} and {@code EnhancedQuickSort} class of this package.
     * Benchmarks record the time taken to sort arrays of size {@code N} up to {@code M} incremented at a factor of {@code FACTOR_OF_N}
     * @param args No arguments necessary.
     */
    public static void main(String[] args) {
        long n = N;
        long m = M;
        String txt, pat;
        long start, timeTaken;

        while (n < LIMIT_OF_N) {
            txt = generateRandomString(n);
            pat = generateRandomString(m);
            System.out.println("\nSearch Text Size: " + n + ", Pattern Size: " + m);

            System.out.print("(BF) ");
            start = System.nanoTime();
            BruteForceSearch.search(txt, pat);
            timeTaken = System.nanoTime() - start;
            System.out.println("Time Taken: " + timeTaken + "ns ");

            System.out.print("(KMP)");
            start = System.nanoTime();
            KMPSearch.search(txt, pat);
            timeTaken = System.nanoTime() - start;
            System.out.println("Time Taken: " + timeTaken + "ns");

            n*=FACTOR_OF_N;
            m+= ADDITION_OF_M;
        }
    }

    /**
     * Generates a string of random characters of length N.
     * The right and left limits of characters generated can be adjusted internally.
     * @param N Length of desired string
     * @return Randomly generated string of characters of lenth N.
     */
    public static String generateRandomString(long N) {
        int leftLimit = 65; // letter 'A'
        int rightLimit = 67; // letter 'B'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(N)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
