import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/maximum-spiral-sum-in-binary-tree/
 * 
 * 
 * Given a binary tree containing n nodes. 
 * 
 * The problem is to find the maximum sum obtained when the tree is spirally traversed.
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
 * Approach: 
 * Obtain the level order traversal in spiral form of the given binary tree with the help of two stacks and store it in an array. 
 * 
 * Find the maximum sum sub-array of the array so obtained.
 * 
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 * 
 */

public class p61_max_spiral_sum extends HELPER {

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

   

  }

}