import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
 * 
 * The distance between two nodes is the minimum number of edges to be traversed to reach one node from another.
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
 * We first find the LCA of two nodes. Then we find the distance from LCA to two nodes.
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(ht)
 * 
 * 
 *  
 * 
 * 
 * 
 * 
 * 
 */

class node {
    int data;
    node left;
    node right;

    node(int d) {
        data = d;
        left = right = null;
    }
}

class p22_distance_btwn_2_nodes_in_tree {

    public static void main(String[] args) {

        node root = null;

        root = new node(10);
        root.left = new node(5);
        root.left.left = new node(2);
        root.left.right = new node(20);
        root.right = new node(8);

        node a = root.left;
        node b = root.right;
        int ans = Solution.function(root, a, b);
        System.out.println(ans);

    }

}

class Solution {

    static int function(node root, node a, node b) {
        node lca = LCA(root, a, b);
        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);
        return d1 + d2;
    }

    static node LCA(node curr, node x, node y) {
        //complete

        if (curr == null || curr == x || curr == y) {
            return curr;
        }

        node lft = LCA(curr.left, x, y);
        node rght = LCA(curr.right, x, y);

        if (lft != null && rght != null) {
            return curr;
        }

        else if (lft == null && rght != null) {
            return rght;
        }

        else {
            return lft;
        }

    }

    public static int findLevel(node curr, node x, int level) {
        //complete
        // return -1;
        if (curr == null) {
            return Integer.MAX_VALUE;
        } else if (curr == x) {
            return level;
        } else {
            int ll = findLevel(curr.left, x, level + 1);
            int rl = findLevel(curr.right, x, level + 1);
            return Math.min(ll, rl);
        }

    }

}
