import java.util.*;

/**
 * 
 * 
 * check if given array is pre-order traversal of a BST
 * 
 * 
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * example if arr[] = [8, 5, 3, 6, 10, 9, 15, 19]
 * 
 * We can see that the pre-order traversal order is reflected in this list
 * [root] + [left subtree] + [right subtree]
 * [8] + [5, 3, 6] + [10, 9, 15, 19]
 * 
 * This pattern recursively repeats in each of the subtrees.
 * 
 * use this fact to solve
 * 
 * 
 * https://medium.com/@PherricOxide/coding-question-could-a-given-array-of-integers-represent-a-pre-order-traversal-of-a-binary-6871eaa8d1e1
 * 
 * 
 * 
 * ========================
 * TC = O(n)   
 * SC = O(n)
 *
 */

class p52_check_if_given_sequence_is_preorder_of_BST {

    public static void main(String[] args) {

        int[] pre_order = { 8, 5, 3, 6, 10, 9, 15, 19 };

        // boolean result = is_pre_order_brute(pre_order, 0, pre_order.length);
        boolean result = is_pre_order_optimal(pre_order);

        if (result) {
            System.out.println("YES : it is pre-order of some BST");
        } else {
            System.out.println("NO : it is not pre-order of some BST");

        }

    }

    static boolean is_pre_order_brute(int[] pre_order, int start_idx, int end_idx) {

        //if ony 1 element in array
        if (end_idx - start_idx <= 1) {
            return true;
        }

        int key = pre_order[start_idx];

        // finding the IDX at which arr[IDX] > key
        // ie it is the beginning of RST  
        int i = start_idx;
        for (; i < end_idx; i++) {
            if (pre_order[i] > key) {
                break;
            }
        }

        // check if all elements beyond IDX are greate that root
        // if not then it is not BST pre-order
        for (int j = i; j < end_idx; j++) {
            if (pre_order[j] < key) {
                return false;
            }
        }

        // recursively check in remainder part of the array 
        boolean result_left = is_pre_order_brute(pre_order, start_idx + 1, i);
        boolean result_right = is_pre_order_brute(pre_order, i + 1, end_idx);
        return (result_left && result_right);
    }

    static boolean is_pre_order_optimal(int[] pre_order) {

        Stack<Integer> my_stack = new Stack<>();

        int min_allowed = Integer.MIN_VALUE + 1;

        for (int key : pre_order) {

            if (key < min_allowed) {
                return false;
            }

            // if key > top of stack => RST has started
            // pop from stack untill stack is empty or key > top
            while (my_stack.size() > 0 && key > my_stack.peek().intValue()) {
                min_allowed = my_stack.pop().intValue();
            }

            my_stack.push(key);

        }

        return true;

    }

}