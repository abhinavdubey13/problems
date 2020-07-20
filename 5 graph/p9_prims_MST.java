import java.util.*;

/**
 *
 * 
 * https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
 * 
 * https://www.geeksforgeeks.org/prims-mst-for-adjacency-list-representation-greedy-algo-6/
 * 
 * 
 * find MST using prims algo
 * 
 * 
 * ==========
 * example :
 * ==========
 * 
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
 * NOTE :
 * 1. prims algo is a greedy algo
 * 2. MST can only be found for a connected graph
 *  
 * 
 *   
 * 
 * 
 */

class p9_prims_MST {

    public static void main(String[] args) {
        Prims_directed_graph_using_adj_list.driver();
    }
}

/**
 * 
 * type of graph : undirected , using matrix representation 
 * given NxN matrix representation of graph , implement Prims algorithm to find MST 
 * 
 * https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
 * 
 * https://www.youtube.com/watch?v=xthRL0lcx2w&ab_channel=TECHDOSE
 * 
 * =============================================================================
 * similar to Dijsktra algo
 * 
 * TC = O(v^2) : each vertex is checked for all other verted as neighbours
 * SC = O(v)   :  maintaining 3 extra arrays of size V
 * 
 * 
 * 
 */

class Prims_undirected_graph_using_matrix {

    static void driver() {

        //5x5 graph
        int[][] graph = { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        int src = 0;

        prims(graph, src);
    }

    static void prims(int[][] graph, int src) {

        int num_vertices = graph.length;

        int[] parent = new int[num_vertices];
        int[] value = new int[num_vertices]; //DIFFERENCE FROM DIJKSTRA : instead of having dist from souce , we have this array , denoting the edge weight connecting a node to MST 
        boolean[] processed = new boolean[num_vertices]; //DIFFERENCE FROM DIJKSTRA : this array wll denote if a node is in MST or not

        Arrays.fill(value, Integer.MAX_VALUE); //fill current dist from source as INFINITY
        Arrays.fill(parent, -1); //parent of any node is not known in the beginning

        value[src] = 0;
        //donot set processed[src] , here , it will be done in the  below logic

        for (int i = 0; i < num_vertices; i++) {
            int min_dist_vertex = find_min_dist_unprocessed_vertes(num_vertices, processed, value);
            processed[min_dist_vertex] = true;

            for (int j = 0; j < num_vertices; j++) {

                boolean edge_exist = graph[min_dist_vertex][j] != 0;
                boolean j_is_unprocessed = !processed[j];
                if (edge_exist && j_is_unprocessed) {
                    relax_edge(min_dist_vertex, j, graph, parent, value);
                }
            }
        }
        print_min_mst(num_vertices, src, value, parent);
    }

    //DIFFERENCE FROM DIJKSTRA : relax an edge only if u-v dist is less than val[v]
    static void relax_edge(int from, int to, int[][] graph, int[] parent, int[] value) {
        int edge_weight = graph[from][to];
        if (edge_weight < value[to]) {
            value[to] = edge_weight;
            parent[to] = from;
        }
    }

    static int find_min_dist_unprocessed_vertes(int v, boolean[] processed, int[] dist) {
        int answer_vertex = 0;
        int min_dist = Integer.MAX_VALUE;
        for (int i = 0; i < v; i++) {
            if (!processed[i] && dist[i] < min_dist) {
                min_dist = dist[i];
                answer_vertex = i;
            }
        }
        return answer_vertex;
    }

    static void print_min_mst(int v, int src, int[] value, int[] parent) {
        for (int i = 0; i < v; i++) {
            if (i == src) {
                System.out.println(i + " : source node");
            } else {
                System.out.println(i + " - " + parent[i] + " : " + value[i]);
            }
        }
    }

}