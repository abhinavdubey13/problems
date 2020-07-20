import java.util.*;

/**
 * 
 * leetcode id : 105
 * 
 * Given two integer arrays preorder and inorder 
 * where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, 
 * 
 * construct and return the binary tree.
 *
 */

/**
 * 
 * 
 * idea is the maintain 3 indices
 * 2 for the range in inorder[]
 * 1 for the preorder[] , to denote which node to pick
 * 
 * 
 * the pre order index points to the start of a tree/subtree
 * 
 * 
 * 
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

}

class p38_tree_using_in_pre_order {

    public static void main(String[] args) {
        int[] in = { 9, 3, 15, 20, 7 };
        int[] pre = { 3, 9, 20, 15, 7 };
        TreeNode root = new Solution().function(pre, in);
        System.out.println(root);

    }
}

class Solution {

    TreeNode function(int[] pre, int[] in) {
        int n = pre.length - 1;
        return fun(pre, in, 0, n, 0);
    }

    TreeNode fun(int[] pre, int[] in, int si, int ei, int pre_idx) {
        if (si > ei) {
            return null;
        }

        if (si == ei) {
            return new TreeNode(in[si]);
        }

        int node_val = pre[pre_idx];
        TreeNode n = new TreeNode(node_val);

        int i = si;
        for (; i <= ei; i++) {
            if (in[i] == node_val) {
                break;
            }
        }

        int lst_size = (int) Math.abs(si - i);

        n.left = fun(pre, in, si, i - 1, pre_idx + 1); //for LST : pre_idx will begin from the just next index
        n.right = fun(pre, in, i + 1, ei, pre_idx + lst_size + 1); // for RST : pre_idx will begin from : pre+(size of LST)+1

        return n;
    }

}