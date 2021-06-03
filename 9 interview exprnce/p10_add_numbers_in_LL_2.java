import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/sum-of-two-linked-lists/
 * 
 * add 2 numbers represented in linked list
 * 
 * head of LL is most significant digit : MSB (which makes this problem a bit tricky)
 * 
 *
 * ========
 * example 
 * ========
 * 
 * List1: 5->6->3 // represents number 563 
 * List2: 1->4->2 // represents number 142
 * Output: 
 * Explanation: 563 + 142 = 705
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
 * using 
 * 
 * 1.recursion+stack
 * 2. only recursion
 * using 2 stacks
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

class p10_add_numbers_in_LL_2 {

    public static void main(String[] args) {

        // System.out.println("using 1 stack and recursion");
        // Using_1_stack_and_recusion app1 = new Using_1_stack_and_recusion();
        // app1.driver();

        // System.out.println("using 2 stacks and recursion");
        // Iterative_uing_2_stack app2 = new Iterative_uing_2_stack();
        // app2.driver();

        System.out.println("using recursion only");
        Uing_recursion_only app3 = new Uing_recursion_only();
        app3.driver();

    }

}

class Using_1_stack_and_recusion {

    private String answer;

    void driver() {
        Node h1;
        Node h2;

        //expected : 563 + 842 = 1405
        // h1 = new Node(5);
        // h1.next = new Node(6);
        // h1.next.next = new Node(3);
        // h2 = new Node(8);
        // h2.next = new Node(4);
        // h2.next.next = new Node(2);

        // //expected : 1245 + 930 = 2175
        // h1 = new Node(1);
        // h1.next = new Node(2);
        // h1.next.next = new Node(4);
        // h1.next.next.next = new Node(5);
        // h2 = new Node(9);
        // h2.next = new Node(3);
        // h2.next.next = new Node(0);

        // expected : 999... + 1 = 1000...
        h1 = new Node(9);
        h1.next = new Node(9);
        h1.next.next = new Node(9);
        h1.next.next.next = new Node(9);
        h1.next.next.next = new Node(9);
        h2 = new Node(1);

        // Solution s = new Solution();
        String answer1 = function(h1, h2);
        String answer2 = function(h2, h1); //changing order of params
        System.out.println(answer1);
        System.out.println(answer2);

    }

    String function(Node h1, Node h2) {

        if (h1 == null && h2 == null) {
            return "";
        }

        answer = "";

        Stack<Integer> stk = new Stack<>();

        set_stack(h1, stk);

        int last_carry = add(h2, stk);

        if (stk.size() > 0) {
            while (stk.size() > 0) {
                int sum = last_carry + stk.pop();
                answer = (sum % 10) + answer;
                last_carry = sum / 10;
            }
        }

        if (last_carry > 0) {
            answer = last_carry + answer;
        }

        return answer;
    }

    void set_stack(Node h1, Stack<Integer> stk) {
        if (h1 != null) {
            stk.push(h1.data);
            set_stack(h1.next, stk);
        }
    }

    int add(Node h, Stack<Integer> stk) {

        int carry_rcvd = 0;

        if (h.next != null) {
            carry_rcvd = add(h.next, stk);
        }

        int sum = h.data + carry_rcvd;

        if (stk.size() > 0) {
            sum += stk.pop().intValue();
        }

        int carry_frwd = sum / 10;
        answer = (sum % 10) + answer;
        return carry_frwd;

    }

}

class Iterative_uing_2_stack {

    void driver() {

        Node h1;
        Node h2;

        //expected : 563 + 842 = 1405
        h1 = new Node(5);
        h1.next = new Node(6);
        h1.next.next = new Node(3);
        h2 = new Node(8);
        h2.next = new Node(4);
        h2.next.next = new Node(2);

        // //expected : 1245 + 930 = 2175
        // h1 = new Node(1);
        // h1.next = new Node(2);
        // h1.next.next = new Node(4);
        // h1.next.next.next = new Node(5);
        // h2 = new Node(9);
        // h2.next = new Node(3);
        // h2.next.next = new Node(0);

        // expected : 999... + 1 = 1000...
        // h1 = new Node(9);
        // h1.next = new Node(9);
        // h1.next.next = new Node(9);
        // h1.next.next.next = new Node(9);
        // h1.next.next.next = new Node(9);
        // h2 = new Node(1);

        Node answer = function(h1, h2);
        Node answer2 = function(h2, h1);

        Helper_method.print_list(answer);
        Helper_method.print_list(answer2);

    }

    Node function(Node h1, Node h2) {

        Stack<Integer> stk1 = new Stack<>();

        Stack<Integer> stk2 = new Stack<>();

        Node answer_list = null;

        set_stack(h1, stk1);
        set_stack(h2, stk2);

        int carry = 0;

        while (stk1.size() > 0 || stk2.size() > 0) {

            int num1 = (stk1.size() > 0) ? stk1.pop() : 0;
            int num2 = (stk2.size() > 0) ? stk2.pop() : 0;

            int sum = carry + num1 + num2;
            carry = sum / 10;

            Node temp = new Node(sum % 10);

            if (answer_list == null) {
                answer_list = temp;
            } else {
                temp.next = answer_list;
                answer_list = temp;
            }
        }

        if (carry > 0) {
            Node temp = new Node(carry);
            temp.next = answer_list;
            answer_list = temp;
        }

        return answer_list;
    }

    void set_stack(Node h1, Stack<Integer> stk) {
        if (h1 != null) {
            stk.push(h1.data);
            set_stack(h1.next, stk);
        }
    }

}

class Uing_recursion_only {

    Node answer_list;

    int global_carry;

    void driver() {

        Node h1;
        Node h2;

        //expected : 563 + 142 = 705
        // h1 = new Node(5);
        // h1.next = new Node(6);
        // h1.next.next = new Node(3);
        // h2 = new Node(1);
        // h2.next = new Node(4);
        // h2.next.next = new Node(2);

        //expected : 1245 + 930 = 2175
        h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(4);
        h1.next.next.next = new Node(5);
        h2 = new Node(9);
        h2.next = new Node(3);
        h2.next.next = new Node(0);

        // expected : 999... + 1 = 1000...
        // h1 = new Node(9);
        // h1.next = new Node(9);
        // h1.next.next = new Node(9);
        // h1.next.next.next = new Node(9);
        // h1.next.next.next = new Node(9);
        // h2 = new Node(1);

        Node answer = function(h1, h2);
        Node answer2 = function(h2, h1);

        Helper_method.print_list(answer);
        Helper_method.print_list(answer2);

    }

    Node function(Node h1, Node h2) {

        int len_1 = get_len(h1, 0);
        int len_2 = get_len(h2, 0);

        int diff = Math.abs(len_1 - len_2);
        Node temp = null;
        global_carry = 0;
        answer_list = null;

        if (len_1 > len_2) {
            temp = h1;
            int i = diff;
            while (i > 0) {
                temp = temp.next;
                i--;
            }
            global_carry = add_equal_size(temp, h2);

            if (global_carry > 0) {
                propagate_carry(h1, diff, 1);
                if (global_carry > 0) {
                    Node temp2 = new Node(global_carry);
                    temp2.next = answer_list;
                    answer_list = temp2;
                }
            }

        }

        else {
            temp = h2;
            int i = diff;
            while (i > 0) {
                temp = temp.next;
                i--;
            }
            global_carry = add_equal_size(h1, temp);
            if (global_carry > 0) {
                propagate_carry(h2, diff, 1);
                if (global_carry > 0) {
                    Node temp2 = new Node(global_carry);
                    temp2.next = answer_list;
                    answer_list = temp2;
                }
            }
        }

        return answer_list;
    }

    void propagate_carry(Node h, int num_steps, int curr_step) {
        if (num_steps != curr_step) {
            propagate_carry(h.next, num_steps, curr_step + 1);
        }
        int sum = h.data + global_carry;
        global_carry = sum / 10;
        Node temp = new Node(sum % 10);
        temp.next = answer_list;
        answer_list = temp;
    }

    int add_equal_size(Node h1, Node h2) {

        int carry_rcvd = 0;

        if (h1.next != null && h2.next != null) {
            carry_rcvd = add_equal_size(h1.next, h2.next);
        }

        int sum = h1.data + h2.data + carry_rcvd;
        int carry_frwd = sum / 10;

        Node temp = new Node(sum % 10);

        if (answer_list == null) {
            answer_list = temp;
        } else {
            temp.next = answer_list;
            answer_list = temp;
        }

        return carry_frwd;

    }

    int get_len(Node n, int len_till_now) {
        if (n == null) {
            return len_till_now;
        }
        return get_len(n.next, len_till_now + 1);
    }

}
