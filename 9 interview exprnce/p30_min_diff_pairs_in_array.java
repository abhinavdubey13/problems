import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/find-minimum-difference-pair/
 * 
 * Given an unsorted array, find the minimum difference between any pair in given array.
 *  
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 *
 * using sorting
 * 
 * after sort , pair with min diff will come consecutively
 * 
 * ============
 * TC = O(n.logn)
 * SC = O(1)
 * 
 * 
 *  
 * 
 * 
 * 
 * 
 * 
 */

class p30_min_diff_pairs_in_array {

    public static void main(String[] args) {

        // int n = 438237764;
        int[] n = { 1, 5, 3, 19, 18, 25 };
        int ans = Solution.function(n);
        System.out.println(ans);

    }

}

class Solution {

    static int function(int[] arr) {

        int n = arr.length;

        if (n < 2) {
            return -1;
        }

        if (n == 2) {
            return (int) Math.abs(arr[0] - arr[1]);
        }

        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int diff = (int) Math.abs(arr[i] - arr[i - 1]);
            answer = Math.min(answer, diff);
        }

        return answer;

    }

}