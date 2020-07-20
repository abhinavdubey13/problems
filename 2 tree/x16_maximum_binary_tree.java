import java.util.*;

/**
 * 
 * leetcode id : 654
 * 
 * You are given an integer array nums with no duplicates. 
 * 
 * A maximum binary tree can be built recursively from nums using the following algorithm:
 * 
 * 1. Create a root node whose value is the maximum value in nums.
 * 
 * 2. Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * 
 * 3. Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * 
 * Return the maximum binary tree built from nums
 *
 * 
 * ==========
 * example :
 * ==========
 * 
 * i/p : 
 * o/p : 
 * 
 */

/**
 * ============
 * approach : 1
 * =============
 * recursive
 * 
 * maintain low and high at each function call , to be able to know the range in the input array to search for Largest number
 * 
 * 
 * 
 * ==============
 * TC = O(n)
 * SC = O(height)
 * 
 * 
 */

public class x16_maximum_binary_tree extends HELPER {

  public static void main(String[] args) {

    int[] arr = { 3, 2, 1, 6, 0, 5 };

    node root = function_util(arr);

    HELPER.perform_inorder(root);
    System.out.println();

  }

  static node function_util(int[] arr) {
    return function(arr, 0, arr.length - 1);
  }

  static node function(int[] arr, int low, int high) {
    int n = arr.length;
    if (low < 0 || high >= n) {
      return null;
    }

    node curr = null;

    if (low == high) {
      curr = new node(arr[low]);
      return curr;

    }

    int idx = find_max_idx(arr, low, high);
    curr = new node(arr[idx]);

    if (idx == low) {
      curr.right = function(arr, low + 1, high);
    } else if (idx == high) {
      curr.left = function(arr, low, high - 1);

    } else {
      curr.left = function(arr, low, idx - 1);
      curr.right = function(arr, idx + 1, high);
    }

    return curr;

  }

  static int find_max_idx(int[] arr, int low, int high) {
    int answer = low;
    for (int i = low; i <= high; i++) {
      if (arr[answer] < arr[i]) {
        answer = i;
      }
    }
    return answer;
  }

}