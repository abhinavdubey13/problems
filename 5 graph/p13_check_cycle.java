import java.util.*;

/**
 * 
 * Problem : 
 * 
 * Given a directed graph. 
 * 
 * Check if there is a cycle in the graph
 * 
 * 
 *
 *
 * 
 */

/**
 * =============
 * APPROACH : 
 * =============
 * 
 * using dfs
 * 
 */

public class p13_check_cycle {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();

        // // graph with 5 nodes : expected true
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(1, 2))); //neighbours of 0 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(2))); //neighbours of 1 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 2 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(0, 4))); //neighbours of 3 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(5))); //neighbours of 4 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(3))); //neighbours of 4 (directed - edge)

        //  // graph with 3 nodes : expected true
        //  adj_list.add(new ArrayList<Integer>(Arrays.asList(1))); //neighbours of 0 (directed - edge)
        //  adj_list.add(new ArrayList<Integer>(Arrays.asList(2))); //neighbours of 1 (directed - edge)
        //  adj_list.add(new ArrayList<Integer>(Arrays.asList(1))); //neighbours of 2 (directed - edge)

        // graph with  5 nodes : expected true
        adj_list.add(new ArrayList<Integer>(Arrays.asList(1, 3))); //neighbours of 0 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(2))); //neighbours of 1 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(1))); //neighbours of 2 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(4))); //neighbours of 2 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 2 (directed - edge)

        int num_nodes = adj_list.size();
        boolean answer = Solution.function(num_nodes, adj_list);
        System.out.println(answer);
    }

}

class Solution {

    static boolean[] atleast_one_edge_leads_to_cycle;
    static boolean[] done_explored;
    static boolean[] on_stack;

    static boolean function(int num_nodes, ArrayList<ArrayList<Integer>> graph) {

        atleast_one_edge_leads_to_cycle = new boolean[num_nodes];
        done_explored = new boolean[num_nodes];
        on_stack = new boolean[num_nodes];

        Arrays.fill(atleast_one_edge_leads_to_cycle, false);
        Arrays.fill(done_explored, false);
        Arrays.fill(on_stack, false);

        for (int i = 0; i < num_nodes; i++) {
            dfs(i, graph);
        }

        //we will get to know which nodes are a part of any cycle
        boolean answer = false;
        for (boolean b : atleast_one_edge_leads_to_cycle) {
            answer = answer | b;
        }
        return answer;

    }

    static boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph) {

        if (done_explored[curr]) {
            return atleast_one_edge_leads_to_cycle[curr];
        }

        //this is the main step , if we reach a node , which is currently being explored , then there is a cycle for sure
        if (on_stack[curr]) {
            return true;
        }

        on_stack[curr] = true;

        for (Integer n : graph.get(curr)) {
            boolean hasCycle = dfs(n, graph);
            if (hasCycle) {
                atleast_one_edge_leads_to_cycle[curr] = true;
                break;
            }
        }

        done_explored[curr] = true;
        on_stack[curr] = false;
        return atleast_one_edge_leads_to_cycle[curr];

    }

}