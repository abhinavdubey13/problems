/**
 * =============
 * Problem : 
 * =============
 * 
 * leetcode id : https://www.geeksforgeeks.org/maximum-sum-alternating-subsequence-sum/
 * 
 * Given an array, the task is to find sum of maximum sum alternating subsequence starting with first element. 
 * 
 * Here alternating sequence means first decreasing, then increasing, then decreasing, … For example 10, 5, 14, 3 is an alternating sequence.
 * 
 * Note that the reverse type of sequence (increasing – decreasing – increasing -…) is not considered alternating here.
 * 
 * 
 *
 * ===========
 * Example : 
 * ===========
 * 
 * 
 * Input :  arr[] = {4, 3, 8, 5, 3, 8}  
 * Output :  28
 * Explanation: The alternating subsequence (starting with first element) that has above maximum sum is {4, 3, 8, 5, 8}
 * 
 * Input : arr[] = {4, 8, 2, 5, 6, 8} 
 * Output :  14
 * The alternating subsequence (starting with first element) that has above maximum sum is {4, 2, 8}
 *  
 */

/**
 * ====================
 * APPROACH WITH DP :
 * ====================
 * 
 * it is an extension of LONGEST INCREASING SUBSEQ.
 *
 * 
 * Create two empty array that store result of maximum sum  of alternate sub-sequence
 * inc[] : inc[i] stores results of maximum sum alternatingsubsequence ending with arr[i] such that arr[i] is greater than previous element of the subsequence 
 * 
 * dec[] : dec[i] stores results of maximum sum alternating subsequence ending with arr[i] such that arr[i] is less than previous element of the subsequence 
 * 
 * Include first element of 'arr' in both inc[] and dec[] inc[0] = dec[0] = arr[0]
 * 
 * Maintain a flag i.e. it will makes the greater elements count only if the first decreasing element is counted.
 * flag  = 0 intially
 *
 * 
 *
 * 
 */

public class p66_max_ZigZagSeq_sum {
    public static void main(String[] args) {
        int[] arr = { 8, 2, 3, 5, 7, 9, 10 }; //expected = 25
        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        int n = arr.length;
        int[] dp_dec = new int[n];
        int[] dp_inc = new int[n];

        dp_dec[0] = dp_inc[0] = arr[0];

        int flag = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[i] > arr[j] && flag == 1) {
                    dp_inc[i] = Math.max(dp_inc[i], dp_dec[j] + arr[i]);
                }

                if (arr[i] < arr[j]) {
                    dp_dec[i] = Math.max(dp_dec[i], dp_inc[j] + arr[i]);
                    flag = 1;
                }
            }
        }

        //find max of all cells
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(dp_dec[i], dp_inc[i]);
        }

        return answer;
    }

}
