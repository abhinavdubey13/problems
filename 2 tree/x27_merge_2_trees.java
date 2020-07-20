import java.util.*;

/**
 * 
 * leetcode id : 617
 *
 * 
 * Given two binary trees and imagine that when you put one of them to cover the other, 
 * some nodes of the two trees are overlapped while the others are not.
 * 
 * You need to merge them into a new binary tree. 
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. 
 * 
 * Otherwise, the NOT null node will be used as the node of new tree
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
 * similar to checking if 2 tree are identical
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class x27_merge_2_trees extends HELPER {

  public static void main(String[] args) {

    //tree-1
    node r1;
    r1 = new node(1);
    r1.left = new node(3);
    r1.left.left = new node(5);
    r1.right = new node(2);

    //tree-2
    node r2;
    r2 = new node(2);
    r2.left = new node(1);
    r2.left.right = new node(4);
    r2.right = new node(3);
    r2.right.right = new node(7);


    //tree-1
    // node r1;
    // r1 = new node(1);
    // r1.left = new node(3);
    // r1.left.left = new node(5);
    // r1.right = new node(2);

    //tree-2
    // node r2;
    // r2 = new node(2);
   

    node answer = function(r1, r2);
    HELPER.perform_inorder(answer);
    System.out.println();

  }

  static node function(node r1, node r2) {

    if (r1 == null) {
      return r2;
    }

    if (r2 == null) {
      return r1;
    }

    node root = new node(r1.data + r2.data);
    root.left = function(r1.left, r2.left);
    root.right = function(r1.right, r2.right);
    return root;

  }

}