import java.util.*;

/**
 * 
 * given 2 binary tree , we have to find if they are isomorphic
 * 
 * https://www.geeksforgeeks.org/tree-isomorphism-problem/
 * 
 * 
 * Two trees are called isomorphic if one of them can be obtained from other by a series of flips
 * i.e. by swapping left and right children of a number of nodes. 
 * Any number of nodes at any level can have their children swapped. 
 * Two empty trees are isomorphic.
 * 
 */

/**
 * 
 * here we use 2 sub-problems :
 * 1. check if 2 trees are mirrors
 * 2. check if 2 trees are identical
 *
 * using recursion , check if data of both tree nodes is same
 * 
 * for isomorphism , one of the 2 condition must be true
 * 
 * 1. (left-child of left-tree and left-child of right-tree)  && (right-child of left-tree and right-child of right-tree)
 * 
 * 2. (right-child of left-tree and left-child of right-tree)  && (right-child of left-tree and left-child of right-tree)
 *
 * 
 * 
 * =================================
 * let total nodes in trees = n , m
 * 
 * TC = O(MIN(m,n))
 * SC = O( MIN(ht(m) , ht(n)) )
 *
 */

class p42_check_isomorphic extends HELPER {

    public static void main(String[] args) {

        //left tree
        node LEFT_ROOT = new node(1);
        LEFT_ROOT.left = new node(2);
        LEFT_ROOT.left.right = new node(5);
        LEFT_ROOT.left.right.left = new node(7);
        LEFT_ROOT.left.left = new node(4);
        LEFT_ROOT.left.right.right = new node(8);
        LEFT_ROOT.right = new node(3);
        LEFT_ROOT.right.left = new node(6);

        //right tree
        node RIGHT_ROOT = new node(1);
        RIGHT_ROOT.left = new node(3);
        RIGHT_ROOT.left.right = new node(6);
        RIGHT_ROOT.right = new node(2);
        RIGHT_ROOT.right.left = new node(4);
        RIGHT_ROOT.right.right = new node(5);
        RIGHT_ROOT.right.right.left = new node(8);
        RIGHT_ROOT.right.right.right = new node(7); //to check false , change this to a value NOT 7

        // System.out.println(function(LEFT_ROOT, RIGHT_ROOT));
        System.out.println(function_simple(LEFT_ROOT, RIGHT_ROOT));

    }

    static boolean function(node left_root, node right_root) {

        if (left_root == null && right_root == null) {
            return true;
        }

        if (left_root == null && right_root != null) {
            return false;
        }

        if (left_root != null && right_root == null) {
            return false;
        }

        boolean check_1 = (left_root.data == right_root.data);

        if (!check_1) {
            return false;
        }

        //checking if left children of both same
        boolean check_2_1 = ((left_root.left == null && right_root.left == null)
                || left_root.left != null && right_root.left != null && left_root.left.data == right_root.left.data)
                        ? true
                        : false;

        //checking if right children of both same
        boolean check_2_2 = ((left_root.right == null && right_root.right == null)
                || left_root.right != null && right_root.right != null && left_root.right.data == right_root.right.data)
                        ? true
                        : false;

        //checking if left child of left tree and right child of right tree is same
        boolean check_3_1 = ((left_root.left == null && right_root.right == null)
                || left_root.left != null && right_root.right != null && left_root.left.data == right_root.right.data)
                        ? true
                        : false;

        //checking if right child of left tree and left child of right tree is same
        boolean check_3_2 = ((left_root.right == null && right_root.left == null)
                || left_root.right != null && right_root.left != null && left_root.right.data == right_root.left.data)
                        ? true
                        : false;

        if (check_2_1 && check_2_2) {
            return (function(left_root.left, right_root.left) && function(left_root.right, right_root.right));
        } else if (check_3_1 && check_3_2) {
            return (function(left_root.left, right_root.right) && function(left_root.right, right_root.left));
        } else {
            return false;
        }
    }

    //does the same job as above
    static boolean function_simple(node left_root, node right_root) {

        if (left_root == null && right_root == null) {
            return true;
        }

        if (left_root == null || right_root == null) {
            return false;
        }

        if (left_root.data != right_root.data) {
            return false;
        }

        //if we have reached here , it means data is same  , so no need to check this

        //we have 2 set of combinations

        //check if same tree problem
        boolean check_1 = function_simple(left_root.left, right_root.left)
                && function_simple(left_root.right, right_root.right);

        //check if mirror tree problem
        boolean check_2 = function_simple(left_root.right, right_root.left)
                && function_simple(left_root.left, right_root.right);

        return check_1 || check_2;
    }

}