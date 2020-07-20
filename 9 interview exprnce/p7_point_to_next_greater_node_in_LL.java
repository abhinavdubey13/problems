import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/point-to-next-higher-value-node-in-a-linked-list-with-an-arbitrary-pointer/
 * 
 * 
 * Given singly linked list with every node having an additional “arbitrary” pointer that currently points to NULL. 
 * 
 * Need to make the “arbitrary” pointer point to the next higher value node.
 * 
 * 
 */

/**
 * 
 * 
 * An Efficient Solution works in O(nLogn) time. The idea is to use Merge Sort for linked list. 
 * 
 * 1) Traverse input list and copy next pointer to arbit pointer for every node. 
 * 
 * 2) Do Merge Sort for the linked list formed by arbit pointers.
 * 
 * 
 */

class Node {
    int data;
    Node next, arbit;

    Node(int data) {
        this.data = data;
        next = null;
        arbit = null;
    }
}

class p7_point_to_next_greater_node_in_LL {

    public static void main(String[] args) {

        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        head = Solution.function(head);
        Helper.traverse_list(head);

    }

}

class Solution {

    static Node function(Node head) {

        Node temp = head;
        while (temp != null) {
            temp.arbit = temp.next;
            temp = temp.next;
        }

        // Helper.traverse_list(head);
        return merge_sort(head);
    }

    static Node merge_sort(Node start) {
        if (start == null || start.arbit == null) {
            return start;
        }

        Node middle_node = get_mid_node(start);
        Node next_of_mid = middle_node.arbit;
        middle_node.arbit = null;

        Node head_left_sorted = merge_sort(start);
        Node head_right_sorted = merge_sort(next_of_mid);

        Node merged = merge_sorted(head_left_sorted, head_right_sorted);

        return merged;
    }

    static Node get_mid_node(Node start) {

        if (start == null || start.arbit == null || start.arbit.arbit == null) {
            return start;
        }

        Node fast = start;
        Node slow = start;
        Node prev_slow = null;

        while (fast != null && fast.arbit != null) {
            prev_slow = slow;
            fast = fast.arbit.arbit;
            slow = slow.arbit;
        }
        return prev_slow;

    }

    static Node merge_sorted(Node l_sorted, Node r_sorted) {

        if (l_sorted == null) {
            return r_sorted;
        }

        if (r_sorted == null) {
            return l_sorted;
        }

        Node head = null;

        if (l_sorted.data < r_sorted.data) {
            head = l_sorted;
            head.arbit = merge_sorted(l_sorted.arbit, r_sorted);

        } else {
            head = r_sorted;
            head.arbit = merge_sorted(l_sorted, r_sorted.arbit);
        }

        return head;

    }

}

class Helper {

    static void traverse_list(Node node) {

        Node temp = node;
        System.out.println("Traversal using Next Pointer");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        temp = node;
        System.out.println("\nTraversal using Arbit Pointer");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.arbit;
        }
        System.out.println();
    }

}