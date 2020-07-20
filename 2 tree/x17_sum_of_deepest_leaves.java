import java.util.*;

/**
 * 
 * leetcode id : 1302
 *
 * Given a binary tree, return the sum of values of its deepest leaves.
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
 * globally maintian 2 variables
 * 
 * 1. max level
 * 2. sum of leaves at max level (answer)
 * 
 * ===============
 * TC = O(n)
 * SC = O(ht)
 * 
 * 
 */

public class x17_sum_of_deepest_leaves extends HELPER {

  static int MOVES;

  public static void main(String[] args) {

    // //expected = 10
    // node root;
    // root = new node(0);
    // root.left = new node(0);
    // root.left.left = new node(4);
    // root.left.right = new node(2);
    // root.right = new node(0);
    // root.right.right = new node(0);

    // //expected = 2
    // node root;
    // root = new node(3);
    // root.left = new node(0);  
    // root.right = new node(0);

    //  //expected = 3
    //  node root;
    //  root = new node(0);
    //  root.left = new node(3);  
    //  root.right = new node(0);

    // //expected = 2
    // node root;
    // root = new node(1);
    // root.left = new node(0);  
    // root.right = new node(2);

    // //expected = 4
    // node root;
    // root = new node(1);
    // root.left = new node(0);
    // root.left.right = new node(3);
    // root.right = new node(0);


    //expected = 4
    node root;
    root = new node(0);
    root.left = new node(1);
    root.left.left = new node(3);
    root.left.right = new node(0);


    int answer = function_util(root);
    System.out.println("total : " + answer);

  }

  static int function_util(node root) {

    MOVES = 0;
    int l = function(root.left);
    int r = function(root.right);

    root.data = root.data + l + r;

    int upwards = MOVES;

    System.out.println("upwards : " + upwards);

    function2(root, 0);

    System.out.println("downwards : " + (MOVES - upwards));

    return MOVES;
  }

  static int function(node root) {

    if (root == null) {
      return 0;
    }

    int excess_lst = function(root.left);
    int excess_rst = function(root.right);

    root.data = root.data + excess_lst + excess_rst;

    int returned_from_here = 0;

    if (root.data > 1) {
      returned_from_here = root.data - 1;
      root.data = 1;
      MOVES += returned_from_here;
    }

    return returned_from_here;
  }

  static void function2(node root, int level) {
    if (root == null) {
      return;
    }

    if (root.data == 0) {
      MOVES += level;
    }

    function2(root.left, level + 1);
    function2(root.right, level + 1);

  }

}