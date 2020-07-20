
class node {
    int data;
    node left, right;

    node(int num) {
        this.data = num;
        this.left = this.right = null;
    }
}

class HELPER {

    //construct the tree in main() of that file using this
    static node ROOT;

    /**
     * METHOD-1
     * @param n 
     * @return if the node is leaf or not
     */
    static boolean isLeaf(node n) {
        return (n.left == null && n.right == null);
    }

    /**
    * METHOD-2
    * @param rootNode
    * @return the total number of nodes in the tree
    */
    static int countNodes(node rootNode) {
        if (rootNode == null) {
            return 0;
        }
        return 1 + countNodes(rootNode.left) + countNodes(rootNode.right);
    }

    /**
    * METHOD-3
    * @param rootNode
    * @return the number of nodes from ROOT to the FARTHEST leaf
    */
    static int getHeight(node rootNode) {
        if (rootNode == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(rootNode.left), getHeight(rootNode.right));
    }

    /**
     * METHOD-4
     * @param rootNode root of the tree
     * @param targetNode  node whose level is to be found out
     * @param current_level  
     * 
     * @return the level of the TARGET_NODE from ROOT_NODE of TREE 
     * considering root of the tree : level = 0
     * children of the root : level = 1 
     * .... and so on 
     * returned value is -1 if targetNode is NOT in the tree
     */
    static int getLevelOfNode(node curr_node, node target_node, int current_level) {

        //if target is null , or on traversing we hit null
        //it means current path does not contains target node , so return -1
        if (target_node == null || curr_node == null) {
            return -1;
        }

        if (curr_node == target_node) {
            return current_level;
        }

        int left_level = getLevelOfNode(curr_node.left, target_node, current_level + 1);
        int right_level = getLevelOfNode(curr_node.right, target_node, current_level + 1);

        if (left_level > -1 && right_level == -1) {
            return left_level;
        } else if (left_level == -1 && right_level > -1) {
            return right_level;
        } else {
            return -1;
        }

    }

    /**
     * METHOD-4
     * @param rootNode root of the tree
     * 
     * prints all leaves in the tree FROM LEFT TO RIGHT
     */
    static void printLeaves(node rootNode) {
        if (rootNode == null) {
            return;
        }
        if (isLeaf(rootNode)) {
            System.out.print(rootNode.data + " ");
        }
        printLeaves(rootNode.left);
        printLeaves(rootNode.right);
    }

    //the below just prints in-order traversal
    static void perform_inorder(node root) {
        if (root == null) {
            return;
        }
        perform_inorder(root.left);
        System.out.print(root.data + " ");
        perform_inorder(root.right);
    }

}