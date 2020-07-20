import java.util.*;

/**
 * 
 * given an array which represents a number , [2,1,3,4] = 2134
 * 
 * find a number X , using the same digits , which is JUST greater than the original number 
 *  
 * https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 * 
 * 
 * ==========
 * example : 
 * ==========
 * 
 * i/p : 5, 3, 4, 9, 7, 6 
 * o/p : 5, 3, 6, 4, 7, 9 
 * 
 * i/p : 1, 2, 5, 4, 6, 7
 * o/p : 1, 2, 5, 4, 7, 6 
 * 
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * 
 * 
 * case-1 : if array is sorted in descending order : NOT POSSIBLE
 * case-2 : if array is sorted in ascending order : SWAP last 2 digits
 * 
 * CASE-3 :
 * 
 * 1. scan form RHS and find index i , such that arr[i]<arr[i+1]
 * 
 * 2. find the smallest number just bigger than on RHS of arr[i]
 * 
 * 3. swap arr[i] and the smallest number
 * 
 * 4. sort the array on RHS of i
 * 
 * 
 * if number obtained is even : we have the answer
 * else repeat the same , to get a even number
 * 
 * 
 * TC= O(N log.N)
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p31_next_greater_even_number_with_same_digits {

    public static void main(String[] args) {
        int arr[] = { 5, 3, 4, 9, 7, 6 }; // expected = 5 3 6 7 9 4
        // int arr[] = { 5, 4, 3, 2, 1 }; // expected = not possible
        // int arr[] = { 3, 4, 7, 2, 2, 6, 4, 1 }; // expected = 3 4 7 2 1 2 4 6 
        // int arr[] = { 4, 7, 9 }; // expected = 7,9,4 
        // int arr[] = { 4, 9, 7 }; // expected = 7,9,4 

        Solution.function(arr);
    }

}

class Solution {

    static void function(int arr[]) {

        int n = arr.length;
        int req_idx = -1;

        //from 2nd last till 0th index , find an index i , such that a[i]<a[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                req_idx = i;
                break;
            }
        }

        if (req_idx == -1) {
            //if array is sorted in descing order
            System.out.println("not possible");
            return;
        }

        //EITHER DO THIS 
        // int diff = Integer.MAX_VALUE;
        // int just_larger_idx = req_idx + 1;
        // for (int i = n - 1; i > req_idx; i--) {
        //     int curr_diff = (arr[i] > arr[req_idx]) ? (arr[i] - arr[req_idx]) : Integer.MAX_VALUE;
        //     if (curr_diff < diff) {
        //         just_larger_idx = i;
        //         diff = curr_diff;
        //     }
        // }

        //OR DO THIS 
        Arrays.sort(arr, req_idx + 1, n);
        int just_larger_idx = req_idx + 1;

        //swap req_idx and just_larger_idx
        int temp = arr[req_idx];
        arr[req_idx] = arr[just_larger_idx];
        arr[just_larger_idx] = temp;

        //sort the array after the required_idx
        Arrays.sort(arr, req_idx + 1, n);

        if (arr[n - 1] % 2 == 0) {
            //print : as we have our answer
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            function(arr);
        }

    }

}
