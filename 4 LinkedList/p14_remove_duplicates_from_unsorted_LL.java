import java.util.*;

/**
 * leetcode id : 
 * 
 * Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. 
 * 
 * The input list is not sorted. 
 *  
 * ========
 * example 
 * ========
 * i/p : 8-2-8-2
 * o/p : 8-2
 * 
 * i/p : 8-1-8-2-4-3-2
 * o/p : 8-1-2-4-3
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * using hashset and recursion
 * 
 * for each recursive call , maintiain prev and curr pointers , and also the hash set
 * ==========
 * TC = O(n)
 * SC = O(n)
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

class p14_remove_duplicates_from_unsorted_LL {

    static Node left = null;

    public static void main(String[] args) {

        // Node head;
        // head = new Node(8);
        // head.next = new Node(1);
        // head.next.next = new Node(8);
        // head.next.next.next = new Node(2);
        // head.next.next.next.next = new Node(4);
        // head.next.next.next.next.next = new Node(3);
        // head.next.next.next.next.next.next = new Node(2);

        // Node head;
        // head = new Node(8);
        // head.next = new Node(8);
        // head.next.next = new Node(8);
        // head.next.next.next = new Node(8);

        Node head;
        head = new Node(8);
        head.next = new Node(8);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);

        Helper.print_list(head);
        head = function_util(head);
        Helper.print_list(head);
    }

    static Node function_util(Node head) {

        //if list has atmost 1 node
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> elements = new HashSet<>();
        elements.add(head.data);
        function(head, head.next, elements);
        return head;
    }

    //consider that uptill previous , we have all unique elements
    static void function(Node prev, Node curr, Set<Integer> elements) {

        if (curr == null) {
            return;
        }

        boolean is_duplicate = elements.contains(curr.data);

        //if we found a duplicate , prev will remain same for next recursive call
        //prev's next will be changed 
        if (is_duplicate) {
            prev.next = curr.next;
            function(prev, curr.next, elements);
        }

        //if curr is also uniq , add it to set
        //move prev and cur forward by 1 
        else {
            elements.add(curr.data);
            function(curr, curr.next, elements);
        }

    }
}

class Helper_method {
    static void print_list(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            print_list(n.next);
        } else {
            System.out.println();
        }
    }
}
