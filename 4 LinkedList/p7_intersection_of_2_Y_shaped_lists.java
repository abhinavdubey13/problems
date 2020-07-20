import java.util.*;

/**
 * leetcode id : 
 * 
 * There are two singly linked lists in a system. 
 * 
 * By some programming error, the end node of one of the linked list got linked to the second list, forming an inverted Y shaped list. 
 * 
 * Write a program to get the point where two linked list merge. 
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
 * Get count of the nodes in the first list, let count be c1.
 * 
 * Get count of the nodes in the second list, let count be c2.
 * 
 * Get the difference of counts d = abs(c1 – c2)
 * 
 * Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes 
 * 
 * Then we can traverse both the lists in parallel till we come across a common node. 
 * 
 * (Note that getting a common node is done by comparing the address of the nodes)
 * 
 * ==============
 * TC = O(n+m)
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

class p7_intersection_of_2_Y_shaped_lists {

    public static void main(String[] args) {

        Node head_1;
        head_1 = new Node(1);
        head_1.next = new Node(2);
        head_1.next.next = new Node(3);
        head_1.next.next.next = new Node(4);
        head_1.next.next.next.next = new Node(5);
        head_1.next.next.next.next.next = new Node(6);

        Node head_2;
        head_2 = new Node(11);
        head_2.next = head_1.next.next.next;

        //expected = 4
        int intersection = function_util(head_1, head_2);
        System.out.println(intersection);
    }

    static int function_util(Node head_1, Node head_2) {

        int len_1 = Helper.get_list_len(head_1, 0);
        int len_2 = Helper.get_list_len(head_2, 0);

        Node temp_1 = head_1;
        Node temp_2 = head_2;

        if (len_1 < len_2) {
            for (int i = 0; i < Math.abs(len_1 - len_2); i++) {
                temp_2 = temp_2.next;
            }
        }

        if (len_1 > len_2) {
            for (int i = 0; i < Math.abs(len_1 - len_2); i++) {
                temp_1 = temp_1.next;
            }
        }

        while (temp_1 != null && temp_2 != null) {
            if (temp_1 == temp_2) {
                return temp_1.data;
            }
            temp_1 = temp_1.next;
            temp_2 = temp_2.next;
        }

        return -1;

    }

}

class Helper {

    static int get_list_len(Node n, int curr_len) {
        if (n == null) {
            return curr_len;
        }
        return get_list_len(n.next, curr_len + 1);
    }

}