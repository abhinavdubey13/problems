import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 * 
 * add 2 numbers represented in linked list
 * 
 * head of LL is least significant digit : LSB (which makes this problem easy)
 * 
 *
 * ========
 * example 
 * ========
 * 
 * List1: 5->6->3 // represents number 365 
 * List2: 8->4->2 // represents number 248 
 * Output: 
 * Resultant list: 3->1->6 // represents number 613 
 * Explanation: 365 + 248 = 613
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
 * 
 * using recursion
 * 
 * ============
 * TC = O(n1+n2)
 * SC = O(Max(n1,n2))
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

class p9_add_numbers_in_LL_1 {

    public static void main(String[] args) {

        Node h1;
        Node h2;

        // //expected : 316 which represents 613
        // h1 = new Node(5);
        // h1.next = new Node(6);
        // h1.next.next = new Node(3);
        // h2 = new Node(8);
        // h2.next = new Node(4);
        // h2.next.next = new Node(2);

        // //expected : 50056 which represents 65005
        // h1 = new Node(7);
        // h1.next = new Node(5);
        // h1.next.next = new Node(9);
        // h1.next.next.next = new Node(4);
        // h1.next.next.next.next = new Node(6);

        // h2 = new Node(8);
        // h2.next = new Node(4);

        //expected : 50056 which represents 65005
        h1 = new Node(9);
        h1.next = new Node(9);
        h1.next.next = new Node(9);
        h1.next.next.next = new Node(9);
        h1.next.next.next.next = new Node(9);
        h1.next.next.next.next.next = new Node(9);
        h1.next.next.next.next.next.next = new Node(9);

        h2 = new Node(9);
        h2.next = new Node(9);
        h2.next.next = new Node(9);
        h2.next.next.next = new Node(9);

        String answer = new Solution().function(h1, h2);
        System.out.println(answer);
    }

}

class Solution {

    int carry;
    StringBuffer sbr;

    String function(Node h1, Node h2) {

        if (h1 == null && h2 == null) {
            return "";
        }

        carry = 0;
        sbr = new StringBuffer();
        sbr.append("");

        fun(h1, h2);

        if (carry > 0) {
            sbr.append(carry);
        }
        return sbr.toString();
    }

    void fun(Node h1, Node h2) {

        if (h1 == null && h2 == null) {
            return;
        }

        int h1_num = (h1 == null) ? 0 : h1.data;
        int h2_num = (h2 == null) ? 0 : h2.data;

        int sum = h1_num + h2_num + carry;

        sbr.append(sum % 10);
        carry = sum / 10;

        if (h1 != null && h2 != null) {
            fun(h1.next, h2.next);
        }

        else if (h1 == null && h2 != null) {
            fun(h1, h2.next);
        }

        else if (h1 != null && h2 == null) {
            fun(h1.next, h2);
        }

    }

}