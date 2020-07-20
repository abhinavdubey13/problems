import java.util.*;


/**
 * 
 * leetcode id : 515
 * 
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
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
 * using BFS (iterative level-order travarsal)
 * 
 * ==============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class x21_largest_in_each_row extends HELPER {

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

    List<Integer> answer = function(root);
    for (Integer i : answer) {
      System.out.print(i + " ");
    }
    System.out.println();

  }

  static List<Integer> function(node root) {

    List<Integer> answer = new ArrayList<>();

    if (root == null) {
      return answer;
    }

    Queue<node> q = new LinkedList<>();
    q.add(root);
    answer.add(root.data);

    while (q.size() > 0) {
      int size = q.size();
      Integer max_i = null;

      for (int i = 0; i < size; i++) {
        node removed = q.poll();

        if (removed.left != null) {
          max_i = (max_i == null) ? removed.left.data : Math.max(max_i.intValue(), removed.left.data);
          q.add(removed.left);
        }

        if (removed.right != null) {
          max_i = (max_i == null) ? removed.right.data : Math.max(max_i.intValue(), removed.right.data);
          q.add(removed.right);
        }

      }

      if (max_i != null) {
        answer.add(max_i);
      }

    }

    return answer;

  }

}