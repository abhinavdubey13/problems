import java.util.*;

/**
 * leetcode id : 
 * 
 * Given two linked lists sorted in increasing order. Merge them such a way that the result list is in decreasing order (reverse order).
 * 
 * can u do this without reversing the given lists or the final list ??
 * 
 * ========
 * example 
 * ========
 * 
 * 
 * Input:  
 * a: 5->10->15->40
 * b: 2->3->20
 * Output: res: 40->20->15->10->5->3->2
 * 
 * 
 * Input:  
 * a: NULL
 * b: 2->3->20 
 * Output: res: 20->3->2
 *  
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * A Simple Solution is to do following.
 * 1) Reverse first list ‘a’.
 * 2) Reverse second list ‘b’.
 * 3) Merge two reversed lists.
 * 
 * Another Simple Solution is first Merge both lists, then reverse the merged list.
 * ==========
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 * ==========================
 * approach-2 (implemented)
 * ==========================
 * 1) Initialize result list as empty: res = NULL.
 * 2) Let 'a' and 'b' be heads first and second lists respectively.
 * 
 * 3) While (a != NULL and b != NULL)
 *  a) Find the smaller of two (Current 'a' and 'b')
 *  b) Insert the smaller value node at the front of result. (INSERTING AT THE FRONT ALWAYS IS THE KEY HERE)
 *  c) Move ahead in the list of smaller node. 
 * 
 * 4) If 'b' becomes NULL before 'a', insert all nodes of 'a' 
 * into result list at the beginning.
 * 
 * 5) If 'a' becomes NULL before 'b', insert all nodes of 'a' into result list at the beginning.
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

class p17_merge_2_sorted_in_reverse_order {

    static Node MERGED_TILL_NOW = null;

    public static void main(String[] args) {

        Node a;
        a = new Node(5);
        a.next = new Node(10);
        a.next.next = new Node(15);
        a.next.next.next = new Node(40);

        Node b;
        b = new Node(2);
        b.next = new Node(3);
        b.next.next = new Node(20);

        function(a, b);
        Helper.print_list(MERGED_TILL_NOW);
    }

    static void function(Node a, Node b) {

        if (a == null) {
            b.next = MERGED_TILL_NOW;
            MERGED_TILL_NOW = b;
            return;
        }

        if (b == null) {
            a.next = MERGED_TILL_NOW;
            MERGED_TILL_NOW = a;
            return;
        }

        Node temp;
        if (a.data < b.data) {
            temp = a;
            a = a.next;
            temp.next = MERGED_TILL_NOW;
            MERGED_TILL_NOW = temp;
            // Helper.print_list(MERGED_TILL_NOW);
            function(a, b);
        } else {
            temp = b;
            b = b.next;
            temp.next = MERGED_TILL_NOW;
            MERGED_TILL_NOW = temp;
            // Helper.print_list(MERGED_TILL_NOW);
            function(a, b);
        }

    }
}

class Helper {
    static void print_list(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            print_list(n.next);
        } else {
            System.out.println();
        }
    }
}
