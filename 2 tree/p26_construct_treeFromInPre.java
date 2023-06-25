import java.util.HashMap;
import java.util.Map;

/**
 * 
 * given in-order and pre-order of a binary tree 
 * construct the tree 
 * 
 */

/**
 * 
 * Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call
 * 
 * Create a new tree node tNode with the data as picked element.
 * 
 * Find the picked element’s index in Inorder. Let the index be inIndex.
 * 
 * Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
 * 
 * Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
 * 
 * return tNode.
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

class char_node {
    char data;
    char_node left, right;

    char_node(char dta) {
        this.data = dta;
        this.left = this.right = null;
    }
}

class p26_construct_treeFromInPre extends HELPER {

    static int pre_index_pickup = 0;

    static void print_in_order(char_node curNode) {
        if (curNode != null) {
            print_in_order(curNode.left);
            System.out.print(curNode.data + " ");
            print_in_order(curNode.right);
        }
    }

    //map is used to find index of some element in in_order O(1) time
    static void make_index_map(char[] in_order, Map<Character, Integer> my_map) {
        for (int i = 0; i < in_order.length; i++) {
            my_map.put(in_order[i], i);
        }
    }

    static char_node construct_tree(char[] in_order, char[] pre_order, Map<Character, Integer> my_map,
            int in_order_start_idx, int in_order_end_idx) {

        if (in_order_start_idx > in_order_end_idx) {
            return null;
        }

        char node_data = pre_order[pre_index_pickup++];

        char_node treeNode = new char_node(node_data);

        if (in_order_start_idx == in_order_end_idx) {
            return treeNode;
        }

        int index_in_inorder = my_map.get(node_data);

        treeNode.left = construct_tree(in_order, pre_order, my_map, in_order_start_idx, index_in_inorder - 1);
        treeNode.right = construct_tree(in_order, pre_order, my_map, index_in_inorder + 1, in_order_end_idx);

        return treeNode;
    }

    public static void main(String[] args) {
        char[] in_order = { 'D', 'B', 'E', 'A', 'F', 'C' };
        char[] pre_order = { 'A', 'B', 'D', 'E', 'C', 'F' };

        Map<Character, Integer> my_map = new HashMap<Character, Integer>();
        make_index_map(in_order, my_map);
        char_node Root = construct_tree(in_order, pre_order, my_map, 0, in_order.length - 1);
        print_in_order(Root);
    }

}