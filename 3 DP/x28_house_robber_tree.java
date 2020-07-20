import java.util.*;

/**
 * leetcode id : 337
 * 
 * The thief has found himself a new place for his thievery again. 
 * 
 * There is only one entrance to this area, called the "root." 
 * 
 * Besides the root, each house has one and only one parent house. 
 * 
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
 * 
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * 
 * ==========
 * example : 
 * ==========
 *
 *
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * 
 * at each node , we find what will be the result if we 
 *  1. include the current node : if we do this , we need to exlude both the children of this node
 *  2. exlcude the current node : if we do this , we can include/exclude the children
 * 
 * so we make this decision in port-order traversal
 * 
 * 
 * ===========
 * TC=O(n)
 * SC=O(n)
 * 
 * 
 * 
 */

class Detail {
    int exclude;
    int include;

    Detail(int e, int i) {
        exclude = e;
        include = i;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class x28_house_robber_tree {

    public static void main(String[] args) {

        // expected = 7 
        // TreeNode root;
        // root = new TreeNode(4);
        // root.left = new TreeNode(1);
        // root.left.left = new TreeNode(2);
        // root.left.left.left = new TreeNode(3);

        //expected = 7
        TreeNode root;
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        int answer = function(root);
        System.out.println(answer);
    }

    static int function(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.val;
        }

        Map<TreeNode, Detail> hmap = new HashMap<>();
        fun(root, hmap);

        Detail root_detail = hmap.get(root);
        return Math.max(root_detail.include, root_detail.exclude);
    }

    static void fun(TreeNode curr, Map<TreeNode, Detail> hmap) {
        if (curr == null) {
            return;
        }

        fun(curr.left, hmap);
        fun(curr.right, hmap);

        Detail left_detail = (curr.left != null) ? hmap.get(curr.left) : null;
        Detail right_detail = (curr.right != null) ? hmap.get(curr.right) : null;

        int include_curr = 0;
        int exclude_curr = 0;

        //if including curr node , we need to make sure , children are excluded
        include_curr = curr.val;
        include_curr += (left_detail != null) ? left_detail.exclude : 0;
        include_curr += (right_detail != null) ? right_detail.exclude : 0;

        //if excluding curr node , we can exlude/include the childre
        exclude_curr += (left_detail != null) ? Math.max(left_detail.exclude, left_detail.include) : 0;
        exclude_curr += (right_detail != null) ? Math.max(right_detail.exclude, right_detail.include) : 0;

        //update map 
        hmap.put(curr, new Detail(exclude_curr, include_curr));
    }

}
