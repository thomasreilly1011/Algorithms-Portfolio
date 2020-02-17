package lab4;

import java.util.Random;
import static java.lang.System.nanoTime;

public class TestSorts {

    public static void main(String[] args) {
        long startTime;
        long timeTaken;

        int[] smallArr = new int[10];
        int[] mediumArr = new int[100];
        int[] bigArr = new int[500];
        int[] hugeArr = new int[1000];

        //Small Array
        System.out.println("-----SMALL ARRAY------");
        smallArr = genRandArr(10, 20);
        System.out.println("Sorting a small array with selection sort: " + arrToString(smallArr));
        startTime = nanoTime();
        SortingAlgorithms.selectionSort(smallArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Selection sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(smallArr));
        System.out.println();

        smallArr = genRandArr(10, 20);
        System.out.println("Sorting a small array with insertion sort: " + arrToString(smallArr));
        startTime = nanoTime();
        SortingAlgorithms.insertionSort(smallArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Insertion sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(smallArr));
        System.out.println();

        smallArr = genRandArr(10, 20);
        System.out.println("Sorting a small array with stalin sort: " + arrToString(smallArr));
        startTime = nanoTime();
        SortingAlgorithms.stalinSort(smallArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Stalin sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(smallArr));
        System.out.println();
        System.out.println();

        //Medium Array
        System.out.println("-----MEDIUM ARRAY------");
        mediumArr = genRandArr(50, 100);
        System.out.println("Sorting a medium array with selection sort: " + arrToString(mediumArr));
        startTime = nanoTime();
        SortingAlgorithms.selectionSort(mediumArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Selection sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(mediumArr));
        System.out.println();

        mediumArr = genRandArr(50, 100);
        System.out.println("Sorting a medium array with insertion sort: " + arrToString(mediumArr));
        startTime = nanoTime();
        SortingAlgorithms.insertionSort(mediumArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Insertion sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(mediumArr));
        System.out.println();

        mediumArr = genRandArr(50, 100);
        System.out.println("Sorting a medium array with stalin sort: " + arrToString(mediumArr));
        startTime = nanoTime();
        SortingAlgorithms.stalinSort(mediumArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Stalin sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(mediumArr));
        System.out.println();
        System.out.println();

        //Big Array
        System.out.println("-----BIG ARRAY------");
        bigArr = genRandArr(100, 500);
        System.out.println("Sorting a big array with selection sort: " + arrToString(bigArr));
        startTime = nanoTime();
        SortingAlgorithms.selectionSort(bigArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Selection sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(bigArr));
        System.out.println();

        bigArr = genRandArr(100, 500);
        System.out.println("Sorting a big array with insertion sort: " + arrToString(bigArr));
        startTime = nanoTime();
        SortingAlgorithms.insertionSort(bigArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Insertion sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(bigArr));
        System.out.println();

        bigArr = genRandArr(100, 500);
        System.out.println("Sorting a big array with stalin sort: " + arrToString(bigArr));
        startTime = nanoTime();
        SortingAlgorithms.stalinSort(bigArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Stalin sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(bigArr));
        System.out.println();
        System.out.println();

        //Huge Array
        System.out.println("-----HUGE ARRAY------");
        hugeArr = genRandArr(1000, 5000);
        System.out.println("Sorting a small array with selection sort: " + arrToString(hugeArr));
        startTime = nanoTime();
        SortingAlgorithms.selectionSort(hugeArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Selection sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(hugeArr));
        System.out.println();

        hugeArr = genRandArr(1000, 5000);
        System.out.println("Sorting a small array with insertion sort: " + arrToString(hugeArr));
        startTime = nanoTime();
        SortingAlgorithms.insertionSort(hugeArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Insertion sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(hugeArr));
        System.out.println();

        hugeArr = genRandArr(1000, 5000);
        System.out.println("Sorting a small array with stalin sort: " + arrToString(hugeArr));
        startTime = nanoTime();
        SortingAlgorithms.stalinSort(hugeArr);
        timeTaken = nanoTime() - startTime;
        System.out.println("Stalin sort took " + timeTaken + " nanoseconds to sort to: " + arrToString(hugeArr));
        System.out.println();
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

    public static String arrToString(int[] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i] + ", ";
        }
        return s;
    }
}
