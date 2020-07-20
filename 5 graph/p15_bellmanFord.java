import java.util.*;

/**
 * 
 * given graph  , in terms of edge list
 * 
 * implement bellmen-ford algo
 * 
 *  
 * https://www.geeksforgeeks.org/bellman-ford-algorithm-simple-implementation/ 
 * 
 *  
 */

/**
 * 
 * ============
 * approach :
 * ============
 * 
 * STEP-1:
 * This step calculates shortest distances. Do following |V|-1 times where |V| is the number of vertices in given graph.
 * a) Do following for each edge u-v
 * If dist[v] > dist[u] + weight of edge uv, then update dist[v]
 * dist[v] = dist[u] + weight of edge uv
 * 
 * 
 * STEP-2:
 * This step reports if there is a negative weight cycle in graph. Do following for each edge u-v
 * If dist[v] > dist[u] + weight of edge uv, then “Graph contains negative weight cycle”
 * 
 *
 * =============
 * TC = O(VE)
 *   
 * 
 * 
 */

class Info {

    String parent;
    int weight_from_src;

    Info(String s, int w) {
        this.parent = (s == null) ? null : new String(s);
        this.weight_from_src = w;
    }

}
//  weighted edge U-->V 

class Edge {
    String U;
    String V;
    int weight;

    Edge(String s, String d, int w) {
        this.U = new String(s);
        this.V = new String(d);
        this.weight = w;
    }
}

class p15_bellmanFord {

    static int INFINITY = 1000;

    // ind the non-processed , least weight node
    static int find_min(int[] heap, boolean[] isProcessed) {
        int total_vertices = heap.length;
        int return_idx = -1;
        int min_so_far = Integer.MAX_VALUE;
        for (int i = 0; i < total_vertices; i++) {
            if (isProcessed[i] == false && heap[i] < min_so_far) {
                min_so_far = heap[i];
                return_idx = i;
            }
        }

        return return_idx;
    }

    static void printMst(int[][] graph, int[] parent) {
        System.out.println();
        System.out.println("Edge\t weight");
        int total_vertices = parent.length;
        for (int i = 1; i < total_vertices; i++) {
            System.out.println(parent[i] + "-" + i + "\t" + graph[i][parent[i]]);
        }
    }

    static void bellmanFord(List<Edge> graph, String SRC) {

        int num_of_edges = graph.size();

        Map<String, Info> answer = new HashMap<>();

        //initialize distance of src to each edge as infinite
        // and parent of each node as null
        for (Edge edge : graph) {
            answer.put(edge.U, new Info(null, INFINITY));
            answer.put(edge.V, new Info(null, INFINITY));
        }

        //source is 0 distance from itself
        answer.put(SRC, new Info(null, 0));

        //relax each edge V-1 times
        for (int i = 0; i < num_of_edges; i++) {
            for (Edge edge : graph) {
                int src_to_U = answer.get(edge.U).weight_from_src;
                int src_to_V = answer.get(edge.V).weight_from_src;
                int current_wt = edge.weight;
                if (current_wt + src_to_U < src_to_V) {
                    answer.put(edge.V, new Info(edge.U, current_wt + src_to_U));
                }
            }
        }

        // relax each edge 1 more time 
        // if any weight reduces , it means -ve weight cycle is there
        for (Edge edge : graph) {
            int src_to_U = answer.get(edge.U).weight_from_src;
            int src_to_V = answer.get(edge.V).weight_from_src;
            int current_wt = edge.weight;
            if (current_wt + src_to_U < src_to_V) {
                System.out.println("there is a -ive cycle in the graph");
                return;
            }
        }

        // print distance from src of each node , if no -ive cycle
        System.out.println("there is no -ive cycle in graph");
        for (Map.Entry<String, Info> entry : answer.entrySet()) {
            System.out.println(entry.getKey() + " is at " + entry.getValue().weight_from_src + "   from " + SRC);
        }

    }

    public static void main(String[] args) {

        // the graph is represented as an array of edges
        List<Edge> graph = new ArrayList<Edge>();

        //graph without -ive cycle
        // graph.add(new Edge("a", "b", -1));
        // graph.add(new Edge("a", "c", 4));
        // graph.add(new Edge("b", "c", 3));
        // graph.add(new Edge("b", "d", 2));
        // graph.add(new Edge("b", "e", 2));
        // graph.add(new Edge("d", "c", 5));
        // graph.add(new Edge("d", "b", 1));
        // graph.add(new Edge("e", "d", -3));

        //graph with -ive cycle
        graph.add(new Edge("a", "b", 1));
        graph.add(new Edge("b", "c", 2));
        graph.add(new Edge("c", "a", -13));

        String source = "a";
        bellmanFord(graph, source);
    }

}
