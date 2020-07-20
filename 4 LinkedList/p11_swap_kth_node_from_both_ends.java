import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a singly linked list, swap kth node from beginning with kth node from end. Swapping of data is not allowed, only pointers should be changed
 * ========
 * example 
 * ========
 * Input: 1 -> 2 -> 3 -> 4 -> 5, K = 2
 * Output: 1 -> 4 -> 3 -> 2 -> 5 
 * Explanation: The 2nd node from 1st is 2 and 
 * 2nd node from last is 4, so swap them
 * 
 * Input: 1 -> 2 -> 3 -> 4 -> 5, K = 5
 * Output: 5 -> 2 -> 3 -> 4 -> 1 
 * Explanation: The 5th node from 1st is 5 and 
 * 5th node from last is 1, so swap them.
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * Approach: The idea is very simple 
 * 1. find the k th node from the start and 
 * 2. the kth node from last is (n-k+1)'th node from start. Swap both the nodes.
 * However there are some corner cases, which must be handled
 * 
 * 
 * 1. X and Y are same
 * 2. X and Y don’t exist (k is more than number of nodes in linked list)
 * ==========
 * TC = O(n)
 * SC = O(n)
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

class p11_swap_kth_node_from_both_ends {

    static Node STATIC_HEAD;

    public static void main(String[] args) {

        STATIC_HEAD = new Node(1);
        STATIC_HEAD.next = new Node(2);
        STATIC_HEAD.next.next = new Node(3);
        STATIC_HEAD.next.next.next = new Node(4);
        STATIC_HEAD.next.next.next.next = new Node(5);
        STATIC_HEAD.next.next.next.next.next = new Node(6);

        int k = 6;

        Helper_class.print_list(STATIC_HEAD);
        function(k);
        Helper.print_list(STATIC_HEAD);
    }

    static void function(int k) {

        int len = Helper.get_list_len(STATIC_HEAD);

        //if k is more than number of nodes
        if (k > len) {
            return;
        }

        //if k'th node from start and end are same
        if (2 * k - 1 == len) {
            return;
        }

        Node kth_start = STATIC_HEAD;
        Node kth_start_prev = null;

        Node kth_end = STATIC_HEAD;
        Node kth_end_prev = null;

        // Find the kth node from beginning of linked list. 
        // We also find previous of kth node because we need to update next pointer of the previous. 
        for (int i = 1; i < k; i++) {
            kth_start_prev = kth_start;
            kth_start = kth_start.next;
        }

        // Similarly, find the kth node from end and its previous. kth node from end is (n-k+1)th node from beginning 
        for (int i = 1; i < len - k + 1; i++) {
            kth_end_prev = kth_end;
            kth_end = kth_end.next;
        }

        if (kth_start_prev != null) {
            kth_start_prev.next = kth_end;
        }

        if (kth_end_prev != null) {
            kth_end_prev.next = kth_start;
        }

        //swap
        Node temp = kth_start.next;
        kth_start.next = kth_end.next;
        kth_end.next = temp;

        if (k == 1) {
            STATIC_HEAD = kth_end;
        }

        if (k == len) {
            STATIC_HEAD = kth_start;
        }

    }
}

class Helper {

    public static void print_list(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            print_list(n.next);
        } else {
            System.out.println();
        }
    }

    public static int get_list_len(Node n) {
        if (n == null) {
            return 0;
        }
        return 1 + get_list_len(n.next);
    }
}
