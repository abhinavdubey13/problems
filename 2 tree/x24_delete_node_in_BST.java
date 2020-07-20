import java.util.*;

/**
 * 
 * leetcode id : 450
 * 
 * 
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
 * 
 * Return the root node reference (possibly updated) of the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
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
 * https://www.youtube.com/watch?v=gcULXE7ViZw&ab_channel=mycodeschool
 * 
 * node to be deleted can be one of the 3 : 
 * 
 * 1. it is a leaf node : do nothing , remove it by making parent's left/right as null
 * 2. it has only 1 child : simply return the non-null child
 * 
 * 3. it has both chldren 
 *    a. find min in RST of the node to be deleted
 *    b. copy its data to the node to be deleted
 *    c. now delete the min in RST (it will be either 1 or 2 above)
 * 
 * ===============
 * TC = O(ht)
 * SC = O(ht)
 * 
 * 
 */

public class x24_delete_node_in_BST extends HELPER {

  public static void main(String[] args) {

    //tree
    node root;
    root = new node(5);
    root.left = new node(2);
    root.left.left = new node(1);
    root.left.right = new node(3);

    root.right = new node(6);
    root.right.right = new node(7);

    int key_to_delete = 5;

    HELPER.perform_inorder(root);
    System.out.println();

    root = delete_node(root, key_to_delete);

    HELPER.perform_inorder(root);
    System.out.println();

  }

  static node delete_node(node root, int key) {

    if (root == null) {
      return null;
    }

    if (root.data < key) {
      root.right = delete_node(root.right, key); //bcz root's right may get updated
    } else if (root.data > key) {
      root.left = delete_node(root.left, key); //bcz root's left may get updated
    } else {

      if (root.left == null) {
        return root.right; //handles case 1 and 2
      } else if (root.right == null) {
        return root.left; //handles case 1 and 2
      } else {
        node min_in_rst = get_min_in_rst(root.right);
        root.data = min_in_rst.data; //copy
        root.right = delete_node(root.right, min_in_rst.data); //RST will get modified , obviously bcz we found min in RST
      }
    }

    return root;
  }

  static node get_min_in_rst(node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

}