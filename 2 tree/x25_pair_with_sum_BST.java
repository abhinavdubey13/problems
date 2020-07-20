import java.util.*;

/**
 * 
 * leetcode id : 653
 * 
 * Given the root of a Binary Search Tree and a target number k, 
 * 
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
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
 * inorder traversal gives nodes in sorted order
 * 
 * then use 2 pointers
 * 
 * =============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class x25_pair_with_sum_BST extends HELPER {

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

    int sum = 47;
    boolean answer = function(root, sum);
    System.out.println(answer);

  }

  static boolean function(node root, int sum) {

    if (root == null || root.left == null && root.right == null) {
      return false;
    }

    List<Integer> inorder = new ArrayList<>();
    get_inorder(root, inorder);

    int i = 0, j = inorder.size() - 1;

    while (i < j) {
      int a = inorder.get(i);
      int b = inorder.get(j);
      if (a + b == sum) {
        return true;
      }
      else if (a + b < sum) {
        i++;
      }
      else if (a + b > sum) {
        j--;
      }
    }

    return false;

  }

  static void get_inorder(node curr, List<Integer> inorder) {
    if (curr == null) {
      return;
    }

    get_inorder(curr.left, inorder);
    inorder.add(curr.data);
    get_inorder(curr.right, inorder);
  }

}