import java.util.*;

/**
 * 
 * leetcode id : 
 * 
 * https://www.geeksforgeeks.org/remove-duplicates-from-an-array-of-small-primes/ 
 * 
 * Given an array of primes such that the range of primes is small. Remove duplicates from the array.
 *  
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * using 2 loops
 *  
 * ============
 * TC = O(n.n)
 * SC = O(uniq)
 * 
 * 
 * 
 * ============
 * approach : 2
 * ============
 * using sorting
 *  
 * ============
 * TC = O(n.logn)
 * SC = O(uniq)
 * 
 * 
 * ============
 * approach : 3
 * ============
 * using hashing
 *  
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 * ============
 * approach : 4
 * ============
 * using product
 * 
 * Initially keep a variable (p = 1).
 * 
 * Traverse the array from start to end.
 * 
 * While traversing, check whether p is divisible by the i-th element. If true, then erase that element.
 * 
 * Else keep that element and update the product by multiplying that element with the product (p = p * arr[i])
 *  
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 *  
 * 
 * 
 * 
 * 
 * 
 */

class p26_closet_node_to_given_val_in_BST {

    public static void main(String[] args) {

    }

}

class Solution {

}