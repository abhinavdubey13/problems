import java.util.*;

/**
 * 
 * 
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * 
 * then the whole array will be sorted in ascending order.
 * 
 * Return the shortest such subarray and output its length
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * 
 * 
 */

/**
 *  
 * =============
 * approach : 1
 * =============
 * 
 * use extra array to copy new elements and sort it
 * find the first and last indices which are not equal to the input array
 * 
 * ============
 * TC = O(n.logn)
 * SC = O(n)
 * 
 * 
 * =============
 * approach : 2
 * =============
 * 
 * idx_1 : the left-most index which has an element smaller to it on the RHS
 * idx_2 : the right-most index which has an element greater to it on the LHS
 * 
 * return (idx1-idx2+1)
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x14_shortest_unsorted_subarray {

    public static void main(String[] args) {

        // int[] arr = { 2, 6, 4, 8, 10, 9, 15 }; //expected = 5
        // int[] arr = { 3, 1, 2, 4, 5, 6 }; //expected =3
        int[] arr = { 1, 2, 3, 4, 5 }; //expected =0

        int answer = function_2(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        if (arr.length == 0 || arr.length == 1) {
            return 0;
        }

        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp);

        ArrayList<Integer> idx = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != temp[i]) {
                idx.add(i);
            }
        }

        if (idx.size() == 0) {
            return 0;
        }

        return Math.abs(idx.get(0) - idx.get(idx.size() - 1)) + 1;

    }

    static int function_2(int[] arr) {

        int n = arr.length;

        if (n == 0 || n == 1) {
            return 0;
        }

        int begin = -1;
        int end = -1;

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (arr[i] < max) {
                end = i;
            }
        }

        int min = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(min, arr[i]);
            if (arr[i] > min) {
                begin = i;
            }
        }

        if (end == begin) {
            return 0;
        }

        return end - begin + 1;

    }

}
