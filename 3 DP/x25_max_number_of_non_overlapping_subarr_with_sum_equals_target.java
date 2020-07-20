import java.util.*;

/**
 * leetcode id : 1546
 * 
 * Given an array nums and an integer target.
 * 
 * Return the maximum number of non-empty non-overlapping subarrays such that the sum of values in each subarray is equal to target.
 *  
 * ============
 * example : 1
 * ============
 * 
 * Example 1:
 * Input: nums = [1,1,1,1,1], target = 2
 * Output: 2
 * Explanation: There are 2 non-overlapping subarrays [1,1,1,1,1] with sum equals to target(2).
 * 
 * 
 * Example 2:
 * Input: nums = [-1,3,5,1,4,2,-9], target = 6
 * Output: 2
 * Explanation: There are 3 subarrays with sum equal to 6. ([5,1], [4,2], [3,5,1,4,2,-9]) but only the first 2 are non-overlapping.
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *
 * https://www.youtube.com/watch?v=0LWRSbYH5oM&ab_channel=AbrarSher
 * 
 * Well, we all know how to find all arrays that sum to a target in O(n) - track prefix sum in a hash map and look up complements (sum - target) there.
 * 
 * Now, how do we count non-overlapping arrays? 
 * 
 * The intuition here is that the right side of our array is only increasing, and we can greedily track the smallest right. 
 * Value in dp is the left index of the subarray with the target sum. 
 * If we find a non-overlapping array (right <= left), we increase cnt and update right to the current position.
 * 
 * 
 * ===========
 * TC=O(n)
 * SC=O(n)
 * 
 * 
 * 
 */

class x25_max_number_of_non_overlapping_subarr_with_sum_equals_target {

    public static void main(String[] args) {

        int[] arr = { 1, 1, 1, 1 };
        int target = 2;

        int answer = function(arr, target);
        System.out.println(answer);
    }

    static int function(int[] arr, int target) {

        int n = arr.length;

        Map<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, -1);

        int rightmost_idx_used = -1;
        int answer = 0;

        int prefix_sum = 0;

        for (int i = 0; i < n; i++) {
            prefix_sum += arr[i];

            int complement = prefix_sum - target;

            if (hmap.containsKey(complement) && hmap.get(complement) >= rightmost_idx_used) {
                answer++;
                rightmost_idx_used = i;
            }

            hmap.put(prefix_sum, i);
        }

        return answer;

    }

}
