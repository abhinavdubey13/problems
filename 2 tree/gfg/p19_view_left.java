
import java.util.*;

/**
 * 
 * given a binary tree , print its left view
 * 
 * 
 * 
 */

/**
 * 
 * nodes in left view are 1st node of each level in level order traversal
 * 
 * thus we use level order traversal , using QUEUE , along with node data , we also note the level of each node in queue
 * we print only if the level is more than previous_max_level
 * 
 * =================================
 * TC = O(n)
 * SC = O(maximum nodes at a level)
 *
 * 
 * 
 * 
 * 
 * 
 * 
 * we can also use DFS for the same
 * space will be optimized
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

class p19_view_left extends HELPER {

    public static void main(String[] args) {

        ROOT = new node(1);
        ROOT.left = new node(2);
        ROOT.right = new node(3);
        ROOT.left.left = new node(4);
        ROOT.left.right = new node(5);

        function(ROOT);
        System.out.println();
    }

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

            if (front.treeNode.left != null) {
                my_queue.offer(new Custom_Obj(front.treeNode.left, front.level + 1));
            }

            if (front.treeNode.right != null) {
                my_queue.offer(new Custom_Obj(front.treeNode.right, front.level + 1));
            }

        }

    }

}

class Optimal_using_dfs {

    int MAX_LEVEL;

    ArrayList<Integer> leftView(node root) {
        // Your code here

        ArrayList<Integer> answer = new ArrayList<>();

        MAX_LEVEL = -1;

        if (root == null) {
            return answer;
        }

        dfs(root, 0, answer);
        return answer;
    }

    void dfs(node curr, int level, ArrayList<Integer> ans) {

        if (curr == null) {
            return;
        }

        if (level > MAX_LEVEL) {
            MAX_LEVEL = level;
            ans.add(curr.data);
        }

        dfs(curr.left, level + 1, ans);
        dfs(curr.right, level + 1, ans);

    }

}
