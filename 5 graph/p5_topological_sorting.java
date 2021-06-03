import java.util.*;

/**
 *
 * https://practice.geeksforgeeks.org/problems/topological-sort/1/
 * 
 * 
 * NOTE : topological sorting is only possible for DAGs (directed + acyclic graph)
 * 
 * 
 * Topological sorting for Directed cyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v,
 * vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 * 
 * 
 *
 *  
 */

/**
 * 
 * ============
 * approach :
 * ============
 * 
 * https://www.youtube.com/watch?v=ddTC4Zovtbc&ab_channel=TusharRoy-CodingMadeSimple
 * 
 * 
 * using DFS , when we are done exploring all neighbour of current node , we add it to the stack
 * 
 * 
 * TC = O(v+e)
 * SC = O(v)
 * 
 * 
 *   
 * 
 * 
 */

class p5_topological_sorting {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();

        // forest graph => expected : 1,2,3,0 (1,2,3 can be in any 0rder)
        adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 0 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(0))); //neighbours of 1 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(0))); //neighbours of 2 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(0))); //neighbours of 3 (undirected - edge)

        int num_nodes = adj_list.size();

        int[] answer = Solution.function_util(num_nodes, adj_list);
        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

class Solution {

    static int[] function_util(int num_nodes, ArrayList<ArrayList<Integer>> adj_list) {

        int[] answer = new int[num_nodes];
        boolean[] visited = new boolean[num_nodes];

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < num_nodes; i++) {
            if (!visited[i]) {
                dfs(i, adj_list, visited, stk);
            }
        }

        int i = 0;
        while (stk.size() > 0) {
            answer[i] = stk.pop().intValue();
            i++;
        }
        return answer;

    }

    static void dfs(int curr, ArrayList<ArrayList<Integer>> adj_list, boolean[] vis, Stack<Integer> stk) {

        vis[curr] = true;  //we can have it here or at the bottom , since graph is DAG it wont matter

        List<Integer> neighbours = adj_list.get(curr);

        for (Integer n : neighbours) {
            if (!vis[n]) {
                dfs(n, adj_list, vis, stk);
            }
        }

        stk.add(curr);
    }

}