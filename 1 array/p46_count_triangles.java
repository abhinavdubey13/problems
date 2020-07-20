import java.util.*;

/**
 * 
 * leetcode id : 
 *
 * 
 * Given an unsorted array of positive integers, 
 * 
 * find the number of triangles that can be formed with three different array elements as three sides of triangles. 
 * 
 * For a triangle to be possible from 3 values, the sum of any of the two values (or sides) must be greater than the third value (or third side).
 * 
 * ==========
 * example :
 * ==========
 * 
 * i/p : {4, 6, 3, 7}
 * o/p : 3
 * 
 */

/**
 * ============
 * approach : 1
 * =============
 * 
 * sort input array
 * 
 * fix i and j (i+1) as the 2 sides
 * 
 * find the 3rd side using k (initially i+1) .............bcz trialngle can be isoseles also (2 sides same)
 * 
 *  
 * 
 * ===============
 * TC = O(n.logn + n^2)
 * SC = O(n)
 * 
 * 
 */

class p46_count_triangles {

    public static void main(String[] args) {
        // int arr[] = { 2, 7, 5, 3, 0, 8, 1 };

        // int arr[] = { 4, 6, 3, 7 };

        int arr[] = { 4,4,4 };


        int answer = function(arr);
        System.out.println(answer);

    }

    static int function(int[] arr) {

        int n = arr.length;

        if (n < 3) {
            return 0;
        }

        int count = 0;
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {

            for (int j = i + 1; j < n - 1; j++) {

                int k = i + 1;

                // Find the rightmost element which is smaller than the sum of two fixed elements 
                while (k < n && arr[i] + arr[j] > arr[k]) {
                    k++;
                }

                // One is subtracted from k because k is incremented one extra in above while loop
                if (k > j) {
                    count += k - j - 1;
                }

            }
        }

        return count;

    }

}
