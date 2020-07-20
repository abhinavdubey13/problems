import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a linked list, check if the linked list has loop or not. Below diagram shows a linked list with a loop. 
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
 * maitain a set of addresses of nodes , if while traversing the list , we get repeated address , it has a loop
 * if iterator becomes null , no loop found
 *  
 * ==============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * ============
 * approach : 2
 * ============
 * using 2 pointers , fast and slow (move by 1 and 2 steps)
 * 
 * if at any time , fast == slow : loop is there
 * else if any of them becomes null : no loop
 * 
 *  
 * ==============
 * TC = O(n)
 * SC = O(1)
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

class p3_detect_loop {

    public static void main(String[] args) {

        //has loop
        // Node head;
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = head.next;

        //no loop
        Node head;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        boolean answer = Hashing_approach.has_loop(head);
        boolean answer2 = Two_pointer_approach.has_loop(head);

        System.out.println(answer);
        System.out.println(answer2);

    }

    static void print_list(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            print_list(n.next);
        }
    }

}

class Hashing_approach {

    static boolean has_loop(Node head) {
        Set<Node> addresses = new HashSet<>();
        Node curr = head;

        while (curr != null) {
            if (addresses.contains(curr.next)) {
                return true;
            }
            addresses.add(curr);
            curr = curr.next;
        }

        return false;
    }

}

class Two_pointer_approach {

    static boolean has_loop(Node head) {

        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}