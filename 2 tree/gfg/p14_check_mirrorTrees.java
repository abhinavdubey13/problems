
/**
 * Given two Binary Trees, write a function that returns true if two trees are mirror of each other,
 */

/**
 * 
 * approach : recursively check if 
 *  1. the data is same 
 *  2. RST of Left-tree == LST of right-tree
 *  3. LST of Left-tree == RST of right-tree
 * 
 * TC - O(n)
 * SC - O(height) 
 * 
 */

class p14_check_mirrorTrees extends HELPER {

    public static void main(String[] args) {

        //true
        // node leftRoot = new node(10);
        // leftRoot.left = new node(8);
        // leftRoot.right = new node(2);
        // node rightRoot = new node(10);
        // rightRoot.left = new node(2);
        // rightRoot.right = new node(8);

        //true
        node a = new node(1);
        node b = new node(1);
        a.left = new node(2);
        a.right = new node(3);
        a.left.left = new node(4);
        a.left.right = new node(5);
        b.left = new node(3);
        b.right = new node(2);
        b.right.left = new node(5);
        b.right.right = new node(4);

        System.out.println(function(a, b));
    }

    static boolean function(node leftRoot, node rightRoot) {

        if (leftRoot == null) {
            return rightRoot == null;
        }

        if (rightRoot == null) {
            return leftRoot == null;
        }

        if (isLeaf(leftRoot) && isLeaf(rightRoot)) {
            return (leftRoot.data == rightRoot.data);
        }

        boolean check_1 = (leftRoot.data == rightRoot.data);
        boolean check_2 = function(leftRoot.right, rightRoot.left);
        boolean check_3 = function(leftRoot.left, rightRoot.right);

        return (check_1 && check_2 && check_3);
    }

}