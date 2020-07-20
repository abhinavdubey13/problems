import java.util.*;

/**
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
 * TC = O(n)   
 * SC = O(max-nodes-at-a-level)
 *
 */

class x5_sum_of_nodes_with_even_grand_parent extends HELPER {

    static int sum_of_grand_children(node grand_parent) {

        int sum = 0;

        if (grand_parent.left != null && grand_parent.left.left != null) {
            sum += grand_parent.left.left.data;
        }

        if (grand_parent.left != null && grand_parent.left.right != null) {
            sum += grand_parent.left.right.data;
        }

        if (grand_parent.right != null && grand_parent.right.left != null) {
            sum += grand_parent.right.left.data;
        }

        if (grand_parent.right != null && grand_parent.right.right != null) {
            sum += grand_parent.right.right.data;
        }

        return sum;
    }

    static int function(node root) {
        node temp = root;
        int return_val = 0;
        Stack<node> my_stack = new Stack<>();
        while (my_stack.size() > 0 || temp != null) {
            while (temp != null) {
                my_stack.push(temp);
                temp = temp.left;
            }
            node popped = my_stack.pop();
            //perform check here
            if (popped.data % 2 == 0) {
                return_val += sum_of_grand_children(popped);
            }
            temp = popped.right;
        }
        return return_val;
    }

    public static void main(String[] args) {

        node root;

        // tree-1 : expected = 18
        root = new node(6);
        root.left = new node(7);
        root.left.left = new node(2);
        root.left.left.left = new node(9);
        root.left.right = new node(7);
        root.left.right.left = new node(1);
        root.left.right.right = new node(4);

        root.right = new node(8);
        root.right.left = new node(1);
        root.right.right = new node(3);
        root.right.right.right = new node(5);

        int result = function(root);
        System.out.println(result);
    }

}