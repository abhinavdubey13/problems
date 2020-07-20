import java.util.*;

/**
 * 
 * leetcode id : 538
 *
 * 
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree 
 * 
 * such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
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
 * 
 * 1. get inorder sequence 
 * 2. convert the inorder seq to prefix array , but start from the end of the sequence
 * 3. set the prefix sum seq as the new inorder in the tree
 * 
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 * 
 * ============
 * approach : 2
 * =============
 * 
 * Since this is a BST, we can do a reverse inorder traversal to traverse the nodes of the tree in descending order. 
 * 
 * In the process, we keep track of the running sum of all nodes which we have traversed thus far
 * 
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 */

public class x22_convert_BST_to_greater_tree extends HELPER {

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(4);
    root.left = new node(1);
    root.left.left = new node(0);
    root.left.right = new node(2);
    root.left.right.right = new node(3);

    root.right = new node(6);
    root.right.left = new node(5);
    root.right.right = new node(7);
    root.right.right.right = new node(8);

    HELPER.perform_inorder(root);
    System.out.println();

    root = function(root);

    HELPER.perform_inorder(root);
    System.out.println();

  }

  static node function(node root) {

    if (root == null || root.left == null && root.right == null) {
      return root;
    }

    List<Integer> inorder = new ArrayList<>();
    get_inorder(root, inorder);
    get_new_inorder(inorder);
    set_new_inorder(root, inorder);
    return root;
  }

  static void set_new_inorder(node curr, List<Integer> inorder) {
    if (curr == null) {
      return;
    }

    set_new_inorder(curr.left, inorder);
    curr.data = inorder.remove(0).intValue();
    set_new_inorder(curr.right, inorder);
  }

  static void get_inorder(node curr, List<Integer> inorder) {
    if (curr == null) {
      return;
    }

    get_inorder(curr.left, inorder);
    inorder.add(curr.data);
    get_inorder(curr.right, inorder);
  }

  static void get_new_inorder(List<Integer> inorder) {

    int n = inorder.size();

    for (int i = n - 2; i >= 0; i--) {
      int current = inorder.get(i);
      inorder.set(i, current + inorder.get(i + 1));
    }

  }

}