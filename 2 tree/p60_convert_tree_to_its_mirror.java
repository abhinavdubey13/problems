import java.util.*;


/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 *
 * convert a binary tree to its mirror tree
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
 * recursive
 * 
 * at each node , swap left and right subtrees
 * 
 * ===============
 * TC = O(n)
 * SC = O(height)
 * 
 * 
 * ============
 * approach : 2
 * ============
 * 
 * iterative (used if tree in n-ary tree)
 * 
 * The idea is to do queue based level order traversal. While doing traversal, swap left and right children of every node. * 
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class p60_convert_tree_to_its_mirror extends HELPER {

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(1);
    root.left = new node(2);
    root.left.left = new node(4);
    root.left.right = new node(5);

    root.right = new node(3);
    root.right.left = new node(6);
    root.right.right = new node(7);

    HELPER.perform_inorder(root);
    System.out.println();

    Iterative.function(root);

    HELPER.perform_inorder(root);
    System.out.println();

  }

}

class Recursive {
  static void function(node root) {

    if (root == null) {
      return;
    }

    node temp = root.right;
    root.right = root.left;
    root.left = temp;

    function(root.left);
    function(root.right);

  }
}

class Iterative {
  static void function(node root) {

    if (root == null)
      return;

    Queue<node> q = new LinkedList<>();
    q.add(root);

    // Do BFS(level-order). While doing BFS, keep swapping left and right children 
    while (q.size() > 0) {
      node curr = q.poll();

      // swap 
      node temp = curr.left;
      curr.left = curr.right;
      curr.right = temp;

      // push left and right children 
      if (curr.left != null)
        q.add(curr.left);
      if (curr.right != null)
        q.add(curr.right);
    }

  }
}