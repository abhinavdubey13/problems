import java.util.*;

/**
 * leetcode id : 561
 * 
 * Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) 
 * such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
 * 
 * 
 * ===========
 * example -1
 * ===========
 * Input: nums = [1,4,3,2]
 * Output: 4
 * 
 * Explanation: All possible pairings (ignoring the ordering of elements) are:
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * So the maximum possible sum is 4.
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * The algorithm is first sort the input array and then the sum of 1st, 3rd, 5th..., is the answer.
 *
 *  
 * 
 * ============
 * TC = O(n.logn)
 * SC = O(1)
 * 
 * 
 * 
 */

class x42_array_partition {

    public static void main(String[] args) {

        // int[] arr = { 6, 2, 6, 5, 1, 2 };

        int[] arr = { 1,4,3,2 };


        int answer = function(arr);

        System.out.println(answer);

    }

    static int function(int[] arr) {

        int n = arr.length;
        int answer = 0;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {

            answer += (i % 2 == 0) ? arr[i] : 0;

        }

        return answer;

    }

}
