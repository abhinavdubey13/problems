
/**
 * approach : iterative using 2 stacks
 */

import java.util.*;

class p7_traverse_leveOrderSpiral extends HELPER {

    public static void main(String[] args) {
        node ROOT = new node(10);

        ROOT.left = new node(9);
        ROOT.left.left = new node(11);
        ROOT.left.left.right = new node(15);

        ROOT.right = new node(-10);
        ROOT.right.left = new node(16);
        ROOT.right.right = new node(21);
        ROOT.right.left.left = new node(18);
        ROOT.right.right.right = new node(19);

        // using_2_stacks.function(ROOT);
        // System.out.println();

        List<List<Integer>> ans = Using_recursion.function(ROOT);
        for (List<Integer> li : ans) {
            for (Integer i : li) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}

class using_2_stacks {

    static void function(node rootNode) {

        Stack<node> L2R = new Stack<node>();
        Stack<node> R2L = new Stack<node>();

        L2R.push(rootNode);

        while (L2R.size() > 0 || R2L.size() > 0) {

            if (!L2R.isEmpty()) {
                while (!L2R.isEmpty()) {

                    //pop n print
                    node temp = L2R.pop();
                    System.out.print(temp.data + " ");

                    //push right , then left in other stack
                    if (temp.right != null) {
                        R2L.push(temp.right);
                    }
                    if (temp.left != null) {
                        R2L.push(temp.left);
                    }
                }
            }

            else if (!R2L.isEmpty()) {
                while (!R2L.isEmpty()) {

                    //pop and print
                    node temp = R2L.pop();
                    System.out.print(temp.data + " ");

                    //push left , then right in other stack
                    if (temp.left != null) {
                        L2R.push(temp.left);
                    }
                    if (temp.right != null) {
                        L2R.push(temp.right);
                    }
                }

            }

        }

    }
}


//preorder traversal dfs
class Using_recursion {

    static List<List<Integer>> function(node root) {
        List<List<Integer>> sol = new ArrayList<>();
        dfs(root, sol, 0);
        return sol;
    }

    static void dfs(node curr, List<List<Integer>> sol, int level) {
        if (curr == null)
            return;

        if (sol.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> level_list = sol.get(level);

        if (level % 2 == 0)
            level_list.add(curr.data);
        else
            level_list.add(0, curr.data);

        dfs(curr.left, sol, level + 1);
        dfs(curr.right, sol, level + 1);
    }

}