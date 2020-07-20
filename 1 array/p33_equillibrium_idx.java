import java.util.*;

/**
 * 
 * equillibrium idx is the idx before and after which sum is same
 * 
 * https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 * 
 */

/**
 *  
 * ============
 * approach : 1
 * ============
 * 
 * using 2 loops
 * 
 * TC= O(N^2)
 * SC= O(1)
 * 
 * ==============
 * approach : 2
 * ==============
 * in one iterations , we can do this 
 * 
 * step-1 : find the sum of array
 * step-2 : traverse the array , maintaining left and right sums 
 * 
 * TC= O(N)
 * SC= O(1)
 */

class p33_equillibrium_idx {

    public static void main(String[] args) {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int arr[]) {

        int arr_sum = 0;
        for (int i : arr) {
            arr_sum += i;
        }

        int left_sum = 0, right_sum = 0;

        //going from 2nd till 2nd-last index
        for (int i = 1; i < arr.length - 1; i++) {

            left_sum += arr[i - 1];
            right_sum = arr_sum - arr[i] - left_sum;

            if (left_sum == right_sum) {
                return i;
            }

        }

        return -1;

    }

}