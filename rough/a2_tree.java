import java.util.*;

class node {
    int data;
    node left, right;

    node(int item) {
        data = item;
        left = right = null;
    }

}

class a2_tree {

    public static void main(String[] args) {

        node root = null;

        root = new node(3);
        root.left = new node(1);
        // root.left.left = new node(4);
        root.left.right = new node(2);
        // root.left.left.right = new node(8);

        root.right = new node(4);
        // root.right.left = new node(6);
        // root.right.right = new node(7);

        int k = 4;

        
        int ans = new Solution().function(root, k);
        System.out.println(ans);

    }

}

class Solution {

    int function(node root, int k) {

        return -1;

    }

}
