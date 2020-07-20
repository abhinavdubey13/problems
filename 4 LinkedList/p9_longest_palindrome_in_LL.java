import java.util.*;

/**
 * leetcode id : 
 * 
 * Given a linked list, the task is to find the length of the longest palindrome list in it
 * ========
 * example 
 * ========
 *  
 * i/p : 2-3-7-3-2-12-24
 * o/p : 5 (2-3-7-3-2)
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 * based on the reversing of linked list
 * 
 * continue reversing the entire list normally , in between , check for the longest palindromes
 * using reversed and un-reversed linked list
 * 
 * 
 * ==========
 * TC = O(n^2)
 * SC = O(1)
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

class p9_longest_palindrome_in_LL {

    static Node left = null;

    public static void main(String[] args) {

        Node head;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);

        int answer = function(head);
        System.out.println(answer);
    }

    static int function(Node head) {

        Node prv = null;
        Node nxt = null;
        Node cur = head;
        int answer = 0;

        while (cur != null) {

            nxt = cur.next;
            cur.next = prv;

            //odd length palindromes : centered at CUR
            int len_1 = find_common_len(prv, nxt);
            answer = Math.max(answer, 2 * len_1 + 1);

            //even length palindromes : begining of 1st list from CUR
            int len_2 = find_common_len(cur, nxt);
            answer = Math.max(answer, 2 * len_2);

            prv = cur;
            cur = nxt;

        }

        return answer;
    }

    static int find_common_len(Node a, Node b) {

        int count = 0;

        while (a != null && b != null) {
            if (a.data != b.data) {
                break;
            }
            count++;
            a = a.next;
            b = b.next;
        }

        return count;
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
