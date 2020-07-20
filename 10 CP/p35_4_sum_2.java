import java.util.*;

/**
 * 
 * leetcode id : 454
 * 
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * 
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * 
 *  
 */

/**
 * 
 * using hashmap
 * 
 * hash every combination (c,d) 
 * 
 * and check for complement using every (a,b)
 *  
 * 
 * TC = n^2
 * SC = n^2
 * 
 * 
 * 
 */

class p35_4_sum_2 {

    public static void main(String[] args) {

        int[] A = { 1, 2 };
        int[] B = { -1, -2 };
        int[] C = { -1, 2 };
        int[] D = { 0, 2 };

        int answer = Solution.function(A, B, C, D);
        System.out.println(answer);

    }
}

class Solution {

    static int function(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int c : C) {
            for (int d : D) {
                int s = c + d;
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int result = 0;
        for (int a : A) {
            for (int b : B) {
                int req_sum = -1 * (a + b);
                result += map.getOrDefault(req_sum, 0);
            }
        }
        return result;

    }
}
