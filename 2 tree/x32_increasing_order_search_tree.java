import java.util.*;

/**
 * 
 * leetcode id : 897
 *
 * Given the root of a binary search tree, 
 * 
 * rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, 
 * 
 * and every node has no left child and only one right child.
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
 * use inorder traversal 
 * 
 * maintain the new-root and rightmost of new-root as global variales
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class x32_increasing_order_search_tree extends HELPER {

  node NEW_ROOT;
  node ITERATOR;

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(5);
    root.left = new node(3);
    root.left.left = new node(2);
    root.left.left.left = new node(1);

    root.left.right = new node(4);

    root.right = new node(6);
    root.right.right = new node(8);
    root.right.right.left = new node(7);
    root.right.right.right = new node(9);

    HELPER.perform_inorder(root);
    System.out.println();

    x32_increasing_order_search_tree class_var = new x32_increasing_order_search_tree();
    root = class_var.function_util(root);

    HELPER.perform_inorder(root);
    System.out.println();
  }

  node function_util(node root) {

    if (root == null || isLeaf(root)) {
      return root;
    }

    NEW_ROOT = new node(-1); //adding dummy node to init the variables
    ITERATOR = NEW_ROOT;
    function(root);
    return NEW_ROOT.right;
  }

  void function(node curr) {
    if (curr == null) {
      return;
    }

    node lst = curr.left;
    node rst = curr.right;

    function(lst);

    curr.left = null;
    curr.right = null;
    ITERATOR.right = curr;
    ITERATOR = ITERATOR.right;

    function(rst);
  }

}