import java.util.*;

/**
 * 
 * given a binary tree , we have to find the sum of diagonal nodes , with same slope
 * https://www.geeksforgeeks.org/diagonal-sum-binary-tree/
 * 
 */

/**
 * 
 *
 * using hashmap , key is diagonal level , and value is array of nodes
 *
 * 
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(n)
 *
 */

class p41_diagonal_sum_of_tree extends HELPER {

    public static void main(String[] args) {

        //tree
        ROOT = new node(1);
        ROOT.left = new node(2);

        ROOT.left.right = new node(6);
        ROOT.left.right.left = new node(11);
        ROOT.left.left = new node(9);
        ROOT.left.left.right = new node(10);

        ROOT.right = new node(3);
        ROOT.right.right = new node(5);
        ROOT.right.left = new node(4);
        ROOT.right.left.right = new node(7);
        ROOT.right.left.left = new node(12);

        Map<Integer, ArrayList<node>> my_map = new HashMap<Integer, ArrayList<node>>();
        get_map(ROOT, my_map, 0);
        print_diagonal_sum(my_map);
        System.out.println();
    }

    static void get_map(node currNode, Map<Integer, ArrayList<node>> my_map, int level_of_curr_node) {

        if (currNode == null) {
            return;
        }

        if (my_map.get(level_of_curr_node) == null) {
            ArrayList<node> al = new ArrayList<node>();
            al.add(currNode);
            my_map.put(level_of_curr_node, al);

        } else {
            ArrayList<node> al = my_map.get(level_of_curr_node);
            al.add(currNode);
        }

        get_map(currNode.left, my_map, level_of_curr_node + 1);
        get_map(currNode.right, my_map, level_of_curr_node);
    }

    static void print_diagonal_sum(Map<Integer, ArrayList<node>> my_map) {

        for (Map.Entry<Integer, ArrayList<node>> entry : my_map.entrySet()) {
            ArrayList<node> nodes_at_a_diagonal_level = entry.getValue();

            int x = 0;
            for (node n : nodes_at_a_diagonal_level) {
                x += n.data;
            }

            System.out.print(x + " ");
        }

    }

}