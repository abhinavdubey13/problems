import java.util.*;

/**
 * 
 * given a BST and an integer KEY
 * write a method which finds the in-order predecessor and successor of the KEY
 * 
 * https://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/
 *  
 */

/**
 * 
 *
 * use 
 * =================================
 * let total nodes in trees = n
 * 
 * TC = O(ht)   
 * SC = O(ht)
 *
 */

class p48_predecessor_successor_in_BST extends HELPER {

    static int PREDECESSOR = -1;
    static int SUCCESSOR = -1;

    public static void main(String[] args) {

        //left tree
        node ROOT = new node(50);
        ROOT.left = new node(30);
        ROOT.left.left = new node(20);
        ROOT.left.right = new node(40);

        ROOT.right = new node(70);
        ROOT.right.left = new node(60);
        ROOT.right.right = new node(80);

        // int key = 65;
        int key = 170;
        function(ROOT, key);
        System.out.println(PREDECESSOR);
        System.out.println(SUCCESSOR);
    }

    static void function(node root, int KEY) {

        if (root == null) {
            return;
        }

        //go right , since current value is less/equal than the key
        if (root.data <= KEY) {
            PREDECESSOR = root.data;
            function(root.right, KEY);
        }

        //go left , since current value is greater than the key
        if (root.data > KEY) {
            SUCCESSOR = root.data;
            function(root.left, KEY);
        }
    }

}