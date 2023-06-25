import java.util.*;

/**
 * 
 * 
 * given root node of BST and a range [X,Y]
 * print all node such that : [ X<= node.data <= Y ]
 *   
 */

/**
 * 
 * ======================
 * approach : 1 (simple)
 * ======================
 * 
 * using simple recursive in-order traversal of a tree , and before Printing , check if data is in range
 * 
 * TC = O(n)   
 * SC = O(height)
 * 
 * 
 * 
 * =======================
 * approach : 2 (optimal)
 * =======================
 * 
 * use morris order traversal , create a link to return to a particular root-node
 * when-ever we goto LST of that root-node
 * 
 * TC = O(n)   
 * SC = O(1)
 *
 */

class p54_print_BST_keys_in_a_given_range extends HELPER {

    public static void main(String[] args) {

        node root = new node(10);
        root.left = new node(5);
        root.left.left = new node(-2);
        root.left.right = new node(6);
        root.left.left.right = new node(2);
        root.left.right.right = new node(8);
        root.left.left.right.left = new node(-1);

        root.right = new node(30);
        root.right.right = new node(40);

        //in-order = -2 , -1 , 2 , 5 , 6 , 8 , 10 , 30 , 40

        int X = 7;
        int Y = 15;

        morris_inorder(root, X, Y);
    }

    static void morris_inorder(node root, int X, int Y) {

        node pointer = root;
        List<node> in_order = new ArrayList<>();

        while (pointer != null) {

            if (pointer.left == null) {
                if (pointer.data >= X && pointer.data <= Y)
                    in_order.add(pointer);
                pointer = pointer.right;
            }

            else {
                node in_order_predecessor = get_in_order_predecessor(pointer);
                if (in_order_predecessor.right == null) {
                    in_order_predecessor.right = pointer;
                    pointer = pointer.left;
                } else {
                    in_order_predecessor.right = null;
                    if (pointer.data >= X && pointer.data <= Y)
                        in_order.add(pointer);
                    pointer = pointer.right;

                }
            }
        }

        for (node n : in_order) {
            System.out.print(n.data + "  ");
        }
        System.out.println();

    }

    static node get_in_order_predecessor(node n) {
        if (n != null) {

            node predecessor = n.left;
            while (predecessor.right != null && predecessor.right != n) {
                predecessor = predecessor.right;
            }

            return predecessor;
        }

        return null;
    }
}