import java.util.*;

/**
 * 
 * 
 * given root node of BST and a range [X,Y]
 * 
 * modify the input BST such that all nodes outside the range are removed
 * 
 * resultant tree must also be BST
 * 
 * https://www.geeksforgeeks.org/remove-bst-keys-outside-the-given-range/
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * use post-order traversal
 * 
 * 1) Node’s key is outside the given range. This case has two sub-cases.
 *       a) Node’s key is smaller than the min value => return RST of root
 *       b) Node’s key is greater that the max value => return LST of root
 * 
 * 2) Node’s key is in range => do nothing in this case
 * 
 *
 * TC = O(n)   
 * SC = O(1)
 *
 */

class p55_remove_keys_outside_a_range_BST extends HELPER {

    public static void main(String[] args) {

        node root = new node(10);
        root.left = new node(5);
        root.left.left = new node(-2);
        root.left.right = new node(6);
        root.left.left.right = new node(2);
        root.left.right.right = new node(8);
        root.left.left.right.left = new node(-1);

        root.right = new node(30);
        root.right.right = new node(40);

        //before-removal
        //in-order = -2 , -1 , 2 , 5 , 6 , 8 , 10 , 30 , 40

        int X = 7;
        int Y = 15;
        root = remove_outside_range(root, X, Y);

        //print inorder of resultant tree
        perform_inorder(root);
        System.out.println();
    }

    static node remove_outside_range(node root, int X, int Y) {
        if (root == null) {
            return null;
        }

        root.left = remove_outside_range(root.left, X, Y);
        root.right = remove_outside_range(root.right, X, Y);

        if (root.data < X) {
            node return_node = root.right;
            root = null;
            return return_node;
        } 
        
        else if (root.data > Y) {
            node return_node = root.left;
            root = null;
            return return_node;
        }

        return root;
    }

    static void perform_inorder(node root) {
        if (root != null) {
            perform_inorder(root.left);
            System.out.print(root.data + " ");
            perform_inorder(root.right);
        }
    }

}