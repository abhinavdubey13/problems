import java.util.*;

/**
 * 
 * leetcode id :
 * 
 */

/**
 * 
 * 
 * =============
 * APPROACH : 
 * =============
 * 
 * 
 * 
 * 
 */

class x12_least_flight_cost {

    public static void main(String[] args) {

        // int total = 3;
        // int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }; //expected : 200
        // int src = 0;
        // int dest = 2;
        // int k = 0;

        // int total = 5;
        // int[][] flights = { { 4, 1, 1 }, { 1, 2, 3 }, { 0, 3, 2 }, { 0, 4, 10 }, { 3, 1, 1 }, { 1, 4, 3 } }; //expected : 200
        // int src = 2;
        // int dest = 1;
        // int k = 1;

        int total = 4;
        int[][] flights = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } }; //expected : 6
        int src = 0;
        int dest = 3;
        int k = 1;

        int ans = new Solution().function(total, flights, src, dest, k);
        System.out.println(ans);

    }

}

class Answers {
    int hops;
    int cost;

    Answers(int h, int c) {
        hops = h;
        cost = c;
    }
}

class Edge {
    int to;
    int cost;

    Edge(int t, int c) {
        this.to = t;
        this.cost = c;
    }

}

class Heap_node implements Comparable<Heap_node> {
    int n;
    int min_cost;
    int min_step;

    Heap_node(int n, int c, int s) {
        this.n = n;
        this.min_cost = c;
        this.min_step = s;
    }

    @Override
    public boolean equals(Object obj) {
        Heap_node x = (Heap_node) obj;
        if (this.n == x.n & this.min_cost == x.min_cost && this.min_step == x.min_step) {
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Heap_node x) {
        return this.min_cost - x.min_cost;
    }
}

class Solution {

    final int INFINITE = 50000;

    int function(int total_nodes, int[][] flights, int src, int dst, int step_allowed) {

        step_allowed++;

        PriorityQueue<Heap_node> heap = new PriorityQueue<>();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < total_nodes; i++) {
            graph.add(new ArrayList<>());
        }

        //init graph
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];
            graph.get(from).add(new Edge(to, cost));
        }

        //init heap
        for (int i = 0; i < total_nodes; i++) {
            int heap_cost = (i == src) ? 0 : INFINITE;
            int heap_step = (i == src) ? 0 : INFINITE;
            heap.offer(new Heap_node(i, heap_cost, heap_step));
        }

        int[] min_costs = new int[total_nodes];
        int[] min_steps = new int[total_nodes];

        Arrays.fill(min_costs, INFINITE);
        Arrays.fill(min_steps, INFINITE);

        min_costs[src] = 0;
        min_steps[src] = 0;

        int k = 0;

        List<Answers> ans = new LinkedList<>();

        while (heap.size() > 0 && k <= step_allowed) {
        // while (heap.size() > 0) {

            Heap_node popped = heap.poll();
            int i = popped.n;

            k++;

            for (Edge e : graph.get(i)) {
                int j = e.to;
                int edge_ij = e.cost;
                boolean is_relaxble = relax_edge(i, j, edge_ij, min_costs, min_steps, step_allowed);
                if (is_relaxble) {
                    //delete + add =  update (in heap)
                    heap.remove(new Heap_node(j, min_costs[j], min_steps[j]));
                    min_costs[j] = min_costs[i] + edge_ij;
                    min_steps[j] = min_steps[i] + 1;
                    heap.add(new Heap_node(j, min_costs[j], min_steps[j]));

                    if (j == dst) {
                        ans.add(new Answers(min_steps[i] + 1, min_costs[j]));
                    }
                }

            }

        }

        int final_ans = INFINITE;
        int final_hops = INFINITE;
        for (Answers a : ans) {
            final_ans = (a.hops < final_hops) ? a.cost : final_ans;
        }

        return (final_ans == INFINITE) ? -1 : final_ans;

    }

    // //relax an edge only if new weight is lesser than the previously known weight
    static boolean relax_edge(int i, int j, int edge_wt_ij, int[] cost, int[] step, int max_steps_allwd) {
        // if (cost[i] + edge_wt_ij < cost[j] && step[i] + 1 <= max_steps_allwd) {
        if (cost[i] + edge_wt_ij < cost[j]) {

            return true;
        }
        return false;
    }

}
