import java.util.*;

/**
 * 
 * leetcode id : https://www.techiedelight.com/sink-nodes-containing-zero-bottom-binary-tree/
 *
 * given a binary tree , sink all nodes with value = 0 to the bottom of the tree
 * 
 * ie. any parent node (parent can be of 1 child or 2 children) should have non-zero value
 * 
 * NOTE : number of zero nodes are lesses than non-zero nodes
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
 * post order traversal
 * 
 * first fix LST and RST of root
 * 
 * now if current node has val = 0 , it can be fixed by swapping with non-zero left or right(as they are already fixed)
 * 
 * and then fixing the one with which we had swapped
 * 
 * ie. if we had swapped root and root.left
 * then we need to sink(or fix) root.left , as its new val = 0 
 * 
 * ============
 * TC = O(n^2)
 * SC = O(ht)
 * 
 * 
 */

public class p66_sink_nodes_with_value_0 extends HELPER {

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(0);
    root.left = new node(1);

    root.right = new node(0);
    root.right.left = new node(0);
    root.right.left.left = new node(3);
    root.right.left.right = new node(4);
    root.right.right = new node(2);

    HELPER.perform_inorder(root);
    System.out.println();

    sink_util(root);

    HELPER.perform_inorder(root);
    System.out.println();

  }

  static void sink_util(node curr) {

    if (curr == null) {
      return;
    }

    sink_util(curr.left);
    sink_util(curr.right);

    if (curr.data == 0) {
      sink(curr);
    }
  }

  static void sink(node curr) {
    if (curr == null || curr.data != 0) {
      return;
    }

    if (curr.left != null && curr.left.data != 0) {
      int temp = curr.data;
      curr.data = curr.left.data;
      curr.left.data = temp;
      sink(curr.left);
    }

    else if (curr.right != null && curr.right.data != 0) {
      int temp = curr.data;
      curr.data = curr.right.data;
      curr.right.data = temp;
      sink(curr.left);
    }

  }

}