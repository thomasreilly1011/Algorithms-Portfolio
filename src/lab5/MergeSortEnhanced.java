package lab5;

import java.util.Arrays;

public class MergeSortEnhanced
{
    public static void main(String[] args)
    {
        int[] a = {5, 1, 4 , 8, 10, 9, 43, 3, 6, 7};
        System.out.println("Random array: " + Arrays.toString(a));
        a = mergeSort(a);
        System.out.println("Random array sorted using merge-sort: " + Arrays.toString(a));
    }

    public static int[] mergeSort(int[] arr) {
        int[] a = arr;
        int N = a.length;
        int[] left = new int[N];
        int[] right = new int[N];

        //Base case
        if (N == 1) {
            return a;
        }
        //Enhancement 1: Cut off case for smaller arrays.
         if (N <= 3) {
            return insertionSort(a);
         }

        left = Arrays.copyOfRange(a, 0, N/2);
        right = Arrays.copyOfRange(a, N/2, N);

        left = mergeSort(left);
        right = mergeSort(right);

        //Enhancement 2: If they're already sorted, just join them.
        if(left[left.length-1] <= right[0]) {
            int[] e = new int[left.length+right.length];
            int j = 0;
            for (int value : left)
            {
                e[j] = value;
                j++;
            }
            for (int value : right)
            {
                e[j] = value;
                j++;
            }
            return e;
        }

        int[] mergeArrays = merge(left, right);

        return mergeArrays;
    }

    public static int[] merge(int[] a, int[] b)
    {
        int i = 0;
        int[] S = new int[a.length + b.length];

        while (a.length != 0 && b.length != 0)
        {
            if (a[a.length-1] >= b[b.length-1])
            {
                S[S.length - i -1] = a[a.length-1];
                a = Arrays.copyOfRange(a, 0, a.length-1);
                i++;
            } else if (b[b.length-1] >= a[a.length-1])
            {
                S[S.length - i -1] = b[b.length-1];
                b = Arrays.copyOfRange(b, 0, b.length-1);
                i++;
            }

            if (a.length == 0)
            {
                for (int j = 0; j < b.length; j++, i++)
                {
                    S[S.length-i-1] = b[b.length-j-1];
                }
            } else if (b.length == 0)
            {
                for (int j = 0; j < a.length; j++, i++)
                {
                    S[S.length-i-1] = a[a.length-j-1];
                }
            }
        }
        return S;
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


}
