import java.util.*;

/**
 * 
 * 
 * Given an array containing N integers and a positive integer K
 * 
 * find the length of the longest sub array with sum = K.
 * 
 * ===========
 * Example 1
 * ===========
 * 
 * Input:
 * A[] = {10, 5, 2, 7, 1, 9}
 * K = 3
 * Output: 4
 * 
 * 
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * 
 * using prefix sum
 * 
 * ============
 * TC = O(n^2)
 * SC = O(n)
 * 
 * 
 * ============
 * approach : 2
 * ============
 * 
 * using hashmap <sum , ending_index_of_sum>
 * 
 * 1. maintian a sum_till_now variable (initially it is zero) , and iterate over the array from 1st till last element
 *
 * 2. if sum_till_now == k , update end_index as i
 * 
 * 3. we can also get sum as k as below : 
 *      3.1  sum_till_now - x = k
 *       or  k = sum_till_now - x 
 * 
 * 4. check if map contains an entry for sum = x
 *      -if yes : len = i - map.get(x)
 *      -update the maxLen 
 * 
 * 
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 *  
 * 
 * 
 */

class p42_longest_subarray_whose_sum_is_k {

    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, 9 };
        int k = 15;

        int result = function(arr, k);
        System.out.println(result);
    }

    static int function(int[] arr, int k) {

        int n = arr.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return (arr[0] % k == 0) ? 1 : 0;
        }

        if (n == 2) {
            return ((arr[0] + arr[1]) == k) ? 2 : (arr[0] == k || arr[1] == k) ? 1 : 0;
        }

        HashMap<Integer, Integer> hmap = new HashMap<>();

        int sum_till_now = 0;
        int max_len = 0;

        for (int i = 0; i < n; i++) {
            sum_till_now += arr[i];

            if (sum_till_now == k) {
                max_len = Math.max(max_len, i + 1);
            }

            if (!hmap.containsKey(sum_till_now)) {
                hmap.put(sum_till_now, i);
            }

            int x = sum_till_now - k;
            if (hmap.containsKey(x)) {
                int len = i - hmap.get(x);
                max_len = Math.max(max_len, len);
            }

        }

        return max_len;

    }
}