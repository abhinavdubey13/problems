
import java.util.*;

/**
 * 
 * given a binary tree , print its bottom order
 * https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 * 
 */

/**
 * 
 * 
 * using Hash_map 
 * key : int representing a verical level
 * value : ArrayList of nodes at that vertical level
 * 
 * use preorder traversal to form the map 1st and then print map , key-by-key
 * 
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(n)
 * =============================================================================================
 * 
 * APPROACH:2
 * 
 * we can also use DFS , nd tree-map
 * 
 * update the key of tree map , with current val , only if level of curr is more than prev level at that key
 * 
 * 
 */

class node {
    int data;
    node left, right;

    node(int d) {
        this.data = d;
        left = right = null;
    }
}

class p23_view_bottom extends HELPER {

    public static void main(String[] args) {
        node ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(5);

        function(ROOT);
    }

    static void function(node currentRoot) {

        Map<Integer, ArrayList<node>> my_map = new TreeMap<Integer, ArrayList<node>>();
        get_map_using_preorder(currentRoot, my_map, 0);

        for (Map.Entry<Integer, ArrayList<node>> entry : my_map.entrySet()) {
            ArrayList<node> nodes_at_a_vertical_level = entry.getValue();

            int last_idx = nodes_at_a_vertical_level.size() - 1;

            System.out.print(nodes_at_a_vertical_level.get(last_idx).data + " ");
        }
    }

    static void get_map_using_preorder(node Root, Map<Integer, ArrayList<node>> my_map, int current_level) {
        if (Root != null) {

            if (my_map.get(current_level) != null) {
                ArrayList<node> al = my_map.get(current_level);
                al.add(Root);
            } else {
                ArrayList<node> al = new ArrayList<node>();
                al.add(Root);
                my_map.put(current_level, al);
            }

            get_map_using_preorder(Root.left, my_map, current_level - 1);
            get_map_using_preorder(Root.right, my_map, current_level + 1);
        }
    }

}