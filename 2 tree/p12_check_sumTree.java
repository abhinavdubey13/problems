
/**
 * check if the given Binary Tree is SumTree . 
 * 
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree. 
 * 
 * An empty tree is SumTree and sum of an empty tree can be considered as 0.
 * 
 * A leaf node is also considered as SumTree.
 * 
 * 
 */

/**
 * 
 * approach : recursively check if (sum of LST) + (sum of RST) = node-data
 * 
 * the method here , returns the sum of all nodes , rooted at currentNode as Root 
 * 
 * TC - O(n)
 * SC - O(height) 
 * 
 */

class p12_check_sumTree extends HELPER {

    //this will be the answer
    static boolean RESULT;

    public static void main(String[] args) {

        //true
        ROOT = new node(26);
        ROOT.left = new node(10);
        ROOT.right = new node(3);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(6);
        ROOT.right.right = new node(3);

        //false
        // ROOT = new node(10);
        // ROOT.left = new node(8);
        // ROOT.right = new node(2);
        // ROOT.right.left = new node(3);
        // ROOT.right.right = new node(15);

        //initialize the result
        RESULT = true;

        function(ROOT);
        System.out.println(RESULT);

    }

    static int function(node currentNode) {

        if (currentNode == null) {
            return 0;
        }

        if (isLeaf(currentNode)) {
            return currentNode.data;
        }

        int sum_of_LST = function(currentNode.left);
        int sum_of_RST = function(currentNode.right);

        if (currentNode.data == sum_of_LST + sum_of_RST) {
            RESULT = (RESULT & true);
        } else {
            RESULT = false;
        }

        return (currentNode.data + sum_of_LST + sum_of_RST);

    }

}