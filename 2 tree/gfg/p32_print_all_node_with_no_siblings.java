import java.util.*;

/**
 * 
 * given a binary tree , print all nodes which do NOT have a sibling.
 * 
 * ROOT node cannot have a sibling , so do NOT print that node
 * 
 */

/**
 * 
 *
 * apprach is similar to pre-order traversal , 
 * 
 * here , instead of printing the node values , we add to list , if sibling not present
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(height)
 *
 */

class p32_print_all_node_with_no_siblings extends HELPER {

    public static void main(String[] args) {

        // node 2 and 3  do not have sibling
        // ROOT = new node(1);
        // ROOT.left = new node(2);
        // ROOT.left.left = new node(3);

        //all nodes have sibling
        // ROOT = new node(2);
        // ROOT.left = new node(1);
        // ROOT.right = new node(3);

        //tree
        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.right = new node(4);
        ROOT.right.left = new node(5);
        ROOT.right.left.left = new node(6);

        ArrayList<node> nodes_with_no_sib = new ArrayList<node>();

        function(ROOT, nodes_with_no_sib);

        if (nodes_with_no_sib.size() > 0) {
            for (node n : nodes_with_no_sib) {
                System.out.print(n.data + " ");
            }
        } else {
            System.out.println("all nodes have a sibling");

        }

        System.out.println();
    }

    static void function(node currNode, ArrayList<node> nodes_with_no_sib) {

        if (currNode == null) {
            return;
        }

        //check if only left child
        if (currNode.left != null && currNode.right == null) {
            nodes_with_no_sib.add(currNode.left);
        }

        //check if only right child
        else if (currNode.left == null && currNode.right != null) {
            nodes_with_no_sib.add(currNode.right);
        }

        function(currNode.left, nodes_with_no_sib);
        function(currNode.right, nodes_with_no_sib);

    }

}