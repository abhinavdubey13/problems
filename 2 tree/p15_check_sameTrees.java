
//Two trees are identical when they have same data and arrangement of data is also same. 

/**
 * 
 * approach : recursively check if 
 *  1. the data is same 
 *  2. LST of Left-tree == LST of right-tree
 *  3. RST of Left-tree == RST of right-tree
 * 
 * TC - O(n)
 * SC - O(height) 
 * 
 */

class p15_check_sameTrees extends HELPER {

    public static void main(String[] args) {

        //true
        node a = new node(1);
        a.left = new node(2);
        a.right = new node(3);
        a.left.left = new node(4);
        a.left.right = new node(5);

        node b = new node(1);
        b.left = new node(2);
        b.right = new node(3);
        b.left.left = new node(4);
        b.left.right = new node(5);

        System.out.println(function(a, b));
    }

    static boolean function(node leftRoot, node rightRoot) {

        if (leftRoot == null && rightRoot == null) {
            return true;
        }

        if (isLeaf(leftRoot) && isLeaf(rightRoot)) {
            return (leftRoot.data == rightRoot.data);
        }

        boolean check_1 = (leftRoot.data == rightRoot.data);
        boolean check_2 = function(leftRoot.left, rightRoot.left);
        boolean check_3 = function(leftRoot.right, rightRoot.right);

        return (check_1 && check_2 && check_3);
    }

}