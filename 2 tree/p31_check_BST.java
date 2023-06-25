
/**
 * 
 * given a binary tree , check if it is a BST or not
 * 
 */

/**
 * 
 * BST property : 
 *  1. all nodes are uniques 
 *  2. every node in LST is smaller than ROOT 
 *  3. every node in RST is greater than ROOT
 * =================================
 * let total nodes in tree = n
 * 
 * TC = O(n)
 * SC = O(height)
 *
 */

class p31_check_BST extends HELPER {

    public static void main(String[] args) {

        // node ROOT = new node(3);
        // ROOT.left = new node(1);
        // ROOT.right = new node(5);
        // ROOT.right.left = new node(4);
        // ROOT.right.right = new node(6); //add this => BST
        // ROOT.right.right = new node(1); //add this => not a BST

        node ROOT = new node(Integer.MIN_VALUE);
        ROOT.right = new node(Integer.MAX_VALUE);

        System.out.println(Solution.function(ROOT));
    }

}

//using int_min and int_max (might give some wrng result if tree has min and max values)
class Solution {

    static boolean answer;

    static boolean function(node root) {
        answer = true;
        dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return answer;
    }

    static void dfs(node root, Integer MIN_ALLOWED, Integer MAX_ALLOWED) {

        if (root == null || answer == false) {
            return;
        }

        // root's value must be between min and max
        // when we goto LST : max-value-allwd changes to current root and min-value-allwd is same
        // when we goto RST : min-value-allwd changes to current root and maz-value-allwd is same
        if (MAX_ALLOWED >= root.data && root.data >= MIN_ALLOWED) {
            dfs(root.left, MIN_ALLOWED, root.data);
            dfs(root.right, root.data, MAX_ALLOWED);
        } else {
            answer = false;
        }

    }
}

//using inorder traversal ( always gives correct soln)
//basic idea is : inoder traversal is increasing : so curr must be greater than prev
class Solution_iterative_inorder {

    static boolean function(Node root) {
        Stack<Node> stk = new Stack<>();
        Node curr = root;
        Node prev = null;

        while (stk.size() > 0 || curr != null) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            if (prev != null && prev.data > curr.data) {
                return false;
            }

            prev = curr;
            curr = curr.right;
        }

        return true;

    }
}