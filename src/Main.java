import lab4_Elementary_Sort_Algorithms.SortingAlgorithms;
import lab5_Merge_Sorts.MergeSort;
import lab5_Merge_Sorts.MergeSortEnhanced;
import lab7_Pattern_Search.BruteForceSearch;
import lab7_Pattern_Search.KMPSearch;
import lab_8_Tries.Trie;

import java.util.Arrays;

import static java.lang.System.nanoTime;
import static java.lang.System.setOut;

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
        System.out.println("\n\n -------- Lab One Tests - Russian Peasants Algorithm --------");
        System.out.println("Russian peasants algorithms performs a mxn multiplication");

        System.out.println("\nm=2, n=2, m*n is as follow...");
        long startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(2, 2));
        long elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime);

        System.out.println("\nm=20, n=20, m*n is as follow...");
        startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(20, 20));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime);

        System.out.println("\nm=200, n=200, m*n is as follow...");
        startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(200, 200));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime);

        System.out.println("\nm=2000, n=20000, m*n is as follow...");
        startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(2000, 2000));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime);

        System.out.println("\nm=200000, n=200000, m*n is as follow...");
        startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(200000, 200000));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime);

        System.out.println("\nm=2000000, n=2000000, m*n is as follow...");
        startTime = nanoTime();
        System.out.println(lab1_Introduction.RussianPeasants.russianMultiply(2000000, 2000000));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken in nano seconds was " + elapsedTime);
    }

    private static void testLabTwo(){
        System.out.println("\n\n -------- Lab Two Tests - Asymptotic Time Analysis --------");
        System.out.println("All code from this lab was provided and is run externally.\nResults from the analysis can be found in the github README.");
    }

    private static void testLabThree(){
        System.out.println("\n\n -------- Lab Three Tests - Recursion --------");
        System.out.println("Fibonacci algorithm - Both Iterative and Recursive:");
        System.out.println("Computing Fibonacci number for 40");
        int n = 40;
        long startTime = nanoTime();
        System.out.println("Result for iterative algorithm: " + lab3_Recursion.Fibonacci.fibonacciIterative(n));
        long elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken for iterative algorithm was: " + elapsedTime);

        startTime = nanoTime();
        System.out.println("Result for recursive algorithm: " + lab3_Recursion.Fibonacci.fibonacciRecursive(n));
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken for recursive algorithm was: " + elapsedTime);

        System.out.println("\nRecursive Towers of Hanoi algorithm with 5 Disks:");
        startTime = nanoTime();
        lab3_Recursion.Hanoi.towersOfHanoi(5, 'A', 'B', 'C');
        elapsedTime = nanoTime() - startTime;
        System.out.println("The time taken for towersOfHanoi was: " + elapsedTime);
    }

    private static void testLabFour(){
        System.out.println("\n\n -------- Lab Four Tests - Elementary Sorting Algorithms --------");

    }

    private static void testLabFive(){
        System.out.println("\n\n -------- Lab Four Tests - Merge Sorts --------");

    }

    private static void testLabSix(){
        System.out.println("\n\n -------- Lab Six Tests - Quick Sorts --------");
    }

    private static void testLabSeven(){
        System.out.println("\n\n -------- Lab Seven Tests - Pattern Search --------");
        int N = 100;
        int M = 2;
        String txt, pat;
        long start, timeTaken;

        while (N < 1000000) {
            txt = lab7_Pattern_Search.Benchmark.generateRandomString(N);
            pat = lab7_Pattern_Search.Benchmark.generateRandomString(M);

            start = System.nanoTime();
            BruteForceSearch.search(txt, pat);
            timeTaken = System.nanoTime() - start;
            System.out.println("Time taken for Brute Force Search Algorithm:\t" + timeTaken + " nano seconds");


            start = System.nanoTime();
            KMPSearch.search(txt, pat);
            timeTaken = System.nanoTime() - start;
            System.out.println("Time taken for KMP Search:\t" + timeTaken + " nano seconds");

            M*=2;
            N*=10;
        }
    }

    private static void testLabEight(){
        System.out.println("\n\n -------- Lab Eight Tests - Tries --------");
        String[] S = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};

        System.out.println("Inserting the following words into the trie: " + Arrays.toString(S));

        for (String key:S) {
            lab_8_Tries.Trie.insert(key);
        }

        System.out.println("search(bank) returns: " + lab_8_Tries.Trie.search("bank"));
        System.out.println("search(film) returns: " + lab_8_Tries.Trie.search("film"));
        System.out.println("search(silver) returns: " + lab_8_Tries.Trie.search("silver"));
        System.out.println("search(hello) returns: " + lab_8_Tries.Trie.search("hello"));
    }

    private static void testLabNine(){
        System.out.println("\n\n -------- Lab Nine Tests - Run Length Encoding --------");
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
