import java.util.*;

/**
 * 
 * leetcode id : 1319
 * 
 * 
 * There are n computers numbered from 0 to n-1 connected by ethernet cables 
 * connections forming a network where connections[i] = [a, b] 
 * represents a connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.
 * 
 * 
 * Given an initial computer network connections. 
 * You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected. 
 * 
 * 
 * Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible, return -1
 * 
 * 
 * =========
 * example : 
 * =========
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
 * using DSU
 * 
 * keep track of reduant connections and number of components at last
 * 
 * depending on these 2 we will have our answer
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
        Queue<Q_helper> q = new LinkedList<>();

        boolean[] vis = new boolean[n];

        q.add(new Q_helper(start, thresh));

        vis[start] = true;

        while (q.size() > 0) {
            Q_helper polled = q.poll();
            int thresh_left = polled.thresh_left;

            for (Edge e : graph.get(polled.city)) {

                int thresh_required = e.wt;
                if (!vis[e.to] && thresh_left >= thresh_required) {
                    q.add(new Q_helper(e.to, thresh_left - thresh_required));
                    vis[e.to] = true;
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
