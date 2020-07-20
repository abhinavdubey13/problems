import java.util.*;

/**
 * leetcode id : 
 * 
 * find nth node from end in a given linked list 
 *
 * 
 * ========
 * example 
 * ========
 * N = 2
 * LinkedList: 1->2->3->4->5->6->7->8->9
 * Output: 8
 * 
 * Explanation: In the first example, there are 9 nodes in linked list and we need to find 2nd node from end. 2nd node from end is 8
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 *  
 * using head-first recursion , goto last node
 * 
 * start counting when returning back
 * 
 * ==============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * ============
 * approach : 2
 * ============
 *  
 * k'th from last = (n-k+1) from beginning
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

class p6_nth_node_from_end {

    public static void main(String[] args) {

        Node head;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int n = 2; //expected = 5
        // int n = 13; //expected = -1

        int nth_from_last = function_util(head, n);
        System.out.println(nth_from_last);
    }

    static int function_util(Node head, int n) {
        Nth_from_last.ith_from_last = 0; //initialize
        Nth_from_last.function(head, n);
        return Nth_from_last.answer;
    }

}

class Nth_from_last {

    static int ith_from_last = 0;
    static int answer = -1;

    static void function(Node curr, int n) {

        if (curr == null) {
            return;
        }

        function(curr.next, n);
        ith_from_last++; //begin counting on returning back

        if (ith_from_last == n) {
            answer = curr.data;
        }

    }

}