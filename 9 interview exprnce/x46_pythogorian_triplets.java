import java.util.*;

/**
 *
 * https://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
 *
 * 
 * Given an array of integers, write a function that returns true if 
 * 
 * there is a triplet (a, b, c) that satisfies a2 + b2 = c2
 * 
 */

/**
 * 
 * approach-1
 * running 3 loops
 * 
 * TC = n^3
 * 
 * 
 * 
 * 1) Do square of every element in input array. This step takes O(n) time.
 * 2) Sort the squared array in increasing order. This step takes O(nLogn) time.
 * 3) To find a triplet (a, b, c) such that a2 = b2 + c2, do following. 
 * 
 * Fix ‘a’ as last element of sorted array.
 * 
 * Now search for pair (b, c) in subarray between first element and ‘a’. 
 * 
 * A pair (b, c) with given sum can be found in O(n) time using 2 pointers
 * 
 * If no pair found for current ‘a’, then move ‘a’ one position back and repeat step 3.2.
 * 
 * 
 * 
 * 
 *
 */

class x46_pythogorian_triplets {

    public static void main(String[] args) {

    }

}

class Solution {

    boolean function(int[] arr, int m) {
        return false;

    }

}