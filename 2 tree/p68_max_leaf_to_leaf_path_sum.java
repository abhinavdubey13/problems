import java.util.*;

/**
 * 
 * 
 * https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 * 
 * 
 * Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another. 
 * 
 * The maximum sum path may or may not go through root. For example, in the following binary tree, 
 * 
 * the maximum sum is 27(3 + 6 + 9 + 0 – 1 + 10). Expected time complexity is O(n).
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
 *
 */

class p68_max_leaf_to_leaf_path_sum extends HELPER {

    public static void main(String[] args) {

        node root;

        // //tree-1 : expected = 16
        // root = new node(3);
        // root.left = new node(4);
        // root.left.left = new node(-10);
        // root.left.right = new node(4);
        // root.right = new node(5);

        //expected  = -8
        root = new node(-10);
        root.left = new node(-1);
        root.left.left = new node(3);
        root.right = new node(0);

        Solution s = new Solution();
        int x = s.function(root);
        System.out.println(x);
    }

}

class Solution {

    int answer;

    int function(node root) {

        if (root == null) {
            return 0;
        }

        answer = Integer.MIN_VALUE;
        fun(root);

        return answer;

    }

    Integer fun(node curr) {
        if (curr == null) {
            return null;
        }

        if (curr.left == null && curr.right == null) {
            return curr.data;
        }

        Integer l = fun(curr.left);
        Integer r = fun(curr.right);

        if (l != null && r != null) {
            answer = Math.max(answer, l + r + curr.data);
            return Math.max(l, r) + curr.data;
        }

        else if (l == null) {
            // answer = Math.max(answer, r + curr.data); //donot update answer here , as LST is missing
            return r + curr.data;
        }

        else {
            // answer = Math.max(answer, l + curr.data);//donot update answer hare , as right subtree is misssing
            return l + curr.data;
        }

    }
}