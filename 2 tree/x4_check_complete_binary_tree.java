import java.util.*;

/**
 * 
 * Given a binary tree, determine if it is a complete binary tree.
 * Definition of a complete binary tree from Wikipedia:
 * 
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. 
 * 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * iterative using level-order traversal
 * 
 * solutions : https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
 *
 * TC = O(n)   
 * SC = O(max-nodes-at-a-level)
 *
 */

class x4_check_complete_binary_tree extends HELPER {

    static boolean function(node root) {

        if (root == null) {
            return true;
        }

        boolean flag = false;

        Queue<node> my_queue = new LinkedList<>();

        my_queue.offer(root);

        while (my_queue.size() > 0) {

            node popped = my_queue.poll();

            if (popped.left != null) {

                if (flag == true) {
                    return false;
                }
                my_queue.offer(popped.left);
            } else {
                flag = true;
            }

            if (popped.right != null) {

                if (flag == true) {
                    return false;
                }
                my_queue.offer(popped.right);
            } else {
                flag = true;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        node root;

        // tree-1 : expected = false
        // root = new node(1);
        // root.left = new node(2);
        // root.left.left = new node(3);
        // root.right = new node(4);
        // root.right.left = new node(5);
        // root.right.right = new node(6);

        // tree-2 : expected = true
        root = new node(1);
        root.left = new node(2);
        root.left.left = new node(3);
        root.left.right = new node(4);

        root.right = new node(5);
        // root.right.left = new node(6);

        boolean result = function(root);
        System.out.println(result);
    }

}