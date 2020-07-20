import java.util.*;

/**
 * 
 * leetcode id : 169
 * 
 * 
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n/2⌋ times. 
 * You may assume that the majority element always exists in the array.
 * 
 * 
 * Follow-up: Could you solve the problem in 
 * O(n)time and
 * O(1) space 
 * 
 * 
 */

/**
 * 
 * 
 * moore voting algo
 * 
 * array can be divided into 2 type of elements : 
 * 1. majority and 
 * 2. non-majority
 * 
 * increment count if i is majority
 * else decrement count
 * 
 * if count is 0 at any point : re initialize the majority element
 *
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class p3_majority_element {

    public static void main(String[] args) {

        // int[] arr = { 2, 2, 1, 1, 1, 2, 2 };

        // int[] arr = { 3, 3, 4 };

        int[] arr = { -1, 1, 1, 1, 2, 1 };

        int answer = Solution.function(arr);
        System.out.println(answer);

    }

}

class Solution {

    static int function(int[] arr) {

        int n = arr.length;

        Integer major = null;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                major = arr[i];
            } else if (major == arr[i]) {
                count++;
            } else if (major != arr[i]) {
                count--;
            }

        }
        return major;

    }

}