import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. 
 * 
 * Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 
 * 
 * 
 * use no extra space
 *  
 * ========
 * example 
 * ========
 * 
 * Input:  1 -> 2 -> 3 -> 4
 * Output: 1 -> 4 -> 2 -> 3
 * 
 * Input:  1 -> 2 -> 3 -> 4 -> 5
 * Output: 1 -> 5 -> 2 -> 4 -> 3
 *  
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * 1) Find the middle point using slow and fat pointer
 * 2) Split the linked list into two halves using found middle point in step 1.
 * 3) Reverse the second half.
 * 4) Do alternate merge of first and second halves.
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 * ============
 * approach : 2
 * ============
 * 
 * similar to checking list is palindrome , 
 * 
 * append L and then R each time at the end of the list
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
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

class p13_rearrange_alternate_first_and_last {

    public static void main(String[] args) {

        // //expected : 1 6 2 5 3 4 
        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = new Node(6);

        //expected : 1 5 2 4 3
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Helper.print_list(head);
        // head = Solution_1.function(head);
        head = new Solution_2().function(head);

        Helper.print_list(head);
    }

}

class Solution_1 {

    static Node function(Node head) {

        if (head == null) {
            return null;
        }

        Node slow = head;
        Node slow_prev = null;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //total nodes are even
        //slow will be at start of 2nd half
        if (fast == null) {
            Node a = head;
            Node b = Helper.reverse_list(slow);
            slow_prev.next = null; //end the first half

            return Helper.merge_lists_alternate(a, b, 'a');
        }

        //total nodes are odd
        //slow will be exact mid point of list
        //2nd half will begin from slow.next
        if (fast != null && fast.next == null) {
            Node a = head;
            Node b = Helper.reverse_list(slow.next);
            slow.next = null; //end the first half

            return Helper.merge_lists_alternate(a, b, 'a');
        }

        return null;

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

    public static Node reverse_list(Node head) {
        Node cur = head;
        Node prv = null;
        Node nxt = null;

        while (cur != null) {
            nxt = cur.next;
            cur.next = prv;
            prv = cur;
            cur = nxt;
        }

        return prv;
    }

    public static Node merge_lists_alternate(Node a, Node b, char pick_from) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        Node result = null;
        if (pick_from == 'a') {
            result = a;
            result.next = merge_lists_alternate(a.next, b, 'b');
        } else if (pick_from == 'b') {
            result = b;
            result.next = merge_lists_alternate(a, b.next, 'a');
        }
        return result;
    }
}

class Solution_2 {

    Node answer_head;
    Node answer_end;
    Node LEFT;
    int TIMES;
    int LIST_LEN;

    Node function(Node head) {

        LEFT = head;

        answer_head = new Node(-100);
        answer_end = answer_head;

        set_length(head);

        fun(head);

        if (LIST_LEN % 2 == 1) {
            LEFT.next = null;
            answer_end.next = LEFT;
        }

        return answer_head.next;
    }

    void fun(Node right) {
        if (right.next != null) {
            fun(right.next);
        }

        Node temp = LEFT.next; //hold the next remaining list

        if (TIMES > 0) {

            //append L and R at the end of answer respectively
            LEFT.next = right;
            right.next = null;
            answer_end.next = LEFT;
            answer_end = right;
            TIMES--;

            //reassign for continuation
            LEFT = temp;
        }

    }

    void set_length(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        LIST_LEN = count;
        TIMES = count / 2;
    }
}