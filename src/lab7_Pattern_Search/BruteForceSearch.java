package lab7_Pattern_Search;

import javax.crypto.spec.PSource;

public class BruteForceSearch {
    public static void search(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        for (int pos = 0; pos < n-m; pos++) {
            int i;
            for (i = 0; i < m; i++) {
                if(txt.charAt(pos+i) != pat.charAt(i)) {
                    break;
                }
            }
            if (i == m) {
                if (txt.length() <= 200) {
                    System.out.print("Match found at index: " + pos + ", ");
                }
            }
        }
        System.out.println();
    }
}
