import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a linked list, check if the linked list has loop or not. 
 * 
 * also if loop exist , remove the loop 
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
 * maitain a set of addresses of nodes , if while traversing the list , we get repeated address , it has a loop => make the next as null and return
 * if iterator becomes null , no loop found
 *  
 * ==============
 * TC = O(n)
 * SC = O(n)
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

class p4_remove_loop {

    public static void main(String[] args) {

        //has loop
        Node head;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;

        //no loop
        // Node head;
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);

        boolean answer = has_loop(head);

        System.out.println(answer);

        print_list(head);
        System.out.println();

    }

    static boolean has_loop(Node head) {
        Set<Node> addresses = new HashSet<>();
        Node curr = head;

        while (curr != null) {
            if (addresses.contains(curr.next)) {
                curr.next = null; //removes loop
                return true;
            }
            addresses.add(curr);
            curr = curr.next;
        }

        return false;
    }

    static void print_list(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            print_list(n.next);
        }
    }

}
