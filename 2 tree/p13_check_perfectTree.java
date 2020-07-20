import java.util.*;

/**
 * check if the given Binary Tree is perfect tree . 
 * 
 * perfect tree : both the below condition satisfy
 * 
 * condition-1 : all nodes are either leaf node or have 2 chilren
 * condition-2 : all leaf nodes at same level
 * 
 */

/**
 * 
 * approach : recursive check if both children are present or not 
 * 
 * and at leaf  , noted the level of that leaf
 * 
 * TC - O(n)
 * SC - Max(possible leaf levels , height)
 * 
 */

class p13_check_perfectTree extends HELPER {

    public static void main(String[] args) {

        //true
        // ROOT = new node(26);
        // ROOT.left = new node(10);
        // ROOT.right = new node(3);
        // ROOT.left.left = new node(4);
        // ROOT.left.right = new node(6);
        // ROOT.right.left = new node(3);
        // ROOT.right.right = new node(3);

        //false : condition-1 (true) and condition-2(false)
        ROOT = new node(10);
        ROOT.left = new node(8);
        ROOT.right = new node(2);
        ROOT.right.left = new node(3);
        ROOT.right.right = new node(15);

        Set<Integer> set_of_ht = new HashSet<Integer>();
        int initLevel = 1;

        boolean condition_1_satisfied = function(ROOT, set_of_ht, initLevel);

        if (condition_1_satisfied) {

            boolean finalResult = (set_of_ht.size() == 1) ? true : false;
            System.out.println(finalResult);

        } else {
            System.out.println(false);
        }

    }

    static boolean function(node currentNode, Set set_of_ht, int curr_level) {

        if (currentNode == null) {
            return true;
        }

        if (isLeaf(currentNode)) {
            set_of_ht.add(curr_level);
            return true;
        }

        if (currentNode.left != null && currentNode.right != null) {
            boolean lft = function(currentNode.left, set_of_ht, curr_level + 1);
            boolean rht = function(currentNode.left, set_of_ht, curr_level + 1);
            return lft && rht;
        }

        return false;

    }

}