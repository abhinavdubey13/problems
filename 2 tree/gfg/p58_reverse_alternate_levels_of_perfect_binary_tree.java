import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
 * 
 * Given a Perfect Binary Tree, reverse the sequence of nodes at odd level . 
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
 * do two inorder traversals. The following are the steps to be followed. 
 * 
 * 1) Traverse the given tree in inorder fashion and store all odd level nodes in an auxiliary array. 
 *    For the above example given tree, contents of array become {h, i, b, j, k, l, m, c, n, o}
 * 
 * 2) Reverse the array. The array now becomes {o, n, c, m, l, k, j, b, i, h}
 * 
 * 3) Traverse the tree again inorder fashion. While traversing the tree, 
 *    one by one take elements from array and store elements from an array to every odd level traversed node. 
 * 
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

class p58_reverse_alternate_levels_of_perfect_binary_tree extends HELPER {

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(1);

    root.left = new node(2);

    root.left.left = new node(4);
    root.left.left.left = new node(8);
    root.left.left.right = new node(9);

    root.left.right = new node(5);
    root.left.right.left = new node(10);
    root.left.right.right = new node(11);

    root.right = new node(3);

    root.right.left = new node(6);
    root.right.left.left = new node(12);
    root.right.left.right = new node(13);

    root.right.right = new node(7);
    root.right.right.left = new node(14);
    root.right.right.right = new node(15);

    HELPER.perform_inorder(root);
    System.out.println();

    function(root);

    HELPER.perform_inorder(root);
    System.out.println();
  }

  static void function(node root) {

    List<Integer> list_of_nodes_at_odd_level = new LinkedList<>();

    //get list
    get_list_using_inorder(root, 0, list_of_nodes_at_odd_level);

    //reverse list
    reverse_list(list_of_nodes_at_odd_level);

    //use list to reverse alternate level node sequence
    int[] idx_to_use = { 0 };
    set_nodes_using_inorder(root, 0, idx_to_use, list_of_nodes_at_odd_level);

  }

  static void get_list_using_inorder(node cur, int cur_level, List<Integer> my_list) {

    if (cur == null) {
      return;
    }

    get_list_using_inorder(cur.left, cur_level + 1, my_list);
    if (cur_level % 2 == 1) {
      my_list.add(cur.data);
    }
    get_list_using_inorder(cur.right, cur_level + 1, my_list);

  }

  static void set_nodes_using_inorder(node cur, int cur_level, int[] idx_to_use, List<Integer> my_list) {

    if (cur == null) {
      return;
    }

    set_nodes_using_inorder(cur.left, cur_level + 1, idx_to_use, my_list);
    if (cur_level % 2 == 1) {
      cur.data = my_list.get(idx_to_use[0]);
      idx_to_use[0]++;
    }
    set_nodes_using_inorder(cur.right, cur_level + 1, idx_to_use, my_list);

  }

  static void reverse_list(List<Integer> my_list) {
    int i = 0;
    int j = my_list.size() - 1;
    while (i < j) {
      int temp = my_list.get(i);
      my_list.set(i, my_list.get(j));
      my_list.set(j, temp);
      i++;
      j--;

    }
  }

}