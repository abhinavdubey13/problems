import java.util.*;

/**
 * 
 * leetcode id : 872
 *
 * 
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * 
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
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
 * convert leaf sequence to string
 * 
 * then compare 2 strings 
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class x26_leaf_similar_trees extends HELPER {

  public static void main(String[] args) {

    //tree-1
    node r1;
    r1 = new node(1);
    r1.left = new node(2);
    r1.right = new node(3);

    //tree-2
    node r2;
    r2 = new node(1);
    r2.left = new node(4);
    r2.left.left = new node(2);
    r2.left.right = new node(3);

    boolean answer = function(r1, r2);
    System.err.println(answer);

  }

  static boolean function(node r1, node r2) {

    if (r1 == null && r2 == null) {
      return true;
    }

    if (r1 == null) {
      return false;
    }

    if (r2 == null) {
      return false;
    }

    StringBuilder leaf_seq_1 = new StringBuilder();
    StringBuilder leaf_seq_2 = new StringBuilder();
    dfs(r1, leaf_seq_1);
    dfs(r2, leaf_seq_2);

    //as string buffers equals is not over-ridden
    return leaf_seq_1.toString().equals(leaf_seq_2.toString());
  }

  static void dfs(node curr, StringBuilder leaf_seq) {
    if (curr == null) {
      return;
    }

    if (isLeaf(curr)) {
      leaf_seq.append(String.valueOf(curr.data));
    }

    dfs(curr.left, leaf_seq);
    dfs(curr.right, leaf_seq);
  }

}