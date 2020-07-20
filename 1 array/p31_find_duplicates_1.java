import java.util.*;

/**
 * given an array of size N 
 * 
 * each element can be [0,N-1] ie. Range of elements
 * 
 * there is an element which is occuring twice , others are coming only once
 * 
 * 
 * find that number
 * 
 * ==========
 * example :
 * ==========
 * 
 * i/p : 0 1 1 2
 * 0/p : 1
 * 
 * i/p : 0 1 3 2
 * 0/p : no duplicates (or u can give -1 )
 * 
 * 
 * 
 */

/**
 *  
 * =======================
 * approach : 1 (sorting)
 * =======================
 * 
 * sort the array and compare the adjacent pairs , if same , then thats the duplicate
 *
 * TC= O(N.log N)
 * SC= O(1)
 * 
 * 
 * 
 * ===========================================
 * approach : 2 (only works for 1 duplicate)
 * ============================================
 * 
 * duplicate = (sum of the input array) - (sum of numbers from 0...n-1)
 *
 * TC= O(N)
 * SC= O(1)
 * 
 * 
 * 
 * ========================
 * approach : 3 (hashing)
 * ========================
 * 
 * maintain a hashtable : <k,v> = <a[i] , count(a[i])>
 * we need 2 traversals of input array here
 *
 * TC= O(N)
 * SC= O(N)
 * 
 * 
 * ========================
 * approach : 3 (optimal)
 * ========================
 * We iterate over each element and mark its corresponding index by setting its sign to minus. 
 * If we already marked it as negative, it means its INDEX (NOT THE VALUE @ INDEX) is a duplicate.
 * 
 *
 * TC= O(N)
 * SC= O(1)
 * 
 */

class p31_find_duplicates_1 {

    public static void main(String[] args) {
        // int arr[] = { 0, 1, 1, 2 };
        // int arr[] = { 0, 3, 1, 2 };

        int arr[] = { 0, 3, 0, 2 }; //this solution will not work if we have 0 as duplicate

        function(arr);
    }

    static void function(int arr[]) {

        Integer duplicate_val = null;

        for (int i = 0; i < arr.length; i++) {

            int abs_idx = Math.abs(arr[i]);

            if (arr[abs_idx] < 0) {
                duplicate_val = abs_idx; //duplicate value is the index itself , not the value at index
                break;
            } else {
                arr[abs_idx] = -1 * arr[abs_idx];
            }

        }

        if (duplicate_val == null) {
            System.err.println("no duplicates");
        } else {
            System.err.println(duplicate_val.intValue() + " is the duplicate element");

        }

    }

}