import java.util.*;

/**
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 * 
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 * 
 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * 
 * 
 * Notice that |val| denotes the absolute value of val.
 * 
 * ===========
 * example -1
 * ===========
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * 
 * 
 * 
 * ===========
 * example -2
 * ===========
 * Input: nums = [1,1,1,1], k = 0
 * Output: 1
 * Explanation: There is 1 such unique pair [1,1]
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * 
 * form hashmap , of i , count(i)
 * 
 * and iterate over the map
 * 
 * 
 * form 2 answers , one for k=0 & other for k>0
 *
 *  
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

class x9_k_differnce_pairs {

    public static void main(String[] args) {
        // int[] input = { 3, 1, 4, 1, 5 }; // expected = 2
        // int k = 2;

        // int[] input = { 1, 2, 3, 4, 5 }; // expected = 4
        // int k = 1;

        // int[] input = { 3, 1, 4, 1, 5 }; // expected = 1
        // int k = 0;

        int[] input = { 2, 2, 2, 2, 2 }; // expected = 1
        int k = 0;

        int answer = function(input, k);
        System.out.println(answer);
    }

    static int function(int[] arr, int k) {

        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i : arr) {
            int x = (hmap.get(i) == null) ? 1 : hmap.get(i).intValue() + 1;
            hmap.put(i, x);
        }

        int answer_k_0 = 0;
        int answer_k_p = 0;

        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            if (k == 0) {
                answer_k_0 += (entry.getValue() / 2 > 0) ? 1 : 0;
            } else if (k > 0) {
                answer_k_p += (hmap.containsKey(entry.getKey() - k)) ? 1 : 0;
                answer_k_p += (hmap.containsKey(entry.getKey() + k)) ? 1 : 0;
            }
        }

        return ((answer_k_p / 2) + answer_k_0);

    }

}
