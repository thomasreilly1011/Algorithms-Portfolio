import static java.lang.System.nanoTime;

public class Main {
    public static void main(String[] args) {
        testLabOne();
        testLabTwo();
        testLabThree();
        testLabFour();
        testLabFive();
        testLabSix();
        testLabSeven();
        testLabEight();
        testLabNine();
    }

    private static void testLabOne(){
        System.out.println("\n\n ------------------------ Lab One Tests - Russian Peasants Algorithm ------------------------");
        System.out.println("Russian peasants algorithms performs a mxn multiplication");

        System.out.println("\nm=2, n=2, m*n is as follow...");
        long startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(2, 2));
        long elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime + "ns");

        System.out.println("\nm=20, n=20, m*n is as follow...");
        startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(20, 20));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime + "ns");

        System.out.println("\nm=200, n=200, m*n is as follow...");
        startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(200, 200));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime + "ns");

        System.out.println("\nm=2000, n=20000, m*n is as follow...");
        startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(2000, 2000));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime);

        System.out.println("\nm=200000, n=200000, m*n is as follow...");
        startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(200000, 200000));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime + "ns");

        System.out.println("\nm=2000000, n=2000000, m*n is as follow...");
        startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(2000000, 2000000));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime + "ns");
    }

    private static void testLabTwo(){
        System.out.println("\n\n ------------------------ Lab Two Tests - Asymptotic Time Analysis ------------------------");
        System.out.println("All code from this lab was provided and is run externally.\nResults from the analysis can be found in the github README.");
    }

    private static void testLabThree(){
        System.out.println("\n\n ------------------------ Lab Three Tests - Recursion ------------------------");
        System.out.println("Fibonacci algorithm - Both Iterative and Recursive:");
        System.out.println("Computing Fibonacci number for 40");
        int n = 40;
        long startTime = nanoTime();
        System.out.println("Result for iterative algorithm: " + lab3_Recursion.Fibonacci.fibonacciIterative(n));
        long elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken for iterative algorithm was: " + elapsedTime + "ns");

        startTime = nanoTime();
        System.out.println("Result for recursive algorithm: " + lab3_Recursion.Fibonacci.fibonacciRecursive(n));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken for recursive algorithm was: " + elapsedTime + "ns");

        System.out.println("\nRecursive Towers of Hanoi algorithm with 5 Disks:");
        startTime = nanoTime();
        lab3_Recursion.Hanoi.towersOfHanoi(5, 'A', 'B', 'C');
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken for towersOfHanoi was: " + elapsedTime + "ns");
    }

    private static void testLabFour(){
        System.out.println("\n\n ------------------------ Lab Four Tests - Elementary Sorting Algorithms ------------------------");
        System.out.println("A series of randomly generated Integer Arrays will be generated of incrementing length.");
        System.out.println("The result of sorting the first array (of size 10) will be printed, but after that, only the array size, time taken, and isSorted test will be printed.");
        lab4_Elementary_Sort_Algorithms.Benchmark.main(null);
    }

    private static void testLabFive(){
        System.out.println("\n\n ------------------------ Lab Four Tests - Merge Sorts ------------------------");
        System.out.println("A series of randomly generated Integer Arrays will be generated of incrementing length.");
        System.out.println("The result of sorting the first array (of size 10) will be printed, but after that, only the array size, time taken, and isSorted test will be printed.");
        lab5_Merge_Sorts.Benchmark.main(null);
    }

    private static void testLabSix(){
        System.out.println("\n\n ------------------------ Lab Six Tests - Quick Sorts ------------------------");
        System.out.println("A series of randomly generated Integer Arrays will be generated of incrementing length.");
        System.out.println("The result of sorting the first array (of size 10) will be printed, but after that, only the array size, time taken, and isSorted test will be printed.");
        lab6_Quick_Sorts.Benchmark.main(null);
    }

    private static void testLabSeven(){
        System.out.println("\n\n ------------------------ Lab Seven Tests - Pattern Search ------------------------");
        System.out.println("A series of randomly generated string of A or B will be generated of incrementing length.");
        System.out.println("Additionally for each randomly generated string, a pattern of length 4 will be generated also made up of A's or B's.");
        System.out.println("Both a Brute Force algorithm (BF) and a Knuth-Morris-Pattern-Search algorithm (KMP) will attempt to find instances of the pattern in the text.");
        System.out.println("The Indexes and the time taken for each algorithm will be printed to the console.");;

        lab7_Pattern_Search.Benchmark.main(null);
    }

    private static void testLabEight(){
        System.out.println("\n\n ------------------------ Lab Eight Tests - Tries ------------------------");
        lab8_Tries.Trie.main(null);
    }

    private static void testLabNine(){
        System.out.println("\n\n ------------------------ Lab Nine Tests - Run Length Encoding ------------------------");
        String input = "aaaaaaaabbbbbbbb";
        System.out.println("Creating run length encoding for following input string: " + input);;
        lab_9.RunLengthEncoder.runLengthEncode(input);

        input = "aaaafhmdciwkbdsfrbb";
        System.out.println("Creating run length encoding for following input string: " + input);;
        lab_9.RunLengthEncoder.runLengthEncode(input);

        input = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Creating run length encoding for following input string: " + input);;
        lab_9.RunLengthEncoder.runLengthEncode(input);
    }
}
