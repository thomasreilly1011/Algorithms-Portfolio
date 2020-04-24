package lab7_Pattern_Search;

import java.util.Random;

public class Benchmark {
    public static String generateRandomString(int N) {
        int leftLimit = 65; // letter 'A'
        int rightLimit = 66; // letter 'B'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(N)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        int N = 100;
        int M = 2;
        String txt, pat;
        long start, timeTaken;

        while (N < 1000000) {
            txt = generateRandomString(N);
            pat = generateRandomString(M);

            start = System.nanoTime();
            BruteForceSearch.search(txt, pat);
            timeTaken = System.nanoTime() - start;
            System.out.println("Time taken for Brute Force:\t" + timeTaken + " nano seconds");


            start = System.nanoTime();
            KMPSearch.search(txt, pat);
            timeTaken = System.nanoTime() - start;
            System.out.println("Time taken for KMP Search:\t" + timeTaken + " nano seconds");

            M*=2;
            N*=10;
        }
    }
}
