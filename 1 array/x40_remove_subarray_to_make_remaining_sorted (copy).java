import java.util.*;

/**
 * leetcode id : 1574
 * 
 * Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * Return the length of the shortest subarray to remove.
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: arr = [1,2,3,10,4,2,3,5]
 * Output: 3
 * Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
 * Another correct solution is to remove the subarray [3,10,4].
 * 
 */

/**
 *  
 * 
 * ============
 * approach : https://www.youtube.com/watch?v=T3mVs4XHV1E&ab_channel=HappyCoding
 * ============
 * 
 * 
 * 
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

class x40_remove_subarray_to_make_remaining_sorted {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 10, 4, 2, 3, 5 };

        // int[] arr = { 5, 4, 3, 2, 1 };

        // int[] arr = { 1, 2, 3, 4 };

        int answer = function(arr);

        System.out.println(answer);

    }

    static int function(int[] arr) {

        int n = arr.length;

        int start = 0;
        int end = n - 1;

        while (start < n - 1 && arr[start + 1] >= arr[start]) {
            start++;
        }

        //strictly increasing array
        if (start == n - 1) {
            return 0;
        }

        while (end > 0 && arr[end - 1] <= arr[end]) {
            end--;
        }

        //strictly decreasing array
        if (end == 0) {
            return n - 1;
        }

        int result = Math.min(n - start - 1, end);

        //start at the beginning of 2 increasing sequences 
        int i = 0, j = end;

        while (i <= start && j < n) {

            //since in this case , the removable array size is reduced , we update result
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;

    }

}
