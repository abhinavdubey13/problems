import java.util.*;


 /**
 * 
 * leetcode id : https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
 * 
 * 
 * merge 2 BSTs such that output is in sorted order
 * 
 * 
 * space allowed = O(h1 + h2)
 * 
 * h1 : height of BST-1
 * h2 : height of BST-2
 * 
 * ==========
 * example :
 * ==========
 * 
 * i/p : 
 * o/p : 
 * 
 */


 /**
 * ============
 * approach : 
 * ============
 * 
 * https://afteracademy.com/blog/merge-two-bst
 * 
 * https://www.youtube.com/watch?v=g4DwrMNTdvw&ab_channel=KashishMehndiratta
 * 
 * iterative inorder traversal gives nodes in sorted order
 * 
 * 
 * 
 * =============
 * TC = O(n1+n2)
 * SC = O(h1+h2)
 * 
 * 
 */

public class p62_merge_2_bst extends HELPER {

    public static void main(String[] args) {
        // node root1 = null, root2 = null;
        // root1 = new node(3);
        // root1.left = new node(1);
        // root1.right = new node(5);

        // root2 = new node(4);
        // root2.left = new node(2);
        // root2.right = new node(6);

        node root1 = null, root2 = null;
        root1 = new node(10);
        root1.left = new node(5);
        root1.left.left = new node(3);
        root1.left.left.right = new node(4);

        root1.left.right = new node(9);
        root1.left.right.left = new node(7);

        root1.right = new node(12);
        root1.right.left = new node(11);
        root1.right.right = new node(14);

        root2 = new node(15);
        root2.left = new node(13);
        root2.left.left = new node(8);
        root2.right = new node(19);
        root2.right.left = new node(18);
        root2.right.left.left = new node(17);
        root2.right.right = new node(20);

        merge(root1, root2);
        System.out.println();
    }

    

    static void merge(node root1, node root2) {
        Stack<node> s1 = new Stack<>();
        Stack<node> s2 = new Stack<>();

        node current1 = root1;
        node current2 = root2;

        if (root1 == null) {
            HELPER.perform_inorder(root2);
            return;
        }

        if (root2 == null) {
            HELPER.perform_inorder(root1);
            return;
        }

        while (current1 != null || s1.size() > 0 || current2 != null || s2.size() > 0) {

            while (current1 != null) {
                s1.push(current1);
                current1 = current1.left;
            }

            while (current2 != null) {
                s2.push(current2);
                current2 = current2.left;
            }

            //the only condition when stack1 top will be printed
            if (s2.size() == 0 || (s1.size() > 0 && s1.peek().data <= s2.peek().data)) {

                node popped = s1.pop();
                System.out.print(popped.data + " ");
                current1 = popped.right;

            }

            //other-wise stack2's top will be printed
            else {
                node popped = s2.pop();
                System.out.print(popped.data + " ");
                current2 = popped.right;
            }

        }

    }

}
