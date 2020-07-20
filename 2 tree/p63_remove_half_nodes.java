import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/given-a-binary-tree-how-do-you-remove-all-the-half-nodes/
 *
 * Given A binary Tree, how do you remove all the half nodes (which has only one child)? Note leaves should not be touched as they have both children as NULL.
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
 * 
 * using post order traversal
 * 
 * We first process the left children, then right children, and finally the node itself. 
 * So we form the new tree bottom up, starting from the leaves towards the root. 
 * By the time we process the current node, both its left and right subtrees were already processed. 
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class p63_remove_half_nodes extends HELPER {

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(1);
    root.left = new node(2);
    root.left.left = new node(4);
    root.left.left.left = new node(7);

    root.right = new node(3);
    root.right.left = new node(5);
    root.right.left.left = new node(8);
    root.right.left.right = new node(9);
    root.right.right = new node(6);

    HELPER.perform_inorder(root);
    System.out.println();

    root = function(root);

    HELPER.perform_inorder(root);
    System.out.println();

  }

  static node function(node curr) {

    if (curr == null) {
      return null;
    }

    curr.left = function(curr.left);
    curr.right = function(curr.right);

    if (curr.left == null && curr.right != null) {
      return curr.right;
    } else if (curr.left != null && curr.right == null) {
      return curr.left;
    } else {
      return curr;
    }

  }

}