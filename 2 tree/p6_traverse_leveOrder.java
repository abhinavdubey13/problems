import java.util.*;

class p6_traverse_leveOrder extends HELPER {

    public static void main(String[] args) {

        ROOT = new node(10);

        ROOT.left = new node(9);
        ROOT.left.left = new node(11);
        ROOT.left.left.right = new node(15);

        ROOT.right = new node(-10);
        ROOT.right.left = new node(16);
        ROOT.right.right = new node(21);
        ROOT.right.left.left = new node(18);
        ROOT.right.right.right = new node(19);

        function(ROOT);
        System.out.println();
    }

    static void function(node rootNode) {

        node currentNode = null;
        Queue<node> myQueue = new LinkedList<>();

        myQueue.offer(rootNode);
        
        while (!myQueue.isEmpty()) {
            currentNode = myQueue.poll();
            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) {
                myQueue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                myQueue.offer(currentNode.right);
            }
        }

    }

}