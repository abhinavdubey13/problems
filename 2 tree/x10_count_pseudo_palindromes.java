import java.util.*;

/**
 *
 * Given a binary tree where node values are digits from 1 to 9. 
 * 
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 * 
 * 
 * A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
 * 
 * 
 *
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
 * 
 * use the fact that in a palindrome , atmost 1 odd occurnace of a number can be there
 * 
 * 
 * ie all digits will occur even number of times , atmost 1 odd occurance is allwd
 * 
 * 3-3-3
 * 3-4-5-4-3
 *
 * TC = O(n)   
 * SC = O(ht)
 *
 */

class x10_count_pseudo_palindromes extends HELPER {

    static int RESULT;

    public static void main(String[] args) {

        node root;

        // //tree-1 , expected = 2
        root = new node(2);
        root.left = new node(3);
        root.left.right = new node(1);
        root.left.left = new node(3);

        root.right = new node(1);
        root.right.right = new node(1);

        RESULT = 0;
        int answer = function_util(root);
        System.out.println(answer);

    }

    static int function_util(node root) {
        List<Integer> my_list = new ArrayList<>();
        function(root, my_list, 0);
        return RESULT;
    }


    //using pre-order traversal approach
    static void function(node root, List<Integer> my_list, int curr_idx) {

        if (root == null) {
            return;
        }

        if (my_list.size() == curr_idx) {
            my_list.add(root.data);
        } else {
            my_list.set(curr_idx, root.data);
        }

        if (isLeaf(root)) {
            check_if_path_is_pseudo_palindrome(my_list, curr_idx);
        }

        function(root.left, my_list, curr_idx + 1);
        function(root.right, my_list, curr_idx + 1);

    }

    static void check_if_path_is_pseudo_palindrome(List<Integer> my_list, int end_idx) {
        Map<Integer, Integer> my_map = new HashMap<>();
        for (int i = 0; i <= end_idx; i++) {
            int key = my_list.get(i).intValue();
            Integer has = my_map.get(key);
            if (has == null) {
                my_map.put(key, 1);
            } else {
                my_map.put(key, 1 + has.intValue());
            }
        }

        int count_of_odd_frequencies = 0;
        for (Map.Entry<Integer, Integer> entry : my_map.entrySet()) {
            if (entry.getValue().intValue() % 2 == 1) {
                count_of_odd_frequencies++;
            }
        }

        if (count_of_odd_frequencies <= 1) {
            RESULT++;
        }

    }

}