import java.util.*;

/**
 * 
 * leetcode id : 563
 * 
 * Given the root of a binary tree, return the sum of every tree node's tilt.
 * 
 * The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. 
 * 
 * If a node does not have a left child, then the sum of the left subtree node values is treated as 0. 
 * 
 * The rule is similar if there the node does not have a right child.
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
 * ============
 * 
 * set all tilt at each node
 * 
 * then find sum of all those tilts
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class x34_tilt_of_binary_tree extends HELPER {

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(4);
    root.left = new node(2);
    root.left.left = new node(3);
    root.left.right = new node(5);

    root.right = new node(9);
    root.right.right = new node(7);

    int answer = function_util(root);
    System.out.println(answer);
  }

  static int function_util(node root) {

    if (root == null || isLeaf(root)) {
      return 0;
    }

    set_tilt(root);
    int[] answer = new int[] { 0 };
    get_sum_of_tilts(root, answer);
    return answer[0];

  }

  static int set_tilt(node curr) {

    if (curr == null) {
      return 0;
    }

    if (isLeaf(curr)) {
      int return_val = curr.data;
      curr.data = 0;
      return return_val;
    }

    int sum_lst = set_tilt(curr.right);
    int sum_rst = set_tilt(curr.left);

    int sum_of_tree_here = sum_lst + sum_rst + curr.data;
    curr.data = Math.abs(sum_lst-sum_rst);

    return sum_of_tree_here;
  }

  static void get_sum_of_tilts(node curr, int[] answer) {
    if (curr == null) {
      return;
    }

    answer[0] += curr.data;
    get_sum_of_tilts(curr.left, answer);
    get_sum_of_tilts(curr.right, answer);

  }

}