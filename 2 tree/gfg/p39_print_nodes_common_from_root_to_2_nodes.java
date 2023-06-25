import java.util.*;

/**
 * 
 * given a binary tree ,and 2 nodes in the tree ,
 * 
 * there must be a path from ROOT-->n1  and another path from ROOT-->n2
 * 
 * print all common nodes in the 2 paths
 * 
 * 
 * 
 */

/**
 * 
 * here the approach is :
 *  
 * 1. find LCA of the 2 nodes
 * 
 * 2. print ROOT-->LCA path
 * 
 * 
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(height)
 *
 */

class p39_print_nodes_common_from_root_to_2_nodes extends HELPER {

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

        //common(65,80) = 50,60,70
        // node n1 = ROOT.right.right.left;
        // node n2 = ROOT.right.right.right;

        //common(45,80) = 50,60
        // node n1 = ROOT.right.left;
        // node n2 = ROOT.right.right.right;

        //common(30,80) = 50
        // node n1 = ROOT.left;
        // node n2 = ROOT.right.right.right;

        //common(60,80) = 50,60
        node n1 = ROOT.right;
        node n2 = ROOT.right.right.right;

        function(ROOT, n1, n2);
    }

    static void function(node root, node n1, node n2) {

        List<node> list_of_common_nodes = new LinkedList<node>();
        node LCA = find_lca(root, n1, n2);

        get_common_nodes(root, LCA, list_of_common_nodes);

        System.out.print("Common nodes(" + n1.data + " , " + n2.data + ") : ");
        
        for (node n : list_of_common_nodes) {
            System.out.print(n.data + " ");
        }

        System.out.println();

    }

    static boolean get_common_nodes(node root, node LCA, List<node> list_of_common_nodes) {

        if (root == null) {
            return false;
        }

        if (root == LCA) {
            list_of_common_nodes.add(0, root);
            return true;
        }

        boolean left_status = get_common_nodes(root.left, LCA, list_of_common_nodes);
        boolean right_status = get_common_nodes(root.right, LCA, list_of_common_nodes);

        if (left_status || right_status) {
            list_of_common_nodes.add(0, root);
            return true;
        }

        return false;

    }

    //this method prints LCA of n1 and n2 (both are in tree)
    static node find_lca(node root, node n1, node n2) {

        if (root == null) {
            return null;
        }

        if (root == n1 || root == n2) {
            return root;
        }

        node left_lca = find_lca(root.left, n1, n2);
        node right_lca = find_lca(root.right, n1, n2);

        if (left_lca == right_lca) {
            return left_lca;
        }

        else if (left_lca == null && right_lca != null) {
            return right_lca;
        }

        else if (left_lca != null && right_lca == null) {
            return left_lca;
        }

        else if (left_lca != null && right_lca != null && left_lca != right_lca) {
            return root;
        }

        return null;

    }

}