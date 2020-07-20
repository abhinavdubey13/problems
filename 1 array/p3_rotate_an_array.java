import java.util.*;

/**
 * given an array and number of rotations (R), task if to rotate the array
 * 
 *
 * 
 * ==========
 * example :
 * ==========
 * 
 * arr = {1,2,3,4,8}
 * R = 2
 * 
 * output = { 3,4,8,1,2} 
 */

/**
 * ==========
 * approach :
 * ===========
 * 
 * 1. reverse the first R entries of array (0 .... R-1)
 * 2. reverse the remaining entries (R+1 ..... N )
 * 3. reverse the entrire array (0......N )
 * 
 * input array size = N
 * 
 * TC = O(N)
 * SC = O(1)
 * 
 * 
 */

class p3_rotate_an_array {

    public static void main(String[] args) {
        // int arr[] = { 1, 20, 6, 4, 5 };
        int arr[] = { 1, 2, 3, 4, 6, 7, 8 };

        int R = 2;
        function(arr, R);
        print_array(arr);
    }

    static void function(int[] arr, int R) {

        if (R == 0)
            return;
        int n = arr.length;
        rverese_array(arr, 0, R - 1);
        rverese_array(arr, R, n - 1);
        rverese_array(arr, 0, n - 1);
    }

    static void rverese_array(int arr[], int START, int END) {
        int temp = 0;
        while (START < END) {
            temp = arr[START];
            arr[START] = arr[END];
            arr[END] = temp;
            START++;
            END--;
        }
    }

    static void print_array(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}