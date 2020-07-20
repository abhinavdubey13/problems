import java.util.*;

/**
 * leetcode id : 1442
 * 
 * Given an array of integers arr.
 * We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
 * let's define a and b as follows:
 * 
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * 
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 
 * Note that ^ denotes the bitwise-xor operation.
 * Return the number of triplets (i, j and k) Where a == b.
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: arr = [2,3,1,6,7]
 * Output: 4
 * Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
 * 
 * 
 * 
 */

/**
 *  
 * ===========
 * approach : 
 * ===========
 * 
 * We are searching for sub-array of length ≥ 2 and we need to split it to 2 non-empty arrays so that 
 * the xor of the first array is equal to the xor of the second array. 
 * 
 * This is equivalent to searching for sub-array (size>=2) with xor = 0.
 *  
 * Start from every array index as start index and find all the possible subarrays.
 * If there exists a subarray with XOR = 0, it means it has possible i,j and k.
 * 
 * Add (j-i) to total.
 * 
 * 
 *  
 * ========================
 * TC = O(n^2)
 * SC = O(1)
 * 
 * 
 */

class x12_xor_triplets {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 6, 7 };

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        int answer = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int xor = arr[i];

            for (int j = i + 1; j < arr.length; j++) {

                xor = xor ^ arr[j];

                if (xor == 0) {
                    //the number of triplets is (size_of_subarray-1)
                    answer += (j - i);
                }
            }
        }

        return answer;

    }

}
