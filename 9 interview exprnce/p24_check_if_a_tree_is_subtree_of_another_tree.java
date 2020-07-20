import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
 * 
 * 
 * Two of the nodes of a Binary Search Tree (BST) are swapped. 
 * Fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
 *  
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * 
 * 
 * using the problem of checking BST , if a node violates BST property , we add it to incoreect list
 * 
 * at last we swap data if the 2 nodes present in incorrect list
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(ht)
 * 
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

class p24_check_if_a_tree_is_subtree_of_another_tree {

    public static void main(String[] args) {

        Node T = null;
        Node S = null;

        // T = new Node(1);
        // T.left = new Node(2);
        // T.right = new Node(3);
        // T.right.left = new Node(4);
        // S = new Node(3);
        // S.left = new Node(4);

        T = new Node(26);
        T.left = new Node(10);
        T.left.left = new Node(4);
        T.left.left.right = new Node(30);
        T.left.right = new Node(6);
        T.right = new Node(3);
        T.right.right = new Node(3);

        S = new Node(10);
        S.left = new Node(4);
        S.left.right = new Node(30);
        S.right = new Node(6);

        Solution_1 s = new Solution_1();
        boolean answer = s.function(T, S);
        System.out.println(answer);
    }

}

class Solution_1 {

    boolean answer;

    boolean function(Node T, Node S) {
        answer = false;
        pre_order(T, S);
        return answer;
    }

    void pre_order(Node curr, Node S) {

        if (curr == null || S == null || answer) {
            return;
        }

        if (curr.data == S.data) {
            boolean tmp = check_same(curr, S);
            if (!answer) {
                answer = tmp;
            }
        }

        pre_order(curr.left, S);
        pre_order(curr.right, S);

    }

    boolean check_same(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.data == b.data) {
            return check_same(a.left, b.left) && check_same(a.right, b.right);
        }
        return false;
    }

}

// class Helper {
//     static void inorder(Node n) {
//         if (n != null) {
//             inorder(n.left);
//             System.out.print(n.data + " ");
//             inorder(n.right);
//         }
//     }
// }