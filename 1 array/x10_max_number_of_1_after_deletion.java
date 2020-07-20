import java.util.*;

/**
 * 
 * Given a binary array nums, you should delete EXACTLY one element from it (deleted element can be 0 or 1)
 * 
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array.
 * 
 * Return 0 if there is no such subarray.
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * 
 * 
 * ===========
 * example -2
 * ===========
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 * 
 */


/**
 *  
 * ============
 * approach : 1 
 * ============
 * maintain a list of all indices of zeros 
 * 
 * delete each zero in that list one-by-one and find number of contiguous 1's before and after it
 *  
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 * 
 */

class x10_max_number_of_1_after_deletion {

    public static void main(String[] args) {
        // int[] arr = { 0, 1, 1, 1, 0, 1, 1, 0, 1 }; // expected = 5 

        // int[] arr = {1,1,0,1}; // expected = 3

        // int[] arr = { 1, 1, 0, 0, 1, 1, 1, 0, 1 }; //expected=4

        // int[] arr = { 1, 1, 1, 1, 1 }; //expected=4

        int[] arr = { 0, 0, 0, 0 }; //expected=0

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        List<Integer> idx_of_0 = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                idx_of_0.add(i);
            }
        }

        if (idx_of_0.size() == 0) {
            return arr.length - 1;
        } else if (idx_of_0.size() == arr.length) {
            return 0;
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < idx_of_0.size(); i++) {
            int prev_idx_0 = (i == 0) ? -1 : idx_of_0.get(i - 1);
            int curr_idx_0 = idx_of_0.get(i);
            int next_idx_0 = (i + 1 == idx_of_0.size()) ? arr.length : idx_of_0.get(i + 1);

            int num_1_before = curr_idx_0 - prev_idx_0 - 1;
            int num_1_after = next_idx_0 - curr_idx_0 - 1;

            answer = Math.max(answer, num_1_before + num_1_after);
        }

        return answer;

    }

}
