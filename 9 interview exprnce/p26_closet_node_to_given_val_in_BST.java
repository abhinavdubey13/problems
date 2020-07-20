import java.util.*;

/**
 * 
 * leetcode id : 
 * 
 * https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1
 * 
 * Given a BST and an integer. Find the least absolute difference between any node value of the BST and the given integer.
 *  
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * 
 * 
 * using the problem of checking BST , if a node violates BST property , we add it to incoreect list
 * 
 * at last we swap data if the 2 nodes present in incorrect list
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(ht)
 * 
 * 
 *  
 * 
 * 
 * 
 * 
 * 
 */

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class p26_closet_node_to_given_val_in_BST {

    public static void main(String[] args) {

        Node root = null;

        root = new Node(10);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(6);
        root.left.right.left.right = new Node(4);
        root.right = new Node(11);
        int x = 13;


        int answer = new Solution().function(root, x);
        System.out.println(answer);

    }

}

class Solution {

    int min_diff;

    int function(Node root, int x) {

        min_diff = Integer.MAX_VALUE;
        dfs(root, x);
        return min_diff;

    }

    void dfs(Node curr, int x) {

        if (curr == null) {
            return;
        }

        min_diff = Math.min(min_diff, (int) Math.abs(curr.data - x));

        if (curr.data < x) {
            dfs(curr.right, x);

        } else {
            dfs(curr.left, x);
        }

    }

}

class Helper {
    static void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + " ");
            inorder(n.right);
        }
    }
}