import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/find-mirror-given-node-binary-tree/
 * 
 * Given a Binary tree, the problem is to find the mirror of a given node. 
 * 
 * The mirror of a node is a node which exists at the mirror position of the node in opposite subtree at the root.
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
 * use same approach we used to check if 2 trees are mirror of one another
 *
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

class p59_find_mirror_of_given_node extends HELPER {

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
  
  
    int target = 15;
    int answer = Solution.function_util(root, target);
    System.out.println(answer);
  }

}

class Solution {

  static int ANSWER;

  static int function_util(node root, int target) {
    ANSWER = -1;
    function(root, root, target);
    return ANSWER;
  }

  static void function(node a, node b, int target) {
    if (a == null || b == null) {
      return;
    }

    if (a.data == target) {
      ANSWER = b.data;
      return;
    }

    if (b.data == target) {
      ANSWER = a.data;
      return;
    }

    function(a.left, b.right, target);
    function(a.right, b.left, target);

  }

}