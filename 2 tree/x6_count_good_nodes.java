import java.util.*;

/**
 * 
 * Given a binary tree root, 
 * 
 * a node X in the tree is named good if : 
 * in the path from root to X there are no nodes with a value greater than X.
 * 
 * 
 * Return the number of good nodes in the binary tree.
 * 
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * use recursion
 * 
 * 
 * at each node , check if node's value os greater than maximum_so_far
 * 
 * if yes : result+=1 and update maximum_so_far
 * 
 *
 * TC = O(n)   
 * SC = O(ht)
 *
 */

class ResultHolder {
    int result;

    ResultHolder() {
        this.result = 0;
    }
}

class x6_count_good_nodes extends HELPER {

    static void function(node root, int max_till_now, ResultHolder rh) {

        if (root == null) {
            return;
        }

        if (root.data >= max_till_now) {
            rh.result += 1;
        }

        int new_max = Math.max(max_till_now, root.data);
        function(root.left, new_max, rh);
        function(root.right, new_max, rh);
    }

    static int function_util(node root) {

        ResultHolder resultHolder = new ResultHolder();
        function(root, root.data, resultHolder);
        return resultHolder.result;
    }

    public static void main(String[] args) {

        node root;

        // // tree-1 : expected = 4
        // root = new node(3);
        // root.left = new node(1);
        // root.left.left = new node(3);
        // root.right = new node(4);
        // root.right.left = new node(1);
        // root.right.right = new node(5);

        // tree-2 : expected = 3
        root = new node(3);
        root.left = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(2);

        int x = function_util(root);
        System.out.println(x);
    }

}