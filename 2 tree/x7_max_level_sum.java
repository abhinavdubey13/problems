import java.util.*;

/**
 * 
 * Given the root of a binary tree, 
 * 
 * the level of its root is 1, 
 * the level of its children is 2, and so on.
 * 
 * 
 * 
 * Return the level whose sum is maximum
 * 
 * 
 * NOTE : if sum of 2 level is same (and maximum) return the smaller of those levels 
 * 
 *   
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * using hashmap
 * 
 *
 * TC = O(n)   
 * SC = O(ht + number of levels)
 *
 */

class x7_max_level_sum extends HELPER {

    public static void main(String[] args) {

        node root;

        //tree-1 : expected = 2
        root = new node(1);
        root.left = new node(7);
        root.left.left = new node(7);
        root.left.right = new node(-8);
        root.right = new node(0);

        int x = function_util(root);
        System.out.println(x);
    }

    static int function_util(node root) {

        Map<Integer, Integer> my_map = new HashMap<>();
        function(root, 1, my_map);

        List<Integer> answer_levels = new ArrayList<>();
        int max_sum_of_level = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : my_map.entrySet()) {
            if (entry.getValue().intValue() > max_sum_of_level) {
                answer_levels.clear();
                answer_levels.add(entry.getKey().intValue());
                max_sum_of_level = entry.getValue().intValue();
            } else if (entry.getValue().intValue() == max_sum_of_level) {
                answer_levels.add(entry.getKey().intValue());
            }
        }

        int answer = Integer.MAX_VALUE;
        for (Integer i : answer_levels) {
            answer = Math.min(answer, i.intValue());
        }
        return answer;
    }

    static void function(node root, int current_level, Map<Integer, Integer> my_map) {

        if (root == null) {
            return;
        }

        Integer level_sum = my_map.get(current_level);
        if (level_sum == null) {
            my_map.put(current_level, root.data);
        } else {
            int new_sum = level_sum.intValue() + root.data;
            my_map.put(current_level, new_sum);
        }

        function(root.left, current_level + 1, my_map);
        function(root.right, current_level + 1, my_map);

    }

}