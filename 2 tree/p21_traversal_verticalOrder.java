
import java.util.*;

/**
 * 
 * given a binary tree , print its vertical order
 * 
 * https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 * 
 * 
 * 
 * check the below also , asked in interviews
 * https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
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
 * TreeMap : bcz we want sorted order of keys
 * 
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class p21_traversal_verticalOrder extends HELPER {

    public static void main(String[] args) {

        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(5);

        function(ROOT);
    }

    static void function(node currentRoot) {

        //treemap : sorted based on keys
        Map<Integer, ArrayList<node>> my_map = new TreeMap<Integer, ArrayList<node>>();
        
        get_map_using_preorder(currentRoot, my_map, 0);

        for (Map.Entry<Integer, ArrayList<node>> entry : my_map.entrySet()) {

            ArrayList<node> nodes_at_a_vertical_level = entry.getValue();

            for (node n : nodes_at_a_vertical_level) {
                System.out.print(n.data + " ");
            }

            System.out.println();
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