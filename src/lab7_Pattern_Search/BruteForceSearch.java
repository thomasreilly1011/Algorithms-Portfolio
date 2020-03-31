package lab7_Pattern_Search;

public class BruteForceSearch {
    static void search(String txt, String pat) {
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
                System.out.println("(BF) Match found at index: " + pos);
            }
        }
    }
}
