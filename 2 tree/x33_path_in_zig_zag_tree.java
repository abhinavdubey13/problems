import java.util.*;

/**
 * 
 * leetcode id : 1104
 * 
 * In an infinite binary tree where every node has two children, the nodes are labelled in row order.
 * 
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, 
 * 
 * while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
 * 
 * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
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
 * 
 * if the trr was not zig zag , it was an easy qstion , bcz pattern was clear
 * parent = node_data/2
 * 
 * 
 * here we need to find pattern , just like above secenario
 * parent = (max number at current level + min number at current level) - node_data
 * 
 * ============
 * TC = O(log n)
 * SC = O(log n)
 * 
 * 
 */

public class x33_path_in_zig_zag_tree extends HELPER {

  public static void main(String[] args) {

    int node_data = 14;

    List<Integer> answer = function(node_data);

    for (Integer i : answer) {
      System.out.print(i + " ");
    }
    System.out.println();

  }

  static List<Integer> function(int node_data) {

    List<Integer> answer = new LinkedList<>();

    int max_in_level = 1;
    int level = 0;

    //find the level at which label
    while (max_in_level < node_data) {
      max_in_level = max_in_level * 2 + 1;
      level++;
    }

    answer.add(0, node_data);

    while (level >= 0) {
      int min_at_this_level = (int) Math.pow(2, level);
      int max_at_this_level = 2 * min_at_this_level - 1;

      node_data = (min_at_this_level + max_at_this_level - node_data) / 2;

      if (node_data > 0) {
        answer.add(0, node_data);
      }
      level--;
    }

    
    return answer;
  }

}