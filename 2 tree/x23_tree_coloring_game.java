import java.util.*;

/**
 * 
 * leetcode id : 1145
 * 
 * Two players play a turn based game on a binary tree.  
 * We are given the root of this binary tree, and the number of nodes n in the tree.  
 * 
 * n is odd, and each node has a distinct value from 1 to n.
 * 
 * 
 * Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x.  
 * The first player colors the node with value x red, and the second player colors the node with value y blue.
 * Then, the players take turns starting with the first player.  
 * In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)
 * 
 * If (and only if) a player cannot choose such a node in this way, they must pass their turn.  
 * If both players pass their turn, the game ends, and the winner is the player that colored more nodes.
 * 
 * 
 * You are the second player.  If it is possible to choose such a y to ensure you win the game, return true.  If it is not possible, return false.
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
 * The first player colors a node, there are at most 3 nodes connected to this node.
 * 
 * Its left, its right and its parent. Take this 3 nodes as the root of 3 subtrees.
 * 
 * The second player just color any one root, and the whole subtree will be his. 
 * And this is also all he can take, since he cannot cross the node of the first player.
 * 
 * 
 * =============
 * TC = O(n)
 * SC = O(ht)
 * 
 * 
 */

public class x23_tree_coloring_game extends HELPER {

  static node NODE_X;

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(1);
    root.left = new node(2);
    root.left.left = new node(4);
    root.left.left.left = new node(8);
    root.left.left.right = new node(9);

    root.left.right = new node(5);
    root.left.right.left = new node(10);
    root.left.right.right = new node(11);

    root.right = new node(3);
    root.right.left = new node(6);
    root.right.right = new node(7);

    int n = 11;
    int x = 3;
    boolean answer = function_util(root, n, x);
    System.out.println(answer);

  }

  static boolean function_util(node root, int n, int x) {

    if (n < 2) {
      return false;
    }

    function(root, x);

    int size_of_lst_of_x = HELPER.countNodes(NODE_X.left);
    int size_of_rst_of_x = HELPER.countNodes(NODE_X.right);
    int size_of_parent_other_subtree = n - (size_of_lst_of_x + size_of_rst_of_x + 1);

    if (size_of_parent_other_subtree > n / 2) {
      return true;
    } else if (size_of_lst_of_x > n / 2 || size_of_rst_of_x > n / 2) {
      return true;
    }

    return false;
  }

  static void function(node curr, int x) {
    if (curr == null) {
      return;
    }

    if (curr.data == x) {
      NODE_X = curr;
    }

    function(curr.left, x);
    function(curr.right, x);

  }

}