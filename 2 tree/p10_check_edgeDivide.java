
/**
 * Given a Binary Tree, find if there exist edge whose removal creates two trees of equal size.
 * 
 * size = number of nodes
 * 
 */

/**
* approach-1 : O(n^2)
*  step1 : count total nodes
*  step2 : visit each node one-by-one and check if number of nodes rooted at this nodes(say x) = totalNodes - x
*  step3 : if yes , return true
* 
* 
* approach-1 : O(n)
* 
*  the above can be done in linear time , when we traverse the tree from leaf to root
*  step1 : count total nodes
*  step2 : visit each node form leaf to root and check if number of nodes rooted at this nodes(say x) = totalNodes - x
*  step3 : if yes , return true
* 
* 
*/

class p10_check_edgeDivide extends HELPER {

    //global variable , this would be the answer
    static boolean RESULT = false;

    public static void main(String[] args) {

        //true
        // node ROOT = new node(10);
        // ROOT.left = new node(8);
        // ROOT.left.left = new node(3);

        // ROOT.right = new node(2);
        // ROOT.right.left = new node(3);
        // ROOT.right.right = new node(15);

        //false
        node ROOT = new node(10);
        ROOT.left = new node(8);
        ROOT.left.left = new node(3);
        ROOT.left.right = new node(3);

        ROOT.right = new node(2);
        ROOT.right.left = new node(3);
        ROOT.right.right = new node(15);

        int totalNodes = countNodes(ROOT);
        function(ROOT, totalNodes);
        System.out.println(RESULT);
    }

    /**
     * 
     * @param curreNode
     * @param count
     * @return
     */
    static int function(node curreNode, int totalNodes) {

        //total nodes should be even
        if (totalNodes % 2 == 1) {
            return 0;
        }

        if (curreNode == null) {
            return 0;
        }

        int nodes_in_lst = function(curreNode.left, totalNodes);
        int nodes_in_rst = function(curreNode.right, totalNodes);

        int nodes_rooted_here = 1 + nodes_in_lst + nodes_in_rst;

        if (2 * nodes_rooted_here == totalNodes) {
            RESULT = true;
        }

        return nodes_rooted_here;
    }

}