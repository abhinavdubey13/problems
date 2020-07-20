import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/minimum-insertions-sort-array/
 * 
 * Given an array of integer numbers, 
 * 
 * we need to sort this array in a minimum number of steps where in one step we can insert any array element from its position to any other position.
 * 
 * =========
 * example:
 * =========
 * 
 * Input  : arr[] = [2, 3, 5, 1, 4, 7, 6]
 * Output : 3
 * We can sort above array in 3 insertion steps as shown below,
 * 1 before array value 2
 * 4 before array value 5
 * 6 before array value 7
 * 
 * Input : arr[] = {4, 6, 5, 1}
 * Output : 2
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
 * We can solve this problem using dynamic programming. 
 * 
 * The main thing to observe is that moving an element doesn’t change the relative order of elements other than the element which is being moved. 
 * 
 * Now consider longest increasing subsequence (LIS) which gives longest increasing sequence, 
 * 
 * so , if keep the element of this increasing sequence as it is and move all other elements then it will take the least number of steps 
 * 
 * because we have taken longest subsequence which does not need to be moved. 
 * 
 * Finally, the answer will be the size of the array minus the size of the longest increasing subsequence.
 * 
 *
 *
 * ===========
 * TC = O(n.n)
 * SC = O(n)
 * 
 * 
 * 
 * 
 */

public class p67_minimum_swaps_to_sort_array {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 1, 4, 7, 6 }; //expected = 3

        // int[] arr = { 5, 1, 2, 3, 4 }; //expected = 1

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        int n = arr.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (arr[i] > arr[j]) ? Math.max(dp[i], 1 + dp[j]) : dp[i];
            }
        }


        //find len of max incresing subseq
        int max_inc_sub_seq_len = -1;

        for (int i : dp) {
            max_inc_sub_seq_len = Math.max(max_inc_sub_seq_len, i);
        }

        return n - max_inc_sub_seq_len;

    }

}
