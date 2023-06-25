import java.util.Stack;

/**
 * approach : 
 * 
 */

class p3_traverse_preOrderIterative extends HELPER {

    static void function(node rootNode) {
        if (rootNode == null) {
            return;
        }

        node pointer = rootNode;
        Stack<node> myStack = new Stack<node>();

        while (!myStack.isEmpty() || pointer != null) {
            while (pointer != null) {
                System.out.print(pointer.data + " ");
                myStack.push(pointer);
                pointer = pointer.left;
            }
            pointer = myStack.pop();
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
    }

}