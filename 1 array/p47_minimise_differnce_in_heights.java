import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
 *
 * 
 * Given heights of n towers and a value k. We need to either increase or decrease height of every tower by k (only once) where k > 0. 
 * The task is to minimize the difference between the heights of the longest and the shortest tower after modifications, and output this difference
 * 
 * ==========
 * example :
 * ==========
 * Input  : arr[] = {1, 15, 10}, k = 6
 * Output :  Maximum difference is 5.
 * 
 * Explanation : We change 1 to 6, 15 to 
 * 9 and 10 to 4. Maximum difference is 5
 * (between 9-4). We can't get a lower difference
 *
 * 
 */

/**
 * ============
 * approach : 
 * ============
 * 
 * The idea is to sort all elements increasing order. 
 * 
 * And for all elements check if subtract(element-k) and add(element+k) makes any changes or not.
 * 
 * ===============
 * TC = O(n.logn)
 * SC = O(1)
 * 
 * 
 */

class p47_minimise_differnce_in_heights {

    public static void main(String[] args) {
        int arr[] = { 1, 15, 10 };
        int k = 6;

        // int arr[] = { 3,9,12,16,20 };
        // int k = 3;

        int answer = Minimise_difference.function(arr, k);
        System.out.println(answer);

    }

}

class Minimise_difference {
    static int function(int[] arr, int k) {

        int n = arr.length;
        Arrays.sort(arr);

        //one possibe case is this
        //when we add k to both corner elements or subtract k from both corner elements
        int answer = arr[n - 1] - arr[0];

        // Handle corner elements 
        int smallest = arr[0] + k;
        int biggest = arr[n - 1] - k;
        int temp = 0;

        if (smallest > biggest) {
            temp = smallest;
            smallest = biggest;
            biggest = temp;
        }

        for (int i = 1; i < n - 1; i++) {

            int subtract = arr[i] - k;
            int add = arr[i] + k;

            if (subtract >= smallest || add <= biggest) {
                continue;
            }

            if (biggest - subtract <= add - smallest) {
                smallest = subtract;
            } else {
                biggest = add;
            }
        }

        return Math.min(answer, biggest - smallest);

    }

}
