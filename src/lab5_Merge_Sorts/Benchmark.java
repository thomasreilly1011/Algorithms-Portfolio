package lab5_Merge_Sorts;

import lab6_Quick_Sorts.QuickSort;
import lab6_Quick_Sorts.QuickSortEnhanced;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

import static java.lang.System.nanoTime;

public class Benchmark
{
    private static final Random random = new Random();
    public static void main(String[] args) {
//        long start;
//        long timeTaken;
//
//        int[] hugeArr;
//        int[] hugeArr2;
//
//        //Set up the arrays
//        hugeArr = genRandArr(1000, 5000);
//        hugeArr2 = hugeArr;
//
//        //Testing regular merge sort
//        System.out.println("Sorting an array with regular merge-sort: " + Arrays.toString(hugeArr));
//        startTime = nanoTime();
//        hugeArr = MergeSort.sort(hugeArr);
//        timeTaken = nanoTime() - startTime;
//        System.out.println("The regular merge sort took " + timeTaken + " nanoseconds to sort to: " + Arrays.toString(hugeArr));
//        System.out.println();
//
//        //Testing enhanced merge sort
//        System.out.println("Sorting an array with an enhanced merge-sort: " + Arrays.toString(hugeArr));
//        startTime = nanoTime();
//        hugeArr2 = MergeSortEnhanced.mergeSort(hugeArr2);
//        timeTaken = nanoTime() - startTime;
//        System.out.println("The enhanced merge sort took " + timeTaken + " nanoseconds to sort to: " + Arrays.toString(hugeArr2));
//        System.out.println();
//
//        System.out.println("-----------Testing Regular Quick Sort------------");
//        System.out.println("Array Size | Time Taken | IsSorted?");

        int N=10;
        long start, timeTaken;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

        System.out.println("-----------Testing Regular Merge Sort------------");
        System.out.println("Array Size | Time Taken | IsSorted?");

        while (N<=100000) {
            //Generate a random array of size N
            LinkedList<Integer> arr = random.ints(0, N).distinct().limit(N).boxed()
                    .collect(Collectors.toCollection(LinkedList<Integer>::new));
            Integer[] a = arr.toArray(new Integer[arr.size()]);

            //System.out.println(Arrays.toString(a));

            //Perform and time the sorting algorithm
            start = System.nanoTime();
            a=MergeSort.sort(a);
            timeTaken = System.nanoTime() - start;

            //System.out.println(Arrays.toString(a));

            //Print the results (and test that it is sorted given that n <= 100).
            if (N<=1000) {
                System.out.println(decimalFormat.format(N) + " " + decimalFormat.format(timeTaken)+ "ns " + isSorted(a, a.length));
                if (!isSorted(a, a.length)) {
                    System.out.println(Arrays.toString(a));
                }

            } else {
                System.out.println(N + " " + decimalFormat.format(timeTaken) + "ns");
            }

            //Increment N for next iteration
            N*=1.5;
        }


        System.out.println("-----------Testing Enhanced Merge Sort------------");
        System.out.println("Array Size | Time Taken | IsSorted?");

        N=10;
        while (N<=100000) {
            //Generate a random array of size N
            LinkedList<Integer> arr = random.ints(0, N).distinct().limit(N).boxed()
                    .collect(Collectors.toCollection(LinkedList<Integer>::new));
            Integer[] a = arr.toArray(new Integer[arr.size()]);

            //System.out.println(Arrays.toString(a));

            //Perform and time the sorting algorithm
            start = System.nanoTime();
            a=MergeSortEnhanced.sort(a);
            timeTaken = System.nanoTime() - start;

            //System.out.println(Arrays.toString(a));

            //Print the results (and test that it is sorted given that n <= 100).
            if (N<=1000) {
                System.out.println(N + " " + decimalFormat.format(timeTaken)+ "ns " + isSorted(a, a.length));
                if (!isSorted(a, a.length)) {
                    System.out.println(Arrays.toString(a));
                }
            } else {
                System.out.println(N + " " + decimalFormat.format(timeTaken) + "ns");
            }

            //Increment N for next iteration
            N*=1.5;
        }
    }

    private static boolean isSorted(Comparable[] array, int length) {
        if (array == null || length < 2)
            return true;
        if (array[length - 2].compareTo(array[length - 1]) > 0)
            return false;
        return isSorted(array, length - 1);
    }

//    public static int[] genRandArr(int size, int max) {
//        int[] arr = new int[size];
//        Random r = new Random();
//        for (int i = 0; i < size; i++) {
//            arr[i] = r.nextInt(max);
//        }
//        return arr;
//    }

}
