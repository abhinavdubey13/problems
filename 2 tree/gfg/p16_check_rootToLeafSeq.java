
// Given a binary tree and an array, the task is to find if the given array sequence is present as a root to leaf path in given tree.

/**
 * 
 * approach : recursively check if the index in the input parameter matches the rootNode 
 * 
 * TC - O(n)
 * SC - O(height) 
 * 
 */

class p16_check_rootToLeafSeq extends HELPER {

    public static void main(String[] args) {

        //true
        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(5);

        int[] seq = { 1, 2, 5 }; //true
        // int[] seq = { 1, 2, 7 }; //false

        int index_to_begin = 0;

        System.out.println(function(ROOT, seq, index_to_begin));

    }

    static boolean function(node n, int[] sequence, int index_to_check) {

        if ((n == null) || (index_to_check >= sequence.length)) {
            return false;
        }

        if (isLeaf(n) && index_to_check == sequence.length - 1) {
            return n.data == sequence[index_to_check];
        }

        //non-leaf node
        boolean left_has_seq = function(n.left, sequence, index_to_check + 1);
        boolean right_has_seq = function(n.right, sequence, index_to_check + 1);
        
        return (left_has_seq || right_has_seq);

    }

}