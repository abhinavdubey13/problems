import java.util.*;

/**
 * 
 * leetcode id : 113
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
 * simple , maintian current path in global array
 * 
 * andd current root to leaf path if sum matches
 * 
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class x18_path_with_sum_2 extends HELPER {

  static List<List<Integer>> answer;

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(5);
    root.left = new node(4);
    root.left.left = new node(11);
    root.left.left.left = new node(7);
    root.left.left.right = new node(2);

    root.right = new node(8);
    root.right.left = new node(13);
    root.right.right = new node(4);
    root.right.right.left = new node(5);
    root.right.right.right = new node(1);

    int target_sum = 22;

    List<List<Integer>> answer = function_util(root, target_sum);

    //debug here to check the answer list
    System.out.println("answer");

  }

  static List<List<Integer>> function_util(node root, int target_sum) {

    answer = new ArrayList<List<Integer>>();

    int ht = getHeight(root);
    int[] path = new int[ht];

    function(root, 0, target_sum, path, 0);
    return answer;

  }

  static void function(node curr, int path_sum_excluding_curr, int target_sum, int[] path, int path_idx) {

    if (curr == null) {
      return;
    }

    int sum_till_now = curr.data + path_sum_excluding_curr;

    path[path_idx] = curr.data;

    if (isLeaf(curr) && sum_till_now == target_sum) {
      add_new_list(path, path_idx);
    }

    function(curr.left, sum_till_now, target_sum, path, path_idx + 1);
    function(curr.right, sum_till_now, target_sum, path, path_idx + 1);

  }

  static void add_new_list(int[] path, int end_idx) {
    List<Integer> required_path = new ArrayList<>();
    for (int i = 0; i <= end_idx; i++) {
      required_path.add(path[i]);
    }
    answer.add(required_path);
  }

}