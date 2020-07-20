import java.util.*;

/**
 *
 * 
 * 
 * 
 */

/**
 * 
 * 
 */

class x50_smallest_window_having_all_chars_of_string {

    public static void main(String[] args) throws Exception {

        // String s = "aabcbcdbca";
        String s = "aaab";
        // String s = "aaa";

        Solution.function(s);

    }

}

class Solution {

    static void function(String s) {

        int n = s.length();
        Map<Character, Integer> hmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hmap.put(s.charAt(i), 0);
        }

        int uniq_chars_total = hmap.size();
        int uniq_chars_window = 1;

        int ans_min_len = n;

        int i = 0;
        int j = 1;

        while (i < n && j < n && i <= j) {
            char curr = s.charAt(j);
            int freq_of_curr = hmap.get(curr);

            if (uniq_chars_window < uniq_chars_total) {
                if (freq_of_curr == 0) {
                    uniq_chars_window++;
                }
                hmap.put(curr, 1 + freq_of_curr);
                j++;

            } else if (uniq_chars_window == uniq_chars_total) {
                ans_min_len = Math.min(ans_min_len, j - i);

                if (hmap.get(s.charAt(i)) == 1) {
                    uniq_chars_window--;
                }
                hmap.put(s.charAt(i), hmap.get(s.charAt(i)) - 1);
                i++;
            }

        }

        while (uniq_chars_total == uniq_chars_window && i <= j) {
            ans_min_len = Math.min(ans_min_len, j - i);

            if (hmap.get(s.charAt(i)) == 1) {
                uniq_chars_window--;
            }
            hmap.put(s.charAt(i), hmap.get(s.charAt(i)) - 1);
            i++;
        }

        System.out.println("length of window having all chars of s : " + (ans_min_len + 1));

    }

}
