import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 * 
 * 
 *
 * given root node and another node in the tree(say n)
 * 
 * return inorder successor of n
 *  
 * 
 */

/**
 *  
 * 
 * ==================================
 * approach : 1 (inorder successor)
 * ==================================
 * 
 * 
 * if(n.right!=null) : inorder successor is minimum node in RST
 * else              : inorder successor is just greater node in (ROOT-->n) path 
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(ht)
 * 
 * 
 * 
 * 
 * similary we can do for predecessor
 * 
 *  
 * 
 * 
 * 
 * 
 * 
 */

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class p16_inorder_successor_n_predecessor_in_BST {

    public static void main(String[] args) {

        Node root = null;

        root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(20);
        root.right.left = new Node(13);

        Node query_node = root.right.left;

        //successor
        Node successor = Successor.find_successor(root, query_node);
        if (successor != null)
            System.out.println("successor for " + query_node.data + " is : " + successor.data);
        else
            System.out.println("no successor for : " + query_node.data);

        //predecessor
        Node predecessor = Predecessor.find_predecessor(root, query_node);
        if (predecessor != null)
            System.out.println("Predecessor for " + query_node.data + " is : " + predecessor.data);
        else
            System.out.println("no predecessor for : " + query_node.data);

    }

}

class Successor {

    static Node find_successor(Node root, Node n) {

        if (n.right != null) {
            return min_in_rst(n.right);
        }

        //in this case , the element just greater than the root , in root-->n path , will be the inorder successor 
        Node successor = null;

        while (root != null) {

            //going left : to search for n
            if (root.data > n.data) {
                successor = root;
                root = root.left;
            }

            //going right : to search for n
            else if (root.data < n.data) {
                root = root.right;
            }

            //arrived at n 
            else {
                break;
            }
        }

        return successor;

    }

    static Node min_in_rst(Node n) {
        if (n.left == null) {
            return n;
        }
        return min_in_rst(n.left);
    }

}

class Predecessor {

    static Node find_predecessor(Node root, Node n) {

        if (n.left != null) {
            return max_in_lst(n.right);
        }

        //in this case , the element just smaller than the root , in root-->n path , will be the inorder successor 
        Node successor = null;

        while (root != null) {

            //going left : to search for n
            if (root.data > n.data) {
                root = root.left;
            }

            //going right : to search for n
            else if (root.data < n.data) {
                successor = root;
                root = root.right;
            }

            //arrived at n 
            else {
                break;
            }
        }

        return successor;

    }

    static Node max_in_lst(Node n) {
        if (n.right == null) {
            return n;
        }
        return max_in_lst(n.right);
    }

}
