import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/longest-increasing-odd-even-subsequence/
 * 
 * Given an array of size n. 
 * 
 * The problem is to find the length of the subsequence in the given array 
 * 
 * such that all the elements of the subsequence are sorted in increasing order and also they are alternately odd and even.
 * 
 * Note that the subsequence could start either with the odd number or with the even number.
 *  
 * =========
 * example:
 * =========
 *
 * Input : arr[] = {5, 6, 9, 4, 7, 8}
 * Output : 4
 * {5, 6, 7, 8} is the required longest increasing odd even subsequence.
 * 
 * Input : arr[] = {1, 12, 2, 22, 5, 30, 31, 14, 17, 11}
 * Output : 5
 *
 * 
 */

/**
 *  
 * 
 * ==========
 * approach : 
 * ==========
 * 
 *
 * application of LIS 
 * 
 * we maintain 2 dp arrays
 * 
 * dp_odd[i] : max len required sub seq , which ends with odd number
 * 
 * dp_even[i] : max len required sub seq , which ends with even number
 *
 * ===========
 * TC = O(n.n)
 * SC = O(n)
 * 
 * 
 * 
 * 
 */

public class p70_longest_even_odd_subseq {
    public static void main(String[] args) {

        int[] arr = { 5, 6, 9, 4, 7, 8 }; //expected = 4

        // int[] arr = { 1, 12, 2, 22, 5, 30, 31, 14, 17, 11 }; //expected = 5

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        int n = arr.length;

        if (n < 2) {
            return n;
        }

        int[] dp_odd = new int[n];
        int[] dp_even = new int[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 1) {
                dp_odd[i] = 1;
            } else {
                dp_even[i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % 2 == 0 && arr[j] % 2 == 1 && arr[i] > arr[j]) {
                    dp_even[i] = Math.max(dp_even[i], 1 + dp_odd[j]);
                } else if (arr[i] % 2 == 1 && arr[j] % 2 == 0 && arr[i] > arr[j]) {
                    dp_odd[i] = Math.max(dp_odd[i], 1 + dp_even[j]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, Math.max(dp_even[i], dp_odd[i]));
        }
        return answer;
    }

}
