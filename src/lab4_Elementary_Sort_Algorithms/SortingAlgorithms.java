package lab4_Elementary_Sort_Algorithms;

public class SortingAlgorithms {

    /**
     * Performs a selection sort algorithm on an array of integers ordering them from lowest to highest.
     * @param arr Array of Integers to be sorted
     * @return The sorted Integer Array.
     */
    public static Integer[] selectionSort(Integer[] arr) {
        int temp;
        int min_index;

        for (int i=0; i<arr.length; i++) {
            min_index = i;
            for (int j=i+1; j<arr.length; j++) {
                if(arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
        return arr;
    }

    /**
     * Performs a insertion sort algorithm on an array of integers ordering them from lowest to highest.
     * @param arr Array of Integers to be sorted
     * @return The sorted Integer Array.
     */
    public static Integer[] insertionSort (Integer[] arr) {
        int key;
        int j;
        for (int i=1; i<arr.length; ++i) {
            key = arr[i];
            j = i-1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
                arr[j+1] = key;
            }
        }
        return arr;
    }

    /**
     * Performs a stalin sort algorithm on an array of integers ordering them from lowest to highest.
     * @param arr Array of Integers to be sorted
     * @return The sorted Integer Array.
     */
    public static Integer[] stalinSort (Integer[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; i++, j++) {
            if (arr[i] > arr[j]) {
                i--;
            } else if (j - i > 1) {
                arr[i + 1] = arr[j];
            }
        }
        return arr;
    }

}
