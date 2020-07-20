
/**
 * 
 * given a binary tree, write a method to find sum of all nodes in the tree
 * 
 */

/**
 * 
 * we can weither use traversals or recursion
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(height)
 *
 */

class p28_sum_of_all_nodes extends HELPER {

    public static void main(String[] args) {

        //sum=27
        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.left = new node(1);
        ROOT.left.right = new node(2);
        ROOT.right.left = new node(3);
        ROOT.right.right = new node(15);

        System.out.println(function(ROOT)); // false

    }

    static int function(node root) {

        if (root == null) {
            return 0;
        }

        if (isLeaf(root)) {
            return root.data;
        }

        return root.data + function(root.left) + function(root.right);
    }

}