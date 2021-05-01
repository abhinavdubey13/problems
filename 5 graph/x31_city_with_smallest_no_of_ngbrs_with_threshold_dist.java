import java.util.*;

/**
 * 
 * leetcode id : 1334
 * 
 * 
 * There are n cities numbered from 0 to n-1. 
 * 
 * Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities 
 * fromi and toi, and given the integer distanceThreshold.
 * 
 * 
 * Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, 
 * If there are multiple such cities, return the city with the greatest number.
 * 
 * Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.
 * 
 * 
 * =========
 * example : 
 * =========
 * 
 * Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * output: 3
 * Explanation: The figure above describes the graph. 
 * The neighboring cities at a distanceThreshold = 4 for each city are:
 * City 0 -> [City 1, City 2] 
 * City 1 -> [City 0, City 2, City 3] 
 * City 2 -> [City 0, City 1, City 3] 
 * City 3 -> [City 1, City 2] 
 * Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
 * 
 */

/**
 * 
 * 
 * ============= 
 * APPROACH : 
 * ============= 
 * 
 * using BFS on every node
 * 
 * but here instead of simple queue , we use priority queue
 * 
 * and count visited nodes
 * 
 * 
 * 
 */

class x31_city_with_smallest_no_of_ngbrs_with_threshold_dist {

    public static void main(String[] args) {

        //expected : 3
        // int n = 4;
        // int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
        // int threshold = 4;

        int n = 6;
        int[][] edges = { { 0, 1, 10 }, { 0, 2, 1 }, { 2, 3, 1 }, { 1, 3, 1 }, { 1, 4, 1 }, { 4, 5, 10 } };
        int threshold = 20;

        int answer = new Solution().function(n, edges, threshold);
        System.out.println(answer);
    }

}

class Edge {
    int to;
    int wt;

    Edge(int to, int wt) {
        this.to = to;
        this.wt = wt;
    }
}

class Q_helper {
    int city;
    int thresh_left;

    Q_helper(int c, int t) {
        this.city = c;
        this.thresh_left = t;
    }
}

class Solution {

    int function(int n, int[][] edges, int thresh) {

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(new Edge(e[1], e[2]));
            graph.get(e[1]).add(new Edge(e[0], e[2]));
        }

        int min_ngbr = Integer.MAX_VALUE;
        int min_ngbr_city = 0;
        for (int i = 0; i < n; i++) {

            int ngbrs_rchble_with_threshold = bfs(graph, i, n, thresh);

            if (ngbrs_rchble_with_threshold <= min_ngbr) {
                min_ngbr = ngbrs_rchble_with_threshold;
                min_ngbr_city = Math.max(min_ngbr_city, i);
            }
        }

        return min_ngbr_city;

    }

    int bfs(List<List<Edge>> graph, int start, int n, int thresh) {
        // Queue<Q_helper> q = new LinkedList<>();
        PriorityQueue<Q_helper> q = new PriorityQueue<>((a, b) -> -1 * (a.thresh_left - b.thresh_left));

        boolean[] vis = new boolean[n];

        q.add(new Q_helper(start, thresh));

        vis[start] = true;

        while (q.size() > 0) {
            Q_helper polled = q.poll();
            vis[polled.city] = true;

            int thresh_left = polled.thresh_left;

            List<Edge> ngbrs = graph.get(polled.city);

            for (Edge e : ngbrs) {

                int thresh_required = e.wt;
                if (!vis[e.to] && thresh_left >= thresh_required) {
                    q.add(new Q_helper(e.to, thresh_left - thresh_required));
                    // vis[e.to] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += vis[i] ? 1 : 0;
        }

        return cnt;

    }
}
