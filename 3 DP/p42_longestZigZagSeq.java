/**
 * =============
 * Problem : 
 * =============
 * 
 * Given an array A of N positive integers. 
 * The task is to find the longest Zig-Zag subsequence problem such that all elements of this are alternating (Ai-1 < Ai > Ai+1)
 * 
 * Any sequence of one or two elements is zig zag
 */

/**
 * ===========
 * Example : 
 * ===========
 * 
 * 
 * Input: arr[] = {1, 5, 4}
 * Output: 3
 * The whole arrays is of the form  x1 < x2 > x3 
 * 
 * Input: arr[] = {1, 4, 5}
 * Output: 2
 * All subsequences of length 2 are either of the form  : x1 < x2  or x1 > x2
 *  
 */

/**
 * ====================
 * APPROACH WITH DP :
 * ====================
 * 
 * it is an extension of LONGEST INCREASING SUBSEQ.
 * maintain table[2][n] , ie 2 rows
 * 
 * table[0][i] => Length of the longest Zig-Zag subsequence ending at index i and last element is greater than its previous element
 * 
 * table[1][i] => Length of the longest Zig-Zag subsequence ending at index i and last element is smaller than its previous element
 * 
 * 
 * ========================
 * APPROACH WITH-OUT DP :
 * ========================
 * 
 * maintain 2 variables UP and DOWN , iterate from i=1 to N
 * 
 * if current element is less than prev. : DOWN = UP   + 1
 * if current element is more than prev. : UP   = DOWN + 1
 * 
 *
 * 
 */

public class p42_longestZigZagSeq {
    public static void main(String[] args) {

        int[] arr = { 1, 5, 4, 6 };

        int answer = calculator_no_dp(arr);
        // int answer = calculator_dp(arr);

        System.out.println(answer);

    }

    static int calculator_no_dp(int[] arr) {
        int UP = 1;
        int DOWN = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                UP = DOWN + 1;
            }

            else if (arr[i - 1] < arr[i]) {
                DOWN = UP + 1;
            }
        }

        return Math.max(UP, DOWN);
    }

    static int calculator_dp(int[] arr) {

        int[][] table = new int[2][arr.length];

        //init all cells
        for (int i = 0; i < arr.length; i++) {
            table[0][i] = table[1][i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    table[0][i] = Math.max(table[0][i], table[1][j] + 1);
                }

                if (arr[i] < arr[j]) {
                    table[1][i] = Math.max(table[1][i], table[0][j] + 1);
                }
            }
        }

        //find max of all cells
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(table[0][i], table[1][i]);
        }

        return answer;
    }

}
