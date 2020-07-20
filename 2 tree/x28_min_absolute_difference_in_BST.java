import java.util.*;

/**
 * 
 * leetcode id : 530
 *
 * Given a binary search tree with non-negative values, 
 * 
 * find the minimum absolute difference between values of any two nodes.
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
 * FACT : inorder traversal of BST gives sorted order
 * 
 * in a sorted sequence , the minimum difference is between 2 consecutive nodes
 * 
 * thus we maintain a prev node global variable
 * 
 * ============
 * TC = O(n)
 * SC = O(ht)
 * 
 * 
 */

public class x28_min_absolute_difference_in_BST extends HELPER {

  static node PREVIOUS;

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(1);
    root.left = new node(2);
    root.right = new node(3);

    int answer = function_util(root);
    System.out.println(answer);

  }

  static int function_util(node root) {
    PREVIOUS = null;
    int[] answer = { Integer.MAX_VALUE };
    function(root, answer);
    return answer[0];
  }

  static void function(node curr, int[] answer) {

    if (curr == null) {
      return;
    }

    function(curr.left, answer);

    if (PREVIOUS == null) {
      PREVIOUS = curr;
    } else {
      answer[0] = Math.min(answer[0], Math.abs(PREVIOUS.data - curr.data));
      PREVIOUS = curr;
    }

    function(curr.right, answer);
  }

}