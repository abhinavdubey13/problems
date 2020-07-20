import java.util.*;

/**
 * 
 * given a binary tree , find max difference between 2 node A and B ie. A-B
 * 
 * such that A is any ancestor of B
 * 
 * 
 * 
 * https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
 *  
 */

/**
 * 
 *
 * using recursion , at each node we get the min-in-LST and min-in_RST , 
 * then we do (node.data - minLST) and (node.data - minRST)
 * 
 * we store the max of this result globally
 * 
 * =================================
 * let total nodes in trees = n
 * 
 * TC = O(n)
 * SC = O(ht)
 *
 */

class p44_max_diff_btwn_node_and_ancestor extends HELPER {

    static int RESULT = 0;

    public static void main(String[] args) {

        //left tree
        node ROOT = new node(8);
        ROOT.left = new node(3);
        ROOT.left.right = new node(6);
        ROOT.left.left = new node(1);
        ROOT.left.right.left = new node(4);
        ROOT.left.right.right = new node(7);

        ROOT.right = new node(10);
        ROOT.right.right = new node(14);
        ROOT.right.right.left = new node(13);

        //initialize result
        RESULT = Integer.MIN_VALUE;

        function(ROOT);
        System.out.println(RESULT);
    }

    static int function(node root) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (isLeaf(root)) {
            return root.data;
        }

        int min_node_in_LST = function(root.left);
        int min_node_in_RST = function(root.right);

        RESULT = Math.max(RESULT, Math.max(root.data - min_node_in_LST, root.data - min_node_in_RST));

        return Math.min(root.data, Math.min(min_node_in_LST, min_node_in_RST));
    }

}