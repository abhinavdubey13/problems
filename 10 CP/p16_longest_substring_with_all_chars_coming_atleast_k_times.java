import java.util.*;

/**
 * 
 * LC id : 395
 * 
 * Given a string s and an integer k, 
 * return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
 * 
 * Example 1:
Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * 
 * 
 *  
 */

/**
 * 
 * 
 * divide and conquer
 * 
 * https://www.youtube.com/watch?v=bHZkCAcj3dc&ab_channel=KnowledgeCenter
 * 
 * create partition a i , such that arr[i] occurs less than k times in the subarray
 * 
 * 
 * 
 */

class p16_longest_substring_with_all_chars_coming_atleast_k_times {

    public static void main(String[] args) {

        String s = "aaabbbc";
        int k = 3;

        int answer = new Solution().function_util(s, k);
        System.out.println(answer);
    }
}

class Solution {

    int function_util(String s, int k) {

        //if k is more than length
        if (s.length() < k) {
            return 0;
        }

        if (k == 0 || k == 1) {
            return s.length();
        }

        char[] arr = s.toCharArray();
        return function(arr, 0, arr.length, k);
    }

    int function(char[] arr, int start, int end, int k) {

        if (end - start + 1 < k) {
            return 0;
        }

        else if (k == 0 || k == 1) {
            return end - start;
        }

        else {

            //calculate freq of all chars
            int[] freq = new int[26];
            for (int i = start; i < end; i++) {
                freq[arr[i] - 'a']++;
            }

            int idx_holder = start;
            int res = 0;

            for (int i = start; i < end; i++) {
                if (freq[arr[i] - 'a'] > 0 && freq[arr[i] - 'a'] < k) {

                    //LHS part
                    int temp = function(arr, idx_holder, i, k);
                    res = Math.max(res, temp);
                    idx_holder = i + 1;
                }
            }

            //if all chars were >=k
            if (idx_holder == start) {
                return end - start;
            }

            //RHS part
            int temp = function(arr, idx_holder, end, k);
            res = Math.max(res, temp);
            return res;
        }
    }

}
