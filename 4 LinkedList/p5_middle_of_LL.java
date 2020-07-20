import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a linked list, print its middle node 
 *
 * 
 * ========
 * example 
 * ========
 *
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * using slow and fast pointers  
 * 
 * 
 * NOTE : 
 * 1. if at last fast = null      : length is even
 * 2. if at last fast.next = null : length is odd
 * 
 * ==============
 * TC = O(n)
 * SC = O(1)
 *
 * 
 * 
 * 
 */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class p5_middle_of_LL {

    public static void main(String[] args) {

        // //odd length loop
        // Node head;
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);

        //even length loop
        Node head;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        function(head);
    }

    static void function(Node head) {

        if (head == null) {
            System.out.println("empty list");
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("mid node = " + slow.data);
    }

    static void print_list(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            print_list(n.next);
        }
    }

}
