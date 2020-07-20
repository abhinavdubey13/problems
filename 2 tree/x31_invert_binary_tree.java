import java.util.*;

/**
 * 
 * leetcode id : 226
 * 
 * Invert a binary tree.
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
 * start inverting from the last level , and move upwards
 * 
 * ie. we need to use post order traversal to do this 
 * 
 * ============
 * TC = O(n)
 * SC = O(ht)
 * 
 * 
 */

public class x31_invert_binary_tree extends HELPER {

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(4);
    root.left = new node(2);
    root.left.left = new node(1);
    root.left.right = new node(3);

    root.right = new node(7);
    root.right.left = new node(6);
    root.right.right = new node(9);

    HELPER.perform_inorder(root);
    System.out.println();

    root = function_util(root);

    HELPER.perform_inorder(root);
    System.out.println();

  }

  static node function_util(node root) {

    function(root);
    return root;

  }

  static void function(node curr) {
    if (curr == null) {
      return;
    }

    function(curr.left);
    function(curr.right);

    node temp = curr.left;
    curr.left = curr.right;
    curr.right = temp;

  }

}