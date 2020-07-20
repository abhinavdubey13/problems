import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/longest-path-values-binary-tree/
 *
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. 
 * 
 * This path may or may not pass through the root. 
 * 
 * The length of path between two nodes is represented by the number of edges between them.
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
 * using post order traversal
 * 
 * each node will return an array of size = 2
 * 
 * arr[0] : the value which has the longest trail
 * arr[1] : length of that longest trail 
 * 
 * depending on the left and right such details we make a decision everytime
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class p65_longest_path_with_same_values extends HELPER {

  public static void main(String[] args) {

    // //tree (expected = 4)
    // node root;
    // root = new node(1);
    // root.left = new node(1);
    // root.left.left = new node(3);
    // root.left.right = new node(1);
    // root.left.right.left = new node(1);
    // root.left.right.right = new node(4);

    // root.right = new node(1);
    // root.right.left = new node(3);
    // root.right.left.right = new node(3);
    // root.right.right = new node(2);

    //tree (expected = 4)
    node root;
    root = new node(55);
    root.left = new node(4);
    root.left.left = new node(4);
    root.left.right = new node(9);

    root.right = new node(4);
    root.right.right = new node(5);

    // HELPER.perform_inorder(root);
    // System.out.println();

    int answer = function_util(root);
    System.out.println(answer);

  }

  static int function_util(node root) {
    if (root == null || isLeaf(root)) {
      return (root == null) ? 0 : 1;
    }
    int[] answer = { 1 };
    function(root, answer);
    return answer[0];
  }

  //returns arr[] of size 2
  //arr[0] : the data whose trail is max
  //arr[1] : the length of the trail 
  static int[] function(node curr, int[] answer) {

    if (curr == null) {
      return new int[] { Integer.MIN_VALUE, 0 };
    }

    int[] left_detail = function(curr.left, answer);
    int[] right_detail = function(curr.right, answer);

    //both left & right childs data match
    if (left_detail[0] == curr.data && right_detail[0] == curr.data) {
      answer[0] = Math.max(answer[0], 1 + left_detail[1] + right_detail[1]);
      return new int[] { curr.data, 1 + Math.max(left_detail[1], right_detail[1]) };
    }

    //only left childs data match
    else if (left_detail[0] == curr.data) {
      answer[0] = Math.max(answer[0], 1 + left_detail[1]);
      return new int[] { curr.data, 1 + left_detail[1] };
    }

    //only right childs data match
    else if (right_detail[0] == curr.data) {
      answer[0] = Math.max(answer[0], 1 + right_detail[1]);
      return new int[] { curr.data, 1 + right_detail[1] };
    }

    //neither left or right childs data match
    else {
      return new int[] { curr.data, 1 };
    }
  }

}