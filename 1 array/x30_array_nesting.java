import java.util.*;

/**
 * leetcode id : 565
 * 
 * A zero-indexed array A of length N contains all integers from 0 to N-1. 
 * 
 * Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 * 
 * Suppose the first element in S starts with the selection of element A[i] of index = i, 
 * 
 * the next element in S should be A[A[i]], and then A[A[A[i]]]… 
 * 
 * By that analogy, we stop adding right before a duplicate element occurs in S.
 * 
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: A = [5,4,0,3,1,6,2]
 * 
 * Output: 4
 * 
 * Explanation: 
 * 
 * A[0] = 5, 
 * A[1] = 4, 
 * A[2] = 0, 
 * A[3] = 3, 
 * A[4] = 1, 
 * A[5] = 6, 
 * A[6] = 2.
 * 
 * One of the longest S[K]:
 * 
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0} 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * 
 * the basic idea is to find the longst cycle , 
 * also note that nodes in cycle will always be same , ie in above example 
 * 
 * if we begin as 
 * i=0 : cycle = 5-6-2-0
 * i=1 : cycle = 1-4
 * i=2 : cycle = 0-5-6-2
 * i=3 : cycle = 3
 * i=4 : cycle = 1-4
 * i=5 : cycle = 6-2-0-5
 * i=6 : cycle = 2-0-5-6
 * 
 * so we maintain a set of non-visited node and keep removing node from that
 *
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class x30_array_nesting {

    public static void main(String[] args) {

        int[] arr = { 5, 4, 0, 3, 1, 6, 2 };

        int answer = function(arr);

        System.out.println(answer);
    }

    static int function(int[] arr) {

        int n = arr.length;

        Set<Integer> non_visited = new HashSet<Integer>();
        for (int i : arr) {
            non_visited.add(i);
        }

        int max_cycle = Integer.MIN_VALUE;
        int cur_cycle = 0;

        for (int i = 0; i < n; i++) {

            cur_cycle = 0;
            int cur_ele = arr[i];

            while (true) {
                if (non_visited.contains(cur_ele)) {
                    non_visited.remove(cur_ele);
                    cur_cycle++;
                    cur_ele = arr[cur_ele];
                } else {
                    break;
                }
            }

            max_cycle = Math.max(max_cycle, cur_cycle);
        }

        return max_cycle;

    }

}
