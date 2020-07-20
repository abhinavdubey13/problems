
/**
 * given a perfect binary tree
 *      1. all leaf nodes at same level
 *      2. all non-leaf nodes have 2 children
 * 
 * print the middle level nodes of the tree , WITHOUT finding the height of the tree
 * 
 */

/**
 * 
 * approach : fast nd slow pointer technique
 * 
 * TC - O(n)
 * SC - O(height) 
 * 
 */

class p17_print_middleLevel extends HELPER {


    public static void main(String[] args) {

        //true
        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(5);
        ROOT.right.left = new node(6);
        ROOT.right.right = new node(7);

        function(ROOT, ROOT);
        System.out.println();

    }

    static void function(node slow , node fast) {

        if(slow == null || fast == null){
             return;
        }

        if(isLeaf(fast)){
            System.out.print(slow.data + " ");
            return;
        }


        function(slow.left, fast.left.left);
        function(slow.right, fast.right.right);
    }

    

}