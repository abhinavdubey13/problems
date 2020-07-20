
/**
 * 
 * given a binary tree and an interger X , find sum of all parent nodes having X as a child node
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

class p29_sum_of_parents_having_x extends HELPER {

    static int SUM = 0;

    public static void main(String[] args) {

        //sum=27
        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.left = new node(1);
        ROOT.left.right = new node(2);
        ROOT.right.left = new node(3);
        ROOT.right.right = new node(15);
        int x = 3;

        function(ROOT, x);
        System.out.println(SUM);

    }

    static void function(node root, int X) {

        if (root == null || isLeaf(root)) {
            return;
        }

        boolean is_left_child_x = (root.left != null && root.left.data == X) ? true : false;
        boolean is_right_child_x = (root.left != null && root.right.data == X) ? true : false;

        if (is_left_child_x || is_right_child_x) {
            SUM += root.data;
        }

        function(root.left, X);
        function(root.right, X);
    }

}