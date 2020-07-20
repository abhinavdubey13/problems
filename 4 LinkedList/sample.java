import java.util.*;

/**
 * leetcode id : 
 * 
 ** 
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
 * * 
 * ============
 * TC = O(n)
 * SC = O(n)
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
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class sample {

    static Node left = null;

    public static void main(String[] args) {

        Node head;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);

        int answer = function(head);
        System.out.println(answer);
    }

    static int function(Node right) {
        return 0;
    }
}

class Helper_method {
    static void print_list(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            print_list(n.next);
        } else {
            System.out.println();
        }
    }
}
