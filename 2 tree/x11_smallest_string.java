import java.util.*;

/**
 *
 * Given the root of a binary tree, 
 * 
 * each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 * 
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 * 
 * As a reminder, any shorter prefix of a string is lexicographically smaller: 
 * for example, "ab" is lexicographically smaller than "aba".  
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
 * IMPORTANT : bottom-up recursion WILL NOT WORK here
 * example tree
 * 
 *                  z
 *                 /
 *                b
 *               /\
 *              a  a
 *             /
 *            b
 *           /
 *          a
 * 
 * at the 1st "b" from top
 * left  = aba
 * right = a
 * 
 * it will select right , and final string = abz
 * but actual answer                       = ababz 
 *
 *
 * 
 * =========================================
 * we need to go top-down
 * 
 * TC = O(n)   
 * SC = O(ht)
 *
 */

class x11_smallest_string extends HELPER {

    public static void main(String[] args) {

        node root;

        // // //tree-1 , expected = dba
        // root = new node(0);
        // root.left = new node(1);
        // root.left.left = new node(3);
        // root.left.right = new node(4);

        // root.right = new node(2);
        // root.right.left = new node(3);
        // root.right.right = new node(4);

        // tree-2 , expected = abc
        // root = new node(2);
        // root.left = new node(2);
        // root.left.right = new node(1);
        // root.left.right.left = new node(0);

        // root.right = new node(1);
        // root.right.left = new node(0);

        // tree-3 , expected = ababz
        root = new node(25);
        root.left = new node(1);
        root.left.left = new node(0);
        root.left.right = new node(0);

        root.left.left.left = new node(1);
        root.left.left.left.left = new node(0);

        String answer = function_util(root);
        System.out.println(answer);

    }

    static String function_util(node root) {
        return function(root, "");
    }

    static String function(node root, String suffix) {

        if (root == null) {
            return suffix;
        }

        suffix = "" + (char) ('a' + root.data) + suffix;

        if (isLeaf(root)) {
            return suffix;
        }

        if (root.left == null) {
            return function(root.right, suffix);
        }

        if (root.right == null) {
            return function(root.left, suffix);

        }

        String left_str = function(root.left, suffix);
        String right_str = function(root.right, suffix);
        return left_str.compareTo(right_str) <= 0 ? left_str : right_str;

    }
}