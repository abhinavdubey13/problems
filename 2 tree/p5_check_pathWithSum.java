/**
 * given a binary tree , check if there is a path from ROOT to leaf with a given sum
 */

/**
 * approach : 
 * base-condition-1 : if tree is empty , then return true if SUM = 0
 * base-condition-2 : if current node is leaf  , then return true if ( SUM = node.data )
 * 
 * recursively check LST and RST with (sumLeft = SUM - node.data )
 * 
 * 
 */

class p7_checkPathWithSum extends HELPER {

    public static void main(String[] args) {
        // ROOT = new node(10);
        // ROOT.left = new node(16);
        // ROOT.right = new node(5);
        // ROOT.left.right = new node(-3);
        // ROOT.right.left = new node(6);
        // ROOT.right.right = new node(11);
        // int sumRequired = 26;

        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(5);
        int sumRequired = 9;

        boolean answer = function(ROOT, sumRequired);
        System.out.println(answer);
    }

    static boolean function(node rootNode, int sumRequired) {

        if (rootNode == null) {
            return false;
        }

        if (isLeaf(rootNode)) {
            return rootNode.data == sumRequired;
        }

        int sumLeft = sumRequired - rootNode.data;
        boolean l = function(rootNode.left, sumLeft);
        boolean r = function(rootNode.right, sumLeft);
        return l || r;
    }

}