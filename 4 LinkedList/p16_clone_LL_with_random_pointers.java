import java.util.*;

/**
 * leetcode id : 138
 * 
 * https://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/
 * 
 * 
 * ========
 * example 
 * ========
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
 * using hashmap
 * 
 * Map<node, node> 
 * key is original node , and value of deep-copy of this node
 *  
 * ==========
 * TC = O(n)
 * SC = O(n) 
 * 
 * 
 * 
 * 
 * ============
 * approach : 2
 * ============
 * 
 * https://www.youtube.com/watch?v=VNf6VynfpdM&ab_channel=takeUforward
 *  
 * ==========
 * TC = O(n)
 * SC = O(1) //deep copy is not considered extra space , bcz thats is to be returned
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
    int val;
    Node next;
    Node random;

    Node(int d) {
        val = d;
        next = null;
        random = null;
    }

    Node(Node n) {
        if (n != null) {
            val = n.val;
            next = n.next;
            random = n.random;
        }
    }
}

class p16_clone_LL_with_random_pointers {

    static Node left = null;

    public static void main(String[] args) {

        Node head;

        // //init next pointers
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);

        // //init random pointers
        // head.random = head.next.next;
        // head.next.random = head;
        // head.next.next.random = head.next.next.next.next;
        // head.next.next.next.random = head.next.next.next.next;
        // head.next.next.next.next.random = head.next;

        //init next pointers
        head = new Node(-1);
        head.next = new Node(0);

        //init random pointers
        head.random = head;
        head.next.random = head;

        Helper.print_list(head);
        Helper.print_random_pointers_only(head);

        Node cloned = function(head);

        Helper.print_list(cloned);
        Helper.print_random_pointers_only(cloned);

    }

    static Node function(Node head) {

        if (head == null) {
            return null;
        }

        //STEP 1 : insert cloned nodes in between the original nodes
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val); //multiplied by 10 to see the diff while printing
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        //STEP 2 : set random pointers of the cloned nodes
        curr = head;
        while (curr != null) {
            Node clone = curr.next;
            if (curr.random != null)
                clone.random = curr.random.next;
            else
                clone.random = null;

            curr = curr.next.next;
        }

        //STEP 3 : seggregate cloned and original lists
        Node cloned_head = head.next;
        Node cloned_itr = head.next;
        curr = head;
        while (curr != null) {
            curr.next = curr.next.next;
            if (cloned_itr.next == null) {
                break;
            }
            cloned_itr.next = cloned_itr.next.next;
            cloned_itr = cloned_itr.next;
            curr = curr.next;
        }

        // Helper.print_list(original_head);
        // Helper.print_list(cloned_head);

        return cloned_head;
    }
}

class Helper {
    static void print_list(Node n) {
        if (n != null) {
            System.out.print(n.val + " ");
            print_list(n.next);
        } else {
            System.out.println();
        }
    }

    static void print_random_pointers_only(Node n) {
        if (n != null) {
            System.out.print(n.random.val + " ");
            print_random_pointers_only(n.next);
        } else {
            System.out.println();
        }
    }
}
