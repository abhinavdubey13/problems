import java.util.*;

/**
 * given a level-order of a binary tree , check if it represents a BST
 * 
 * https://www.geeksforgeeks.org/check-given-array-can-represent-level-order-traversal-binary-search-tree/
 *   
 */

/**
 * 
 * The idea is to use a queue data structure. 
 * Every element of queue has a structure say NodeDetails which stores details of a tree node. 
 * 
 * The details are node’s data, and two variables min and max where min stores the lower limit for the node values
 * which can be a part of the left subtree and max stores the upper limit for the node values which can be a part of the right subtree for the specified node in NodeDetails structure variable. 
 * 
 * 
 * step-1
 * For the 1st array value arr[0], create a NodeDetails structure having arr[0] as node’s data and min = INT_MIN and max = INT_MAX. 
 * Add this structure variable to the queue. 
 * This Node will be the root of the tree. 
 * 
 * 
 * step-2
 * Move to 2nd element in arr[] and then perform the following steps:
 * Pop NodeDetails from the queue in temp.
 * 
 * 
 * step-3
 * Check whether the current array element can be a left child of the node in temp with the help of min and temp.data values. 
 * If it can, then create a new NodeDetails structure for this new array element value with its proper ‘min’ and ‘max’ values and 
 * push it to the queue, 
 * 
 * 
 * 
 * step-4
 * move to next element in arr[].Check whether the current array element can be a right child of the node in temp 
 * with the help of max and temp.data values.
 * If it can, then create a new NodeDetails structure for this new array element value with its proper ‘min’ and ‘max’ values and push it to the queue, and move to next element in arr[].
 * 
 * 
 * 
 * Repeat steps 2, 3 and 4 until there are no more elements in arr[] or
 * there are no more elements in the queue.
 * 
 * Finally, if all the elements of the array have been traversed then the array represents the level order traversal of a BST, else NOT.
 * 
 * 
 * 
 * ========================
 * input  array size = n
 * TC = O(n)   
 * SC = O(n)
 *
 */

class Details {
    int min_allowed_in_LST;
    int current_node;
    int max_allowed_in_RST;

    Details(int L, int C, int R) {
        this.min_allowed_in_LST = L;
        this.current_node = C;
        this.max_allowed_in_RST = R;
    }
}

class p49_check_if_given_level_order_is_BST {

    public static void main(String[] args) {

        // expect yes
        // int[] level_order = { 7, 4, 12, 3, 6 };
        // int[] level_order = { 7, 8, 9 };

        // expect no
        int[] level_order = { 7, 18, 4 };

        function(level_order);

    }

    static void function(int[] level_order) {

        Queue<Details> my_queue = new LinkedList<>();

        my_queue.offer(new Details(Integer.MIN_VALUE, level_order[0], Integer.MAX_VALUE));

        int i = 1;

        while (i != level_order.length && my_queue.size() > 0) {

            Details popped = my_queue.poll();

            //if i'th element is in (min-in-LST of popped , popped-current)
            boolean belong_to_LST = (i < level_order.length && level_order[i] > popped.min_allowed_in_LST
                    && level_order[i] < popped.current_node);

            if (belong_to_LST) {
                my_queue.offer(new Details(popped.min_allowed_in_LST, level_order[i], popped.current_node - 1));
                i++;
            }

            //if i'th element is in (popped-currnet ,  max-in-rst of popped)
            boolean belong_to_RST = (i < level_order.length && level_order[i] > popped.current_node
                    && level_order[i] < popped.max_allowed_in_RST);

                    
            if (belong_to_RST) {
                my_queue.offer(new Details(popped.current_node + 1, level_order[i], popped.max_allowed_in_RST));
                i++;
            }

        }

        // print result 
        System.out.println();
        if (i == level_order.length) {
            System.out.println("CAN BE a level-order of BST");
        } else {
            System.out.println("NOT a level-order of BST");
        }

    }

}