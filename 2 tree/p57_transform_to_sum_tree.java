import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 *  
 * Given a Binary Tree of size N , where each node can have positive or negative values. 
 * 
 * Convert this to a tree where each node contains the sum of the left and right sub trees of the original tree. 
 * 
 * The values of leaf nodes are changed to 0.
 * 
 * 
 * 
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * using recursion : 
 * 
 * find LST sum and RST sum at each node
 * and convert node's data to sum of LST n RST
 * 
 * before doing that , calculate the value to return from this node
 *  
 * 
 *
 * ===========
 * TC = O(n)
 * SC = O(height)
 *
 */

class p57_transform_to_sum_tree extends HELPER {

    public static void main(String[] args) {

        node root = new node(10);
        root.left = new node(-2);
        root.left.left = new node(8);
        root.left.right = new node(-4);

        root.right = new node(6);
        root.right.left = new node(7);
        root.right.right = new node(5);

        function(root);
        HELPER.perform_inorder(root);
        System.out.println();
    }

    static int function(node curr) {

        if (curr == null) {
            return 0;
        }

        int val_to_return = curr.data;

        if (isLeaf(curr)) {
            val_to_return = curr.data;
            curr.data = 0;
            return val_to_return;
        }

        int sum_lst = function(curr.left);
        int sum_rst = function(curr.right);

        val_to_return = sum_lst + sum_rst + curr.data;

        curr.data = sum_lst + sum_rst;

        return val_to_return;
        

    }

}

