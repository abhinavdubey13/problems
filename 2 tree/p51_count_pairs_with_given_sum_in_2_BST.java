import java.util.*;

/**
 * 
 * 
 * Given two Binary Search Trees(BST), find the number of pairs (such that the 2 elements forming the pair are from diffrent BSTs)
 * 
 * whose sum is equal to a given value X 
 * 
 *   
 */

/**
 * 
 * =============
 * approach : 1
 * =============
 * using in-order traversal , form 2 lists , then use 2 pointer techniq
 * 
 *
 * ===============
 * TC = O(m+n)   
 * SC = O(m+n)
 * 
 * 
 * 
 * =============
 * approach : 2
 * =============
 * using hash-map , store the values in hashmap , while traversing smaller sized BST
 * travere the 2nd BST and use the map to check if pair exist
 * 
 *
 * ===============
 * TC = O(m+n)   
 * SC = O(MIN(m,n))
 *
 */

class p51_count_pairs_with_given_sum_in_2_BST extends HELPER {

    public static void main(String[] args) {

        node root_1 = new node(5);
        root_1.left = new node(3);
        root_1.left.left = new node(2);
        root_1.left.right = new node(4);
        root_1.right = new node(7);
        root_1.right.left = new node(6);
        root_1.right.right = new node(8);

        node root_2 = new node(10);
        root_2.left = new node(6);
        root_2.left.left = new node(3);
        root_2.left.right = new node(8);
        root_2.right = new node(15);
        root_2.right.left = new node(11);
        root_2.right.right = new node(18);

        int SUM = 16;

        count_pairs(root_1, root_2, SUM);

    }

    static void modified_inorder(node current, List<Integer> my_list) {
        if (current != null) {
            modified_inorder(current.left, my_list);
            my_list.add(current.data);
            modified_inorder(current.right, my_list);
        }
    }

    static void count_pairs(node root_1, node root_2, int SUM) {

        List<Integer> list_1 = new ArrayList<>();
        List<Integer> list_2 = new ArrayList<>();
        modified_inorder(root_1, list_1);
        modified_inorder(root_2, list_2);

        int num_of_pairs = 0;

        int i = 0;
        int j = list_2.size() - 1;

        while (i < list_1.size() && j >= 0) {

            int found = list_1.get(i) + list_2.get(j);

            if (found == SUM) {
                num_of_pairs++;
                i++;
                j--;
            } else if (found < SUM) {
                i++;
            } else {
                j--;
            }

        }

        System.out.println("pairs found : " + num_of_pairs);
    }

}