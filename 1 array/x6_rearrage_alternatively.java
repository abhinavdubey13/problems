import java.util.*;

/**
 * 
 * Given a sorted array of positive integers, rearrange the array alternately i.e 
 * first element should be the maximum value, second minimum value, third-second max, fourth-second min and so on.
 * 
 * ==========
 * example : 
 * ==========
 * Input: arr[] = {1, 2, 3, 4, 5, 6, 7}
 * 
 * Output: arr[] = {7, 1, 6, 2, 5, 3, 4}
 * 
 */

/**
 *  
 * ============
 * approach : 1
 * ============
 *
 * auxillary array and 2 pointers to copy from inout array to auxillary array
 *  
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * ============
 * approach : 2
 * ============
 *
 * The idea is to use multiplication and modular trick to store two elements at an index.
 * 
 * 
 * How does expression “arr[i] += arr[max_index] % max_element * max_element” work ?
 * 
 * The purpose of this expression is to store two elements at index arr[i]. arr[max_index] is stored as multiplier and “arr[i]” is stored as remainder. 
 * 
 * For example in {1 2 3 4 5 6 7 8 9}, max_element is 10 and we store 91 at index 0. With 91, we can get original element as 91%10 and new element as 91/10.
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class x6_rearrage_alternatively {

    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 5, 6, 7 };

        int[] answer = function(input);

        print_array(answer);
    }

    static int[] function(int[] arr) {

        int min_idx = 0;
        int max_idx = arr.length - 1;
        int max_val = arr[arr.length - 1] + 1; //this can be any number greater than maximum number in array

        for (int i = 0; i < arr.length; i++) {
            // at even index , we put max
            if (i % 2 == 0) {
                arr[i] = arr[i] + ((arr[max_idx] % max_val) * max_val);
                max_idx--;
            } else {
                arr[i] = arr[i] + ((arr[min_idx] % max_val) * max_val);
                min_idx++;
            }
        }

        // to get the array in re-arranged fashion
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / max_val;
        }


        // to get the original array
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = arr[i] % max_val;
        // }

        return arr;
    }

    static void print_array(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
