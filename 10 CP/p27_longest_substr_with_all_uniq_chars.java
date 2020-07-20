import java.util.*;

/**
 * 
 * leetcode id : 3
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * 
 * Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 * 
 *  
 */

/**
 * 
 * 
 * using hashset and sliding window approach
 * 
 * TC = 
 * SC = 
 * 
 */

class p27_longest_substr_with_all_uniq_chars {

    public static void main(String[] args) {

        // String s = "abcabcaa";
        // String s = "bbbb";
        String s = "pwwkew";

        int answer_len = new Solution().function(s);
        System.out.println(answer_len);
    }

}

class Solution {

    int function(String input) {
        int n = input.length();
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return (input.charAt(0) != input.charAt(1)) ? 2 : 1;
        }

        Set<Character> myset = new HashSet<>();
        myset.add(input.charAt(0));
        int answer = 1;
        int i = 0;
        int j = 1;

        while (j < n) {

            char curr = input.charAt(j);

            if (myset.contains(curr)) {
                myset.remove(input.charAt(i));
                i++;
            } else {

                myset.add(curr);
                j++;
                answer = Math.max(answer, j - i);

            }

        }

        return answer;

    }

}
