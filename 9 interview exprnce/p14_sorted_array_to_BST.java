import java.util.*;

/**
 * 
 * leetcode id : 108
 * 
 * gfg id : https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
 * 
 * 
 * Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements
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
 * 1) Get the Middle of the array and make it root.
 * 2) Recursively do same for left half and right half.
 * 
 * a) Get the middle of left half and make it left child of the root created in step 1.
 * b) Get the middle of right half and make it right child of the root created in step 1.
 * 
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(ht)
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

class p14_sorted_array_to_BST {

    public static void main(String[] args) {

        Node root;

        // int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

        int[] arr = { 1, 2, 3, 4 };

        Solution s = new Solution();
        root = s.function(arr);

        Helper.inorder(root);
        System.out.println();

    }

}

class Solution {

    Node function(int arr[]) {
        Node root = null;
        root = fun(arr, 0, arr.length - 1);
        return root;
    }

    Node fun(int[] arr, int start, int end) {

        if (start > end) {
            return null;
        }

        if (start == end) {
            return new Node(arr[start]);
        }

        int idx = start + (end - start) / 2;
        int data = arr[idx];

        Node n = new Node(data);

        n.left = fun(arr, start, idx - 1);
        n.right = fun(arr, idx + 1, end);

        return n;
    }

}

class Helper {
    static void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + " ");
            inorder(n.right);
        }
    }
}