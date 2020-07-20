import java.util.*;

/**
 * leetcode id : 945
 * 
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
 * 
 * Return the least number of moves to make every value in A unique.
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: [3,2,1,2,1,7]
 * Output: 6
 * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * 
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * The idea is to sort the input 
 * 
 * then we move forward from the beginning of the array till the end.
 * 
 * As soon as we found a condition that the current element is less than or equal to the previous elements ,
 * then we need to update the current array element.
 *  
 * 
 * ============
 * TC = O(n.logn)
 * SC = O(1)
 * 
 * 
 * 
 */

class x43_make_array_elem_uniq {

    public static void main(String[] args) {

        // int[] arr = { 3, 2, 1, 2, 1, 7 }; //expected = 6

        int[] arr = { 1, 2, 2 }; //expected =1 ;

        // int[] arr = { 0, 2, 2 }; //ecpected = 1

        // int[] arr = { 2, 2, 2, 2, 0 }; //expected = 6

        int answer = function(arr);

        System.out.println(answer);

    }

    static int function(int[] arr) {

        int n = arr.length;

        Arrays.sort(arr);

        int answer = 0;

        for (int i = 1; i < n; i++) {

            if (arr[i] <= arr[i - 1]) {
                int old_val = arr[i];

                arr[i] = arr[i - 1] + 1;//make current value unique

                int increment = arr[i] - old_val;
                answer += increment;

            }

        }

        return answer;

    }

}
