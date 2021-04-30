import java.util.*;

/**
 * 
 * leetcode id : 1584
 * 
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 * 
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 * 
 * Return the minimum cost to make all points connected. 
 * 
 * All points are connected if there is exactly one simple path between any two points.
 * 
 * 
 * 
 * =========
 * example : 
 * =========
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
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
 * using Kruskal alog and Union find
 * 
 * consider complete graph , each point s connected to every other point
 * 
 * now we need to find minimum spanning tree , using collection of weighted edges
 * 
 * so we use krukal algo : 
 * 1. min-heap(add min cost edges only) 
 * 2. DSU(to check loops)
 * 
 * 
 */

class x29_min_cost_to_connect_all_pts {

    public static void main(String[] args) {

        // //expected : 20
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };

        int answer = new Solution().function(points);
        System.out.println(answer);

    }

}

class DSU {
    int n;
    int[] rank;
    int[] parent;

    DSU(int n) {
        this.n = n;
        this.rank = new int[n];
        this.parent = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        } else {
            int px = find(parent[x]);
            parent[x] = px;
            return parent[x];
        }
    }

    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return false;
        }

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[py] < rank[px]) {
            parent[py] = px;
        } else if (rank[px] == rank[py]) {
            parent[py] = px;
            rank[px]++;
        }

        return true;
    }
}

class Solution {

    int function(int[][] points) {

        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new int[] { dist_i_j(points, i, j), i, j });
            }
        }  

        int edges_required  =  0;
        int overall_wt = 0;
        DSU dsu = new DSU(n);

        //to connect n points , we need [n-1] edges
        while (edges_required != n - 1) {
            int[] polled = pq.poll();
            if(dsu.union(polled[1], polled[2])){
                edges_required++;
                overall_wt+=polled[0];
            }
        }

        return overall_wt;

    }

    int dist_i_j(int[][] points, int i, int j) {
        return (Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
    }
}
