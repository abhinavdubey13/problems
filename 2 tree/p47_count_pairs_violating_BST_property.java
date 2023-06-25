import java.util.*;

/**
 * 
 * given a BST  
 * write a method which counts the number of pairs violating the BST property
 * 
 * https://www.geeksforgeeks.org/count-of-pairs-violating-bst-property/
 *  
 */

/**
 * 
 *
 * use in-order traversal to store node values in array , then check number of inversions 
 * =================================
 * let total nodes in trees = n
 * 
 * TC = O(n^2)   : bcz checking inversion by brute force here ... nlogn if we use merge sort to count inversions
 * SC = O(n)
 *
 */

class p47_count_pairs_violating_BST_property extends HELPER {

    public static void main(String[] args) {

        //left tree
        node ROOT = new node(50);
        ROOT.left = new node(30);
        ROOT.left.left = new node(20);
        ROOT.left.right = new node(25);

        ROOT.right = new node(60);
        ROOT.right.left = new node(10);
        ROOT.right.right = new node(40);

        List<Integer> my_list = new ArrayList<>();
        get_inorder(ROOT, my_list);
        System.out.println(get_inversions(my_list));

    }

    static void get_inorder(node root, List<Integer> my_list) {
        if (root != null) {
            get_inorder(root.left, my_list);
            my_list.add(root.data);
            get_inorder(root.right, my_list);
        }
    }

    static int get_inversions(List<Integer> my_list) {

        int inversion_count = 0;

        for (int i = 0; i < my_list.size() - 1; i++) {
            for (int j = i + 1; j < my_list.size(); j++) {
                if (my_list.get(i) > my_list.get(j)) {
                    inversion_count++;
                }
            }
        }

        return inversion_count;
    }

   

}