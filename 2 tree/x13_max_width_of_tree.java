import java.util.*;

/**
 *
 * Given a binary tree, write a function to get the maximum width of the given tree. 
 * The maximum width of a tree is the maximum width among all levels.
 * 
 * 
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, 
 * where the null nodes between the end-nodes are also counted into the length calculation.
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * 
 * use heap like indexing
 * 
 * for each level , maintain start and end idx
 *
 * TC = O(n)   
 * SC = O(ht)
 *
 */

class Detail {
    int start_idx;
    int end_idx;

    Detail() {
        this.start_idx = 0;
        this.end_idx = 0;
    }

    Detail(int si, int ei) {
        this.start_idx = si;
        this.end_idx = ei;
    }
}

class x13_max_width_of_tree extends HELPER {

    static void function(node root, int level, int idx, Map<Integer, Detail> my_map) {

        if (root == null) {
            return;
        }

        Detail has = my_map.get(level);

        if (has == null) {
            my_map.put(level, new Detail(idx, idx));
        }

        else {
            int end_idxx = Math.max(has.end_idx, idx);
            my_map.put(level, new Detail(has.start_idx, end_idxx));
        }

        function(root.left, level + 1, 2 * idx, my_map);
        function(root.right, level + 1, 2 * idx + 1, my_map);

    }

    static int function_util(node root) {
        Map<Integer, Detail> my_map = new HashMap<>();
        function(root, 1, 1, my_map);
        int max_width = 0;
        for (Map.Entry<Integer, Detail> entry : my_map.entrySet()) {
            Detail current_level = entry.getValue();
            int current_width = current_level.end_idx - current_level.start_idx + 1;
            max_width = Math.max(max_width, current_width);
        }
        return max_width;
    }

    public static void main(String[] args) {

        node root;

        // tree-1 , expected = 8
        // root = new node(1);
        // root.left = new node(4);
        // root.left.left = new node(3);
        // root.left.left.left = new node(4);

        // root.right = new node(2);
        // root.right.right = new node(3);
        // root.right.right.right = new node(4);

        // tree-2 , expected = 5
        root = new node(1);
        root.left = new node(2);
        root.left.right = new node(4);
        root.left.right.left = new node(5);
        root.left.right.left.left = new node(6);

        root.right = new node(10);
        root.right.left = new node(11);
        root.right.left.left = new node(12);
        root.right.left.left.left = new node(13);

        int answer = function_util(root);
        System.out.println(answer);

    }

}