import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
 *
 * 
 * find MST using kruskal's algo
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
 * https://www.youtube.com/watch?v=6j-vHQMXXiA&ab_channel=CodingNinjas
 * 
 *
 * NOTE :
 * 1. kruskal's algo is a greedy algo
 * 2. MST can only be found for a connected graph
 * 
 * 
 * algo : 
 * 1. sort the edges based on increasing edge weights
 * 2. scan edges one by one untill we have included (nodes-1) edges in MST
 * 
 * 3. the condition to be included in MST is : current edge must not cause a cycle
 * ie. parent of src,dst of current edge must be different
 * initially all nodes are parent of itself (ie. belong to same set)
 * 
 * 4. after inclusion of an edge in MST , update 
 *      a. parent of src =  parent of dest , OR
 *      b. parent of dst =  parent of src , OR
 *  
 * 
 *   
 * 
 * 
 */

class Edge implements Comparable<Edge> {

    int from;
    int to;
    int weight;

    Edge(int f, int t, int w) {
        this.from = f;
        this.to = t;
        this.weight = w;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }

}

class p10_kruskal_mst {

    public static void main(String[] args) {
        Kruskal_directed_graph_using_adj_list.driver();
    }
}

class Kruskal_directed_graph_using_adj_list {

    static void driver() {

        Edge[] edges = { new Edge(0, 1, 10), new Edge(0, 2, 6), new Edge(0, 3, 5), new Edge(1, 3, 15),
                new Edge(2, 3, 4) };

        int nodes = 4;
        kruskals(edges, nodes);
    }

    static void kruskals(Edge[] edges_arr, int num_nodes) {

        Arrays.sort(edges_arr);

        int[] parent = new int[num_nodes];
        int edges_left_for_mst = num_nodes - 1;
        int i = 0;

        List<Edge> MST = new ArrayList<>();

        //initially every node is parent of itself
        for (int k = 0; k < num_nodes; k++) {
            parent[k] = k;
        }

        while (edges_left_for_mst > 0) {

            Edge cur_edge = edges_arr[i];

            int parent_of_src = find_parent(cur_edge.from, parent);
            int parent_of_dst = find_parent(cur_edge.to, parent);

            //condition for current edge to be included SAFELY in MST
            if (parent_of_dst != parent_of_src) {
                edges_left_for_mst--;
                parent[parent_of_dst] = parent_of_src; //mandatory updation
                MST.add(cur_edge);
            }

            i++;

        }

        print_min_mst(MST);

    }

    static int find_parent(int query_vertex, int[] parent) {
        if (parent[query_vertex] == query_vertex) {
            return query_vertex;
        }
        return find_parent(parent[query_vertex], parent);
    }

    static void print_min_mst(List<Edge> mst) {
        for (Edge e : mst) {
            System.out.println(e.from + " - " + e.to + " : " + e.weight);
        }
    }

}