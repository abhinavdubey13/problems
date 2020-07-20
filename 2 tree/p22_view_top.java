
import java.util.*;

/**
 * 
 * given a binary tree , print its top order
 * 
 * https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/?ref=lbp
 * 
 */

/**
 * 
 * using vertical order solution 
 *
 * print 1st node of each vertical level
 * 
 * TreeMap : bcz we want sorted order of keys
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(n)
 * 
 */

class p22_view_top extends HELPER {

    public static void main(String[] args) {

        // node ROOT = new node(1);
        // ROOT.left = new node(2);
        // ROOT.right = new node(3);
        // ROOT.left.left = new node(4);
        // ROOT.left.right = new node(5);
        // ROOT.right.left = new node(6);
        // ROOT.right.right = new node(7);

        // expected : 3 2 10 20 40 50
        node ROOT = new node(40);
        ROOT.left = new node(20);
        ROOT.right = new node(50);
        ROOT.left.left = new node(10);
        ROOT.left.right = new node(35);
        ROOT.left.right.right = new node(38);
        ROOT.left.right.left = new node(30);
        ROOT.left.right.left.left = new node(1);
        ROOT.left.right.left.left.left = new node(2);
        ROOT.left.right.left.left.left.left = new node(3);

        function(ROOT);//hashing
        new Without_hashing().function(ROOT);//w/o hashing
    }

    static void function(node currentRoot) {

        Map<Integer, ArrayList<node>> my_map = new TreeMap<Integer, ArrayList<node>>();
        get_map_using_preorder(currentRoot, my_map, 0);

        for (Map.Entry<Integer, ArrayList<node>> entry : my_map.entrySet()) {
            ArrayList<node> nodes_at_a_vertical_level = entry.getValue();
            System.out.print(nodes_at_a_vertical_level.get(0).data + " ");
        }

        System.out.println();
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

class Without_hashing {

    int MIN_SO_FAR;
    int MAX_SO_FAR;

    void function(node root) {

        MIN_SO_FAR = 0;
        fun_left(root.left, -1, true);
        System.out.print(root.data + " ");

        MAX_SO_FAR = 0;
        fun_right(root.right, 1, true);
        System.out.println();

    }

    void fun_left(node curr, int level, boolean print) {

        if (curr == null) {
            return;
        }

        int left_level = level - 1;
        int right_level = level + 1;

        boolean left_print = false;

        if (left_level < MIN_SO_FAR) {
            left_print = true;
            MIN_SO_FAR = left_level;
        }

        //goto right first and then left
        fun_left(curr.right, right_level, false);
        fun_left(curr.left, left_level, left_print);

        //first recurse , print on back tracking
        if (print) {
            System.out.print(curr.data + " ");
        }
    }

    void fun_right(node curr, int level, boolean print) {

        if (curr == null) {
            return;
        }

        //first print then recurse
        if (print) {
            System.out.print(curr.data + " ");
        }

        int left_level = level - 1;
        int right_level = level + 1;

        boolean right_print = false;

        if (right_level > MAX_SO_FAR) {
            right_print = true;
            MAX_SO_FAR = right_level;
        }

        //first goto left , then right
        fun_right(curr.left, left_level, false);
        fun_right(curr.right, right_level, right_print);
    }

}