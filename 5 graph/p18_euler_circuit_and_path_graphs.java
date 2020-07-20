import java.util.*;

/**
 *
 *
 * ================================
 * Euler Circuit/cycle in a graph :
 * ================================
 * 1. all vertices with non-zero degree are connected
 * (ie. if we have a forest , all edges must be present in 1 component & all other components must be single vertices ONLY)
 * 
 * 2. visit each edge of the graph exactly 1 time
 * 3. start and end at same vertex
 * 
 * NOTE : point 2 and 3 can be combined to ===> ALL VERTICES HAVE EVEN DEGREE
 * 
 * 
 * 
 * 
 * =================================
 * Euler path /  semi-euler graph : 
 * =================================
 * 
 * 1. same as 1.  above
 * 2. same as 2. above
 * 
 * NOTE : here starting and ending need not be same , so we can say ==> EXACTLY 2 VERTICES WITH ODD DEGREE
 * 
 * 
 * 
 * 
 * ==================================
 * Logic behind even degree of nodes 
 * ==================================
 * if we reach a node by an edge , there should be another edge to allow us to leave that vetex
 * ie. entry and exit edges must for pair
 * 
 * 
 *
 * 
 *
 *  
 */

/**
 * 
 * ===========
 * approach : 
 * ===========
 * 
 * STEP-1 : check if all edges are in 1 component only (usig DFS)
 *        : if no  : we cannot have euler-path or euler-circuit
 *        : if yes : we can proceed with step 2
 * 
 * STEP-2 : check the degee of each vertex
 *        : if all vertices have EVEN degee ==> euler circuit
 *        : elseif 2 vertices with odd degree   ==> euler path
 *        : else neither euler-path nor euler-circuit
 * 
 * 
 * 
 */

class p18_euler_circuit_and_path_graphs {

    public static void main(String[] args) {
        Solution.driver();
    }
}

class Solution {

    static void driver() {
        ArrayList<ArrayList<Integer>> graph = get_graph();
        int nodes = graph.size();
        int answer = check_euler(nodes, graph);

        if (answer == 1) {
            System.out.println("Euler circuit");
        } else if (answer == 2) {
            System.out.println("Euler path");
        } else {
            System.out.println("None");
        }

    }

    static ArrayList<ArrayList<Integer>> get_graph() {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        //graph with no edges : euler circuit
        // graph.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 0 (undirected - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 1 (undirected - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 2 (undirected - edge)

        // //complete graph with 3 vertices : euler circuit
        // graph.add(new ArrayList<Integer>(Arrays.asList(1,2))); //neighbours of 0 (undirected - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(0,2))); //neighbours of 1 (undirected - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(0,1))); //neighbours of 2 (undirected - edge)

        //graph with 3 vertices : V shaped : euler path
        graph.add(new ArrayList<Integer>(Arrays.asList(1))); //neighbours of 0 (undirected - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(0, 2))); //neighbours of 1 (undirected - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(1))); //neighbours of 2 (undirected - edge)

        return graph;
    }

    static int check_euler(int num_nodes, ArrayList<ArrayList<Integer>> graph) {

        boolean all_edges_together = check_1(num_nodes, graph);

        if (!all_edges_together) {
            return 3;
        }

        int even_degree_nodes = 0;
        int odd_degree_nodes = 0;

        for (int i = 0; i < num_nodes; i++) {
            if (graph.get(i).size() % 2 == 0) {
                even_degree_nodes++;
            } else {
                odd_degree_nodes++;
            }
        }

        if (even_degree_nodes == num_nodes) {
            return 1;
        } else if (odd_degree_nodes == 2) {
            return 2;
        } else {
            return 3;
        }

    }

    static boolean check_1(int num_nodes, ArrayList<ArrayList<Integer>> graph) {

        boolean[] visited = new boolean[num_nodes];
        Arrays.fill(visited, false);

        //find a verted with non-zero degee to begin the DFS
        //perform DFS with 1st node having non-zero degree , and break out of the loop
        for (int i = 0; i < num_nodes; i++) {
            if (graph.get(i).size() > 0) {
                dfs(i, visited, graph);
                break;
            }
        }

        //if any un-visited vertex has non-zero degree , then we have forest with scattered edges
        //thus we cannot have euler path or euler cycle
        for (int i = 0; i < num_nodes; i++) {
            if (!visited[i] && graph.get(i).size() > 0) {
                return false;
            }
        }

        return true;
    }

    static void dfs(int curr, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        visited[curr] = true;
        for (Integer ngbr : graph.get(curr)) {
            if (!visited[ngbr]) {
                dfs(ngbr, visited, graph);
            }
        }
    }

}