import java.util.*;

/**
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K
 * 
 * Return a list of the values of all nodes that have a distance K from the target node.  
 * 
 * The answer can be returned in any order.
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
 * As we know, if the distance from a node to target node is k, 
 * the distance from its child to the target node is k + 1 unless the child node is closer to the target node 
 * which means the target node is in it's subtree.
 * 
 * To avoid this situation, we need to travel the tree first to find the path from root to target, to:
 * store the value of distance in hashamp from the all nodes in that path to target
 * 
 * Then we can easily use dfs to travel the whole tree. 
 * Every time when we meet a treenode which has already stored in map, use the stored value in hashmap instead of the value from its parent node.
 *
 * TC = O(n)   
 * SC = O(ht)
 *
 */

class node {
    int data;
    node left, right;

    node(int d) {
        this.data = d;
    }
}

class x14_nodes_at_dist_K_from_target extends HELPER {

    public static void main(String[] args) {

        node root;

        // // tree-1 , expected = 8
        root = new node(1);
        root.left = new node(2);
        root.left.left = new node(4);
        root.left.left.left = new node(8);
        root.left.left.right = new node(9);

        root.left.right = new node(5);
        root.left.right.left = new node(10);
        root.left.right.left.left = new node(12);
        root.left.right.left.right = new node(13);
        root.left.right.left.left.left = new node(16);
        root.left.right.left.left.right = new node(17);

        root.left.right.right = new node(11);
        root.left.right.right.left = new node(14);
        root.left.right.right.right = new node(15);

        root.right = new node(3);
        root.right.left = new node(6);
        root.right.right = new node(7);

        node target = root.left.right;
        int k = 3;

        // node target = root;
        // int k = 4;

        // tree-2 , expected = 8
        // root = new node(0);
        // root.left = new node(1);
        // root.left.left = new node(3);
        // root.left.right = new node(2);

        // node target = root.left.right;
        // int k = 1;

        List<Integer> k_dist = Solution.function_util(root, target, k);
        System.out.println(k_dist);

    }

}

class Solution {

    static List<Integer> function_util(node root, node target, int k) {

        List<Integer> answer = new LinkedList<>();
        Map<node, Integer> path_map = new HashMap<>();
        store_root_to_target_path(root, target, path_map);
        dfs(root, target, path_map, path_map.get(root), answer, k);
        return answer;

    }

    static int store_root_to_target_path(node root, node target, Map<node, Integer> path_map) {
        if (root == null) {
            return -1;
        }
        if (root.data == target.data) {
            path_map.put(root, 0);
            return 0;
        }
        int left_d = store_root_to_target_path(root.left, target, path_map);
        int right_d = store_root_to_target_path(root.right, target, path_map);

        if (left_d > -1) {
            path_map.put(root, left_d + 1);
            return left_d + 1;
        } else if (right_d > -1) {
            path_map.put(root, right_d + 1);
            return right_d + 1;
        }
        return -1;
    }

    static void dfs(node root, node target, Map<node, Integer> path_map, int distance_from_target, List<Integer> answer,
            int k) {

        if (root == null) {
            return;
        }

        if (path_map.containsKey(root)) {
            distance_from_target = path_map.get(root).intValue();
        }

        if (distance_from_target == k) {
            answer.add(root.data);
        }

        dfs(root.left, target, path_map, distance_from_target + 1, answer, k);
        dfs(root.right, target, path_map, distance_from_target + 1, answer, k);

    }

}