

/**
 * 
 * given in-order and level-order of a binary tree 
 * construct the tree 
 * 
 */

/**
 * 
 * 1st node in level order is Root node of the tree
 * 
 * next we get index of this node in in-order array
 * 
 * we form LST and RST for this node using elements in in-order , BUT SORT THOSE ELEMENTS USING ORDERING OF LEVEL ORDER
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n^2)
 * SC = O(n^2)
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class p27_construct_treeFromInLevel extends HELPER {

    static void print_pre_order(node curNode) {
        if (curNode != null) {
            System.out.print(curNode.data + " ");
            print_pre_order(curNode.left);
            print_pre_order(curNode.right);
        }
    }

    //map is used to find index of some element in in_order O(1) time
    static void make_index_map(int[] in_order, Map<Integer, Integer> my_map, int[] level_order,
            Map<Integer, Integer> my_map2) {

        for (int i = 0; i < in_order.length; i++) {
            my_map.put(in_order[i], i);
        }

        for (int i = 0; i < level_order.length; i++) {
            my_map2.put(level_order[i], i);
        }
    }


    static node construct_tree(int[] in_order, ArrayList<Integer> level_order, Map<Integer, Integer> inorder_map,
            Map<Integer, Integer> levelorder_map, int in_order_start_idx, int in_order_end_idx) {

        if (in_order_start_idx > in_order_end_idx || level_order.size() <= 0) {
            return null;
        }

        int node_data = level_order.get(0);

        node treeNode = new node(node_data);

        if (in_order_start_idx == in_order_end_idx) {
            return treeNode;
        }

        int index_in_inorder = inorder_map.get(node_data);

        ArrayList<Integer> LST = new ArrayList<Integer>();
        ArrayList<Integer> RST = new ArrayList<Integer>();
        Map<Integer, Integer> map_lst = new TreeMap<Integer, Integer>();
        Map<Integer, Integer> map_rst = new TreeMap<Integer, Integer>();

        for (int i = in_order_start_idx; i < index_in_inorder; i++) {
            int element = in_order[i];
            int index_of_element = levelorder_map.get(element);
            map_lst.put(index_of_element, element);
        }

        for (int i = index_in_inorder + 1; i <= in_order_end_idx; i++) {
            int element = in_order[i];
            int index_of_element = levelorder_map.get(element);
            map_rst.put(index_of_element, element);
        }

        for (Map.Entry<Integer, Integer> entry : map_lst.entrySet()) {
            LST.add(entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : map_rst.entrySet()) {
            RST.add(entry.getValue());
        }

        treeNode.left = construct_tree(in_order, LST, inorder_map, levelorder_map, in_order_start_idx,
                index_in_inorder - 1);

        treeNode.right = construct_tree(in_order, RST, inorder_map, levelorder_map, index_in_inorder + 1,
                in_order_end_idx);

        return treeNode;
    }



    public static void main(String[] args) {
        int[] in_order = { 4, 8, 10, 12, 14, 20, 22 };

        int[] level_order = { 20, 8, 22, 4, 12, 10, 14 };

        ArrayList<Integer> level_order_al = new ArrayList<Integer>();

        for (int i : level_order) {
            level_order_al.add(i);
        }

        Map<Integer, Integer> inorder_map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> levelorder_map = new HashMap<Integer, Integer>();

        make_index_map(in_order, inorder_map, level_order, levelorder_map);

        node Root = construct_tree(in_order, level_order_al, inorder_map, levelorder_map, 0, in_order.length - 1);
        print_pre_order(Root);
    }

}