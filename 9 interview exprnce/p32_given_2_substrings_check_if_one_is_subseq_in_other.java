import java.util.*;

/**
 * 
 * Given two strings str1 and str2, find if str1 is a subsequence of str2. 
 * 
 * A subsequence is a sequence that can be derived from another sequence by deleting some elements 
 * 
 * without changing the order of the remaining elements (source: wiki). Expected time complexity is linear.
 *  
 *
 * https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/ 
 * 
 * ==========
 * example : 
 * ==========
 * Input: str1 = "AXY", str2 = "ADXCPY"
 * Output: True (str1 is a subsequence of str2)
 * 
 * Input: str1 = "AXY", str2 = "YADXCP"
 * Output: False (str1 is not a subsequence of str2)
 * 
 * Input: str1 = "gksrek", str2 = "geeksforgeeks"
 * Output: True (str1 is a subsequence of str2)
 * 
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * 
 * 
 * The idea is simple, we traverse both strings from one side to other side (say from rightmost character to leftmost). 
 * If we find a matching character, we move ahead in both strings. Otherwise we move ahead only in str2. 
 * 
 * TC= O(parent)
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p32_given_2_substrings_check_if_one_is_subseq_in_other {

    public static void main(String[] args) {

        String parent = "geeksforgeeks";
        String child = "gksrek";
        boolean answer = Solution.function(parent, child);
        System.out.println(answer);

    }

}

class Solution {

    static boolean function(String parent, String child) {

        int ci = child.length() - 1;
        int pi = parent.length() - 1;

        while (pi >= 0 && ci >= 0) {

            char c = child.charAt(ci);
            char p = parent.charAt(pi);
            if (c == p) {
                ci--;
                pi--;
            } else {
                pi--;
            }
        }

        return (ci == -1);

    }

}
