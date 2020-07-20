import java.util.*;

/**
 * Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. 
 * 
 * This path may or may not pass through the root.
 * 
 * The length of the path between two nodes is represented by the number of edges between them.
 * 
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * recursive
 * 
 * from leaf to top
 * 
 * maintain wat is the max_path_len and Path_of_what_value
 * 
 * 
 * 
 * 
 *
 * TC = O(n)   
 * SC = O(ht)
 *
 */

class Detail {

    int path_of;
    int node_count;

    Detail() {
        this.path_of = 0;
        this.node_count = 0;
    }

    Detail(int po, int pl) {
        this.path_of = po;
        this.node_count = pl;
    }

}

class x9_longest_univalue_path extends HELPER {

    static int result;

    static Detail function(node root) {

        if (root == null) {
            return new Detail(-100001, 0);
        }

        Detail _left = function(root.left);
        Detail _right = function(root.right);

        Detail return_val = new Detail();
        return_val.path_of = root.data;

        if (_left.path_of == root.data && _right.path_of == root.data) {

            result = Math.max(result, 1 + _left.node_count + _right.node_count);
            return_val.node_count = 1 + Math.max(_left.node_count, _right.node_count);
        }

        else if (_left.path_of == root.data) {
            result = Math.max(result, 1 + _left.node_count);
            return_val.node_count = 1 + _left.node_count;
        }

        else if (_right.path_of == root.data) {
            result = Math.max(result, 1 + _right.node_count);
            return_val.node_count = 1 + _right.node_count;
        }

        else {
            result = Math.max(result, 1);
            return_val.node_count = 1;
        }

        return return_val;
    }

    static int function_util(node root) {
        Detail detail = function(root);
        return detail.node_count;
    }

    public static void main(String[] args) {

        node root;

        // //tree-1 , expected = 3
        root = new node(1);
        root.left = new node(6);
        root.left.right = new node(2);
        root.left.left = new node(1);
        root.left.left.left = new node(1);
        root.left.left.right = new node(1);

        root.right = new node(7);
        root.right.left = new node(1);
        root.right.left.left = new node(1);
        root.right.left.right = new node(1);
        root.right.left.right.right = new node(1);

        //tree-2 : expected = 7
        // root = new node(1);
        // root.left = new node(1);
        // root.left.right = new node(1);
        // root.left.left = new node(1);
        // root.left.left.left = new node(1);
        // root.left.left.right = new node(1);

        // root.right = new node(1);
        // root.right.left = new node(1);
        // root.right.left.left = new node(1);
        // root.right.left.right = new node(1);
        // root.right.left.right.right = new node(1);

        result = 0;
        function_util(root);
        System.out.println(result - 1);

    }

}