import java.util.*;

/**
 * 
 * leetcode id : 297
 * 
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * using level-order (BFS) to convert tree into serialzed string
 * 
 * and then using queue to get the tree from string in similar fashion
 * 
 * we can also remove trailing NULL_REPRESENTATONS to optimise space
 * 
 * ===========
 * TC = O(n)
 * SC = O(n)
 *
 */

class p56_serialize_deserialize_tree extends HELPER {

    static final String SEPERATOR = "-";
    static final String NULL_REPRESENTATION = "x";

    public static void main(String[] args) {

        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.right.left = new node(4);
        root.right.right = new node(5);

        String serialized = serialize(root);
        System.out.println(serialized);

        node returned_root = de_serialize(serialized);
        HELPER.perform_inorder(returned_root);
        System.out.println();
    }

    static String serialize(node root) {
        if (root == null) {
            return "";
        }
        StringBuffer helper = new StringBuffer();
        Queue<node> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            node curr = queue.poll();

            if (curr == null) {
                helper.append(NULL_REPRESENTATION).append(SEPERATOR);
            } else {
                helper.append(curr.data).append(SEPERATOR);
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }

        String answer = helper.substring(0, helper.length() - 1); //remove the last seperator 
        return answer;

    }

    static node de_serialize(String input) {
        if (input.length() < 1) {
            return null;
        }

        String[] splitted = input.split(SEPERATOR);
        node root = new node(Integer.parseInt(splitted[0]));

        Queue<node> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < splitted.length; i++) {
            node curr = queue.poll();
            if (!splitted[i].equals(NULL_REPRESENTATION)) {
                curr.left = new node(Integer.parseInt(splitted[i]));
                queue.offer(curr.left);
            }
            i++;
            if (!splitted[i].equals(NULL_REPRESENTATION)) {
                curr.right = new node(Integer.parseInt(splitted[i]));
                queue.offer(curr.right);

            }

        }

        return root;

    }

}
