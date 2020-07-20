/**
 * 
 * given a binary tree , print all root to leaf paths 
 * 
 * one path per line
 * 
 */

/**
 * 
 * approach is using a global array , which stores 1 path at a time
 * 
 * when a leaf is encountered , just print all the elements in that array
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

class p24_print_nodeToLeafPaths extends HELPER {

    public static void main(String[] args) {

        node ROOT = new node(11);
        ROOT.left = new node(12);
        ROOT.right = new node(13);
        ROOT.left.left = new node(14);
        ROOT.left.right = new node(15);

        int[] arr = new int[10];
        fun(ROOT, 0, arr);

    }

    static void fun(node root, int idx, int[] arr) {

        if (root == null) {
            return;
        }

        arr[idx] = root.data;

        if (isLeaf(root)) {
            print_arr(arr, idx);
        }
        
        fun(root.left, idx + 1, arr);
        fun(root.right, idx + 1, arr);

    }

    static void print_arr(int[] arr, int end_idx) {
        for (int i = 0; i <= end_idx; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
