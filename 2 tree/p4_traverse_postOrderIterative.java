
import java.util.*;

/**
 * 
 * =================
 * using 2 stacks :
 * =================
 * 1. Push root to first stack.
 * 
 * 2. Loop while first stack is not empty
 *      2.1 Pop a node from first stack and push it to second stack
 *      2.2 Push left and right children of the popped node to first stack
 * 
 * 3. Print contents of second stack
 * 
 * 
 * 
 * 
 */

class p4_traverse_postOrderIterative extends HELPER {

    public static void main(String[] args) {
        node root;

        root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);

        Using_1_stack.function(root);
        System.out.println();

        Using_2_stack.function(root);
        System.out.println();
    }

}

class Using_2_stack {

    static void function(node root) {

        Stack<node> stk_1 = new Stack<>();
        Stack<node> stk_2 = new Stack<>();

        node curr = root;
        stk_1.push(curr);

        while (stk_1.size() > 0) {
            curr = stk_1.pop();

            if (curr.left != null) {
                stk_1.push(curr.left);
            }
            if (curr.right != null) {
                stk_1.push(curr.right);
            }

            stk_2.push(curr);
        }

        while (stk_2.size() > 0) {
            System.out.print(stk_2.pop().data + " ");
        }

    }

}

class Using_1_stack {

    static void function(node rootNode) {
        if (rootNode == null) {
            return;
        }

        node curr = rootNode;
        Stack<node> myStack = new Stack<node>();

        while (!myStack.isEmpty() || curr != null) {

            while (curr != null) {
                myStack.push(curr);
                curr = curr.left;
            }

            node temp = myStack.peek().right;

            // if RST of top node is not null , we explore the RST 
            if (temp != null) {
                curr = temp;
            }

            // if RST of top node is null , means we have to return to parent of top node
            // but here is a chance that we may get into infinite loop
            // so we pop untill top-most node is parent of poped node
            else {
                temp = myStack.pop();
                System.out.print(temp.data + " ");
                while (!myStack.isEmpty() && temp == myStack.peek().right) {
                    temp = myStack.pop();
                    System.out.print(temp.data + " ");
                }
            }

        }
    }

}