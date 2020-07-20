import java.util.*;

/**
 * leetcode id : 
 * 
 * given a linked list , check of it is a palindrome
 *
 * 
 * ========
 * example 
 * ========
 * i/p : 1-2-2-1
 * o/p : true
 * 
 * i/p : 1-1
 * o/p : true
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * using recursion 
 *  1. compare 1st and last , if equal check the sub-list except 1st and elase
 *  2. if unequal , return false
 * 
 * ==========
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * other approaches
 * ============
 * approach : 2
 * ============
 * using stack 
 *  1. iterate from 1st till last node and fill the stack
 *  2. again iterate from 1st nd compare with top of stack
 * 
 * ============
 * approach : 2
 * ============
 * reverse the 2nd half of the LL and compare with 1st half 
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

class p1_check_palindrome {

    static Node left = null;

    public static void main(String[] args) {
        Node head;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);

        left = head;
        boolean answer = function(head);
        System.out.println(answer);
    }

    static boolean function(Node right) {

        if (right == null) {
            return true;
        }

        boolean x = function(right.next);

        boolean y = x && (left.data == right.data);

        if (y) {
            left = left.next;
            return true;
        } else {
            return false;
        }

    }

}
