package lab6_Quick_Sorts;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

public class Benchmark {

    private static final Random random = new Random();

    /** The starting Array size for the benchmark series */
    private final static int N = 10;
    /** The limiting Array size for the benchmark series */
    private final static int M = 100000;
    /** The factor that N should be incremented by for each benchmark */
    private final static double FACTOR_OF_N = 1.5;

    /**
     * Performs a series of BenchMarks on the sorting algorithms available in the {@code QuickSort} and {@code EnhancedQuickSort} class of this package.
     * Benchmarks record the time taken to sort arrays of size {@code N} up to {@code M} incremented at a factor of {@code FACTOR_OF_N}
     * @param args No arguments necessary.
     */
    public static void main(String[] args) {
        int n=N;
        long start, timeTaken;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

        System.out.println("-----------Testing Regular Quick Sort------------");
        System.out.println("1. Array Size | 2. Time Taken | 3. IsSorted?");

        while (n<=M) {
            //Generate a random array of size N
            LinkedList<Integer> arr = random.ints(0, n).distinct().limit(n).boxed()
                    .collect(Collectors.toCollection(LinkedList<Integer>::new));
            Integer[] a = arr.toArray(new Integer[arr.size()]);

            if (n==10) {
                System.out.println("Array Before Sort: " + Arrays.toString(a));
            }

            //Perform and time the sorting algorithm
            start = System.nanoTime();
            QuickSort.sort(a, 0, a.length-1);
            timeTaken = System.nanoTime() - start;

            if (n==10) {
                System.out.println("Array After Sort: " + Arrays.toString(a));
            }

            //Print the results (and test that it is sorted given that n <= 100).
            if (n<=1000) {
                System.out.println(decimalFormat.format(n) + " " + decimalFormat.format(timeTaken)+ "ns " + isSorted(a, a.length));
                if (!isSorted(a, a.length)) {
                    System.out.println(Arrays.toString(a));
                }

            } else {
                System.out.println(n + " " + decimalFormat.format(timeTaken) + "ns");
            }

            //Increment N for next iteration
            n*=FACTOR_OF_N;
        }


        System.out.println("-----------Testing Enhanced Quick Sort------------");
        System.out.println("1. Array Size | 2. Time Taken | 3. IsSorted?");

        n=N;
        while (n<=M) {
            //Generate a random array of size N
            LinkedList<Integer> arr = random.ints(0, n).distinct().limit(n).boxed()
                    .collect(Collectors.toCollection(LinkedList<Integer>::new));
            Integer[] a = arr.toArray(new Integer[arr.size()]);

            if (n==10) {
                System.out.println("Array Before Sort: " + Arrays.toString(a));
            }

            //Perform and time the sorting algorithm
            start = System.nanoTime();
            QuickSortEnhanced.sort(a, 0, a.length-1);
            timeTaken = System.nanoTime() - start;

            if (n==10) {
                System.out.println("Array After Sort: " + Arrays.toString(a));
            }

            //Print the results (and test that it is sorted given that n <= 100).
            if (n<=1000) {
                System.out.println(n + " " + decimalFormat.format(timeTaken)+ "ns " + isSorted(a, a.length));
                if (!isSorted(a, a.length)) {
                    System.out.println(Arrays.toString(a));
                }
            } else {
                System.out.println(n + " " + decimalFormat.format(timeTaken) + "ns");
            }

            //Increment N for next iteration
            n*=FACTOR_OF_N;
        }
    }

    private static boolean isSorted(Comparable[] array, int length) {
        if (array == null || length < 2)
            return true;
        if (array[length - 2].compareTo(array[length - 1]) > 0)
            return false;
        return isSorted(array, length - 1);
    }

}
