import java.util.*;

/**
 *
 * 
 * given 
 * 1. a directed weighted graph
 * 2. number of nodes in the graph
 * 3. src node
 * 
 * find shortest dist from src to all other nodes 
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
 *  
 * 
 *   
 * 
 * 
 */

//used for directed weighted graph
class Edge {
    int to;
    int weight;

    Edge(int to, int w) {
        this.to = to;
        this.weight = w;
    }

}

//used for directed weighted graph
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
    @Override
    public boolean equals(Object o) {
        Heap_helper x = (Heap_helper) o;
        if (this.vertex == x.vertex & this.distance == x.distance) {
            return true;
        } else {
            return false;
        }
    }

}

class p7_dijsktra {

    public static void main(String[] args) {
        // Dijstra_undirected_graph_using_matrix.driver();
        Dijstra_directed_graph_using_adj_list.driver();
    }
}

class Dijstra_directed_graph_using_adj_list {

    static void driver() {
        ArrayList<ArrayList<Edge>> graph = get_graph();
        int src = 0;
        int num_vertices = 6;

        dijsktra(graph, src, num_vertices);
    }

    static ArrayList<ArrayList<Edge>> get_graph() {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();

        // neighbours of 0 are : 1 and 2 , with directed edge weights of 2 and 4 respectively
        graph.add(new ArrayList<Edge>());
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));

        // neighbours of 1 are : 2 and 3 , with directed edge weights of 1 and 7 respectively
        graph.add(new ArrayList<Edge>());
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 7));

        graph.add(new ArrayList<Edge>());
        graph.get(2).add(new Edge(4, 3));

        graph.add(new ArrayList<Edge>());
        graph.get(3).add(new Edge(5, 1));

        graph.add(new ArrayList<Edge>());
        graph.get(4).add(new Edge(3, 2));
        graph.get(4).add(new Edge(5, 5));

        //5 has no outgoing edges
        graph.add(new ArrayList<Edge>());

        return graph;

    }

    static void dijsktra(ArrayList<ArrayList<Edge>> graph, int src, int num_vertices) {

        PriorityQueue<Heap_helper> min_heap = new PriorityQueue<>();

        for (int i = 0; i < num_vertices; i++) {
            int d = (src == i) ? 0 : Integer.MAX_VALUE;
            min_heap.offer(new Heap_helper(i, d));
        }

        int[] parent = new int[num_vertices];
        int[] dist_from_src = new int[num_vertices];
        // boolean[] processed = new boolean[num_vertices]; //NOT REQUIRED

        Arrays.fill(dist_from_src, Integer.MAX_VALUE); //fill current dist from source as INFINITY
        Arrays.fill(parent, -1); //parent of any node is not known in the beginning

        dist_from_src[src] = 0;

        while (min_heap.size() > 0) {
            Heap_helper polled = min_heap.poll();

            ArrayList<Edge> neighbours = graph.get(polled.vertex);
            for (Edge n : neighbours) {
                int i = polled.vertex;
                int j = n.to;
                int edge_wt_ij = n.weight;

                boolean is_relaxble = relax_edge(i, j, edge_wt_ij, dist_from_src);
                if (is_relaxble) {
                    //delete + add =  update (in heap)
                    min_heap.remove(new Heap_helper(j, dist_from_src[j]));
                    dist_from_src[j] = dist_from_src[i] + edge_wt_ij;
                    parent[j] = i;
                    min_heap.add(new Heap_helper(j, dist_from_src[j]));
                }
            }
        }

        print_min_dist(num_vertices, src, dist_from_src, parent);
    }

    //relax an edge only if new weight is lesser than the previously known weight
    static boolean relax_edge(int i, int j, int edge_wt_ij, int[] dist_from_src) {
        if (dist_from_src[i] + edge_wt_ij < dist_from_src[j]) {
            return true;
        }
        return false;
    }

    static void print_min_dist(int v, int src, int[] dist, int[] parent) {
        for (int i = 0; i < v; i++) {
            if (i == src) {
                System.out.println("(" + src + "," + i + ") : " + dist[i] + " source vertex");
            } else {
                System.out.println("(" + src + "," + i + ") : " + dist[i] + "  (parent : " + parent[i] + ")");
            }
        }
    }

}

/**
 * 
 * type of graph : undirected , using matrix representation 
 * 
 * given NxN matrix representation of graph , 
 * implement dijkstra algorithm to fin min dist from a given source to every other vertex 
 * 
 * 
 * 
 * concept : https://www.youtube.com/watch?v=t2d-XYuPfg0&ab_channel=TECHDOSE
 * 
 * 
 * implementation : https://www.youtube.com/watch?v=XB4MIexjvY0&ab_channel=AbdulBari 
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 * 
 * 
 * ===========
 * TC = O(v^2) : each vertex is checked for all other verted as neighbours
 * SC = O(v)   :  maintaining 3 extra arrays of size V
 * 
 * 
 * 
 */

class Dijstra_undirected_graph_using_matrix {

    static void driver() {

        // 6x6 graph
        int[][] graph = { { 0, 1, 4, 0, 0, 0 }, { 1, 0, 4, 2, 7, 0 }, { 4, 4, 0, 3, 5, 0 }, { 0, 2, 3, 0, 4, 6 },
                { 0, 7, 5, 4, 0, 7 }, { 0, 0, 0, 6, 7, 0 } };

        //9x9 graph
        // int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
        //         { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
        //         { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
        //         { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        int src = 0;

        dijsktra(graph, src);
    }

    static void dijsktra(int[][] graph, int src) {

        int num_vertices = graph.length;

        int[] parent = new int[num_vertices];
        int[] dist_from_src = new int[num_vertices];
        boolean[] processed = new boolean[num_vertices];

        Arrays.fill(dist_from_src, Integer.MAX_VALUE); //fill current dist from source as INFINITY
        Arrays.fill(parent, -1); //parent of any node is not known in the beginning

        dist_from_src[src] = 0;
        //donot set processed[src] , here , it will be done in the  below logic

        for (int i = 0; i < num_vertices; i++) {
            int min_dist_vertex = find_min_dist_unprocessed_vertes(num_vertices, processed, dist_from_src);
            processed[min_dist_vertex] = true;

            for (int j = 0; j < num_vertices; j++) {

                boolean edge_exist = graph[min_dist_vertex][j] != 0;
                boolean j_is_unprocessed = !processed[j];
                if (edge_exist && j_is_unprocessed) {
                    relax_edge(min_dist_vertex, j, graph, parent, dist_from_src);
                }
            }
        }
        print_min_dist(num_vertices, src, dist_from_src, parent);
    }

    //relax an edge only if new weight is lesser than the previously known weight
    static void relax_edge(int from, int to, int[][] graph, int[] parent, int[] dist_from_src) {
        int edge_weight = graph[from][to];
        if (dist_from_src[from] + edge_weight < dist_from_src[to]) {
            dist_from_src[to] = dist_from_src[from] + edge_weight;
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

    static void print_min_dist(int v, int src, int[] dist, int[] parent) {
        for (int i = 0; i < v; i++) {
            if (i == src) {
                System.out.println("(" + src + "," + i + ") : " + dist[i] + " source vertex");
            } else {
                System.out.println("(" + src + "," + i + ") : " + dist[i] + "  (parent : " + parent[i] + ")");
            }
        }
    }

}