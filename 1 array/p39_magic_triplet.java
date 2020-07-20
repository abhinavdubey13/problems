import java.util.*;

/**
 * 
 * Given an unsorted-array of size n, a triplet (a[i], a[j], a[k]) is called a Magic Triplet if a[i] < a[j] < a[k] and i < j < k.  
 * Count the number of magic triplets in a given array.
 * 
 * 
 * https://www.geeksforgeeks.org/find-number-of-triplets-in-array-such-that-aiajak-and-ijk/
 * 
 * =========
 * example :
 * ========
 * 
 * [1,2,3,4] => 4 such triplets => <1,2,3> , <1,2,4> , <1,3,4> , <2,3,4>
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * Find the smaller_left[] => smaller_left[i] represents the number of elements smaller than a[i] and in left side of it ( from 0 to i-1 ).
 * 
 * Find the greater_right array => greater_right[i] represents the number of elements greater than a[i] and in right side to it ( from i+1 to n-1 )
 * 
 * 
 * the final answer will be the sum of the product of greater_left[i] and smaller_right[i] for every index.
 *
 * 
 * 
 * TC= O(N^2)
 * SC= O(N) 
 * 
 */

class p39_magic_triplet {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 }; //expected = 4
        // int arr[] = { 3,2,1 }; //expected =0 

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int arr[]) {

        int n = arr.length;
        int[] smaller_nums_left = new int[n];
        int[] greater_nums_right = new int[n];

        for (int i = 0; i < n; i++) {

            int smaller = 0;
            int greater = 0;

            int current = arr[i];

            for (int j = 0; j < i; j++) {
                smaller += (arr[j] < current) ? 1 : 0;
            }

            for (int k = i + 1; k < n; k++) {
                greater += (arr[k] > current) ? 1 : 0;
            }

            smaller_nums_left[i] = smaller;
            greater_nums_right[i] = greater;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {

            result += smaller_nums_left[i] * greater_nums_right[i];
        }

        return result;

    }

}
