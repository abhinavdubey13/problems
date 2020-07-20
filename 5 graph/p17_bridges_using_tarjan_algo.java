import java.util.*;

/**
 *
 *
 * https://www.geeksforgeeks.org/bridge-in-a-graph/
 *  
 * given an un-directed graph , find all bridges 
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
 * https://www.youtube.com/watch?v=Rhxs4k6DyMM&ab_channel=TECHDOSE
 * 
 * similar tot finding articulation points
 * 
 * 
 */

class p17_bridges_using_tarjan_algo {

    public static void main(String[] args) {
        Solution.driver();
    }
}

class Node_Info {
    int low;
    int discovery;
    Integer parent;
    boolean is_cut_vertex;
    boolean on_stack;

    Node_Info(int l, int d, Integer p, boolean is_cut, boolean is_on_stk) {
        low = l;
        discovery = d;
        parent = p;
        is_cut_vertex = is_cut;
        on_stack = is_on_stk;
    }
}

class Bridge {
    int u;
    int v;

    Bridge(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

class Solution {

    static int TIMER;

    static void driver() {
        ArrayList<ArrayList<Integer>> graph = get_graph();
        int nodes = graph.size();
        List<Bridge> answer = find_bridges_using_tarjan(nodes, graph);

        //prinitng answer only
        System.out.println("Bridges are : ");
        for (Bridge b : answer) {
            System.out.println(b.u + "--" + b.v);
        }
        System.out.println();
    }

    static ArrayList<ArrayList<Integer>> get_graph() {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        // // undirected graph with 4 nodes : expected bridges are : 
        // // 2-3 , 1-2 , 0-1
        // graph.add(new ArrayList<Integer>(Arrays.asList(1))); //neighbours of 0 (undirected - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(0, 2))); //neighbours of 1 (undirected - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(1, 3))); //neighbours of 2 (undirected - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(2))); //neighbours of 3 (undirected - edge)

        // undirected graph with 4 nodes : expected bridges are : 
        // 2-3 , 1-2 , 0-1
        graph.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3))); //neighbours of 0 (undirected - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(0, 2))); //neighbours of 1 (undirected - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(0, 1))); //neighbours of 2 (undirected - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(0, 4))); //neighbours of 3 (undirected - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(3))); //neighbours of 4 (undirected - edge)

        return graph;
    }

    static List<Bridge> find_bridges_using_tarjan(int num_nodes, ArrayList<ArrayList<Integer>> graph) {

        Node_Info[] info = new Node_Info[num_nodes];

        //initially no node is discovered , all have 0 child sub components
        for (int i = 0; i < num_nodes; i++) {
            info[i] = new Node_Info(Integer.MAX_VALUE, -1, null, false, false);
        }

        TIMER = -1;

        Stack<Integer> stk = new Stack<>();
        List<Bridge> bridges = new LinkedList<>();
        for (int i = 0; i < num_nodes; i++) {
            boolean visited = info[i].discovery != -1;
            if (!visited) {
                dfs(i, null, graph, info, stk, bridges);
            }
        }

        return bridges;

    }

    static void dfs(int curr, Integer parent, ArrayList<ArrayList<Integer>> graph, Node_Info[] info, Stack<Integer> stk,
            List<Bridge> bridges) {

        TIMER++;

        info[curr].on_stack = true;
        info[curr].discovery = TIMER;
        info[curr].low = TIMER;
        info[curr].parent = parent;
        stk.push(curr);

        for (Integer ngbr : graph.get(curr)) {

            boolean is_tree_edge = (info[ngbr].discovery == -1);

            //if curr --> ngbr is back edge
            //for back edge , we will not consider the immediate parent here 
            boolean is_back_edge = (info[ngbr].discovery > -1 && info[ngbr].on_stack && info[curr].parent != ngbr);

            //if curr --> ngbr is cross edge 
            boolean is_cross_edge = (info[ngbr].discovery > -1 && !info[ngbr].on_stack);

            if (is_tree_edge) {
                dfs(ngbr, curr, graph, info, stk, bridges);
                info[curr].low = Math.min(info[curr].low, info[ngbr].low);
            }

            else if (is_back_edge && !is_cross_edge) {
                info[curr].low = Math.min(info[curr].low, info[ngbr].discovery);
            }

        }

        //finding bridges
        for (Integer ngbr : graph.get(curr)) {
            //for all children of curr
            if (info[ngbr].parent != null && info[ngbr].parent == curr) {

                //strictly greater than , not equal
                if (info[ngbr].low > info[curr].discovery) {
                    bridges.add(new Bridge(curr, ngbr));
                }
            }
        }

        //remove from stack
        info[curr].on_stack = false;
        stk.pop();

    }

}