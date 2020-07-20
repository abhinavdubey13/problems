
/**
 * 
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array.
 * 
 * 
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * 
 * =========
 * example :
 * =========
 * i/p : 3 2 7 10 
 * o/p : 13  (3+10)
 * 
 * i/p : 3 2 5 10 7
 * o/p :  15 (sum of 3, 5 and 7).
 * 
 */

/**
 * ======================
 * approach   : using DP
 * =====================
 * 
 * 1 d arrays will be required
 * 
 * TC= O(n)
 * SC= O(n)
 * 
 * 
 * ====================================
 * approach   : using single traversal
 * ====================================
 * 
 * TC= O(n)
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p23_max_sum_without_adjacent {

    public static void main(String[] args) {
        int arr[] = { 11, 12, 13, 14, 15, 16 };
        function(arr);
    }

    static void function(int arr[]) {

        int excluding_ = 0;
        int including_ = arr[0];

        int temp = 0;

        for (int i = 1; i < arr.length; i++) {

            //this is used to calculate excluding_ for this round
            //if we want to exclude the current element , we can either include/exclude the previous elements (the one which gives max result)
            temp = Math.max(excluding_, including_);

            //when we include current , we need to exclude prev
            including_ = excluding_ + arr[i];

            //if we exclude current 
            excluding_ = temp;

        }

        System.out.println(Math.max(excluding_, including_));

    }

}