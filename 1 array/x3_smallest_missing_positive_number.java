import java.util.*;

/**
 * You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
 * 
 * you are allowed to alter the input array
 * 
 * 
 * 
 * Note: best TC = O(n) , SC = O(1)
 * 
 * ============
 * example : 1
 * ============
 * Input: nums = [1,2,0]
 * Output: 3 
 * 
 * 
 * ============
 * example : 2
 * ============
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * 
 */

/**
 *  
 * ============
 * approach : 1
 * ============
 * using sorting and linear search 
 * ============
 * TC = O(n.lgn)
 * SC = O(1)
 * 
 * 
 * ============
 * approach : 2
 * ============
 * using hasmaps and linear search
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 * ============
 * approach : 3
 * ============
 * using index of the array
 * 
 * NOTE : 
 * 1. for length of input arr = N , answer always lies between [1 , N+1]
 * 2. if numbers in arr[] are {1,2,3,4,5...N} then answer = N+1
 * 3. for other cases , answer lies b/w [1,N]
 * 
 * STEP-1 : for non-positive numbers (-ive and 0) and numbers greater than N , convert them into a marker number
 * STEP-2 : scan the array from L-R , and for every non-marker array entry (say x) , goto arr[x] and negate it
 * STEP-3 : scan the array from L-R , the first index at which a positive number is there , return idx+1
 * 
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class x3_smallest_missing_positive_number {

    public static void main(String[] args) {
        // int[] input = { 0, -10, 1, 3, -20 }; // expected = 2

        // int[] input = { 1, 2, 3, 4, 5 }; // expected =6

        // int[] input = { 3, 4, -1, 1 }; // expected =2

        // int[] input = { 2 }; // expected = 1

        int[] input = { 10,11,12 }; // expected = 1


        int answer = function(input);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        final int MARKER = arr.length + 2;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0 || arr[i] > arr.length) {
                arr[i] = MARKER;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int x = Math.abs(arr[i]);
            if (x != MARKER) {
                //since answer lies from [1,N] , we will not be able to goto index 0
                //so we do x-- , here
                x--;
                if (arr[x] > 0) {
                    arr[x] = arr[x] * -1;
                }
            }
        }

        //final scan to find the required number
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        // if numbers in arr[] are {1,2,3,4,5...} then answer = arr.len+1
        return arr.length + 1;
    }

}
