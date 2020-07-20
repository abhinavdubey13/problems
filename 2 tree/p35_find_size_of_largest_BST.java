
/**
 * 
 * given a binary tree , find size of largest BST in it
 * 
 * if no BST is there , then print 1 , bcz leaf node is always BST
 * 
 */

/**
 * 
 * 
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(height)
 *
 */

class Detail {
    int size;
    boolean isBST;
    int max_so_far;
    int min_so_far;
}

class p35_find_size_of_largest_BST extends HELPER {

    public static void main(String[] args) {

        //tree
        ROOT = new node(50);

        ROOT.left = new node(30);
        ROOT.left.left = new node(5);
        ROOT.left.right = new node(10);

        ROOT.right = new node(60);
        ROOT.right.left = new node(45);
        ROOT.right.right = new node(70);
        ROOT.right.right.right = new node(80);
        ROOT.right.right.left = new node(65);

        //tree
        // ROOT = new node(5);
        // ROOT.left = new node(2);
        // ROOT.right = new node(4);
        // ROOT.left.left = new node(1);
        // ROOT.left.right = new node(3);

        //approach
        Detail detail = function(ROOT);
        System.out.println("size of largest BST is : " + detail.size);

        // System.out.println(detail.isBST);
        // System.out.println(detail.min_so_far + " " + detail.max_so_far);
    }

    static Detail function(node root) {

        Detail newDetail = new Detail();

        if (root == null) {
            newDetail.isBST = true;
            newDetail.size = 0;
            newDetail.min_so_far = 0;
            newDetail.max_so_far = 0;
            return newDetail;
        }

        if (isLeaf(root)) {
            newDetail.isBST = true;
            newDetail.size = 1;
            newDetail.max_so_far = root.data;
            newDetail.min_so_far = root.data;
            return newDetail;
        }

        Detail left_detail = function(root.left);
        Detail right_detail = function(root.right);

        boolean bstProperty = (root.data > left_detail.max_so_far && root.data < right_detail.min_so_far) ? true
                : false;

        if (left_detail.isBST && right_detail.isBST && bstProperty) {
            newDetail.isBST = true;
            newDetail.size = 1 + left_detail.size + right_detail.size;

        } else {
            newDetail.isBST = false;
            newDetail.size = Math.max(left_detail.size, right_detail.size);

        }

        newDetail.max_so_far = Math.max(root.data, Math.max(Math.max(left_detail.min_so_far, left_detail.max_so_far),
                Math.max(right_detail.min_so_far, right_detail.max_so_far)));

        newDetail.min_so_far = Math.min(root.data, Math.min(Math.min(left_detail.min_so_far, left_detail.max_so_far),
                Math.min(right_detail.min_so_far, right_detail.max_so_far)));

        return newDetail;

    }

}