import java.util.*;

/**
 * 
 * 
 * https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
 * 
 * Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST. 
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

class node {
    int data;
    node left, right;

    node(int item) {
        data = item;
        left = right = null;
    }

}

class x34_correct_BST {

    public static void main(String[] args) {

        node root = null;

        root = new node(6);
        root.left = new node(2);
        root.left.left = new node(0);
        root.left.right = new node(4);
        root.left.right.left = new node(3);
        root.left.right.right = new node(5);

        root.right = new node(8);
        root.right.left = new node(7);
        root.right.right = new node(9);

        node ans = Solution.function(root);
        

    }

}

class Solution {

    static int PLUS_INF = 2000;
    static int MINUS_INF = -2000;

    static node correctBST(node root) {
        //code here.

        ArrayList<node> incorrect = new ArrayList<>();

        fun(root, MINUS_INF, PLUS_INF, incorrect);

        if (incorrect.size() == 2) {
            int temp = incorrect.get(0).data;
            incorrect.get(0).data = incorrect.get(1).data;
            incorrect.get(1).data = temp;

        }
        return root;
    }

    static void fun(node curr, int min, int max, ArrayList<node> incorrect) {

        if (curr == null) {
            return;
        }

        if (curr.data > max || curr.data < min) {
            incorrect.add(curr);
        }

        fun(curr.left, min, curr.data, incorrect);
        fun(curr.right, curr.data, max, incorrect);

    }

}
