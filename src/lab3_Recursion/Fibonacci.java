package lab3_Recursion;


public class Fibonacci {

    /**
     * A recursive algorithm that computes the nth element in the fibonacci sequence.
     * @param n element index
     * @return the nth element in the fibonacci sequence
     */
    public static int fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciRecursive(n - 1) +fibonacciRecursive(n - 2);
        }

    }

    /**
     * An iterative algorithm that computes the nth element in the fibonacci sequence.
     * @param n element index
     * @return the nth element in the fibonacci sequence
     */
    public static int fibonacciIterative(int n){
        if (n<=1)
            return 1;

        int fib = 1;
        int prevFib =  1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
        }
        return fib;
    }

    public static void main (String args[])
    {
        int n = 40;
        long startTime = System.currentTimeMillis();
        System.out.println(fibonacciIterative(n));
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("The time taken for fibonacciIterative was: " + elapsedTime);

        startTime = System.currentTimeMillis();
        System.out.println(fibonacciRecursive(n));
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("The time taken for fibonacciRecursive was: " + elapsedTime);
    }

}
