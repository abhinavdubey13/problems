import java.util.*;

/**
 * 
 * leetcode id : 1761
 * 
 * 
 * 
 * You are given an undirected graph. 
 * 
 * You are given an integer n which is the number of nodes in the graph and an array edges, 
 * 
 * where each edges[i] = [ui, vi] indicates that there is an undirected edge between ui and vi.
 * 
 * A connected trio is a set of three nodes where there is an edge between every pair of them.
 * 
 * The degree of a connected trio is the number of edges where one endpoint is in the trio, and the other is not.
 * 
 *  Return the minimum degree of a connected trio in the graph, or -1 if the graph has no connected trios.
 * 
 * 
 * 
 */

/**
 * 
 * 
 * =============
 * APPROACH : 
 * =============
 * 
 * from ege make a graph[][] , it will be a symmetric matrix , as graph is un-directed
 * 
 * also find degree of each node
 * 
 * 
 * now check for trios : using i,j,k as vertices
 * 
 * 
 * 
 * 
 */


 class x8_min_degree_of_connected_trio {

    public static void main(String[] args) {
        int n = 7;

        int[][] edges = { { 1, 3 }, { 4, 1 }, { 4, 3 }, { 2, 5 }, { 5, 6 }, { 6, 7 }, { 7, 5 }, { 2, 6 } };

        Solution s = new Solution();
        int ans = s.function(n, edges);
        System.out.println(ans);

    }

}

class Solution {

    int function(int n, int[][] edges) {

        boolean[][] graph = new boolean[n][n];

        int[] degree = new int[n];

        for (int i = 0; i < edges.length; i++) {

            int[] edge = edges[i];
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            graph[u][v] = true;
            graph[v][u] = true;

            degree[u]++;
            degree[v]++;
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    //if a trio is formed
                    if (i != j && j != k && graph[i][j] && graph[j][k] && graph[k][i]) {

                        int possible_ans = ((degree[i] + degree[j] + degree[k] - 6) >= 0)
                                ? (degree[i] + degree[j] + degree[k] - 6)
                                : -1;

                        answer = Math.min(answer, possible_ans);

                    }

                }
            }
        }

        return (answer == Integer.MAX_VALUE) ? -1 : answer;

    }

}
