import java.util.*;

/**
 * 
 * leetcode id : 1466
 * 
 * There are n cities numbered from 0 to n-1 and n-1 roads such that there is only one way to travel between two different cities (this network form a tree). 
 * 
 * Roads are represented by connections where connections[i] = [a, b] 
 * represents a road from city a to b.
 * 
 * This year, there will be a big event in the capital (city 0), 
 * and many people want to travel to this city.
 * 
 * Your task consists of reorienting some roads such that each city can visit the city 0. 
 * Return the minimum number of edges changed.
 * 
 * 
 * =========
 * example : 
 * =========
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
 * using BFS
 * 
 * make undirected graph using edges and also store current direction of edges
 * 
 * 
 * start BFS from node 0 , use undirected graph for the same
 *
 * required edge : current->parent
 * 
 * if required edge is not found then , flip is required here
 * 
 *
 * 
 * https://www.youtube.com/watch?v=cU47iO_Q70g&ab_channel=codeExplainer
 * 
 *
 *
 * 
 */

class x28_reorder_routes {

    public static void main(String[] args) {

        // //expected : 3
        int n = 6;
        int[][] edges = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };

        int answer = new Solution().function(n, edges);
        System.out.println(answer);

    }

}

class Solution {

    int function(int n, int[][] edges) {

        List<List<Integer>> undirected_graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            undirected_graph.add(new ArrayList<>());
        }

        Set<String> directed_edge_set = new HashSet<>();
        for (int[] e : edges) {
            undirected_graph.get(e[0]).add(e[1]);
            undirected_graph.get(e[1]).add(e[0]);
            directed_edge_set.add(e[0] + "->" + e[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(0);
        vis[0] = true;

        int flips = 0;
        while (q.size() > 0) {

            int polled = q.poll();

            // neighbours
            for (Integer i : undirected_graph.get(polled)) {
                if (!vis[i]) {
                    vis[i] = true;
                    q.add(i);

                    //since we want to reach 0 from every city 
                    // this type of edges are needed
                    String required_edge = i + "->" + polled;
                    flips += (directed_edge_set.contains(required_edge)) ? 0 : 1;
                }
            }
        }

        return flips;

    }
}
