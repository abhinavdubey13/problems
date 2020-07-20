import java.util.*;

/**
 * 
 * leetcode id : 979
 * 
 * 
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins and there are n coins total.
 * 
 *  In one move, we may choose two adjacent nodes and move one coin from one node to another. (A move may be from parent to child, or from child to parent.)
 * 
 * Return the number of moves required to make every node have exactly one coin.
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
 * =============
 * 
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/256136/Java-Recursion-REALLY-easy-to-understand!!
 * 
 * For each node, we use an int array to record the information 
 * 
 * [# of nodes in the subtree (include itself), # of total coins in the subtree (include itself)]. 
 * 
 * Then we know that for a certain node, if there are more coins than nodes in the subtree, 
 * 
 * the node must "contribute" the redundant coins to its parent. 
 * 
 * Else, if there are more nodes than coins in the subtree, then the node must take some coins from the parent.
 * 
 * Both of these two operations will create moves in the tree. 
 * 
 * And we just need to add the absolute value of the (# nodes - # coins) to the final result 
 * 
 * because the move can be "contribute" or "take"
 * 
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class x20_distribute_coins extends HELPER {

  static int moves;

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(0);
    root.left = new node(0);
    root.right = new node(3);

    int answer = function_util(root);
    System.out.println(answer);
  }

  static int function_util(node root) {
    moves = 0;
    function(root);
    return moves;
  }

  static int[] function(node node) {
    if (node == null) {
      return new int[] { 0, 0 };
    }

    int[] left = function(node.left);
    int[] right = function(node.right);

    moves += Math.abs(left[0] - left[1]) + Math.abs(right[0] - right[1]);

    return new int[] { left[0] + right[0] + 1, left[1] + right[1] + node.data };
  }

}