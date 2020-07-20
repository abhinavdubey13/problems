import java.util.*;

/**
 * 
 * Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
 * 
 * 
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right then move to the right child of the current node otherwise move to the left child.
 * Change the direction from right to left or right to left.
 * Repeat the second and third step until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 * 
 * 
 * Return the longest ZigZag path contained in that tree
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * recursive
 * 
 * pass currentdirection info , while recursion 
 * 
 * if current == left
 *  return 1+right
 * 
 * else
 * return 1+left
 *
 *
 * TC = O(n)   
 * SC = O(height)
 *
 */

class Holder {
    int answer;

    Holder() {
        this.answer = 0;
    }

}

class x2_longest_zig_zag_path extends HELPER {

    static int function(String current_direction, node root, Holder h) {

        if (root == null) {
            return 0;
        }

        if (isLeaf(root)) {
            return 1;
        }

        int l = function("left", root.left, h);
        int r = function("right", root.right, h);

        h.answer = Math.max(h.answer, Math.max(l, r));

        if (current_direction.equals("left")) {
            return 1 + r;
        } else {
            return 1 + l;
        }
    }

    static int function_util(node root) {
        Holder holder = new Holder();
        int l = function("left", root.left, holder);
        int r = function("right", root.right, holder);
        holder.answer = Math.max(holder.answer, Math.max(l, r));
        return holder.answer;
    }

    public static void main(String[] args) {

        node root;

        // tree-1 : expected = 4
        // root = new node(1);
        // root.left = new node(2);
        // root.left.right = new node(3);
        // root.left.right.left = new node(4);
        // root.left.right.right = new node(5);
        // root.left.right.left.right = new node(6);
        // root.right = new node(7);

        // tree-2 : expected=3
        root = new node(1);
        root.right = new node(2);
        root.right.left = new node(3);
        root.right.right = new node(4);
        root.right.right.left = new node(5);
        root.right.right.left.right = new node(6);
        root.right.right.left.right.right = new node(7);
        root.right.right.right = new node(8);

        int result = function_util(root);
        System.out.println(result);
    }

}