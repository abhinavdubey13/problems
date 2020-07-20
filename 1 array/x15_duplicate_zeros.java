import java.util.*;

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * 
 * Note that elements beyond the length of the original array are not written.
 * 
 * Do the above modifications to the input array in place, do not return anything from your function.
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: [1,0,2,3,0,4,5,0]
 * 
 * Output: null
 * 
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * 
 * 
 * 
 */

/**
 *  
 * 
 * 
 * 
 * ============
 * approach : 
 * ============
 * 
 * since we cannot use extra space
 * 
 * 1. count number of zeros
 * 2. init 2 pointers , 
 *      - i = arr.len-1 
 *      - j = arr.len -1 + number_of_zeros
 * 
 * 3. copy arr[i] at arr[j] for every number and do this twice if arr[i]==0
 * 
 * 4. repeat the same untill i!=j
 * 
 * https://www.youtube.com/watch?v=io3N5YTFbxM&ab_channel=RajdeepKaur
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x15_duplicate_zeros {

    public static void main(String[] args) {

        // int[] arr = { 2, 0, 9, 1, 0, 2, 4 };
        int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };

        function(arr);

        // System.out.println(answer);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void function(int[] arr) {

        int n = arr.length;

        int num_of_zeros = 0;
        for (int i : arr) {
            num_of_zeros += (i == 0) ? 1 : 0;
        }

        int i = n - 1;
        int j = n - 1 + num_of_zeros;

        while (i != j) {
            insert(arr, i, j);
            j--;
            if (arr[i] == 0) {
                insert(arr, i, j);
                j--;

            }
            i--;
        }

    }

    //put arr[i] at arr[j]
    static void insert(int[] arr, int i, int j) {
        if (j < arr.length) {
            arr[j] = arr[i];
        }
    }

}
