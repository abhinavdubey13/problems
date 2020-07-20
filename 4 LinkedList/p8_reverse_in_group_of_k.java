import java.util.*;

/**
 * leetcode id : 
 * 
 * reverse a linked list in groups of K
 * 
 * 
 * ========
 * example 
 * ========
 * 
 * Input: 1->2->3->4->5->6->7->8->NULL, K = 3
 * Output: 3->2->1->6->5->4->8->7->NULL
 * 
 * Input: 1->2->3->4->5->6->7->8->NULL, K = 5
 * Output: 5->4->3->2->1->8->7->6->NULL
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
 * concept similar to reversing the entire linked list
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

class p8_reverse_in_group_of_k {

    public static void main(String[] args) {

        Node head;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int k = 1;

        Helper_class.print_list(head);
        head = function_util(head, k);
        Helper_class.print_list(head);
    }

    static Node function_util(Node head, int k) {

        if (head == null) {
            return null;
        }

        Node prev = null;
        Node nxt = null;
        Node cur = head;

        int count = 0;

        while (count < k && cur != null) {
            nxt = cur.next; //hold the further list
            cur.next = prev; //reverse the pointer to prev node
            prev = cur; //re-assign
            cur = nxt; //re-assign

            count++;
        }

        //this is a minor difference

        // after the above loop ,
        // 1. prev will be our new head 
        // 2. head will be the last node
        // 3. nxt is now a pointer to (k+1)th node  

        //Recursively call for the list starting from nxt. 
        head.next = function_util(nxt, k);

        return prev;
    }

}

class Helper_class {

    static void print_list(Node head) {
        if (head != null) {
            System.out.print(head.data + " ");
            print_list(head.next);
        } else {
            System.out.println();
        }
    }

}