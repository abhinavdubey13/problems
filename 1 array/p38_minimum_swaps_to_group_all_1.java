import java.util.*;

/**
 * 
 * given an array of 0,1 
 * 
 * find the minimum number of swaps required to group all 1's together
 * 
 * https://www.geeksforgeeks.org/minimum-swaps-required-group-1s-together/
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * 1. let window size = find total number of 1s
 * 2. count the number of 1's in all possible contigous windows (sliding window)...let it be max
 * 3. answer = windowSize - max
 *
 * 
 * 
 * TC= O(N)
 * SC= O(1) 
 * 
 */

class p38_minimum_swaps_to_group_all_1 {

    public static void main(String[] args) {
        int arr[] = { 0, 0, 1, 0, 1, 1, 0, 0, 1 };
        int answer = function(arr);

        System.out.println(answer);
    }

    static int function(int arr[]) {

        int total_1_in_arr = 0;

        for (int i : arr) {
            if (i == 1) {
                total_1_in_arr++;
            }
        }

        int window_size = total_1_in_arr;

        int max_1_in_window = 0;

        //form the first sliding window
        for (int i = 0; i < window_size; i++) {
            if (i == 1) {
                max_1_in_window++;
            }
        }

        int temp = max_1_in_window;
        for (int i = window_size; i < arr.length; i++) {
            if (arr[i] == 1) {
                temp++;
            }

            if (arr[i - window_size] == 1) {
                temp--;
            }
            max_1_in_window = Math.max(temp, max_1_in_window);
        }

        int num_of_zeros_in_window_with_max_1s = window_size - max_1_in_window;

        return  num_of_zeros_in_window_with_max_1s;
    }

    

}
