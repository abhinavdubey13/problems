import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/flattening-a-linked-list/
 * 
 ** 
 * ========
 * example 
 * ========
 * 
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
 * (i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
 * (ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
 * All linked lists are sorted. See the following example
 * 
 * 5 -- 10 -- 19 -- 28
 * |    |     |     |
 * 7    20    22    35
 * |          |     |
 * 8          50    40
 * |                |
 * 30               45
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
 * recursively merge the 2 down-going lists
 * 
 * ==========
 * TC = O(n)
 * SC = O(height of max down list)
 * 
 * 
 *  
 * 
 * 
 * 
 * 
 * 
 */
class Node {
    int data;
    Node right;
    Node down;

    Node(int d) {
        data = d;
        right = null;
        down = null;
    }
}

class p10_flatten_LL {

    public static void main(String[] args) {

        Node head;
        head = new Node(5);
        head.down = new Node(7);
        head.down.down = new Node(8);
        head.down.down.down = new Node(20);

        head.right = new Node(10);
        head.right.down = new Node(20);

        head.right.right = new Node(19);
        head.right.right.down = new Node(22);
        head.right.right.down.down = new Node(50);

        head.right.right.right = new Node(28);
        head.right.right.right.down = new Node(35);
        head.right.right.right.down.down = new Node(40);
        head.right.right.right.down.down.down = new Node(45);

        Node merged = function(head);
        Helper_method.print_list(merged);
    }

    static Node function(Node root) {
        if (root == null) {
            return null;
        }

        Node answer = null;

        Node curr = root;

        while (curr != null) {
            answer = merge_2_sorted_using_down_pointer(answer, curr);
            curr = curr.right;
        }

        return answer;
    }

    static Node merge_2_sorted_using_down_pointer(Node a, Node b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        Node result;

        if (a.data < b.data) {
            result = a;
            result.down = merge_2_sorted_using_down_pointer(a.down, b);
        } else {
            result = b;
            result.down = merge_2_sorted_using_down_pointer(a, b.down);
        }

        return result;
    }
}

class Helper_method {
    static void print_list(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            print_list(n.down);
        } else {
            System.out.println();
        }
    }
}
