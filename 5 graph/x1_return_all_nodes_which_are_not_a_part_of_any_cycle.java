import java.util.*;

/**
 * 
 * leetcode : 802
 * 
 * Given a directed graph. 
 * 
 * print list of all nodes , which have no edge leading to a cycle
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
 * using dfs , and the problem of finding/detecting the cycle in node done previous (p13)
 * 
 * 
 * 
 * 
 */

public class x1_return_all_nodes_which_are_not_a_part_of_any_cycle {

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
        List<Integer> answer = Solution.function(num_nodes, adj_list);

        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

class Solution {

    static List<Integer> function(int num_nodes, ArrayList<ArrayList<Integer>> graph) {

        boolean[] atleast_one_edge_leads_to_cycle = new boolean[num_nodes];
        boolean[] done_explored = new boolean[num_nodes];
        boolean[] being_explored = new boolean[num_nodes];

        Arrays.fill(atleast_one_edge_leads_to_cycle, false);
        Arrays.fill(done_explored, false);
        Arrays.fill(being_explored, false);

        for (int i = 0; i < num_nodes; i++) {
            dfs(i, graph, atleast_one_edge_leads_to_cycle, done_explored, being_explored);
        }

        //we will get to know which nodes are a part of any cycle
        // boolean answer = false;
        // for (boolean b : atleast_one_edge_leads_to_cycle) {
        //     answer = answer | b;
        // }
        // return answer;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < num_nodes; i++) {
            if (!atleast_one_edge_leads_to_cycle[i]) {
                res.add(i);
            }
        }
        return res;

    }

    static boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, boolean[] atleast_one_edge_leads_to_cycle,
            boolean[] done_explored, boolean[] being_explored) {

        if (done_explored[curr]) {
            return atleast_one_edge_leads_to_cycle[curr];
        }

        //this is the main step , if we reach a node , which is currently being explored , then there is a cycle for sure
        if (being_explored[curr]) {
            return true;
        }

        being_explored[curr] = true;

        for (Integer n : graph.get(curr)) {
            boolean ngbr_has_cycle = dfs(n, graph, atleast_one_edge_leads_to_cycle, done_explored, being_explored);
            if (ngbr_has_cycle) {
                atleast_one_edge_leads_to_cycle[curr] = true;
            }
        }

        done_explored[curr] = true;
        being_explored[curr] = false;
        return atleast_one_edge_leads_to_cycle[curr];

    }

}