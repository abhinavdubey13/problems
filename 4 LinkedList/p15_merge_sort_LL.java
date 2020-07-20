import java.util.*;

/**
 * leetcode id : 
 * 
 * Merge sort is often preferred for sorting a linked list. 
 * 
 * quicksort : perform poorly, 
 * 
 * heapsort : completely impossible
 * 
 * ========
 * example 
 * ========
 * i/p : 1 9 2 8 3 7
 * o/p : 1 2 3 7 8 9
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * * 
 * ============
 * TC = O(n.log n)
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

class p15_merge_sort_LL {

    static Node left = null;

    public static void main(String[] args) {

        Node head;
        head = new Node(1);
        head.next = new Node(9);
        head.next.next = new Node(2);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(7);

        Helper.print_list(head);
        head = merge_sort(head);
        Helper.print_list(head);
    }

    static Node merge_sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = Helper.get_middle(head);
        Node mid_next = mid.next;

        //end the first list by making the next of mid as null
        mid.next = null;

        Node list_1 = merge_sort(head);
        Node list_2 = merge_sort(mid_next);

        Node sorted_list = Helper.merge_sorted_lists(list_1, list_2);
        return sorted_list;

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

    static Node merge_sorted_lists(Node a, Node b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        Node result;

        if (a.data < b.data) {
            result = a;
            result.next = merge_sorted_lists(a.next, b);
        } else {
            result = b;
            result.next = merge_sorted_lists(a, b.next);
        }

        return result;
    }

    static Node get_middle(Node head) {
        Node slow_prev = null;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = null;

        //total nodes are even
        if (fast == null) {
            mid = slow_prev;
        } else if (fast.next == null) {
            mid = slow;
        }

        return mid;
    }
}
