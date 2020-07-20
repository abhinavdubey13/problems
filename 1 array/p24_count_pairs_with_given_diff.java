import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * 
 * Given an integer array and a positive integer k, count all distinct pairs with difference equal to k. 
 * 
 * =========
 * example : 
 * =========
 * Input: arr[] = {1, 5, 3, 4, 2}, k = 3
 * Output: 2
 * There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2} 
 * 
 * 
 * Input: arr[] = {8, 12, 16, 4, 0, 20}, k = 4
 * Output: 5
 * There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20} 
 * 
 */

/**
 * =============
 * approach : 1
 * =============
 * 
 * use 2 loops : check all possible pairs
 * TC= O(n^2)
 * SC= O(1)
 * 
 * 
 * =============
 * approach : 2
 * =============
 * 
 * use sorting , 
 * 
 * 1) Initialize count as 0
 * 2) Sort all numbers in increasing order.
 * 3) Remove duplicates from array.
 * 4) Do following for each element arr[i]
 *      a) Binary Search for arr[i] + k in subarray from i+1 to n-1.
 *      b) If arr[i] + k found, increment count. 
 * 5) Return count.
 * 
 * TC= O(n.logn)
 * SC= O(n)
 * 
 * 
 * =============
 * approach : 3
 * =============
 * 
 * use hash set
 * 
 * 1. insert uniq elements 
 * 2. look for arr[i]+k  and arr[i]-k , increase count of found 
 * 3. remove arr[i] from set 
 * 
 * WHY REMOVING arr[i] WORKS ? 
 * bcz we have already considered all pairs , one element of whose is arr[i] , 
 * so we do not need arr[i] further
 * 
 * example : (required diff = 4 )
 * 
 * if arr[i] = 8 : we check if set has 
 *  1.) 4  (8-4=4) , and 
 *  2.) 12 (12-8=4)
 * 
 * now next , when arr[i] = 12 : we check if set has 
 *  1.) 8  (12-8=4) , and  =========> BUT THIS WAS ALREADY CHECKED PREVIOUSLY : thus we find repeating pairs if we have NOT removed 8 previously
 *  2.) 16 (16-12=4) 
 * 
 * 
 * ===========
 * TC= O(n)
 * SC= O(n)
 * 
 */

class p24_count_pairs_with_given_diff {

    public static void main(String[] args) {
        // int arr[] = { 1, 5, 3, 4, 2 };
        // int diff = 3;

        int arr[] = { 8, 12, 16, 4, 0, 20, 8, 12 };
        int diff = 4;

        int answer = function(arr, diff);
        System.out.println(answer);

    }

    static int function(int arr[], int diff) {

        HashSet<Integer> hash = new HashSet<Integer>();

        for (int i : arr) {
            hash.add(i);
        }

        int count = 0;
        for (int i : arr) {
            if (hash.contains(i + diff)) {
                count++;
            }
            if (hash.contains(i - diff)) {
                count++;
            }

            hash.remove(i); //we have already considered all pairs , one element of whose is arr[i] , so we do not need arr[i] further
        }

        return count;

    }

}
