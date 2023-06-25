
/**
 * 
 * given a binary tree , print the boundary order of nodes in anti-clock-wise direction
 * 
 * start from ROOT
 * 
 */

/**
 * 
 * 
 * 1. print left bounday (top down)
 * 
 * 2. print leaves from L to R
 * 
 * 3. print Right boundary (bottom up) 
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(height)
 *
 */

class p34_traversal_boundary_Order_recursive extends HELPER {

    public static void main(String[] args) {

        //tree
        ROOT = new node(20);
        ROOT.left = new node(8);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(12);
        ROOT.left.right.left = new node(10);
        ROOT.left.right.right = new node(14);

        ROOT.right = new node(22);
        ROOT.right.right = new node(25);

        boundary_order_traversal(ROOT);
        System.out.println();

    }


    //driver method
    static void boundary_order_traversal(node root) {
        System.out.print(ROOT.data + " ");

        if (root.left != null) {
            print_left_boundary(root.left);
            printLeaves(root.left);
        }
        if (root.right != null) {
            printLeaves(root.right);
            print_right_boundary(root.right);
        }
    }

    //print when new node found
    static void print_left_boundary(node root) {
        if (root == null || isLeaf(root)) {
            return;
        }
        System.out.print(root.data + " ");
        print_left_boundary(root.left);
    }

    //print on back-tracking
    static void print_right_boundary(node root) {
        if (root == null || isLeaf(root)) {
            return;
        }
        print_right_boundary(root.right);
        System.out.println(root.data);
    }

}