import java.util.*;

/**
 * 
 * given a binary tree , check if it is a heap
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

class p45_check_heap extends HELPER {

    static boolean RESULT;

    public static void main(String[] args) {

        //left tree
        node ROOT = new node(90);
        ROOT.left = new node(15);
        ROOT.left.right = new node(12);
        ROOT.left.left = new node(7);

        ROOT.right = new node(10);
        ROOT.right.right = new node(2);

        // System.out.println(function(ROOT));

        RESULT = true;
        function_2(ROOT);
        System.out.println(RESULT);

    }

    //tail recursion
    static boolean function(node root) {

        if (root == null || isLeaf(root)) {
            return true;
        }

        int left_child = (root.left == null) ? Integer.MIN_VALUE : root.left.data;
        int right_child = (root.right == null) ? Integer.MIN_VALUE : root.right.data;

        if (root.data > left_child && root.data > right_child) {
            return function(root.left) && function(root.right);
        } else {
            return false;
        }
    }

    //head recursion
    static boolean function_2(node root) {

        if (root == null || isLeaf(root)) {
            return true;
        }

        boolean left_status = function_2(root.left);
        boolean right_status = function_2(root.right);

        int left_child = (root.left == null) ? Integer.MIN_VALUE : root.left.data;
        int right_child = (root.right == null) ? Integer.MIN_VALUE : root.right.data;

        boolean check_curr_node = (root.data > left_child && root.data > right_child);

        if (left_status && right_status && check_curr_node) {
            RESULT = RESULT & true;
        } else {
            RESULT = false;
        }

        return left_status && right_status && check_curr_node;
    }

}