package lab6_Quick_Sorts;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

public class Benchmark {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int N=10;
        long start, timeTaken;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

        System.out.println("-----------Testing Regular Quick Sort------------");
        System.out.println("Array Size | Time Taken | IsSorted?");

        while (N<=100000) {
            //Generate a random array of size N
            LinkedList<Integer> arr = random.ints(0, N).distinct().limit(N).boxed()
                    .collect(Collectors.toCollection(LinkedList<Integer>::new));
            Integer[] a = arr.toArray(new Integer[arr.size()]);

            //System.out.println(Arrays.toString(a));

            //Perform and time the sorting algorithm
            start = System.nanoTime();
            QuickSort.sort(a, 0, a.length-1);
            timeTaken = System.nanoTime() - start;

            //System.out.println(Arrays.toString(a));

            //Print the results (and test that it is sorted given that n <= 100).
            if (N<=1000) {
                System.out.println(decimalFormat.format(N) + " " + decimalFormat.format(timeTaken)+ "ns " + isSorted(a, a.length));

            } else {
                System.out.println(N + " " + decimalFormat.format(timeTaken) + "ns");
            }

            //Increment N for next iteration
            N*=10;
        }


        System.out.println("-----------Testing Enhanced Quick Sort------------");
        System.out.println("Array Size | Time Taken | IsSorted?");

        N=10;
        while (N<=10000) {
            //Generate a random array of size N
            LinkedList<Integer> arr = random.ints(0, N).distinct().limit(N).boxed()
                    .collect(Collectors.toCollection(LinkedList<Integer>::new));
            Integer[] a = arr.toArray(new Integer[arr.size()]);

            //System.out.println(Arrays.toString(a));

            //Perform and time the sorting algorithm
            start = System.nanoTime();
            QuickSortEnhanced.sort(a, 0, a.length-1);
            timeTaken = System.nanoTime() - start;

            //System.out.println(Arrays.toString(a));

            //Print the results (and test that it is sorted given that n <= 100).
            if (N<=1000) {
                System.out.println(N + " " + decimalFormat.format(timeTaken)+ "ns " + isSorted(a, a.length));

            } else {
                System.out.println(N + " " + decimalFormat.format(timeTaken) + "ns");
            }

            //Increment N for next iteration
            N*=10;
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
