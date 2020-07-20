import java.util.*;

/**
 * leetcode id : 
 * 
 * Rearrange a linked list in such a way that all odd position nodes are together and all even positions node are together,

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
 * using 2 header for odd and even
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(q)
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

class p12_rearrange_odd_even_together {

    public static void main(String[] args) {

        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = new Node(6);

        // //all odd
        // Node head = new Node(1);
        // head.next = new Node(3);
        // head.next.next = new Node(5);
        // head.next.next.next = new Node(7);

        //all even
        //  Node head = new Node(2);
        //  head.next = new Node(4);
        //  head.next.next = new Node(6);

        // 1 even
        // Node head = new Node(2);

        //1 odd
        Node head = new Node(5);

        Helper_class.print_list(head);
        head = function(head);
        Helper.print_list(head);
    }

    static Node function(Node head) {

        if (head == null) {
            return null;
        }

        Node odd_head = new Node(-1); //colllectes only odd nodes
        Node odd_itr = odd_head; //points to last element of odd list

        Node even_head = new Node(-2);
        Node even_itr = even_head;

        Node curr = head;

        while (curr != null) {

            Node nxt = curr.next;

            //if we get even node , add to even list , set its next to null
            if (curr.data % 2 == 0) {
                even_itr.next = curr;
                even_itr = even_itr.next;
                curr.next = null;
            } else {
                odd_itr.next = curr;
                odd_itr = odd_itr.next;
                curr.next = null;
            }
            curr = nxt;
        }

        //all nodes were even
        if (odd_head.next == null) {
            return even_head.next;
        }

        //all nodes were odd
        if (even_head.next == null) {
            return odd_head.next;
        }

        odd_itr.next = even_head.next;
        return odd_head.next;

    }

}

class Helper {

    public static void print_list(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            print_list(n.next);
        } else {
            System.out.println();
        }
    }

    public static int get_list_len(Node n, int curr) {
        if (n == null) {
            return curr;
        }
        return get_list_len(n.next, curr + 1);
    }
}
