import java.util.*;

/**
 * 
 * given a binary tree ,and a node in the tree , and value 'K'
 * 
 * find the K'th ancestor of the node
 * 
 * 
 */

/**
 * 
 * 1. back-track recursion
 * 
 * 2. backtrack k times to reach to kth ancestor, 
 *    once we have reached to the kth parent, we will simply print the node.
 *  
 *
 * 
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(height)
 *
 */

class Result {
    boolean isAncestor;
    int ancestorData;
    int ancestorLevel;
}

class p40_kth_ancestor_of_a_node extends HELPER {

    static Result function(node root, node n1, int k, int level_of_n1) {

        if (level_of_n1 - 1 < k) {
            System.out.println(n1.data + " has only " + (level_of_n1 - 1) + " ancestors.");
            return null;
        }

        Result result = new Result();

        if (root == null || root == n1) {
            result.ancestorLevel = -1;
            result.ancestorData = -1;
            result.isAncestor = false;
            return result;
        }

        //immediate parent of n1 (1st ancestor)
        if (root.left == n1 || root.right == n1) {
            result.isAncestor = true;
            result.ancestorLevel = 1;
            result.ancestorData = root.data;
            return result;
        }

        Result left_result = function(root.left, n1, k, level_of_n1);
        Result right_result = function(root.right, n1, k, level_of_n1);

        if (left_result.isAncestor || right_result.isAncestor) {

            Result requiredResult = (left_result.isAncestor) ? left_result : right_result;

            //check if already the required ancestor is found
            if (requiredResult.ancestorLevel == k) {
                return requiredResult;
            }

            //if kth ancestor is not found
            result.ancestorLevel = requiredResult.ancestorLevel + 1;
            result.ancestorData = root.data;
            result.isAncestor = true;
            return result;
        }

        //if n1 is not in LST and RST of root
        else {
            result.ancestorLevel = -1;
            result.ancestorData = -1;
            result.isAncestor = false;
            return result;
        }

    }

    public static void main(String[] args) {

        //tree
        ROOT = new node(50);
        ROOT.left = new node(30);
        ROOT.left.left = new node(5);
        ROOT.left.right = new node(10);
        ROOT.right = new node(60);
        ROOT.right.left = new node(45);
        ROOT.right.right = new node(70);
        ROOT.right.right.right = new node(80);
        ROOT.right.right.left = new node(65);

        //ancestores of (65) = 70,60,50
        node n1 = ROOT.right.right.left;
        int level_of_n1 = 4;
        int k = 4;

        Result result = function(ROOT, n1, k, level_of_n1);

        if (result != null)
            System.out.println(k + "'th ancestor of " + n1.data + " is " + result.ancestorData);

    }

}