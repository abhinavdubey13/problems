import java.util.*;

/**
 * 
 * leetcode id : 
 *
 * Given an array of integers, find any one combination of four elements in the array whose sum is equal to a given value req_sum.

 * 
 * ==========
 * example :
 * ==========
 * 
 * Input: array = {10, 2, 3, 4, 5, 9, 7, 8} 
 * req_sum = 23 
 * Output: 3 5 7 8
 * Sum of output is equal to 23, 
 * i.e. 3 + 5 + 7 + 8 = 23.
 * 
 * Input: array = {1, 2, 3, 4, 5, 9, 7, 8}
 * req_sum = 16 
 * Output: 1 3 5 7
 * Sum of output is equal to 16, 
 * i.e. 1 + 3 + 5 + 7 = 16.
 * 
 */

/**
 * ============
 * approach : 1
 * =============
 * 
 * brute force : using 4 nested loops
 * ===============
 * TC = O(n^4)
 * SC = O(1)
 * 
 * 
 * ============
 * approach : 2
 * =============
 * 1) sorting the array 
 * 
 * 2) Fix the first element as A[i] where i is from 0 to n–3. 
 * After fixing the first element of quadruple, fix the second element as A[j] where j varies from i+1 to n-2. 
 * Find remaining two elements in O(n) time, using the method 1 of this post
 * 
 * ===============
 * TC = O(n^3)
 * SC = O(1)
 * 
 * 
 * ============
 * approach : 3
 * =============
 * using hashmap
 * 
 * 1. Store sums of all pairs in a hash table
 * 2. Traverse through all pairs again and search for req_sum – (current pair sum) in the hash table.
 * 3. If a pair is found with the required sum, then make sure that all elements are distinct array elements and 
 * an element is not considered more than once.
 * 
 * ===============
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * 
 */

class pair {
    int first, second;

    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class p50_sum_of_4 {

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 1, 2 };
        int req_sum = 91;

        function(arr,req_sum);
        System.out.println();
        
        
    }

    static void function(int arr[], int req_sum){

        int n = arr.length;
        
        // Store sums of all pairs in a hash table
        HashMap<Integer, pair> hmap = new HashMap<Integer, pair>();

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                hmap.put(arr[i] + arr[j], new pair(i, j));
 
        // Traverse through all pairs and search for req_sum - (current pair sum).
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
 
                // If req_sum - sum is present in hash table,
                if (hmap.containsKey(req_sum - sum)) {
 
                    // Making sure that all elements are distinct 
                    pair p = hmap.get(req_sum - sum);
                    if (p.first != i && p.first != j && p.second != i && p.second != j) {
                        System.out.print(arr[i] + ", " + arr[j] + ", "+ arr[p.first] + ", "+ arr[p.second]);
                        return;
                    }
                }
            }
        }

        System.out.println("not possible");

    }

}
