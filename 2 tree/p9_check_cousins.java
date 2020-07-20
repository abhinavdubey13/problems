/**
 * 
 * write a function which takes in any 2 nodes of the tree and checks if those 2 are cousins 
 * 
 * cousin : at same level but different parent
 * 
 * if any 1 of the 2 is not a node of the tree , return false 
 * 
 */

class p9_check_cousins extends HELPER {

    public static void main(String[] args) {
        ROOT = new node(10);
        ROOT.left = new node(8);
        ROOT.right = new node(2);
        ROOT.left.left = new node(3);
        ROOT.left.right = new node(5);
        ROOT.right.left = new node(3);
        ROOT.right.right = new node(15);

        System.out.println(function(ROOT.left.left, ROOT.right.left)); //true
        System.out.println(function(ROOT.left, ROOT.right.right)); // false

    }

    /**
     * assume that child is never null
     * @param currentRoot root node of the entire tree , initially
     * @param child node whose parent is to be found out
     * @return
     */
    static node getParent(node currentRoot, node child) {

        if (currentRoot == null || child == null) {
            return null;
        }

        if (currentRoot.left == child || currentRoot.right == child) {
            return currentRoot;
        }

        node left_answer = getParent(currentRoot.left, child);
        node right_answer = getParent(currentRoot.right, child);

        if (left_answer != null && right_answer == null) {
            return left_answer;
        }

        else if (left_answer == null && right_answer != null) {
            return right_answer;
        }

        else {
            return null;
        }

    }

    static boolean function(node node_1, node node_2) {

        int level_1 = getLevelOfNode(ROOT, node_1, 0);
        int level_2 = getLevelOfNode(ROOT, node_2, 0);

        if (level_1 != level_2) {
            return false;
        }

        node parent_1 = getParent(ROOT, node_1);
        node parent_2 = getParent(ROOT, node_2);

        if (parent_1 != null && parent_2 != null && parent_1 != parent_2) {
            return true;
        }

        return false;

    }

}