import java.util.*;

/**
 * 
 * 
 * Given two Binary Search Trees(BST), print the elements of both BSTs in sorted form. 
 * 
 * The expected time complexity is O(m+n) where 
 * 
 * m is the number of nodes in first tree and 
 * n is the number of nodes in second tree. 
 * 
 * Maximum allowed auxiliary space is O(height of the first tree + height of the second tree).
 * 
 * https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
 * 
 * 
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * 
 * STEP-1 : perform inorder traversal of both root.left (storing result in 2 seperate list) and print the lists
 * STEP-2 : clear the 2 lists and put root node of both trees in the list
 * STEP-3 : perform inorder traversal of both root.right print the lists
 * 
 * 
 * ========================
 * TC = O(m+n)   
 * SC = O( ht(n) + ht(m) )
 *
 */

class p50_merge_2_BST_with_constraints extends HELPER {


    public static void main(String[] args) {

        node root_1 = new node(3);
        root_1.left = new node(1);
        root_1.right = new node(5);

        node root_2 = new node(4);
        root_2.left = new node(2);
        root_2.right = new node(6);

        merge_bst(root_1, root_2);
    }

    static void merge_bst(node root_1, node root_2) {

        List<node> list_1 = new ArrayList<>();
        List<node> list_2 = new ArrayList<>();

        get_inorder(root_1.left, list_1);
        get_inorder(root_2.left, list_2);

        print_sorted_lists(list_1, list_2);

        list_1.clear();
        list_2.clear();

        list_1.add(root_1);
        list_2.add(root_2);

        get_inorder(root_1.right, list_1);
        get_inorder(root_2.right, list_2);

        print_sorted_lists(list_1, list_2);
        System.out.println();
    }

   

    static void get_inorder(node current, List<node> my_list) {
        if (current != null) {
            get_inorder(current.left, my_list);
            my_list.add(current);
            get_inorder(current.right, my_list);
        }
    }

    //prints 2 sorted list in combined-sorted order
    static void print_sorted_lists(List<node> list_1, List<node> list_2) {
        int size_1 = list_1.size();
        int size_2 = list_2.size();

        int i = 0;
        int j = 0;

        while (i != size_1 && j != size_2) {
            if (list_1.get(i).data < list_2.get(j).data) {
                System.out.print(list_1.get(i).data + " ");
                i++;
            } else {
                System.out.print(list_2.get(j).data + " ");
                j++;
            }
        }

        if (i != size_1) {
            while (i != size_1) {
                System.out.print(list_1.get(i).data + " ");
                i++;
            }
        }

        if (j != size_2) {
            while (j != size_2) {
                System.out.print(list_2.get(j).data + " ");
                j++;
            }
        }
    }

 

}