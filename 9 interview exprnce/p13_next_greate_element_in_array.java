import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/next-greater-element/
 * 
 * Given an array, print the Next Greater Element (NGE) for every element. 
 * 
 * The Next greater Element for an element x is the first greater element on the right side of x in the array. 
 * Elements for which no greater element exist, consider next greater element as -1. 
 *  
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * 
 * using 2 loops 
 * 
 * TC=O(n^2)
 * SC=O(1)
 * 
 * 
 * 
 * ============
 * approach : 2
 * ============
 * 
 * using stack 
 * 
 * traverse arr from end , 
 * 
 * 
 * while top of stack <= current : pop
 * 
 * if for current element , stack is empty , NGE[i] = -1 
 * 
 * 
 * 
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

class p13_next_greate_element_in_array {

    public static void main(String[] args) {

        int[] arr = { 10, 4, 5, 2, 25 };

        Solution.function(arr);
        System.out.println();

    }

}

class Solution {

    static void function(int[] arr) {

        int n = arr.length;

        if (n == 0) {
            return;
        }

        else if (n == 1) {
            System.out.print(-1);
            return;
        }

        int[] answer = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            int curr = arr[i];

            while (stk.size() > 0 && stk.peek() <= curr) {
                stk.pop();
            }

            answer[i] = (stk.size() == 0) ? -1 : stk.peek();
            stk.push(curr);
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + "\t" + answer[i]);
        }

    }
}