import java.util.*;

/**
 * 
 * Given an integer array and a constant number X, print all pair of number in the array whose product is equal to X.
 * 
 *  follow ups: how will you do in O(n)? how will you handle duplicate pairs?
 * 
 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * 
 * 
 * use hashset , 
 * 
 * remove <i,j> from set if i*j ==x
 * 
 * 
 * 
 * 
 */

class p33_count_pairs_with_given_product {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 6 };
        // int x = 6;
        int x = 12;

        int pairs = Solution.function(arr, x);
        System.out.println(pairs);

    }

}

class Solution {

    static int function(int[] arr, int x) {

        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {
            set.add(i);
        }

        int pairs = 0;
        for (int i : arr) {
            if (x % i == 0) {
                int complement = x / i;
                if (set.contains(i) && set.contains(complement)) {
                    pairs++;
                    set.remove(i);
                    set.remove(complement);

                }
            }
        }

        return pairs;

    }

}
