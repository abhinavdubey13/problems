import java.util.*;

/**
 *
 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 * 
 * Given an array and a positive integer k, 
 * 
 * find the first negative integer for each window(contiguous subarray) of size k. 
 * 
 * If a window does not contain a negative integer, then print 0 for that window.
 *
 * 
 * ==========
 * example : 
 * ==========
 * Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
 * Output : -8 0 -6 -6
 * First negative integer for each window of size k
 * {-8, 2} = -8
 * {2, 3} = 0 (does not contain a negative integer)
 * {3, -6} = -6
 * {-6, 10} = -6
 * 
 */

/**
 * 
 * we maintain window_start and window_end as variables
 * 
 * and a scanner
 * 
 * scanner is moved forward , only if current value is positive or out of current window
 * 
 * ============
 * TC = n
 * SC = 1
 * 
 * 
 */

class x54_1st_negative_number_in_each_window_of_size_k {

    public static void main(String[] args) {

        int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;
        List<Integer> answer = Solution.function(arr, k);

        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}

class Solution {

    static List<Integer> function(int[] arr, int k) {

        int n = arr.length;

        int scanner = 0;

        List<Integer> answer = new LinkedList<>();

        for (int win_end = k - 1; win_end < n; win_end++) {

            int win_start = win_end - k + 1;

            while (scanner <= win_end && (scanner < win_start || arr[scanner] > 0)) {
                scanner++;
            }

            if (scanner < n && arr[scanner] < 0) {
                answer.add(arr[scanner]);
                // scanner++;
            } else {
                answer.add(0);
            }
        }

        return answer;
    }

}
