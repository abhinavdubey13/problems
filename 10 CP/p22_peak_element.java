import java.util.*;

/**
 * 
 * leetcode id : 162
 * 
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given an integer array nums, 
 * 
 * find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 *
 * 
 *  
 */

/**
 * 
 * 
 * binary search
 * 
 * TC = logn
 * SC = 1
 * 
 */

class p22_peak_element {

    public static void main(String[] args) {

        // int[] arr = { 1, 2, 3, 1 };

        // int[] arr = { 1, 2, 1, 3, 5, 6, 4 };

        int[] arr = { 6, 5, 4, 3, 2, 3, 2 };

        int idx = Solution.function(arr);

        if (idx >= 0 && idx < arr.length) {
            System.out.println(arr[idx]);
        } else {
            System.out.println("invalid index : " + idx);
        }
    }

}

class Solution {

    static int function(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            if (arr[0] > arr[1]) {
                return 0;
            } else {
                return 1;
            }
        }

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (mid == 0 && arr[mid] > arr[mid + 1]) {
                return 0;
            }

            else if (mid == n - 1 && arr[mid] > arr[mid - 1]) {
                return n - 1;
            }

            else if (mid > 0 && mid < n - 1 && arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            }

            else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                high = mid - 1;
            }

            else if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }

        }

        return -1;

    }

}
