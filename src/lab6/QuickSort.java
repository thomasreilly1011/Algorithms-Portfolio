package lab6;

public class QuickSort {
    static void sort(Integer[] arr, int low, int high) {
        int pi;
        if (low < high) {
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
}
