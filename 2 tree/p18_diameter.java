
/**
 * The diameter of a tree is the number of nodes on the longest path between two leaves in the tree
 * 
 */

/**
 * 
 * approach : 
 * 
 * to print the diameter value : find max of (1 + height(LST) + height(RST)) at every node , EFFICIENTLY
 * 
 * TC - O(n)
 * SC - O(height) 
 * 
 */

class p18_diameter extends HELPER {

    static int DIAMETER;

    public static void main(String[] args) {

        //diameter pass thru ROOT
        // ROOT = new node(1);
        // ROOT.left = new node(2);
        // ROOT.right = new node(3);
        // ROOT.left.left = new node(4);
        // ROOT.left.right = new node(5);
        // ROOT.right.left = new node(6);
        // ROOT.right.right = new node(7);

        //diameter pass thru non-ROOT node
        node ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(5);
        ROOT.left.right.left = new node(6);
        ROOT.left.right.right = new node(7);
        ROOT.left.left.right = new node(8);
        ROOT.left.left.right.left = new node(9);

        DIAMETER = -1;

        function(ROOT);
        System.out.println("nodes on diameter path : " + DIAMETER);
        System.out.println("edges on diameter path : " + (DIAMETER-1));

    }

    //efficient way O(n): only return the value of diameter
    static int function(node currentRoot) {

        if (currentRoot == null) {
            return 0;
        }

        int height_LST = function(currentRoot.left);
        int height_RST = function(currentRoot.right);

        DIAMETER = Math.max(DIAMETER, 1 + height_LST + height_RST);

        return 1 + Math.max(height_LST, height_RST);
    }

}