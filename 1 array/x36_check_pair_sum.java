import java.util.*;

/**
 * leetcode id : 1497
 * 
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
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
 * 
 *
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x36_check_pair_sum {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 };
        int k = 5;

        boolean answer = function(arr, k);

        System.out.println(answer);
    }

    static boolean function(int[] arr, int k) {

        int n = arr.length;
        int total_sum = 0;
        Map<Integer, Integer> freq_map = new HashMap<>();

        for (int i : arr) {
            total_sum += i;
            int count = freq_map.getOrDefault(i, 0);
            count++;
            freq_map.put(i, count);
        }

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int y = k - arr[i];

            int x_freq = freq_map.get(x);
            int y_freq = freq_map.get(y);

            if (x_freq > 0 && y_freq <= 0 || y_freq > 0 && x_freq <= 0) {
                return false;
            }

            x_freq--;
            y_freq--;

            freq_map.put(x, x_freq);
            freq_map.put(y, y_freq);

        }

        return true;

    }

}
