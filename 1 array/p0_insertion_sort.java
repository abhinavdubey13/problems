import java.util.*;

/**
 * 
 * leetcode id : 
 *
 * program for insertion sort
 * 
 * this apporach is used sometimes in other questions
 * 
 * ==========
 * example :
 * ==========
 * 
 * i/p : un-sorted array
 * o/p : sorted array
 * 
 */

/**
 * ============
 * approach : 1
 * =============
  
 * 
 * ===============
 * TC = O(n^2)
 * SC = O(1)
 * 
 * 
 */

class p0_insertion_sort {

    public static void main(String[] args) {
        // int arr[] = { 2, 7, 5, 3, 0, 8, 1 };

        int arr[] = { 3, 2, 1, 6, 5, 4, 9, 8, 7 };

        // int answer = function(arr);
        // System.out.println(answer);

        function(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    static void function(int[] arr) {
        int n = arr.length;

        if (arr.length <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {

            int val_to_be_inserted = arr[i];

            int j = i - 1;

            while (j >= 0) {

                //if cur element is greater than value , shift it to the right
                if (arr[j] > val_to_be_inserted) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }

            //j might become -1 in above while loop
            //thus we need to put value at j+1 ALWAYS
            arr[j + 1] = val_to_be_inserted;

        }

    }

}
