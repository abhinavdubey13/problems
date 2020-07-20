import java.util.*;

/**
 * 
 * LC id : 78
 * 
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * 
 * 
 * Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 * 
 *  
 */

/**
 * 
 * backtracking
 * 
 * each index has 2 choices : include or exclude
 * 
 * total subsets : 2^n
 *
 * 
 * 
 * 
 */

class p15_all_subsets {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };

        List<List<Integer>> answer = new Solution().function(arr);
        for (List<Integer> list : answer) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("answer length : " + answer.size());
    }
}

class Solution {

    List<List<Integer>> answer;

    List<List<Integer>> function(int[] arr) {
        List<Integer> temp = new ArrayList<>();
        answer = new ArrayList<>();
        fun(arr, 0, arr.length, temp, false);
        fun(arr, 0, arr.length, temp, true);
        return answer;
    }

    void fun(int[] arr, int idx, int n, List<Integer> tmp, boolean is_to_be_added) {
        if (idx < n) {

            if (is_to_be_added) {
                tmp.add(arr[idx]);
            }

            if (idx + 1 < n) {
                fun(arr, idx + 1, n, tmp, false);
                fun(arr, idx + 1, n, tmp, true);
            } else {
                print_list(tmp);
            }

            if (is_to_be_added) {
                tmp.remove(tmp.size() - 1);
            }
        }

    }

    void print_list(List<Integer> list) {

        List<Integer> l = new ArrayList<>();
        for (Integer i : list) {
            l.add(i);
            // System.out.print(i + " ");
        }
        // System.out.println();
        answer.add(l);
    }

}
