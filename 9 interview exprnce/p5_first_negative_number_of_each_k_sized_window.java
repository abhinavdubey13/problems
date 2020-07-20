import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 * 
 * 
 * Given an array and a positive integer k, find the first negative integer for each window(contiguous subarray) of size k. 
 * If a window does not contain a negative integer, then print 0 for that window.
 * 
 * 
 * 
 * 
 * Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
 * Output : -8 0 -6 -6
 * First negative integer for each window of size k
 * {-8, 2} = -8
 * {2, 3} = 0 (does not contain a negative integer)
 * {3, -6} = -6
 * {-6, 10} = -6
 * 
 * Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
 * Output : -1 -1 -7 -15 -15 0
 * 
 */

/**
 * 
 * approach-1 : using q of relevent indices
 * relevent indices : whose val is -ive
 * 
 * 
 * TC = O(n)
 * SC = O(k)
 * 
 * 
 * 
 * approach-2 : using 1 pointer 
 * 
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class p5_first_negative_number_of_each_k_sized_window {

    public static void main(String[] args) {
        // int[] arr = { -8, -2, -3, -6, -10 }; //expected : -8 -2 -3 -6 
        // int window_size = 2;

        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int window_size = 3;

        // Solution_queue.function(arr, window_size);

        Solution_optimal.function(arr, window_size);

    }

}

class Solution_queue {

    static void function(int[] arr, int window_size) {

        int n = arr.length;

        Queue<Integer> q_of_neg_idx = new LinkedList<>();

        for (int i = 0; i < window_size; i++) {
            if (arr[i] < 0) {
                q_of_neg_idx.add(i);
            }
        }

        if (q_of_neg_idx.size() > 0) {
            System.out.println(arr[q_of_neg_idx.peek()]);
        }

        //here i is the end index of current window
        for (int i = window_size; i < n; i++) {

            //remove any indices of prev window (let window_size = k)
            //curr window end   : i
            //curr window start : i-k-1 (k elements , including i'th element)

            //remove all indices from beginning which are not part of current window
            int curr_window_start = i - window_size + 1;
            while (q_of_neg_idx.size() > 0 && (q_of_neg_idx.peek() < curr_window_start)) {
                q_of_neg_idx.poll();
            }

            if (arr[i] < 0) {
                q_of_neg_idx.offer(i);
            }

            if (q_of_neg_idx.size() > 0) {
                System.out.println(arr[q_of_neg_idx.peek()]);
            } else {
                System.out.println("0");
            }

        }

    }

}

class Solution_optimal {

    static void function(int[] arr, int window_size) {

        int n = arr.length;

        int neg_idx = 0;

        for (int i = 0; i < window_size; i++) {
            if (arr[i] < 0) {
                neg_idx = i;

                System.out.print(0 + "-" + (window_size - 1) + " : ");
                System.out.print(arr[neg_idx]);
                break;
            }
        }

        System.out.println();

        for (int i = window_size; i < n; i++) {

            int curr_win_start = i - window_size + 1;
            int cur_win_end = i;

            neg_idx = curr_win_start;

            while (neg_idx <= cur_win_end && (neg_idx < curr_win_start || arr[neg_idx] > 0)) {
                neg_idx++;
            }

            System.out.print(curr_win_start + "-" + cur_win_end + " : ");

            if (neg_idx < n && arr[neg_idx] < 0) {
                System.out.print(arr[neg_idx]);
            } else {
                System.out.print("0");
            }

            System.out.println();

        }

    }
}