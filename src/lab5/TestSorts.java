package lab5;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.nanoTime;

public class TestSorts
{

    public static void main(String[] args) {
        long startTime;
        long timeTaken;

        int[] hugeArr;
        int[] hugeArr2;

        //Set up the arrays
        hugeArr = genRandArr(1000, 5000);
        hugeArr2 = hugeArr;

        //Testing regular merge sort
        System.out.println("Sorting an array with regular merge-sort: " + Arrays.toString(hugeArr));
        startTime = nanoTime();
        hugeArr = MergeSort.sort(hugeArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("The regular merge sort took " + timeTaken + " nanoseconds to sort to: " + Arrays.toString(hugeArr));
        System.out.println();

        //Testing enhanced merge sort
        System.out.println("Sorting an array with an enhanced merge-sort: " + Arrays.toString(hugeArr));
        startTime = nanoTime();
        hugeArr2 = MergeSortEnhanced.mergeSort(hugeArr2);
        timeTaken = nanoTime() - startTime;
        System.out.println("The enhanced merge sort took " + timeTaken + " nanoseconds to sort to: " + Arrays.toString(hugeArr2));
        System.out.println();
    }

    public static int[] genRandArr(int size, int max) {
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(max);
        }
        return arr;
    }

}
