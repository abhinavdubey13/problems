import java.util.*;

/**
 * 
 * leetcode id : 938
 * 
 * Given the root node of a binary search tree, 
 * 
 * return the sum of values of all nodes with a value in the range [low, high].
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
 * normal : traverse all nodes
 * 
 * ============
 * TC = O(n)
 * SC = O(ht)
 * 
 * 
 * 
 * ============
 * approach : 2
 * ============
 * 
 * use given fact that given tree is BST 
 * 
 * so depending on current node value we can go left or right or both
 * 
 * ============
 * TC = O(ht)
 * SC = O(ht)
 * 
 * 
 */

public class x29_range_sum_BST extends HELPER {

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(10);
    root.left = new node(5);
    root.left.left = new node(3);
    root.left.right = new node(7);

    root.right = new node(15);
    root.right.right = new node(18);

    int low = 7;
    int high = 15;

    System.out.println(Normal_appoach.function_util(root, low, high));

    System.out.println(Optimal_appoach.function_util(root, low, high));


  }

}

class Normal_appoach {

  static int function_util(node root, int low, int high) {
    int[] answer = { 0 };
    function(root, low, high, answer);
    return answer[0];
  }

  static void function(node root, int low, int high, int[] answer) {
    if (root == null) {
      return;
    }
    function(root.left, low, high, answer);
    if (root.data >= low && root.data <= high) {
      answer[0] += root.data;
    }
    function(root.right, low, high, answer);
  }
}

class Optimal_appoach {

  static int function_util(node root, int low, int high) {
    int[] answer = { 0 };
    function(root, low, high, answer);
    return answer[0];
  }

  static void function(node root, int low, int high, int[] answer) {
    if (root == null) {
      return;
    }

    if (root.data < low) {
      function(root.right, low, high, answer);
      return;
    }

    if (root.data > high) {
      function(root.left, low, high, answer);
      return;
    }

    answer[0] += root.data;
    function(root.left, low, high, answer);
    function(root.right, low, high, answer);

  }

}