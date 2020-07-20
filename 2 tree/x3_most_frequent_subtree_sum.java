import java.util.*;

/**
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree sum. 
 * 
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). 
 * 
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * recursive
 * 
 * pass sum of tree rooted here
 *
 *
 * TC = O(n)   
 * SC = O(height)
 *
 */

class x3_most_frequent_subtree_sum extends HELPER {

    static int function(node root, Map<Integer, Integer> sum_map) {

        if (root == null) {
            return 0;
        }
        int left_sum = function(root.left, sum_map);
        int right_sum = function(root.right, sum_map);
        int sum_rooted_here = root.data + left_sum + right_sum;
        Integer sum_present = sum_map.get(sum_rooted_here);
        if (sum_present != null) {
            sum_map.put(sum_rooted_here, sum_present.intValue() + 1);
        } else {
            sum_map.put(sum_rooted_here, 1);
        }
        return sum_rooted_here;
    }

    static int[] function_util(node root) {
        Map<Integer, Integer> sum_map = new HashMap<>();
        function(root, sum_map);

        List<Integer> my_list = new LinkedList<>();
        int max_frquency_so_far = 0;
        for (Map.Entry<Integer, Integer> entry : sum_map.entrySet()) {
            if (entry.getValue().intValue() > max_frquency_so_far) {
                my_list.clear();
                max_frquency_so_far = entry.getValue();
                my_list.add(entry.getKey().intValue());
            } else if (entry.getValue().intValue() == max_frquency_so_far) {
                my_list.add(entry.getKey().intValue());
            }
        }
        return my_list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

        node root;

        // tree-1 : expected = [6]
        root = new node(3);
        root.left = new node(1);
        root.left.right = new node(2);
        root.left.left = new node(0);
        root.left.right.right = new node(3);

        root.right = new node(5);
        root.right.left = new node(4);
        root.right.right = new node(6);

        // tree-2 : expected=[2]
        root = new node(5);
        root.left = new node(2);
        root.right = new node(-5);

        // tree-3 : expected=[2,-3,4]
        root = new node(5);
        root.left = new node(2);
        root.right = new node(-3);

        int[] result = function_util(root);
        System.out.println(result);
    }

}