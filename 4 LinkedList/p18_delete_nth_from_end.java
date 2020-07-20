import java.util.*;

/**
 * leetcode id : 19
 * 
 * 
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Follow up: Could you do this in one pass? *
 * 
 * ========
 * example 
 * ========
 * N = 2
 * LinkedList: 1->2->3->4->5->6
 * Output: 1->2->3->4->6
 * 
 * 
 */

/**
 *  
 * 
 * 
 * 
 * ============
 * approach : 
 * ============
 *  
 * k'th from last = (n-k+1) from beginning
 * 
 * move fast and slow
 * 
 * slow should move (n-k+1)steps only
 * 
 * for this , we need to move fast k times first 
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

class p18_delete_nth_from_end {

    public static void main(String[] args) {

        Node head;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int k = 2;

        print_list(head);
        head = Solution.function(head, k);
        print_list(head);

    }

    static void print_list(Node curr) {
        if (curr != null) {
            System.out.print(curr.data + " ");
            print_list(curr.next);
        } else {
            System.out.println();
        }
    }

}

class Solution {

    static Node function(Node head, int n) {
        Node headNode = new Node(1);
        headNode.next = head;
        Node fast = headNode;
        Node slow = headNode;

        //move fast n times first
        //then move fast and slow together

        while (fast.next != null) {
            if (n <= 0) {
                slow = slow.next;
            } else {
                n--;
            }
            fast = fast.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return headNode.next;

    }

}