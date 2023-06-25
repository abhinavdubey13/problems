/**
 * Given a binary tree, write a function that returns true if the tree satisfies below property.
 * For every node, data value must be equal to sum of data values in left and right children.
 *  Consider data value as 0 for NULL children.
 */

/**
 * approach : recursively check at each node 
 */

class p8_check_childrenSum extends HELPER {

    public static void main(String[] args) {

        //true
        ROOT = new node(10);
        ROOT.left = new node(8);
        ROOT.left.left = new node(3);
        ROOT.left.right = new node(5);

        ROOT.right = new node(2);
        ROOT.right.left = new node(2);

        // false
        // ROOT = new node(10);
        // ROOT.left = new node(8);
        // ROOT.left.left = new node(3);
        // ROOT.left.right = new node(5);

        // ROOT.right = new node(2);
        // ROOT.right.left = new node(3);

        System.out.println(function(ROOT));
    }

    static boolean function(node rootNode) {

        if (rootNode == null || isLeaf(rootNode)) {
            return true;
        }

        int left_child_data = (rootNode.left == null) ? 0 : rootNode.left.data;
        int right_child_data = (rootNode.right == null) ? 0 : rootNode.right.data;

        if (rootNode.data == left_child_data + right_child_data) {
            return (function(rootNode.right) && function(rootNode.left));
        } else {
            return false;
        }

    }

    static boolean fun2(node n) {

        if (n == null || isLeaf(n)) {
            return true;
        }

        int lft = (n.left != null) ? n.left.data : 0;
        int rgt = (n.right != null) ? n.right.data : 0;

        boolean here = (n.data == lft + rgt);
        boolean l = fun2(n.left);
        boolean r = fun2(n.right);

        return here && l && r;
    }

}