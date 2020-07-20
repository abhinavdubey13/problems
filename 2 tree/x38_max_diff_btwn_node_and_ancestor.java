import java.util.*;

/**
 * 
 * leetcode id : 1026
 * 
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * 
 * Given the root of a binary tree, 
 * 
 * find the maximum value V for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 * 
 * A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.
 *
 *
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * 
 * 
 * 
 * at each node , maintain 2 values returned form childre
 * max and min
 * 
 * 
 * 
 * possible_1 = abs(curr.val - l.min)
 * possible_2 = abs(curr.val - l.max)
 * possible_3 = abs(curr.val - r.min)
 * possible_4 = abs(curr.val - r.max)
 * 
 * answer = max(answer , all possible answer)
 * 
 * 
 *
 * 
 */

class Node {
    int val;
    Node left, right;

    Node(int item) {
        val = item;
        left = right = null;
    }

}

class x38_max_diff_btwn_node_and_ancestor {

    public static void main(String[] args) {

        Node root = null;

        //expected : 3
        root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(0);
        root.right.right.left = new Node(3);

        // root = new Node(2);
        // root.left = new Node(5);
        // root.right = new Node(0);
        // root.right.left = new Node(4);
        // root.right.left.right = new Node(6);
        // root.right.left.right.left = new Node(1);
        // root.right.left.right.left.left = new Node(3);

        Solution s = new Solution();
        int ans = s.function(root);
        System.out.println(ans);

    }

}

class Helper {
    Integer min_val;
    Integer max_val;

    Helper(Integer min, Integer max) {
        min_val = min;
        max_val = max;
    }
}

class Solution {

    int answer;

    public int function(Node root) {
        answer = 0;
        dfs(root);
        return answer;
    }

    Helper dfs(Node curr) {
        if (curr == null) {
            return new Helper(null, null);
        }

        Helper l = dfs(curr.left);
        Helper r = dfs(curr.right);

        //evaluation all 4 possibble answers
        if (l.min_val != null) {
            answer = Math.max(answer, Math.abs(curr.val - l.min_val.intValue()));
        }

        if (l.max_val != null) {
            answer = Math.max(answer, Math.abs(curr.val - l.max_val.intValue()));
        }

        if (r.min_val != null) {
            answer = Math.max(answer, Math.abs(curr.val - r.min_val.intValue()));
        }

        if (r.max_val != null) {
            answer = Math.max(answer, Math.abs(curr.val - r.max_val.intValue()));
        }

        //returning proper values from cur node
        int left_min = (l.min_val == null) ? Integer.MAX_VALUE : l.min_val.intValue();
        int right_min = (r.min_val == null) ? Integer.MAX_VALUE : r.min_val.intValue();

        int left_max = (l.max_val == null) ? Integer.MIN_VALUE : l.max_val.intValue();
        int right_max = (r.max_val == null) ? Integer.MIN_VALUE : r.max_val.intValue();

        int min_so_far = Math.min(curr.val, Math.min(left_min, right_min));
        int max_so_far = Math.max(curr.val, Math.max(left_max, right_max));

        return new Helper(min_so_far, max_so_far);

    }

}
