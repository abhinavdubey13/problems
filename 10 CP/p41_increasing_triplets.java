import java.util.*;

/**
 * 
 * leetcode id : 334
 * 
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) 
 * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * 
 * 
 *
 * 
 * 
 * 
 */

/**
 * 
 * 
 *
 * https://www.youtube.com/watch?v=yEFlGWOVH8g&ab_channel=AlgorithmsMadeEasy
 * 
 *
 * n
 * 1
 * 
 * 
 */

class p41_increasing_triplets {

        public static void main(String[] args) {

                int[] arr = { 1, 2, 3 };
                boolean present = new Solution().function(arr);
                System.out.println(present);

        }
}

class Solution {

        boolean function(int[] arr) {

                int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
                for (int i : arr) {
                        if (i < small) {
                                small = i;
                        } else if (i < mid && i > small) {
                                mid = i;
                        } else if (i > mid) {
                                return true;
                        }
                }
                return false;
        }

}