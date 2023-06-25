import java.util.*;

/**
 * 
 * given a binary tree ,and 2 nodes in the tree , find LCA (lowest common ancestor of the 2 nodes)
 * 
 * NOTE : assume both nodes are in trees AND the tree is NOT a BST
 * 
 */

/**
 * 
 * here an iterative approach is :
 *  1. find 2 paths , root->n1 and root->n2
 *  2. traverse both list and check the last common node , that would be the LCA
 * 
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(n)
 *
 */

class p36_LCA extends HELPER {

    public static void main(String[] args) {

        //tree
        ROOT = new node(50);
        ROOT.left = new node(30);
        ROOT.left.left = new node(5);
        ROOT.left.right = new node(10);
        ROOT.right = new node(60);
        ROOT.right.left = new node(45);
        ROOT.right.right = new node(70);
        ROOT.right.right.right = new node(80);
        ROOT.right.right.left = new node(65);

        //lca(65,80) = 70
        // node n1 = ROOT.right.right.left;
        // node n2 = ROOT.right.right.right;

        //lca(45,80) = 60
        //  node n1 = ROOT.right.left;
        //  node n2 = ROOT.right.right.right;

        //lca(30,80) = 50
        node n1 = ROOT.left;
        node n2 = ROOT.right.right.right;

        print_lca(ROOT, n1, n2);

    }

     //this method prints LCA of n1 and n2 (both are in tree)
     static void print_lca(node ROOT, node n1, node n2) {

        List<node> n1_path = new LinkedList<node>();
        get_root_to_node_path(ROOT, n1, n1_path);

        List<node> n2_path = new LinkedList<node>();
        get_root_to_node_path(ROOT, n2, n2_path);

        int shorter_list_len = (n1_path.size() < n2_path.size()) ? n1_path.size() : n2_path.size();

        node LCA = n1_path.get(0);
        for (int i = 1; i < shorter_list_len; i++) {
            if (n1_path.get(i) == n2_path.get(i)) {
                LCA = n1_path.get(i);
            }
        }

        System.out.println("LCA(" + n1.data + " , " + n2.data + ") :" + LCA.data);
    }


    //this is a helper method which returns a list of nodes from ROOT of the tree and the destination node
    static boolean get_root_to_node_path(node root, node destination, List<node> myList) {

        if (root == null) {
            return false;
        }

        if (root == destination) {
            myList.add(0, root);
            return true;
        }

        boolean left_status = get_root_to_node_path(root.left, destination, myList);

        boolean right_status = get_root_to_node_path(root.right, destination, myList);

        if (left_status || right_status) {
            myList.add(0, root);
            return true;
        }

        return false;

    }

   
}