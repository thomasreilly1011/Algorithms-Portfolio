package lab8_Tries;

import java.util.Arrays;

/**
 * A simple tree data structure that takes in Strings using the {@code insert} method.
 * Words can quickly be searched in this structure using the {@code search} method.
 */
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

    /**
     * Inserts a given key into the tree structure.
     * @param key Key that is to be inserted.
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

    /**
     * Searches for the given key in the tree structure and returns true if found, false otherwise.
     * @param key The key that is to be searched.
     * @return true if the key is found, false otherwise.
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

    /**
     * A simple testing function for the data structure that attempts various inserts and searches.
     * @param args No arguments nessesary.
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
