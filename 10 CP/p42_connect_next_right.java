import java.util.*;

/**
 * 
 * leetcode id : 116
 * 
 * Populate each next pointer to point to its next right node. 
 * 
 * If there is no next right node, the next pointer should be set to NULL.
 * 
 * 
 * 
 * 
 */

/**
 * 
 * 
 * solution 1 : using BFS (BFS using Queue)
 * 
 * 
 * solution 2 : using reveresed-Pre order
 * (this is better space wise)
 * 
 *
 *
 * 
 * 
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int _val) {
        val = _val;
    }
}

class p42_connect_next_right {

    public static void main(String[] args) {

        Node root = null;

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        root = new Solution_using_PreOrder().connect(root);

        System.out.println(123);

    }
}

class Solution_using_BFS {
    public Node connect(Node root) {

        if (root == null) {
            return root;
        }
        que<Node> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            while (size > 0) {
                Node node = q.remove();
                if (prev != null) {
                    prev.next = node;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                prev = node;
                size--;
            }
        }
        return root;

    }
}

class Solution_using_PreOrder {

    Node connect(Node root) {

        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        reverse_preorder(root);

        return root;

    }

    void reverse_preorder(Node curr) {

        //null or leaf : dont do anything
        if (curr == null || curr.left == null && curr.right == null) {
            return;
        }

        //if left child 
        if (curr.left != null) {

            //if right child exist
            if (curr.right != null) {
                curr.left.next = curr.right;
            } else {
                curr.left.next = get_next_right(curr.next);
            }
        }

        //if  right child
        if (curr.right != null) {
            curr.right.next = get_next_right(curr.next);
        }

        //this is reversed preorder
        reverse_preorder(curr.right);
        reverse_preorder(curr.left);
    }

    Node get_next_right(Node n) {
        if (n == null) {
            return null;
        }
        if (n.left != null) {
            return n.left;
        } else if (n.right != null) {
            return n.right;
        } else {
            return get_next_right(n.next);
        }
    }
}
