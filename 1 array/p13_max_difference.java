
/** 
 * given an unsorted array , find the maximum difference between 2 elements  : arr[j]-arr[i] : j>i
 * 
 * https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 * 
 */

/**
 * =========================
 * approach 1  : brute-force
 * =========================
 * using sorting , or two loops
 * 
 * 
 * 
 * =========================
 * approach 2  : optimal
 * =========================
 * 
 * scan from left to right , keeping track of 
 * 
 * 1. minimum element so far , and 
 * 
 * 2. maximum difference so far
 * 
 * TC= O(N)
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p13_max_difference {

    static int function(int[] arr) {

        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];

        for (int i = 1; i < arr.length; i++) {
            min_element = Math.min(min_element, arr[i]);
            max_diff = Math.max(max_diff, arr[i] - min_element);
        }

        return max_diff;

    }

    public static void main(String[] args) {

        // int arr[] = { 1, 2, 90, 10, 110 };
        int[] arr = { 80, 2, 6, 3, 100 };

        System.out.println(function(arr));
    }

}