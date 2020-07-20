import java.util.*;

/**
 * leetcode id : 1018
 * Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number 
 * 
 * (from most-significant-bit to least-significant-bit.)
 * 
 * Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
 *
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: [0,1,1]
 * 
 * Output: [true,false,false]
 * 
 * Explanation: 
 * 
 * The input numbers in binary are 0, 01, 011; 
 * which are 0, 1, and 3 in base-10.  
 * Only the first number is divisible by 5, so answer[0] is true.
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
 * use modular arithimatic , if we go by long , and array is very big , it goes out of long's range
 *  
 * 
 * ============
 * TC = O()
 * SC = O()
 * 
 * 
 * 
 */

class x28_divisible_by_5 {

    public static void main(String[] args) {

        int[] arr = { 0, 1, 1 };
        // int[] arr = { 0, 1, 1, 1, 1, 1 };
        // int[] arr = { 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1,
        //         0, 1, 0, 0, 0, 1 };

        List<Boolean> answer = function(arr);

        // System.out.println(answer);
        for (Boolean b : answer) {
            System.out.print(b + " ");
        }
        System.out.println();
    }

    static List<Boolean> function(int[] arr) {

        int n = arr.length;
        List<Boolean> answer = new ArrayList<>();

        int current_decimal = arr[0];

        answer.add(current_decimal % 5 == 0);

        for (int i = 1; i < n; i++) {

            current_decimal = (current_decimal * 2 + arr[i]) % 5;

            answer.add(current_decimal % 5 == 0);

        }

        return answer;

    }

}
