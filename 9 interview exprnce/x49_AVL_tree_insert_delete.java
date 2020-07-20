import java.util.*;

/**
 * implemeting AVL tree
 * 
 * 1. insert 
 * 2. delete
 * 
 * 
 * https://www.youtube.com/watch?v=a96JFhw5Ee4&ab_channel=CodingBlocks  (followed this)
 * 
 * 
 * https://www.youtube.com/watch?v=otiDcwZbCo4&ab_channel=SimpleSnippets (can also check this)
 * 
 * 
 * 
 * deletion in AVL Tree : https://www.geeksforgeeks.org/avl-tree-set-2-deletion/
 * 
 * 
 * 
 * 
 */

/**
 * 
 * =============
 * LL rotation : right rotate C
 * =============
 * 
 * before : 
 * 
 * 
 *        C
 *       / \
 *      B  T4
 *     / \             
 *    A  T3
 *   / \
 *  T1  T2
 * 
 * 
 * finally : 
 * 
 *      B
 *     / \
 *    A    C
 *   / \  / \
 *  T1 T2 T3 T4
 *  
 * 
 * 
 */

/**
* 
* =============
* LR rotation : convert to LL case by first left rotating B , then right rotating C
* =============
* 
* before : 
* 
* 
*        C
*       / \
*      B  T4
*     / \             
*    T1  A
*       / \
*      T2  T3
* 
* 
*
* inter-mediate : after 1st left rotation of B
* 
* 
*        C
*       / \
*      A  T4
*     / \             
*    B   T3
*   / \
*  T1  T2 
*
*
*
*
*
*
*
*
* finally : 
* 
*      A
*     / \
*    B   C
*   / \  / \
*  T1 T2 T3 T4
*  
* 
* 
*/

/**
 * 
 * =============
 * RR rotation : left rotate C
 * =============
 * 
 * before : 
 * 
 * 
 *        C
 *       / \
 *      T1  B
 *         / \             
 *        T2  A
 *           / \
 *          T3  T4
 * 
 * 
 * finally : 
 * 
 *      B
 *     / \
 *    C   A
 *   / \  / \
 *  T1 T2 T3 T4
 *  
 * 
 * 
 */

/**
* 
* =============
* RL rotation : convert to RR case by first right rotating B , then left rotating C
* =============
* 
* before : 
* 
* 
*        C
*       / \
*      T1  B
*         / \             
*        A   T4
*       / \
*     T2  T3
* 
*
*
*
* inter-mediate : after 1st right rotation of B
* 
* 
*   C
*  / \
* T1  A
*    / \             
*   T2  B
*      / \
*     T3  T4 
*
*
* 
* finally : 
* 
*      A
*     / \
*    C   B
*   / \  / \
*  T1 T2 T3 T4
*  
* 
* 
*/

class node {
    int data;
    node left;
    node right;
    int height;

    node(int d) {
        this.data = d;
        left = right = null;

        height = 1;
        //why ?? bcz this might mess up logic in calculation balance factor if used as 0 
        //bcz if both leaf-node and null node return 0 as heights
    }
}

class x49_AVL_tree_insert_delete {

    public static void main(String[] args) throws Exception {

        AVL_tree root = new AVL_tree();

        root.insert_val(1);
        root.insert_val(2);
        root.insert_val(3);
        root.insert_val(4);
        root.insert_val(5);
        root.insert_val(6);
        root.insert_val(7);
        root.insert_val(8);
        root.insert_val(9);

        root.print_inorder();

        root.delete_val(4);
        root.print_inorder();

        root.delete_val(9);
        root.print_inorder();

    }

}

class AVL_tree {

    private node ROOT;

    AVL_tree() {
        this.ROOT = null;
    }

    void insert_val(int val) {
        this.ROOT = insert(this.ROOT, val);
    }

    void delete_val(int val) {
        this.ROOT = delete(this.ROOT, val);
    }

    void print_inorder() {
        print_inorder_priv(this.ROOT);
        System.out.println();
    }

    private node insert(node curr, int val) {
        if (curr == null) {
            node n = new node(val);
            return n;
        }

        if (val < curr.data) {
            curr.left = insert(curr.left, val);
        } else if (val > curr.data) {
            curr.right = insert(curr.right, val);
        }

        curr.height = Math.max(get_height(curr.left), get_height(curr.right)) + 1;

        //check if imbalance
        int bf_curr = get_balance_factor(curr);
        int bf_left = get_balance_factor(curr.left);
        int bf_right = get_balance_factor(curr.right);

        //LL
        //bf>1 : 1st step is LEFT (bcz LST height is more)
        if (bf_curr > 1 && bf_left >= 0) {
            return right_rotate(curr);
        }

        //LR : convert to LL by left rotating , then finally perform right rotation
        else if (bf_curr > 1 && bf_left < 0) {
            curr.left = left_rotate(curr.left);
            return right_rotate(curr);
        }

        //RR
        else if (bf_curr < -1 && bf_right <= 0) {
            return left_rotate(curr);
        }

        //RL
        else if (bf_curr < -1 && bf_right > 0) {
            curr.right = right_rotate(curr.right);
            return left_rotate(curr);
        }

        return curr;

    }

    private node delete(node curr, int val) {
        if (curr == null) {
            return null;
        }

        if (val < curr.data) {
            curr.left = delete(curr.left, val);
        } else if (val > curr.data) {
            curr.right = delete(curr.right, val);
        } else {
            //if node to be deleted is leaf
            if (curr.left == null && curr.right == null) {
                curr = null;
            } else if (curr.left == null) {
                curr = curr.right;
            } else if (curr.right == null) {
                curr = curr.left;
            } else {
                int min_in_rst = get_min_in_rst(curr.right);
                curr.data = min_in_rst;
                curr.right = delete(curr.right, min_in_rst);
            }
        }

        if (curr == null) {
            return curr;
        } else {
            curr.height = Math.max(get_height(curr.left), get_height(curr.right)) + 1;

            //check if imbalance
            int bf_curr = get_balance_factor(curr);
            int bf_left = get_balance_factor(curr.left);
            int bf_right = get_balance_factor(curr.right);

            //LL
            //bf>1 : 1st step is LEFT (bcz LST height is more)
            if (bf_curr > 1 && bf_left >= 0) {
                return right_rotate(curr);
            }

            //LR : convert to LL by left rotating , then finally perform right rotation
            else if (bf_curr > 1 && bf_left < 0) {
                curr.left = left_rotate(curr.left);
                return right_rotate(curr);
            }

            //RR
            else if (bf_curr < -1 && bf_right <= 0) {
                return left_rotate(curr);
            }

            //RL
            else if (bf_curr < -1 && bf_right > 0) {
                curr.right = right_rotate(curr.right);
                return left_rotate(curr);
            }
            return curr;
        }

    }

    private int get_min_in_rst(node x) {
        if (x.left == null) {
            return x.data;
        } else {
            return get_min_in_rst(x.left);
        }
    }

    private node right_rotate(node c) {
        //initialize/capture
        node b = c.left;
        node T3 = b.right;

        //rotate (we can change order of below 2 statements)
        b.right = c;
        c.left = T3;

        //assign new height to b and c
        //assign C height first , as B height is dependent on C
        c.height = Math.max(get_height(c.left), get_height(c.right)) + 1;
        b.height = Math.max(get_height(b.left), get_height(b.right)) + 1;

        return b;
    }

    private node left_rotate(node c) {
        //initialize/capture
        node b = c.right;
        node T2 = b.left;

        //rotate (we can change order of below 2 statements)
        b.left = c;
        c.right = T2;

        //assign new height to b and c
        //assign C height first , as B height is dependent on C
        c.height = Math.max(get_height(c.left), get_height(c.right)) + 1;
        b.height = Math.max(get_height(b.left), get_height(b.right)) + 1;

        return b;
    }

    private int get_balance_factor(node x) {
        if (x == null) {
            return 0;
        }
        return get_height(x.left) - get_height(x.right);
    }

    private int get_height(node x) {
        if (x == null) {
            return 0;
        }
        return x.height;
    }

    private void print_inorder_priv(node x) {
        if (x == null) {
            return;
        }
        print_inorder_priv(x.left);
        System.out.print(x.data + " ");
        print_inorder_priv(x.right);
    }

}
