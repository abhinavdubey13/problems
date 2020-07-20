import java.util.*;

/**
 * 
 * Given a Binary Search Tree (BST), 
 * 
 * convert it to a Binary Tree such that every key of the original BST is changed to key plus sum of all greater keys in BST.
 * 
 * https://www.geeksforgeeks.org/convert-bst-to-a-binary-tree/
 * 
 */

/**
 * 
 * approach 1
 * 
 * The idea is to use reverse inorder
 * When a BST is being traversed in reverse Inorder, 
 * for every key currently being visited, all keys that are already visited are all greater keys.
 * 
 * 
 * 
 * approach 2
 * 
 * perform inorder , get list , convert list to suffix sum
 * set new vals using inorder
 * 
 * 
 * 
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

class x37_convert_all_node_of_bst_to_sum_of_all_greater_nodes {

    public static void main(String[] args) {

        node root = null;

        root = new node(5);
        root.left = new node(3);
        root.left.right = new node(4);

        root.right = new node(10);
        root.right.left = new node(8);
        root.right.right = new node(15);

        Helper.inorder(root);
        System.out.println();
        new Solution().function(root);
        Helper.inorder(root);
        System.out.println();
    }

}

class Solution {
    int SUM;

    void function(node curr) {
        SUM = 0;
        reverse_inorder_dfs(curr);
    }

    void reverse_inorder_dfs(node curr) {
        if (curr == null) {
            return;
        }
        reverse_inorder_dfs(curr.right);

        int node_val = curr.data;
        curr.data += SUM; //curr = curr + SUM of all greater nodes
        SUM += node_val;
        reverse_inorder_dfs(curr.left);
    }

}

class Helper {
    static void inorder(node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + "  ");
            inorder(n.right);
        }
    }
}