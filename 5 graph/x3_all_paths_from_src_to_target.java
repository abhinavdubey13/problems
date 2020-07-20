import java.util.*;

/**
 * 
 * 
 * leet code : 797 
 * 
 * 
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, 
 * 
 * find all possible paths from node 0 to node n - 1, and return them in any order.
 * 
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i 
 * ie. there is a directed edge from node i to node graph[i][j]
 * 
 *
 * =========
 * example : 
 * ========
 * 
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * 
 * 
 * 
 */

/**
 * =============
 * APPROACH : 
 * =============
 * 
 * using dfs
 * 
 * 
 * since graph is DAG , we need not maitain visited array 
 * 
 * 
 * 
 */

public class x3_all_paths_from_src_to_target {

    public static void main(String[] args) {

        int[][] graph = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };

        List<List<Integer>> answer = Solution.function(graph);

        for (List<Integer> path : answer) {
            for (Integer node : path) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

}

class Solution {

    static List<List<Integer>> function(int[][] graph) {

        int num_nodes = graph.length;

        List<List<Integer>> answer = new ArrayList<>();

        Stack<Integer> stk = new Stack<>();

        dfs(0, graph, num_nodes, stk, answer);
        return answer;

    }

    static void dfs(int curr, int[][] graph, int total_nodes, Stack<Integer> stk, List<List<Integer>> answer) {

        stk.push(curr);

        if (curr == total_nodes - 1) {
            add_path(stk, answer);
        } else {
            int[] ngbrs = graph[curr];
            for (int n : ngbrs) {
                dfs(n, graph, total_nodes, stk, answer);
            }
        }

        stk.pop();
    }

    static void add_path(Stack s, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(s));
    }

}
