import java.util.*;

/**
 * leetcode id : 235
 * 
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * 
 *
 *
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
 * LCA + BST property
 * 
 * 
 * if p and q are smaller than curr , then curr cannot be LCA , LCA must be LHS
 * 
 * if p and q are greater than curr , then curr cannot be LCA , LCA must be RHS
 * 
 * 
 * else 
 *  1. if either of p and q are equal to curr , or
 *  2. p is greater and q is lesser than curr (or vice-versa)
 * 
 * then curr MUST be LCA
 *  
 * 
 *
 * 
 */

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }

}

class x37_LCA_in_BST {

    public static void main(String[] args) {

        Node root = null;

        root = new Node(6);
        root.left = new Node(2);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        // //expected = 6
        // Node p = root.left;
        // Node q = root.right;

        //expected = 2
        Node p = root.left;
        Node q = root.left.right;

        Node ans = Solution.function(root, p, q);
        System.out.println(ans.data);

    }

}

class Solution {

    static Node function(Node curr, Node p, Node q) {

        if (curr.data > p.data && curr.data > q.data) {
            return function(curr.left, p, q);
        } else if (curr.data < p.data && curr.data < q.data) {
            return function(curr.right, p, q);
        } else {
            return curr;
        }

    }

}
