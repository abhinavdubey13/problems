/**
 * 
 * given a binary tree ,and 2 nodes in the tree , find distance (#edges) between the 2 ndoes
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
 * 2. find dist from LCA-->n1 + LCA-->n2
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

class p38_distance_bw_2_nodes_using_LCA extends HELPER {

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

        //dist(65,80) = 2
        // node n1 = ROOT.right.right.left;
        // node n2 = ROOT.right.right.right;

        //dist(45,80) = 3
        node n1 = ROOT.right.left;
        node n2 = ROOT.right.right.right;

        //dist(30,80) = 4
        // node n1 = ROOT.left;
        // node n2 = ROOT.right.right.right;

        //dist(60,80) = 2
        // node n1 = ROOT.right;
        // node n2 = ROOT.right.right.right;

        int dist = find_distance(ROOT, n1, n2);
        System.out.println("Dist(" + n1.data + " , " + n2.data + ") : " + dist);

    }

    static int find_distance(node root, node n1, node n2) {

        node LCA = find_lca(root, n1, n2);

        if (LCA == null) {
            return -1;
        }

        int lca_to_n1 = getLevelOfNode(LCA, n1, 0);
        int lca_to_n2 = getLevelOfNode(LCA, n2, 0);
        
        return (lca_to_n1 + lca_to_n2);
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