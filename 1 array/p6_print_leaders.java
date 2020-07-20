import java.util.*;

/**
 * Write a program to print all the LEADERS in the array.
 * 
 * An element is leader if it is greater than all the elements to its right side. 
 * 
 * And the rightmost element is always a leader. 
 * 
 *
 * 
 * ==========
 * example :
 * ==========
 * 
 * arr = {16, 17, 4, 3, 5, 2}
 * leaders are 17, 5 and 2
 * 
 * 
 */

/**
 * ==========
 * approach :
 * ===========
 * brute force : run 2 loops : O(n^2)
 * 
 * efficient : scan from RHS
 * 
 * 
 * input array size = N 
 * TC = O(N)
 * SC = O(1)
 * 
 * 
 */

class p6_print_leaders {

    public static void main(String[] args) {
        int arr[] = { 16, 17, 4, 3, 5, 2 };
        function(arr);
    }

    static void function(int arr[]) {

        if (arr.length == 0) {
            return;
        }

        int last_element = arr[arr.length - 1];
        int max_till_now = last_element;

        //last element is alawys a leader
        System.out.print(last_element + " ");

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max_till_now) {
                max_till_now = arr[i];
                System.out.print(arr[i] + " ");
            }
        }

        System.out.println();

    }

}