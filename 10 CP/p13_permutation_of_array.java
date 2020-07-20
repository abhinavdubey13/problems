import java.util.*;

/**
 * 
 * leetcode id : 202
 * 
 * 
 *  
 */

/**
 * 
 *
 * 
 * 
 * 
 */

class p13_permutation_of_array {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };
        // int[] arr = { 1 };

        // int[] arr = { 0,1};

        // int[] arr = { 1, 2, 3, 4 };

        List<List<Integer>> answer = new Solution().function(arr);
        for (List<Integer> lst : answer) {
            for (Integer i : lst) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Solution {

    List<List<Integer>> answer;

    List<List<Integer>> function(int[] arr) {
        answer = new ArrayList<>();
        fun(arr, 0, arr.length - 1);
        return answer;
    }

    void fun(int[] arr, int start, int end) {

        if (start >= end) {
            print_arr(arr);
        } else {

            for (int i = start; i <= end; i++) {
                swap(arr, i, start);
                fun(arr, start + 1, end);
                swap(arr, i, start);
            }
        }

    }

    void swap(int[] arr, int i, int j) {
        if (i < arr.length && j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    void print_arr(int[] arr) {
        // int i = 0;
        // while (i < arr.length) {
        //     System.out.print(arr[i] + " ");
        //     i++;
        // }
        // System.out.println();

        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        answer.add(list);
    }

}
