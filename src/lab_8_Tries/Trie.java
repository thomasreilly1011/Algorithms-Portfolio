package lab_8_Tries;

import java.util.Arrays;

public class Trie {
    //Constants
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        //Variables
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        //Constructor
        TrieNode() {
            isEndOfWord = false;

            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    //Variables
    static TrieNode root = new TrieNode();

    /*
    If the key is not present, inserts into trie
    If the key is prefix of Trie node, marks leaf node
     */
    public static void insert(String key) {
        int letterIndex;
        TrieNode curr = root;

        for (int layer=0; layer < key.length(); layer++) {
            letterIndex = key.charAt(layer) - 'a';
            if (curr.children[letterIndex] == null) {
                curr.children[letterIndex] = new TrieNode();
            }
            curr = curr.children[letterIndex];
        }

        curr.isEndOfWord = true;
    }

    /*
    Returns true if key presents in trie, else false
     */
    public static boolean search(String key) {
        int letterIndex;
        TrieNode curr = root;

        for (int layer=0; layer < key.length(); layer++) {
            letterIndex = key.charAt(layer) - 'a';
            if (curr.children[letterIndex] == null) {
                return false;
            }
            curr = curr.children[letterIndex];
        }

        return curr != null && curr.isEndOfWord;
    }

    /*
    Main function for testing purposes
     */
    public static void main(String[] args) {
        String[] S = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};

        System.out.println("Inserting the following words into the trie: " + Arrays.toString(S));

        for (String key:S) {
            Trie.insert(key);
        }

        System.out.println("search(bank) returns: " + Trie.search("bank"));
        System.out.println("search(film) returns: " + Trie.search("film"));
        System.out.println("search(silver) returns: " + Trie.search("silver"));
        System.out.println("search(hello) returns: " + Trie.search("hello"));

    }

}
