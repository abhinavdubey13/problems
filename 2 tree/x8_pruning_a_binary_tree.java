import java.util.*;

/**
 * 
 * We are given the head node root of a binary tree, 
 * 
 * where  every node's value is either a 0 or a 1.
 * 
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 * 
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * using recursion
 * 
 * remove all subtrees whose sum is zero
 * 
 *
 * TC = O(n)   
 * SC = O(ht)
 *
 */

class x8_pruning_a_binary_tree extends HELPER {

    public static void main(String[] args) {

        node root;

        //tree-1 
        root = new node(1);
        root.right = new node(0);
        root.right.left = new node(0);
        root.right.right = new node(1);

        root = function_util(root);
        perform_inorder(root);
    }

    static node function_util(node root) {
        int sum = function(root);
        
        if (sum == 0) {
            return null;
        }
        return root;
    }

    static int function(node root) {

        if (root == null) {
            return 0;
        }

        int sum_left = function(root.left);
        int sum_right = function(root.right);

        if (sum_left == 0) {
            root.left = null;
        }

        if (sum_right == 0) {
            root.right = null;
        }

        return root.data + sum_left + sum_right;
    }

    static void perform_inorder(node root) {
        if (root != null) {
            perform_inorder(root.left);
            System.out.print(root.data + " ");
            perform_inorder(root.right);
        }
    }

}