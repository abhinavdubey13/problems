import java.util.*;

/**
 * leetcode id : 
 * 
 * reverse a linked list
 *
 * 
 * ========
 * example 
 * ========
 * original : 1-2-3-4-5
 * reversed : 5-4-3-2-1
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * iterative
 * 
 * 
 * ==============
 * TC = O(n)
 * SC = O(n)
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

class p2_reverse_LL {

    static Node HEAD;

    public static void main(String[] args) {
        //5 nodes
        // HEAD = new Node(1);
        // HEAD.next = new Node(2);
        // HEAD.next.next = new Node(3);
        // HEAD.next.next.next = new Node(4);
        // HEAD.next.next.next.next = new Node(5);

        //1 node
        HEAD = new Node(1);

        
       

        System.out.print("original list : ");
        print_list(HEAD);
        System.out.println();

        function();

        System.out.print("reversed list : ");
        print_list(HEAD);
        System.out.println();

    }

    static void function() {
        Node prev = null;
        Node nxt = null;
        Node cur = HEAD;

        while (cur != null) {
            nxt = cur.next; //hold the further list
            cur.next = prev; //reverse the pointer to prev node
            prev = cur; //re-assign
            cur = nxt; //re-assign
        }
        HEAD = prev;
    }

    static void print_list(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            print_list(n.next);
        }
    }

}
