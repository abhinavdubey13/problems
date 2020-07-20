import java.util.*;

/**
 * leetcode id : 230
 * 
 * 
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree
 * 
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * 
 * ==========
 * example : 
 * ==========
 * 
 *
 *
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
 * obtain inorder array and then return arr[k-1]
 * 
 * ===========
 * TC=O(n)
 * SC=O(n)
 * ==========
 * 
 * 
 * 
 * 
 * ============================================================
 * approach : optimal (without changing tree node structure)
 * ============================================================
 *
 * using BST property (and inorder traversal)
 * 
 * we maintian 2 global variable : 
 * 
 * 1. number of processed nodes
 * 2. answer
 * 
 * 
 * we process the nodes in inorder fashion (ascding order)
 * if number of processed nodes becomes K , that is our answer
 * 
 * if answer is set , we donot make further calls
 * 
 * 
 * 
 * 
 * ===========
 * TC=O(n)
 * SC=O(ht)
 * ===========
 * 
 * 
 * =============================================================================================================================
 * approach : optimal with modification allowed (changing tree node structure : constraint is that we cannot traverse the tree)
 * ==============================================================================================================================
 *
 * we maintain a new variable : LEFT_COUNT , with each node , which stores number of trees in LHS of a node
 * 
 * https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
 * 
 * Assume that the root is having LC nodes in its left subtree. If K = LC + 1, root is K-th node. 
 * 
 * If K < (LC + 1), we will continue our search (recursion) for the Kth smallest element in the left subtree of root. 
 * 
 * 
 * If K > (LC + 1), we continue our search in the right subtree for the (K – LC – 1)-th smallest element. 
 * 
 * 
 * Note that we need the count of elements in the left subtree only.
 *  
 * 
 * ===========
 * TC=O(n)
 * SC=O(ht)
 * ===========
 * 
 * 
 * pseudo code : 
 * 
 *  public static Node kthSmallest(Node root, int k)
    {
        // base case
        if (root == null)
            return null;
     
        int count = root.lCount + 1;
        if (count == k)
            return root;
     
        if (count > k)
            return kthSmallest(root.left, k);
     
        // else search in right subtree
        return kthSmallest(root.right, k - count);
    }
 * 
 * 
 * 
 * 
 */

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }

}

class x36_kth_largest_in_BST {

    public static void main(String[] args) {

        Node root = null;

        root = new Node(3);
        root.left = new Node(1);
        // root.left.left = new Node(4);
        root.left.right = new Node(2);
        // root.left.left.right = new Node(8);

        root.right = new Node(4);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);

        int k = 4;

        //using recursive inorder
        // Solution s = new Solution();
        // int ans = s.function(root, k);
        // System.out.println(ans);

        //using iterative inorder
        int ans = Solution_iterative_inorder.function(root, k);
        System.out.println(ans);

    }

}

class Solution {

    int NUM_PROCESSED_NODES;

    Integer answer;

    int function(Node root, int k) {
        NUM_PROCESSED_NODES = 0; //initially no nodes are processed
        answer = null; //initially we have not found the answer
        inorder(root, k);
        return answer;
    }

    void inorder(Node curr, int k) {

        //if end of tree , or 
        //answer already found ,then do not make further calls
        if (curr == null || answer != null) {
            return;
        }

        inorder(curr.left, k);

        //when-ever we are going into RST of any node , we increment number of nodes processed
        NUM_PROCESSED_NODES++;

        if (NUM_PROCESSED_NODES == k) {
            answer = curr.data;
        }

        inorder(curr.right, k);

    }

}

class Solution_iterative_inorder {

    static int function(Node root, int k) {
        Stack<Node> stk = new Stack<>();
        Node curr = root;
        while (stk.size() > 0 || curr != null) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            if (--k == 0) {
                return curr.data;
            }
            curr = curr.right;
        }

        return -1;

    }

}
