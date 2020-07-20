import java.util.*;

/**
 * sort an array which has only 0,1,2 in random order
 * 
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * 
 * =========
 * example :
 * =========
 * input  = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
 * output = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2 };
 * 
 */

/**
 * =============
 * approach   : 
 * =============
 * using single linear traversal 
 *  
 * TC= O(n)
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p21_sort_0_1_2 {

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        function(arr);

        // System.out.println(answer);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void function(int arr[]) {

        // int low = 0, mid = 0, high = arr.length - 1;
        // while (mid <= high) {
        //     if (arr[mid] == 0) {
        //         swap(arr, mid, low);
        //         low++;
        //         mid++;
        //     } else if (arr[mid] == 1) {
        //         // increment mid
        //         mid++;
        //     } else if (arr[mid] == 2) {
        //         swap(arr, mid, high);
        //         high--;
        //     }
        // }

        int low = -1; //last index at which 0 was found
        int high = arr.length; //index at which 2 begins
        int mid = 0; //runner

        while (mid < high) {
            if (arr[mid] == 0) {
                low++;
                swap(arr, low, mid);
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                high--;
                swap(arr, mid, high);
            }
        }

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}