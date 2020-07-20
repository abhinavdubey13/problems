import java.util.*;

/**
 * 
 * leetcode id : 287
 * 
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * 
 * example 1:
Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 * 
 *  
 */

/**
 * 
 * 
 * using index and -1 logic
 * 
 * if an index already has -ive value to it, it means we've got the repeating val
 * 
 * 
 * TC = n
 * SC = 1
 * 
 */

class p18_find_repeating_number {

    public static void main(String[] args) {

        // int[] arr = { 1, 3, 4, 2, 2 };
        int[] arr = { 1, 1, 2 };

        int answer = Solution.function(arr);
        System.out.println(answer);
    }
}

class Solution {

    static int function(int[] arr) {

        int n = arr.length;

        if (n == 2) {
            return arr[0];
        }

        for (int i = 0; i < n; i++) {

            int idx = Math.abs(arr[i]);

            if (arr[idx] < 0) {
                return idx;
            }

            arr[idx] = -1 * arr[idx];

        }

        return -1;

    }

}
