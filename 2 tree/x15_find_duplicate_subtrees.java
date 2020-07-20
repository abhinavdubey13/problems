import java.util.*;

/**
 * 
 * leetcode id : 652
 *
 * Given the root of a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * 
 * Two trees are duplicate if they have the same structure with the same node values.
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
 * 1. A unique sub-tree can be uniquely identified by its serialized string;
 * 
 * 2. using post order traversal we can gradualy collect all unique tree-serializations with their associated nodes, with 1 traversal;
 * 
 * 3.then you can see if there is any serialization is associated with more than 1 sub-tree nodes, then you know there is duplicated sub-tree nodes;
 * 
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class x15_find_duplicate_subtrees extends HELPER {

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(1);
    root.left = new node(2);
    root.left.left = new node(4);

    root.right = new node(3);
    root.right.left = new node(2);
    root.right.left.left = new node(4);

    root.right.right = new node(4);

    List<node> answer = function_util(root);
    for (node n : answer) {
      System.out.print(n.data + " ");
    }
    System.out.println();

  }

  static List<node> function_util(node root) {

    List<node> answer = new LinkedList<>();

    if (root == null) {
      return answer;
    }

    Map<String, node> my_map = new HashMap<>();

    function(root, my_map);

    for (Map.Entry<String, node> e : my_map.entrySet()) {
      if (e.getValue() != null) {
        answer.add(e.getValue());
      }
    }

    return answer;
  }

  static String function(node curr, Map<String, node> my_map) {

    if (curr == null) {
      return "";
    }

    String post_order_lst = function(curr.left, my_map);
    String post_order_rst = function(curr.right, my_map);

    String return_val = post_order_lst + post_order_rst + String.valueOf(curr.data);

    if (my_map.containsKey(return_val)) {
      my_map.put(return_val, curr);
    } else {
      my_map.put(return_val, null);
    }

    return return_val;

  }

}