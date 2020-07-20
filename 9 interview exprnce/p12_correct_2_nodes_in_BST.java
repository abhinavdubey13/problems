import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
 * 
 * 
 * Two of the nodes of a Binary Search Tree (BST) are swapped. 
 * Fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
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

class p12_correct_2_nodes_in_BST {

    public static void main(String[] args) {

        Node root = null;

        root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(20);
        root.right = new Node(8);

        Helper.inorder(root);
        System.out.println();

        Solution s = new Solution();
        root = s.function(root);

        Helper.inorder(root);
        System.out.println();

    }

}

class Solution {

    int PLUS_INF = 2000;
    int MINUS_INF = -2000;

    Node function(Node root) {

        ArrayList<Node> incorrect = new ArrayList<>();

        fix(root, MINUS_INF, PLUS_INF, incorrect);

        int temp = incorrect.get(0).data;
        incorrect.get(0).data = incorrect.get(1).data;
        incorrect.get(1).data = temp;
        return root;
    }

    void fix(Node curr, int min, int max, ArrayList<Node> incorrect) {

        if (curr == null) {
            return;
        }

        if (curr.data > max || curr.data < min) {
            incorrect.add(curr);
        }

        fix(curr.left, min, curr.data, incorrect);
        fix(curr.right, curr.data, max, incorrect);

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