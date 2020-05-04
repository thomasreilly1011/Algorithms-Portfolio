package Compression_Assignment;

import java.io.*;
import java.util.*;

public class HuffmanAlgorithm {
    // alphabet size of extended ASCII
    private static final int R = 256;

    private static BinaryIn binaryFileIn;
    private static BinaryOut binaryFileOut;

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "compress" an {@code decompress()} if it is "decompress".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Not enough arguments.");
        } else if (args.length > 3) {
            throw new IllegalArgumentException("Too many arguments.");
        }

        boolean compress;
        if (args[0].equals("compress")) {
            compress = true;
        } else if (args[0].equals("decompress")) {
            compress = false;
        } else {
            throw new IllegalArgumentException("Invalid option " + args[0]);
        }
        String in = args[1];
        String out = args[2];

        File inputFile = new File(in);
        File outputFile = new File(out);

        binaryFileIn = new BinaryIn(new FileInputStream(inputFile));
        binaryFileOut = new BinaryOut(new FileOutputStream(outputFile));

        if (!binaryFileIn.exists()) {
            System.out.println(in + " does not exist.");
            System.exit(-1);
        }

        long start, timeTaken;
        start = System.nanoTime();

        if (compress) {
            compress();
            timeTaken = System.nanoTime() - start;
            System.out.println("Compression Complete!");
            System.out.println(in + " was compressed to " + out + " to " + outputFile.length() + " bytes.");
        }
        else {
            decompress();
            timeTaken = System.nanoTime() - start;
            System.out.println("Decompression Complete!");
            System.out.println(in + " was decompressed to " + out + " to " + outputFile.length() + " bytes.");
        }

        System.out.println("Time taken: " + timeTaken);
    }

    /** Huffman Trie Node */
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return left == null;
        }

        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /** Do not instantiate. */
    private HuffmanAlgorithm() { }

    /**
     * Reads a sequence of 8-bit bytes from {@code standardFileIn}.
     * compresses them using Huffman codes with an 8-bit alphabet.
     * Writes them to {@code binaryFileOut}.
     */
    public static void compress() {
        //Step One: read in the binary input string.
        StringBuilder sb = new StringBuilder();
        while (!binaryFileIn.isEmpty())
        {
            sb.append(binaryFileIn.readChar());
        }
        String dataInString = sb.toString();
        char[] dataInArr = dataInString.toCharArray();

        //Step Two: count character frequencies.
        HashMap<Character, Integer> frequencies = new HashMap<>();
        for (Character c:dataInArr)
        {
            if (frequencies.containsKey(c))
                frequencies.put(c, frequencies.get(c)+1);
            else
                frequencies.put(c, 1);
        }

        // Step 3: build huffman tree
        Node root = buildTrie(frequencies);

        //Step Four: build code lookup table
        String[] codes = new String[R*8];
        buildCode(codes, root, "");

        HashMap<Character,String> lookupTable = new HashMap<>();
        int i = 0;
        for (String code:codes) {
            lookupTable.put((char) i, code);
            i++;
        }

        // Step Five: Write tree for decoder to the compression file.
        writeTrie(root);

        // Step Six: Write number of bytes in original uncompressed message to the compression file.
        binaryFileOut.write(dataInArr.length);

        // Step Seven: Write the encoding to the compression file.
        for (Character c:dataInArr) {
            String bitString = (lookupTable.get(c));
            for (int j = 0; j < bitString.length(); j++) {
                if (bitString.charAt(j) == '1') {
                    binaryFileOut.write(true);
                } else if (bitString.charAt(j) == '0') {
                    binaryFileOut.write(false);
                }
            }
        }
        binaryFileOut.close();
    }


    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void decompress() throws IOException {
        // Step One: read in Huffman trie from input stream
        Node root = readTrie();

        // Step Two: get the number of bytes to write
        int numBytes = binaryFileIn.readInt();

        // decode using the Huffman trie
        for (int i = 0; i < numBytes; i++) {
            Node curr = root;
            while (true) {
                if (curr.isLeaf()) {
                    binaryFileOut.write(curr.ch);
                    break;
                }
                boolean bit = binaryFileIn.readBoolean();
                if (bit) {
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
        }

        binaryFileOut.close();
    }

    /**
     * Builds a huffman trie made up of {@code Node}'s given a HashMap of characters to their frequencies.
     * @param frequencies HashMap of Character's and their corresponding frequencies.
     * @return The root Node of the huffman trie.
     */
    private static Node buildTrie(HashMap<Character, Integer> frequencies) {
        Iterator<Map.Entry<Character, Integer>> freqIterator = frequencies.entrySet().iterator();

        //Insert all elements into a priority queue for easy access of minimum values
        MinPQ<Node> pq = new MinPQ<>();
        while (freqIterator.hasNext())
        {
            Map.Entry<Character, Integer> e = freqIterator.next();
            Node n = new Node(e.getKey(), e.getValue(), null, null);
            pq.insert(n);
        }

        // Build the huffman tree.
        Node root = null;
        while (pq.size() > 1)
        {
            Node left = pq.min();
            pq.delMin();
            Node right = pq.min();
            pq.delMin();

            root = new Node('*', left.freq + right.freq, left, right);

            pq.insert(root);
        }
        return root;
    }


    /**
     * Writes the a huffman trie with root x to {@code binaryFileOut}
     * @param x the root of the huffman trie to write
     */
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            binaryFileOut.write(true);
            binaryFileOut.write(x.ch, 8);
            return;
        }
        binaryFileOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    /**
     * Recursive function that generates bit string encoding for every element in the given huffman trie.
     * @param st The output String array that will hold the encodings.
     * @param x The root of the desired huffman trie for encoding.
     * @param s Helper variable for the recursive funciton, initially this is a blank String.
     */
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.ch] = s;
        }
    }

    /**
     * Reads the a huffman trie from {@code binaryFileIn}
     * @return  the root of the huffman trie read in.
     */
    private static Node readTrie() {
        boolean isLeaf = binaryFileIn.readBoolean();
        if (isLeaf) {
            return new Node(binaryFileIn.readChar(), -1, null, null);
        }
        else {
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }
}
