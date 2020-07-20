/**
 * 
 * given a binary tree , print path from root to a given node 
 * 
 * 
 */

/**
 * 
 * approach is similar to all root to leaf paths question , using a global array , which stores 1 path at a time
 * 
 * when destination is encountered , just print all the elements in that array
 * 
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(height)
 * 
 * 
 * 
 */

class p25_print_rootToGivenNodePath extends HELPER {

    public static void main(String[] args) {
        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(5);

        ROOT.right.left = new node(6);
        ROOT.right.right = new node(7);

        node[] arr = new node[100];
        function(ROOT, arr, 0, ROOT.right);
    }

    static void function(node curr, node[] arr, int idx, node target) {

        if (curr == null) {
            return;
        }
        arr[idx] = curr;

        if (curr == target) {
            print_array(arr, idx);
            return;
        }

        function(curr.left, arr, idx + 1, target);
        function(curr.right, arr, idx + 1, target);

    }

    static void print_array(node[] arr, int end_idx) {
        for (int i = 0; i <= end_idx; i++) {
            System.out.print(arr[i].data + " ");
        }
        System.out.println();
    }

}