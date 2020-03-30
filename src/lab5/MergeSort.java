package lab5;

import java.util.Arrays;

public class MergeSort
{
    public static void main(String[] args)
    {
        int[] a = {5, 1, 4 , 8, 10, 9, 43, 3, 6, 7};
        System.out.println("Random array: " + Arrays.toString(a));
        a = sort(a);
        System.out.println("Random array sorted using merge-sort: " + Arrays.toString(a));
    }

    public static int[] sort(int[] arr) {
        int[] a = arr;
        int N = a.length;
        int[] left;
        int[] right;

        //base case
        if (N == 1) {
            return a;
        }



        if (N % 2 == 0) {
            left = Arrays.copyOfRange(a, 0, N/2);
            right = Arrays.copyOfRange(a, N/2, N);
        } else {
            left = Arrays.copyOfRange(a, 0, N/2);
            right = Arrays.copyOfRange(a, N/2, N);
        }

        left = sort(left);
        right = sort(right);

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

}



