import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/bipartite-graph/
 * 
 * Check whether a given graph(undirected) is Bipartite or not
 * 
 * A Bipartite Graph is a graph whose vertices can be divided into two independent sets, 
 * U and V such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U. 
 * In other words, for every edge (u, v), either u belongs to U and v to V, 
 * or u belongs to V and v to U. We can also say that there is no edge that connects vertices of same set.
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
 * using BFS
 * maintain 2 set/colors : 0,1
 * 
 * each neighbour of any node i must be :
 * 1. either un-visited , or
 * 2. visited but opposite color
 * 
 *   
 * 
 * 
 */

class p4_check_bipartite {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();

        // connected graph => expected : true
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(1))); //neighbours of 0 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(0, 2))); //neighbours of 1 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 2 (undirected - edge)

        // forest graph => expected : true
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(1))); //neighbours of 0 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(0))); //neighbours of 1 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(3))); //neighbours of 2 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(2))); //neighbours of 3 (undirected - edge)

        // forest graph => expected : false
        adj_list.add(new ArrayList<Integer>(Arrays.asList(2,3))); //neighbours of 0 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(3))); //neighbours of 1 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(0,3))); //neighbours of 2 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(0,1,2))); //neighbours of 3 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(5))); //neighbours of 4 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(4))); //neighbours of 5 (undirected - edge)


        int num_nodes = adj_list.size();
        // boolean answer = Solution_connected_graph.function(num_nodes, adj_list);
        boolean answer = Solution_forest.function_util(num_nodes, adj_list);
        System.out.println(answer);
    }

}

//for connected graph
class Solution_connected_graph {

    static boolean function(int num_nodes, ArrayList<ArrayList<Integer>> adj_list) {

        int[] set = new int[num_nodes];
        boolean[] visited = new boolean[num_nodes];
        Queue<Integer> q = new LinkedList<>();

        Arrays.fill(set, -1);

        q.add(0);
        visited[0] = true;
        set[0] = 0;

        while (q.size() > 0) {
            int curr = q.poll();

            int curr_set = set[curr];

            List<Integer> neighbours = adj_list.get(curr);

            for (Integer n : neighbours) {
                if (visited[n] && set[n] == curr_set) {
                    return false;
                } else if (!visited[n]) {
                    q.add(n);
                    set[n] = 1 - curr_set;
                    visited[n] = true;
                }
            }
        }

        return true;

    }

}

//for connected graph
class Solution_forest {

    static boolean function_util(int num_nodes, ArrayList<ArrayList<Integer>> adj_list) {

        int[] set = new int[num_nodes];
        boolean[] visited = new boolean[num_nodes];

        Arrays.fill(set, -1);

        for (int i = 0; i < num_nodes; i++) {
            if (!visited[i]) {
                visited[i] = true;
                set[0] = 0;
                boolean is_bipartite = function(i, adj_list, visited, set);
                if (!is_bipartite) {
                    return false;
                }
            }
        }
        return true;

    }

    static boolean function(int curr, ArrayList<ArrayList<Integer>> adj_list, boolean[] vis, int[] set) {

        Queue<Integer> q = new LinkedList<>();

        q.add(curr);
        vis[curr] = true;

        while (q.size() > 0) {
            int curr_node = q.poll();

            int curr_set = set[curr_node];

            List<Integer> neighbours = adj_list.get(curr_node);

            for (Integer n : neighbours) {
                if (vis[n] && set[n] == curr_set) {
                    return false;
                } else if (!vis[n]) {
                    q.add(n);
                    set[n] = 1 - curr_set;
                    vis[n] = true;
                }
            }
        }

        return true;

    }

}