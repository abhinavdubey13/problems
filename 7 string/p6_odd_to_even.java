import java.util.*;

/**
 * leetcode id : 
 * 
 * Given an odd number in the form of string, 
 * 
 * the task is to make largest even number possible from the given number 
 * 
 * provided you are allowed to do only 1 swap operation, 
 * 
 * if no such number is possible then print the input string itself.
 * 
 *
 * 
 * =========
 * example 
 * =========
 * i/p : 1235785
 * o/p : 1535782
 *  
 * 
 * i/p : 789
 * o/p : 798
 * 
 * 
 * i/p : 536425
 * o/p : 536524
 * 
 * i/p : 357
 * o/p : 357
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * scan from right to left and swap with the i'th index such that
 * 
 * 1. arr[i] is even
 * 2. arr[n-1] - arr[i] is minimum
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * ============
 * approach : 2
 * ============
 * scan from LHS and find the first index , whose value is even && is smaller than last char
 * as soon as we find this index , break out of the loop
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class p6_odd_to_even {

    public static void main(String[] args) {
        // String input = "536425";
        // String input = "789";
        String input = "1235785";
        // String input = "357";

        String answer = function(input);
        System.out.println(answer);

        String answer2 = Practise.fun(input);
        System.out.println(answer2);
    }

    static String function(String input) {

        char[] arr = input.toCharArray();
        int n = arr.length;

        //swap index = -1 implies no even char found
        int swap_idx = -1;

        int min_diff_so_far = Integer.MAX_VALUE;
        int last_number = (arr[n - 1] - '0');

        for (int i = n - 2; i >= 0; i--) {
            int curr_number = (arr[i] - '0');
            boolean isEven = (curr_number % 2 == 0) ? true : false;

            if (isEven) {
                int curr_diff = last_number - curr_number;

                if (last_number > curr_number && curr_diff < min_diff_so_far) {
                    swap_idx = i;
                    min_diff_so_far = curr_diff;
                }
            }
        }

        //swap operation
        if (swap_idx != -1) {
            char temp = arr[n - 1];
            arr[n - 1] = arr[swap_idx];
            arr[swap_idx] = temp;
        }

        return String.valueOf(arr);

    }

}

class Practise {

    static String fun(String input) {

        char[] arr = input.toCharArray();
        int n = arr.length;

        //swap index = -1 implies no even char found
        int swap_idx = -1;

        char last = arr[n - 1];

        //scan from LHS and find the first index , whose value is even && is smaller than last char
        for (int i = 0; i < n; i++) {
            boolean is_even = ((arr[i] - '0') % 2 == 0) ? true : false;
            boolean is_smaller_than_last = ((arr[i] - '0') < (last - '0')) ? true : false;

            if (is_even && is_smaller_than_last) {
                swap_idx = i;
                break;
            }
        }

        if (swap_idx == -1) {
            return "NOT possible";
        } else {
            char temp = arr[n - 1];
            arr[n - 1] = arr[swap_idx];
            arr[swap_idx] = temp;

            return String.valueOf(arr);
        }

    }

}