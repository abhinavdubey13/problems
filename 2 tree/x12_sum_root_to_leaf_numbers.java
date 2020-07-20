import java.util.*;

/**
 *
 * Given a binary tree containing digits from 0-9 only, 
 * 
 * each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * 
 * ================================
 * example
 * 
 *          1
 *         / \
 *        4   5
 * 
 * answer  = 14 + 15 = 29
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * 
 * recursion top-down type
 * 
 * as in prev qstn
 *
 * TC = O(n)   
 * SC = O(ht)
 *
 */

class x12_sum_root_to_leaf_numbers extends HELPER {

    static int RESULT = 0;

    public static void main(String[] args) {

        node root;

        // tree-1 , expected = 1026
        root = new node(4);
        root.left = new node(9);
        root.left.left = new node(5);
        root.left.right = new node(1);
        root.right = new node(0);

        int answer = function_util(root);
        System.out.println(answer);

    }

    static int function_util(node root) {
        RESULT = 0;
        function(root, 0);
        return RESULT;

    }

    static void function(node root, int path_number) {
        if (root == null) {
            return;
        }

        int num_here = path_number * 10 + root.data;
        if (isLeaf(root)) {
            RESULT += num_here;
        }

        function(root.left, num_here);
        function(root.right, num_here);
    }

}