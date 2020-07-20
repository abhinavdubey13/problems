import java.util.*;

/**
 * 
 * leetcode id : 404
 *
 * Find the sum of all left leaves in a given binary tree.
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
 * maintain direction as a parameter in function call
 * 
 * ============
 * TC = O(n)
 * SC = O(ht)
 * 
 * 
 */

public class x30_sum_of_left_leaves extends HELPER {

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(20);
    root.left = new node(8);
    root.left.left = new node(4);
    root.left.right = new node(12);
    root.left.right.left = new node(10);
    root.left.right.right = new node(14);

    root.right = new node(22);
    root.right.right = new node(25);

  }

  static int function_util(node root) {
    if (root == null || root.left == null && root.right == null) {
      return 0;
    }

    int[] answer = { 0 };
    function(root.left, answer, 'L');
    function(root.right, answer, 'R');

    return answer[0];
  }

  static void function(node curr, int[] answer, char direction) {
    if (curr == null) {
      return;
    }

    if (isLeaf(curr) && direction == 'L') {
      answer[0] += curr.data;
    }

    function(curr.left, answer, 'L');
    function(curr.right, answer, 'R');

  }

}