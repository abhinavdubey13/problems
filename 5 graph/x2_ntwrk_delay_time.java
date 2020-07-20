import java.util.*;

/**
 * 
 * leet code : 743
 * 
 * 
 * You are given a network of n nodes, labeled from 1 to n. 
 * 
 * You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), 
 * where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * 
 * We will send a signal from a given node k. 
 * Return the time it takes for all the n nodes to receive the signal. 
 * If it is impossible for all the n nodes to receive the signal, return -1.
 *
 * 
 *
 * =========
 * example : 
 * ========
 * 
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 *
 * 
 */

/**
 * =============
 * APPROACH : 
 * =============
 * 
 * convert edge list into adjacency list
 * 
 * then use Dijktra , SSP algo
 * 
 * NOTE :  tried BFS , but did not work
 * 
 * 
 * 
 */

public class x2_ntwrk_delay_time {

    public static void main(String[] args) {

        //expected = 2
        // int[][] edges = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        // int num_nodes = 4;
        // int src = 2;

        // //expected = -1
        // int[][] edges = { { 1, 2, 1 } };
        // int num_nodes = 2;
        // int src = 2;

        //expected = 3
        int[][] edges = { { 1, 2, 1 }, { 2, 3, 2 }, { 1, 3, 4 } };
        int num_nodes = 3;
        int src = 1;

        //expected = 6
        // int[][] edges = { { 1, 2, 1 }, { 2, 3, 7 }, { 1, 3, 4 }, { 2, 1, 2 } };
        // int num_nodes = 3;
        // int src = 2;

        int answer = Solution.function(edges, num_nodes, src);
        System.out.println(answer);
    }

}

class Edge {
    int to;
    int weight;

    Edge(int to, int w) {
        this.to = to;
        this.weight = w;
    }

}

class Heap_helper implements Comparable<Heap_helper> {
    int vertex;
    int distance;

    Heap_helper(int v, int w) {
        this.vertex = v;
        this.distance = w;
    }

    //insted of doing at the time of declaration , we can also do here
    public int compareTo(Heap_helper x) {
        return this.distance - x.distance;
    }

    //this is done because , when we want to delete a specific node , we cannot pass new Heap_helper(v,d)
    //it will not delete , so we need to override this method
    public boolean equals(Object o) {
        Heap_helper x = (Heap_helper) o;
        if (this.vertex == x.vertex & this.distance == x.distance) {
            return true;
        } else {
            return false;
        }
    }

}

class Solution {

    static int function(int[][] arr, int n, int src) {

        Map<Integer, Integer> time = new HashMap<>();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            int from = arr[i][0] - 1;
            int to = arr[i][1] - 1;
            int wt = arr[i][2];
            graph.get(from).add(new Edge(to, wt));
        }

        int[] times = dijkstra(graph, src - 1, time, n);
        int answer = 0;

        for (int i = 0; i < times.length; i++) {
            if (times[i] == Integer.MAX_VALUE) {
                return -1;
            }
            answer = Math.max(answer, times[i]);
        }
        return answer;
    }

    static int[] dijkstra(ArrayList<ArrayList<Edge>> graph, int src, Map<Integer, Integer> time, int n) {

        PriorityQueue<Heap_helper> min_heap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int d = (src == i) ? 0 : Integer.MAX_VALUE;
            min_heap.offer(new Heap_helper(i, d));
        }

        int[] parent = new int[n];
        int[] dist_from_src = new int[n];

        Arrays.fill(dist_from_src, Integer.MAX_VALUE); //fill current dist from source as INFINITY
        Arrays.fill(parent, -1); //parent of any node is not known in the beginning

        dist_from_src[src] = 0;

        while (min_heap.size() > 0) {
            Heap_helper min_dist = min_heap.poll();

            ArrayList<Edge> neighbours = graph.get(min_dist.vertex);
            for (Edge edg : neighbours) {
                int i = min_dist.vertex;
                int j = edg.to;
                int edge_wt_ij = edg.weight;

                boolean is_relaxble = relax_edge(i, j, edge_wt_ij, parent, dist_from_src);

                if (is_relaxble) {
                    //delete + add =  update (in heap)
                    min_heap.remove(new Heap_helper(j, dist_from_src[j]));
                    dist_from_src[j] = dist_from_src[i] + edge_wt_ij;
                    parent[j] = i;
                    min_heap.add(new Heap_helper(j, dist_from_src[j]));
                }
            }
        }

        return dist_from_src;
    }

    // //relax an edge only if new weight is lesser than the previously known weight
    static boolean relax_edge(int i, int j, int edge_wt_ij, int[] parent, int[] dist_from_src) {
        if (dist_from_src[i] + edge_wt_ij < dist_from_src[j]) {
            return true;
        }
        return false;
    }

}