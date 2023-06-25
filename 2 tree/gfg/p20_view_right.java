
import java.util.*;

/**
 * 
 * given a binary tree , print its right view
 * 
 * 
 * 
 */

/**
 * 
 * nodes in right view are LAST node of each level in level order traversal
 * 
 * thus we use level order traversal , using QUEUE , along with node data , we also note the level of each node in queue
 * we print only if the level is more than previous_max_level
 * 
 * here we do level order from right to left
 * is . insert right child in queue first
 * 
 * =================================
 * TC = O(n)
 * SC = O(maximum nodes at a level)
 * 
 * 
 * 
 */

class Custom_Obj {
    node treeNode;
    int level;

    Custom_Obj(node tn, int l) {
        this.treeNode = tn;
        this.level = l;
    }
}

class p20_view_right extends HELPER {

    static void function(node currentRoot) {

        Queue<Custom_Obj> my_queue = new LinkedList<Custom_Obj>();

        my_queue.offer(new Custom_Obj(currentRoot, 0));

        int max_level_printed = -1;

        while (!my_queue.isEmpty()) {
            Custom_Obj front = my_queue.poll();

            if (front.level > max_level_printed) {
                System.out.print(front.treeNode.data + " ");
                max_level_printed = front.level;
            }

            if (front.treeNode.right != null) {
                my_queue.offer(new Custom_Obj(front.treeNode.right, front.level + 1));
            }

            if (front.treeNode.left != null) {
                my_queue.offer(new Custom_Obj(front.treeNode.left, front.level + 1));
            }

        }

    }

    public static void main(String[] args) {

        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(5);

        function(ROOT);
    }

}