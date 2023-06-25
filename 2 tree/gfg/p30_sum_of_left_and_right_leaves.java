
/**
 * 
 * given a binary tree , write a method which gives the sum of leaf and right leaves in the tree
 * 
 */

/**
 * 
 * recursive
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(height)
 *
 */

class p30_sum_of_left_and_right_leaves extends HELPER {

    public static void main(String[] args) {

        //sum-left = 7
        //sum-right = 13
        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.left.left = new node(3);
        ROOT.left.right = new node(4);

        ROOT.right = new node(5);
        ROOT.right.left = new node(6);
        ROOT.right.right = new node(7);

        System.out.println("sum of leaves in LST : " + sum_of_leaf(ROOT.left));
        System.out.println("sum of leaves in RST : " + sum_of_leaf(ROOT.right));

    }

    static int sum_of_leaf(node root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)) {
            return root.data;
        }
        int left_leaves_sum = sum_of_leaf(root.left);
        int right_leaves_sum = sum_of_leaf(root.right);
        return left_leaves_sum + right_leaves_sum;
    }

}