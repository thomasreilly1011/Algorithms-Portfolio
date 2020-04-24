package lab6_Quick_Sorts;

import java.util.Random;

public class QuickSortEnhanced {
    private static final int CUTOFF = 4;

    static void sort(Integer[] arr, int low, int high) {
        int pi;
        if (high <= low + CUTOFF) {
            //Insertion sort cut-off enhancement
            insertionSort(arr, low, high);
        } else if (low <= high) {
            //Shuffling Enhancement
            //shuffle(arr, low, high);

            //Median Of Three Enhancement
            int mid = low+(high-low)/2;
            medianOfThree(arr, low, mid, high);
            swapReferences(arr, mid, high-1);
            pi = partition(arr, low, high);

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    static int partition(Integer[] arr, int low, int high) {
        //Pivot (Element to be placed at the right position
        int pivot = arr[high];
        //Index of the smaller element
        int i = low-1;
        for (int j = low; j <= high-1; j++) {
            if (arr[j] < pivot) {
                i++;
                Integer temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Integer temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    static void insertionSort(Integer[] arr, int low, int high) {
        int key, j;
        for (int i=low; i<=high; i++) {
            key = arr[i];
            j = i-1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
                arr[j+1] = key;
            }
        }
    }

//    public static void shuffle(Object[] a, int low, int high) {
//        for (int i = low; i <= high; i++) {
//            // choose index uniformly in [0, i]
//            int r = (int) ((Math.random() * (i))+low);
//            Object swap = a[r];
//            a[r] = a[i];
//            a[i] = swap;
//        }
//    }

    public static void shuffle(Object[] a, int low, int high) {
        Random random = new Random();
        for (int i = low; i <= high; i++) {
            // choose index uniformly in [0, i]
            int r = random.nextInt(high-low) + low;
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    public static void medianOfThree(Integer[] arr, int low, int mid, int high) {
        if(arr[mid] < arr[low])
            swapReferences(arr, low, mid);
        if(arr[high] < arr[low])
            swapReferences(arr, low, high);
        if(arr[high] < arr[mid])
            swapReferences(arr, mid, high);
    }

    public static void swapReferences(Integer[] arr, int a, int b) {
        Integer temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
