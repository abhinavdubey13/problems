import java.util.*;

/**
 * 
 * 
 * The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.

 * A binary tree is named Even-Odd if it meets the following conditions:
 * 
 * condition-1 : For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
 * condition-2 : For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
 * 
 * 
 * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false
 *   
 */

/**
 * 
 * =====================
 * approach : iterative
 * ======================
 * 
 * 
 * do a BFS , and maintain another list of key-value pair
 * this list has nodes in BFS order 
 * 
 * 
 * compare list depending on even-odd level
 * 
 * for even level , sub-array of that level must be incremental
 * for odd level , sub-array of that level must be decremental
 *
 *
 * TC = O(n)   
 * SC = O(1)
 * 
 * 
 * ======================
 * approach : recursive
 * ======================
 * 
 * we maintain a hashmap , key=level , value=the last value encountered at that level 
 * 
 * when we enter the helper method , we return FALSE when any 1 of below satisy
 * 1. odd value at odd level
 * 2. even value at even level
 * 3. at even-level we get a value less-than or equal to last value at that level (we must have increased values in even-levels)
 * 4. at odd-level we get a value more-than or equal to last value at that level (we must have decreased values in odd-levels)
 * 
 * if none of the above satify , we reset hashmap
 * and return TRUE if node == null 
 *
 *
 * TC = O(n)   
 * SC = O(height)
 * 
 */

class QueueHelper {

    node treenode;
    int level;

    QueueHelper(node tn, int l) {
        this.treenode = tn;
        this.level = l;
    }
}

class ListHelper {

    int val;
    int level;

    ListHelper(int v, int l) {
        this.val = v;
        this.level = l;
    }
}

class x1_even_odd_tree extends HELPER {

    public static void main(String[] args) {

        // tree-1
        node root = new node(1);
        root.left = new node(10);
        root.left.left = new node(3);
        root.left.left.left = new node(12);
        root.left.left.right = new node(8);
        root.right = new node(4);
        root.right.left = new node(7);
        root.right.left.left = new node(6);
        root.right.right = new node(9);
        root.right.right.right = new node(21);

        // tree-2
        // node root = new node(5);
        // root.left = new node(4);
        // root.left.left = new node(3);
        // root.left.right = new node(3);
        // root.right = new node(2);
        // root.right.left = new node(7);

        Recursive recursive_approach = new Recursive();
        boolean result = recursive_approach.function_util(root);

        // Iterative iterative_approach = new Iterative();
        // boolean result = iterative_approach.function(root);

        System.out.println(result);
    }

}

class Iterative {

    boolean function(node root) {

        if (root.data % 2 == 0) {
            return false;
        }

        Queue<QueueHelper> my_queue = new LinkedList<>();
        List<ListHelper> my_list = new LinkedList<>();

        my_queue.offer(new QueueHelper(root, 0));

        while (my_queue.size() > 0) {
            QueueHelper popped = my_queue.poll();
            int next_level = popped.level + 1;

            my_list.add(new ListHelper(popped.treenode.data, popped.level));

            if (popped.treenode.left != null) {
                my_queue.offer(new QueueHelper(popped.treenode.left, next_level));
            }

            if (popped.treenode.right != null) {
                my_queue.offer(new QueueHelper(popped.treenode.right, next_level));
            }
        }

        int current_level = 1;
        for (int i = 1; i < my_list.size();) {

            int j = i;

            while (j < my_list.size() && my_list.get(j).level == current_level) {
                j++;
            }

            boolean check = checkRange(my_list, i, j, current_level);
            if (check == true) {
                i = j;
                current_level++;
            } else {
                return false;
            }
        }
        return true;
    }

    boolean checkRange(List<ListHelper> my_list, int i, int j, int current_level) {
        int max_so_far = -1;
        if (current_level % 2 == 0) {
            for (int start = i; start < j; start++) {
                if (my_list.get(start).val % 2 == 0 || max_so_far >= my_list.get(start).val) {
                    return false;
                }
                max_so_far = Math.max(max_so_far, my_list.get(start).val);
            }
            return true;
        } else {
            for (int start = j - 1; start >= i; start--) {
                if (my_list.get(start).val % 2 == 1 || max_so_far >= my_list.get(start).val) {
                    return false;
                }
                max_so_far = Math.max(max_so_far, my_list.get(start).val);
            }
            return true;
        }
    }

}

class Recursive {

    boolean function(Map<Integer, Integer> my_map, node root, int current_level) {

        // when we reach end of tree 
        // without failing at any level 
        // then only we return true
        if (root == null) {
            return true;
        }

        // if we get even number at even level
        // or odd number at odd level
        // return false
        if (current_level % 2 == 0 && root.data % 2 == 0) {
            return false;
        } else if (current_level % 2 == 1 && root.data % 2 == 1) {
            return false;
        }

        // now check sequence of values
        if (my_map.containsKey(current_level)) {

            // increase at even-level ideally
            if (current_level % 2 == 0) {
                if (root.data <= my_map.get(current_level)) {
                    return false;
                }
                my_map.put(current_level, root.data);
            }

            // decrease at odd-level ideally
            else {
                if (root.data >= my_map.get(current_level)) {
                    return false;
                }
                my_map.put(current_level, root.data);
            }

        }

        // if new level found
        // set current value as bench-mark to begin with
        else {
            my_map.put(current_level, root.data);
        }

        boolean left = this.function(my_map, root.left, current_level + 1);
        boolean right = this.function(my_map, root.right, current_level + 1);
        return left && right;
    }

    boolean function_util(node root) {
        Map<Integer, Integer> my_map = new HashMap<>();
        return this.function(my_map, root, 0);
    }

}
