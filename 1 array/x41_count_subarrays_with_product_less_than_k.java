import java.util.*;

/**
 * leetcode id : 713
 * 
 * Your are given an array of positive integers nums.
 * 
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k
 * 
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * 
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * using sliding window
 * 
 * The idea is always keep an max-product-window less than K;
 * 
 * Every time shift window by adding a new number on the right(j), if the product is greater than k, then try to reduce numbers on the left(i), 
 * 
 * until the subarray product fit less than k again, (subarray could be empty);
 * 
 * Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
 * 
 * example: for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))
 * 
 * 
 * 
 * NOTE :  the trickiest part is why the number of newly introduced subarrays is j - i + 1.
 * 
 * Say now we have {1,2,3} and add {4} into it. Apparently, the new subarray introduced here are:
 * 
 * {1,2,3,4}, {2,3,4}, {3,4}, {4}, which is the number of elements in the new list.
 * 
 * If we also remove some at the left, say we we remove 1, then subarrays are:
 * 
 * {2,3,4}, {3,4}, {4}. It is easy to get the result is j - i + 1.
 *
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class zz_sample {

    public static void main(String[] args) {

        // int[] arr = { 10, 5, 2, 6 };
        // int k =100;

        int[] arr = { 1, 1, 1 };
        int k = 1;

        int answer = function(arr, k);

        System.out.println(answer);

    }

    static int function(int[] arr, int k) {

        if (k == 0) {
            return 0;
        }

        int n = arr.length;

        int left = 0, right = 0, product = 1, count = 0;

        for (; right < n; right++) {

            product *= arr[right];

            while (left <= right && product >= k) {
                product /= arr[left];
                left++;
            }

            count += right - left + 1;

        }

        return count;

    }

}
