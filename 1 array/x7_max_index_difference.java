import java.util.*;

/**
 * 
 * Given an array Arr[] of N positive integers. 
 * 
 * The task is to find the maximum of j - i subjected to the constraint of Arr[i] <= Arr[j].
 * 
 * ==========
 * example : 
 * ==========
 * Input: N = 9
 * Arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
 * 
 * Output: 6
 * 
 * Explanation: In the given array Arr[1] <
 * Arr[7]  satisfying the required condition
 * (Arr[i] <= Arr[j])  thus giving the
 * maximum difference of j - i which is 6 (7-1).

 * 
 */

/**
 *  
 * ============
 * approach : 1
 * ============
 *
 * 2 loops
 *  
 * ============
 * TC = O(n^2)
 * SC = O(1)
 * 
 * 
 * ============
 * approach : 2
 * ============
 *
 * The idea is to use 2 extra arrays of length n (SIMILAR TO RAIN WATER TRAPPING PROBLEM)
 * 
 * STEP-1:
 * L_MIN[i] => min number in the left of arr[i] , including arr[i]
 * R_MAX[i] => max number in the right of arr[i] , including arr[i]
 * 
 * 
 * STEP-2:
 * begin traversing these 2 array from left-to-right , 
 * use i pointing to L_MIN and j pointing to R_MAX
 * 
 * STEP-3:
 * if(L_MIN[i]<=R_MAX[j]) => move j++
 * else move i++;
 * 
 * keep track of max(j-1)
 * 
 * 
 * 
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

class x7_max_index_difference {

    public static void main(String[] args) {
        int[] input = { 34, 8, 10, 3, 2, 80, 30, 33, 1 }; // expected = 6
        int answer = function(input);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        int n = arr.length;

        int[] lmin = new int[n];
        int[] rmax = new int[n];

        lmin[0] = arr[0];
        rmax[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            lmin[i] = Math.min(lmin[i - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], arr[i]);
        }

        int i = 0;
        int j = 0;
        int answer = Integer.MIN_VALUE;

        while (i < n && j < n) {
            if (lmin[i] <= rmax[j]) {
                answer = Math.max(answer, j - i);
                j++;
            } else {
                i++;
            }
        }

        return answer;
    }

}
