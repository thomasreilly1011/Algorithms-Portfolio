package lab4_Elementary_Sort_Algorithms;

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
    private final static int M = 1000;
    /** The factor that N should be incremented by for each benchmark */
    private final static double FACTOR_OF_N = 1.5;

    /**
     * Performs a series of BenchMarks on the sorting algorithms available in the {@code SortingAlgorithms} class of this package.
     * Benchmarks record the time taken to sort arrays of size {@code N} up to {@code M} incremented at a factor of {@code FACTOR_OF_N}
     * @param args No arguments necessary.
     */
    public static void main(String[] args) {
        int n = N;
        long start, timeTaken;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

        System.out.println("-----------Testing Selection Sort------------");
        System.out.println("1. Array Size | 2. Time Taken | 3. IsSorted?");

        while (n <= M) {
            //Generate a random array of size N
            LinkedList<Integer> arr = random.ints(0, n).distinct().limit(n).boxed()
                    .collect(Collectors.toCollection(LinkedList<Integer>::new));
            Integer[] a = arr.toArray(new Integer[arr.size()]);

            if (n ==10) {
                System.out.println("Array Before Sort: " + Arrays.toString(a));
            }

            //Perform and time the sorting algorithm
            start = System.nanoTime();
            SortingAlgorithms.selectionSort(a);
            timeTaken = System.nanoTime() - start;

            if (n ==10) {
                System.out.println("Array After Sort: " + Arrays.toString(a));
            }

            //Print the results (and test that it is sorted given that n <= 100).
            if (n <= 1000) {
                System.out.println(decimalFormat.format(n) + " " + decimalFormat.format(timeTaken)+ "ns " + isSorted(a, a.length));
                if (!isSorted(a, a.length)) {
                    System.out.println(Arrays.toString(a));
                }

            } else {
                System.out.println(n + " " + decimalFormat.format(timeTaken) + "ns");
            }

            //Increment N for next iteration
            n *= FACTOR_OF_N;
        }
        n = N;
        System.out.println("-----------Testing Insertion Sort------------");
        System.out.println("1. Array Size | 2. Time Taken | 3. IsSorted?");

        while (n <= M) {
            //Generate a random array of size N
            LinkedList<Integer> arr = random.ints(0, n).distinct().limit(n).boxed()
                    .collect(Collectors.toCollection(LinkedList<Integer>::new));
            Integer[] a = arr.toArray(new Integer[arr.size()]);

            if (n ==10) {
                System.out.println("Array Before Sort: " + Arrays.toString(a));
            }

            //Perform and time the sorting algorithm
            start = System.nanoTime();
            SortingAlgorithms.insertionSort(a);
            timeTaken = System.nanoTime() - start;

            if (n ==10) {
                System.out.println("Array After Sort: " + Arrays.toString(a));
            }

            //Print the results (and test that it is sorted given that n <= 100).
            if (n <=1000) {
                System.out.println(decimalFormat.format(n) + " " + decimalFormat.format(timeTaken)+ "ns " + isSorted(a, a.length));
                if (!isSorted(a, a.length)) {
                    System.out.println(Arrays.toString(a));
                }

            } else {
                System.out.println(n + " " + decimalFormat.format(timeTaken) + "ns");
            }

            //Increment N for next iteration
            n *= FACTOR_OF_N;
        }
        n = N;
        System.out.println("-----------Testing Stalin Sort------------");
        System.out.println("1. Array Size | 2. Time Taken | 3. IsSorted?");

        while (n <= M) {
            //Generate a random array of size N
            LinkedList<Integer> arr = random.ints(0, n).distinct().limit(n).boxed()
                    .collect(Collectors.toCollection(LinkedList<Integer>::new));
            Integer[] a = arr.toArray(new Integer[arr.size()]);

            if (n ==10) {
                System.out.println("Array Before Sort: " + Arrays.toString(a));
            }

            //Perform and time the sorting algorithm
            start = System.nanoTime();
            SortingAlgorithms.stalinSort(a);
            timeTaken = System.nanoTime() - start;

            if (n ==10) {
                System.out.println("Array After Sort: " + Arrays.toString(a));
            }

            //Print the results (and test that it is sorted given that n <= 100).
            if (n <=1000) {
                System.out.println(decimalFormat.format(n) + " " + decimalFormat.format(timeTaken)+ "ns " + isSorted(a, a.length));

            } else {
                System.out.println(n + " " + decimalFormat.format(timeTaken) + "ns");
            }

            //Increment N for next iteration
            n *= FACTOR_OF_N;
        }

    }

    public static int[] genRandArr(int size, int max) {
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(max);
        }
        return arr;
    }

    public static String arrToString(int[] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i] + ", ";
        }
        return s;
    }

    private static boolean isSorted(Comparable[] array, int length) {
        if (array == null || length < 2)
            return true;
        if (array[length - 2].compareTo(array[length - 1]) > 0)
            return false;
        return isSorted(array, length - 1);
    }
}
