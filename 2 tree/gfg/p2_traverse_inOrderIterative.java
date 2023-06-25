
import java.util.*;

/**
 * approach : use STACK
 * 
 * the approach is executing the recursive program using our own stack
 * 
 */

class p2_traverse_inOrderIterative extends HELPER {

    static void function(node rootNode) {
        if (rootNode == null) {
            return;
        }

        node pointer = rootNode;
        Stack<node> myStack = new Stack<node>();

        while (!myStack.isEmpty() || pointer != null) {

            while (pointer != null) {
                myStack.push(pointer);
                pointer = pointer.left;
            }
            pointer = myStack.pop();
            System.out.print(pointer.data + " ");
            pointer = pointer.right;
        }
    }

    public static void main(String[] args) {
        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(5);
        ROOT.left.left.right = new node(6);

        function(ROOT);

        // System.out.println();
        // fun(ROOT);

    }

}