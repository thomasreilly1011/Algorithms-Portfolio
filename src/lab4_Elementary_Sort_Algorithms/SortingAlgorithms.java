package lab4_Elementary_Sort_Algorithms;

public class SortingAlgorithms {
    public static int[] selectionSort(int[] arr) {
        int temp;
        int min_index;

        for (int i=0; i<arr.length-1; i++) {
            min_index = i;
            for (int j=i+1; j<arr.length-1; j++) {
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

    public static int[] insertionSort (int[] arr) {
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

    public static int[] stalinSort (int[] arr) {
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
