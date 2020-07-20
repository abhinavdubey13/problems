import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/find-height-of-a-special-binary-tree-whose-leaf-nodes-are-connected
 * 
 * Given a special binary tree whose leaf nodes are connected to form a circular doubly linked list, find its height.
 * 
 */

/**
 * 
 * 
 * The idea is to follow similar approach as we do for finding height of a normal binary tree.
 * We recursively calculate height of left and right subtrees of a node and assign height to the node as max of the heights of two children plus 1. 
 * But left and right child of a leaf node are null for normal binary trees. But, here leaf node is a circular doubly linked li
 * 
 * 
 * 
 * So for a node to be a leaf node, we check if node’s left’s right is pointing to the node 
 * and its right’s left is also pointing to the node itself.
 * 
 * 
 */

class node {
    int data;
    node left, right;

    node(int item) {
        data = item;
        left = right = null;
    }

}

class x35_height_of_spiral_tree {

    public static void main(String[] args) {

        node root = null;

        int ans = new Solution().function(root);
        System.out.println(ans);

    }

}

class Solution {

    int function(node curr) {

        if (root == null) {
            return 0;
        }

        if (is_leaf(curr)) {
            return 1;
        }

        int left_ht = function(curr.left);
        int right_ht = function(curr.right);
        return 1 + Math.max(left_ht, right_ht);

    }

    boolean is_leaf(node n) {
        return (n != null && (n.right != null && n.right.left == n) && (n.left != null && n.left.right == n));
    }

}
