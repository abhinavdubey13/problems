import java.util.*;

/**
 * 
 * 
 * Given an directed graph having A nodes labelled from 1 to A 
 * 
 * containing M edges given by matrix B of size M x 2such that there is a edge directed from node
 * B[i][0] to node B[i][1].
 * 
 * 
 * Find whether a path exists from node 1 to node A.
 * Return 1 if path exists else return 0.
 * 
 * NOTE:
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * 
 *
 *
 * 
 */

/**
 * 
 * 
 * convert edge list to adjacency list and the perform simple BFS
 *
 * 
 */

public class ib1_bfs_using_edges {

    public static void main(String[] args) {
        BFS_edge.driver_function();

    }

}

class BFS_edge {

    static void driver_function() {

        ArrayList<ArrayList<Integer>> edge_list = new ArrayList<ArrayList<Integer>>();

        //expected : true
        // edge_list.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        // edge_list.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        // edge_list.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        // edge_list.add(new ArrayList<Integer>(Arrays.asList(4, 5)));

        //expected : false
        edge_list.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        edge_list.add(new ArrayList<Integer>(Arrays.asList(4, 1)));
        edge_list.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
        edge_list.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        edge_list.add(new ArrayList<Integer>(Arrays.asList(5, 2)));
        edge_list.add(new ArrayList<Integer>(Arrays.asList(1, 3)));

        boolean answer = bfs(5, edge_list);

        System.out.println(answer);
    }

    static boolean bfs(int num_nodes, ArrayList<ArrayList<Integer>> edge_list) {

        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < num_nodes; i++) {
            adj_list.add(new ArrayList<>());
        }

        for (int i = 0; i < edge_list.size(); i++) {
            int from = edge_list.get(i).get(0) - 1;
            int to = edge_list.get(i).get(1) - 1;
            adj_list.get(from).add(to);
        }

        return fun(num_nodes, adj_list);

        // return false;
    }

    static boolean fun(int num_nodes, ArrayList<ArrayList<Integer>> adj_list) {

        ArrayList<Integer> bfs = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[num_nodes];

        q.add(0);
        visited[0] = true;

        while (q.size() > 0) {

            int front = q.poll();
            bfs.add(front);

            //we cannot add visited[n] = true here , it will cause wrong o/p

            ArrayList<Integer> neighbours = adj_list.get(front);

            for (Integer n : neighbours) {
                if (!visited[n]) {
                    q.add(n);
                    visited[n] = true; //must be placed here only
                }
            }

        }

        return visited[num_nodes - 1];

    }

}