import java.util.*;

/**
 * 
 * given a binary tree and a given sum , 
 * write a method which counts the number of subtrees with that sum , 
 * 
 * NOTE : consider a leaf as a subtree too.
 *  
 */

/**
 * 
 *
 * using recursion , return the sum of subtree and check of sum is equal to given sum
 * =================================
 * let total nodes in trees = n
 * 
 * TC = O(n)
 * SC = O(ht)
 *
 */

class p46_count_subtrees_with_sum extends HELPER {

    static int RESULT = 0;

    public static void main(String[] args) {

        //left tree
        node ROOT = new node(5);
        ROOT.left = new node(-10);
        ROOT.left.left = new node(9);
        ROOT.left.right = new node(8);

        ROOT.right = new node(3);
        ROOT.right.left = new node(-4);
        ROOT.right.right = new node(7);

        int sum = 7;
        function(ROOT, sum);
        System.out.println(RESULT);
    }

    static int function(node root, int SUM) {

        if (root == null) {
            return 0;
        }

        if (isLeaf(root)) {
            if (root.data == SUM) {
                RESULT++;
            }
            return (root.data);
        }

        int left_subtree_sum = function(root.left, SUM);
        int right_subtree_sum = function(root.right, SUM);

        if (left_subtree_sum + right_subtree_sum + root.data == SUM) {
            RESULT++;

        }

        return left_subtree_sum + right_subtree_sum + root.data;

    }

  

}