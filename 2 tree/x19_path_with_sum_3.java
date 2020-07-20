import java.util.*;

/**
 * 
 * leetcode id : 437
 * 
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
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
 * So the idea is using HashMap to store prefix sum in the current root-to-leaf path
 * 
 * key : the prefix sum, 
 * value : how many ways get to this prefix sum , 
 * 
 * and whenever reach a node, we check if prefix sum - target exists in hashmap or not, 
 * if it does, we added up the ways of prefix sum - target into res.
 * 
 * For instance : in one path we have 1,2,-1,-1,2, 
 * then the prefix sum will be: 1, 3, 2, 1, 3, 
 * 
 * let's say we want to find target sum is 2, then we will have{2}, {1,2,-1}, {2,-1,-1,2} and {2} ways.
 * 
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class x19_path_with_sum_3 extends HELPER {

  static int FINAL_COUNT;

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(10);
    root.left = new node(5);
    root.left.left = new node(3);
    root.left.right = new node(2);
    root.left.right.right = new node(1);

    root.left.left.left = new node(3);
    root.left.left.right = new node(-2);

    root.right = new node(-3);
    root.right.right = new node(11);

    int target_sum = 8;

    int answer = function_util(root, target_sum);
    System.out.println(answer);

  }

  static int function_util(node root, int target_sum) {

    FINAL_COUNT = 0;

    Map<Integer, Integer> prefix_sum_map = new HashMap<>();
    prefix_sum_map.put(0, 1);
    function(root, 0, target_sum, prefix_sum_map);

    return FINAL_COUNT;

  }

  static void function(node curr, int path_sum_excluding_curr, int target_sum, Map<Integer, Integer> prefix_sum_map) {

    if (curr == null) {
      return;
    }

    int sum_till_now = curr.data + path_sum_excluding_curr;

    int sum_required = sum_till_now - target_sum;

    if (prefix_sum_map.containsKey(sum_required)) {
      FINAL_COUNT += prefix_sum_map.get(sum_required);
    }

    prefix_sum_map.put(sum_till_now, 1 + prefix_sum_map.getOrDefault(sum_till_now, 0));

    function(curr.left, sum_till_now, target_sum, prefix_sum_map);
    function(curr.right, sum_till_now, target_sum, prefix_sum_map);

    prefix_sum_map.put(sum_till_now, prefix_sum_map.get(sum_till_now) - 1);

  }

}