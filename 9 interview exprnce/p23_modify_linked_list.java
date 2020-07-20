import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/modify-contents-of-linked-list-recursive-approach/
 * 
 * 
 * Given a singly linked list containing n nodes. 
 * Modify the value of first half nodes such that 1st node’s new value is equal to the last node’s value minus first node’s current value, 
 * 
 * 2nd node’s new value is equal to the second last node’s value minus 2nd node’s current value, 
 * 
 * likewise for first half nodes. 
 * 
 * If n is odd then the value of the middle node remains unchanged. 
 * 
 * 
 * 
 * 
 * Input: 10 -> 4 -> 5 -> 3 -> 6
 * Output: -4 -> -1 -> 5 -> 3 -> 6
 * 
 * Input: 2 -> 9 -> 8 -> 12 -> 7 -> 10
 * Output: 8 -> -2 -> 4 -> 12 -> 7 -> 10 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * 
 * 
 * using similar approach to check list is palindrome
 * 
 * 
 * ============
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

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class p23_modify_linked_list {

    public static void main(String[] args) {

        Node head = null;

        // head = new Node(10);
        // head.next = new Node(5);
        // head.next.next = new Node(2);

        // //expected : -4  -1  5  3  6 
        // head = new Node(10);
        // head.next = new Node(4);
        // head.next.next = new Node(5);
        // head.next.next.next= new Node(3);
        // head.next.next.next.next = new Node(6);

        //expected : 8  -2   4   12   7   10
        head = new Node(2);
        head.next = new Node(9);
        head.next.next = new Node(8);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.next = new Node(10);

        Helper.print_list(head);
        Node ans = new Solution().function(head);
        Helper.print_list(ans);
    }

}

class Solution {

    Node left;
    int list_len;

    Node function(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        left = head;
        list_len = 0;

        set_len(head);
        list_len = list_len / 2;

        fun(head);
        return head;
    }

    void fun(Node right) {

        if (right.next != null) {
            fun(right.next);
        }

        if (list_len != 0 && left != right) {
            left.data = (right.data - left.data);
            left = left.next;
            list_len--;
        }

    }

    void set_len(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        list_len = count;
    }

}

class Helper {
    static void print_list(Node head) {
        if (head != null) {
            System.out.print(head.data + " ");
            print_list(head.next);
        } else {
            System.out.println();
        }
    }
}