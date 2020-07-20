import java.util.*;

/**
 * leetcode id : 
 * 
 * 
 * Given a string that contains ternary expressions. 
 * The expressions may be nested.
 * You need to convert the given ternary expression to a binary Tree and return the root.
 *  
 * =========
 * example 
 * =========
 * i/p : a?b?c:d:e
 * o/p : 
 *                a
                /  \
              b    e
             /  \
            c    d
 *  
 * 
 * 
 * inorder = c b d a e
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *
 * using stack
 * 
 * use curr to iterate over the tree 
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class node {
    char data;
    node left, right;

    node(char d) {
        this.data = d;
        left = right = null;

    }
}

class p13_ternary_expression_to_binary_tree {

    public static void main(String[] args) {

        String input = "a?b:c?d?e:f:g?h:i?j:k"; //expected = b a e d f c h g j i k 
        // String input = "a?b?c:d:e"; //expected = c b d a e

        node root = function(input);

        inorder(root);
        System.out.println();
    }

    static node function(String s) {

        if (s.length() == 0)
            return null;

        char[] arr = s.toCharArray();

        Stack<node> stack = new Stack<>();
        node curr = new node(arr[0]); //used as iterator
        node root = curr;//final answer

        for (int i = 1; i < arr.length; i += 2) {

            //form new node before hand only
            node n = new node(arr[i + 1]);

            if (arr[i] == '?') {
                stack.push(curr);
                curr.left = n;
                curr = curr.left;
            } 
            
            else if (arr[i] == ':') {
                curr = stack.pop();
                curr.right = n;
                curr = curr.right;
            }
        }

        return root;
    }

    static void inorder(node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + " ");
            inorder(n.right);
        }
    }

}
