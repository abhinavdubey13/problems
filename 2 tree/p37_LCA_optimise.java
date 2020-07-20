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
 * here an recursive approach is : USING POST_ORDER TRAVERSAL
 * recurse in the beginning to left and right subtress , at each call check if the current-node is N1 or N2
 * 
 * 1. if it is , return the current-node , else return NULL
 * 
 * 2. each parent will receive either a NULL or NON-NULL from Left and right recursion result
 *    check those value and return appropriate value from the parent-node
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

class p37_LCA_optimise extends HELPER {

    public static void main(String[] args) {

        //tree
        node ROOT = new node(50);
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

        //lca(60,80) = 60
        //  node n1 = ROOT.right;
        //  node n2 = ROOT.right.right.right;

        // node LCA = print_lca(ROOT, n1, n2);
        node LCA = Solution_2.function(ROOT, n1, n2);
        System.out.println("LCA(" + n1.data + " , " + n2.data + ") :" + LCA.data);

    }

    //this method prints LCA of n1 and n2 (both are in tree)
    static node print_lca(node root, node n1, node n2) {

        if (root == null) {
            return null;
        }

        if (root == n1 || root == n2) {
            return root;
        }

        node left_lca = print_lca(root.left, n1, n2);
        node right_lca = print_lca(root.right, n1, n2);

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

// USING POST_ORDER TRAVERSAL
class Solution_2 {

    public static node function(node curr, node p, node q) {

        if (curr == null || curr == p || curr == q)
            return curr;

        node l = function(curr.left, p, q);
        node r = function(curr.right, p, q);

        if (l != null && r != null)
            return curr;
        if (l != null)
            return l;
        return r;

    }

}