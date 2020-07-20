import java.util.*;

/**
 * 
 * 
 * Given an array containing N integers and a positive integer K
 * 
 * find the length of the longest sub array with sum of the elements divisible by the given value K.
 * 
 * ===========
 * Example 1
 * ===========
 * 
 * Input:
 * A[] = {2, 7, 6, 1, 4, 5}
 * K = 3
 * Output: 4
 * Explanation:The subarray is {7, 6, 1, 4} with sum 18, which is divisible by 3.
 * 
 * 
 * ===========
 * Example 2
 * ===========
 * 
 * Input:
 * A[] = {-2, 2, -5, 12, -11, -1, 7}
 * K = 3
 * Output: 5
 * Explanation:
 * The subarray is {2,-5,12,-11,-1} with sum -3, which is divisible by 3.
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
 * https://www.youtube.com/watch?v=GrV3MTR_Uk0&ab_channel=Pepcoding   (watch for 2 min : u ll get the crux)
 * 
 * using prefix sum mod array
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 *  
 * 
 * 
 */

class p43_longest_subarray_divisible_by_k {

    public static void main(String[] args) {
        int[] arr = { 2, 7, 6, 1, 4, 5 }; //expected = 4
        int k = 3;

        // int[] arr = { -2, 2, -5, 12, -11, -1, 7 }; //expected = 5
        // int k = 3;

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
            return ((arr[0] + arr[1]) % k == 0) ? 2 : (arr[0] % k == 0 || arr[1] % k == 0) ? 1 : 0;
        }

        HashMap<Integer, Integer> hmap = new HashMap<>();

        int[] prefix_sum_mod = new int[n];
        int sum_till_now = 0;

        for (int i = 0; i < n; i++) {
            sum_till_now += arr[i];

            //sum can be -ive : but mod shud be +ive
            prefix_sum_mod[i] = ((sum_till_now % k) >= 0) ? sum_till_now % k : ((sum_till_now % k) + k) % k;
        }

        int max_len = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (prefix_sum_mod[i] == 0) {
                max_len = Math.max(max_len, i);
            }

            if (!hmap.containsKey(prefix_sum_mod[i])) {
                hmap.put(prefix_sum_mod[i], i);
            }

            else if (hmap.containsKey(prefix_sum_mod[i])) {
                max_len = Math.max(max_len, i - hmap.get(prefix_sum_mod[i]));
            }
        }

        return max_len;

    }

}
