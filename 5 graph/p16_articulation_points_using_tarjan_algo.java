import java.util.*;

/**
 *
 * https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
 * 
 * given an un-directed graph , find all articulation points or cut vertices
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
 * https://www.youtube.com/watch?v=64KK9K4RpKE&ab_channel=TECHDOSE
 * 
 * a node can be a cut vertex if is satisfies 1 of the 2 below :
 * 
 * 1. it is a root vertex of DFS tree , having atleast 2 children sub graphs
 * 2. it is non-root vertex (n) , having atleast 1 child (x), such that low(x) >= disc(n)
 * 
 *   
 * 
 * 
 */

class p16_articulation_points_using_tarjan_algo {

    public static void main(String[] args) {
        Solution.driver();
    }
}

class Node_Info {
    int low;
    int discovery;
    int children;
    Integer parent;
    boolean is_cut_vertex;
    boolean on_stack;

    Node_Info(int l, int d, int c, Integer p, boolean is_cut, boolean is_on_stk) {
        low = l;
        discovery = d;
        children = c;
        parent = p;
        is_cut_vertex = is_cut;
        on_stack = is_on_stk;
    }
}

class Solution {

    static int TIMER;

    static void driver() {
        ArrayList<ArrayList<Integer>> graph = get_graph();
        int nodes = graph.size();
        List<Integer> answer = find_cut_vertices_using_tarjan(nodes, graph);
        System.out.print("articulation vertices are : ");
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static ArrayList<ArrayList<Integer>> get_graph() {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        // undirected graph with 2 nodes : expected cut vertices : 1
        // graph.add(new ArrayList<Integer>(Arrays.asList(1))); //neighbours of 0 (undirected - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(0, 2))); //neighbours of 1 (undirected - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(1))); //neighbours of 2 (undirected - edge)

        // undirected graph with 5 nodes : expected cut vertices : 0,3
        graph.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3))); //neighbours of 0 (undirected - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(0, 2))); //neighbours of 1 (undirected - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(0, 1))); //neighbours of 2 (undirected - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(0, 4))); //neighbours of 3 (undirected - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(3))); //neighbours of 4 (undirected - edge)

        return graph;
    }

    static List<Integer> find_cut_vertices_using_tarjan(int num_nodes, ArrayList<ArrayList<Integer>> graph) {

        Node_Info[] info = new Node_Info[num_nodes];

        //initially no node is discovered , all have 0 child sub components
        for (int i = 0; i < num_nodes; i++) {
            info[i] = new Node_Info(Integer.MAX_VALUE, -1, 0, null, false, false);
        }

        TIMER = -1;
        List<Integer> cut_vertices = new LinkedList<>();

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < num_nodes; i++) {
            boolean visited = info[i].discovery != -1;
            if (!visited) {
                dfs(i, null, graph, info, stk, cut_vertices);
            }
        }

        //retreive all cut vertices
        for (int i = 0; i < num_nodes; i++) {
            if (info[i].is_cut_vertex) {
                cut_vertices.add(i);
            }
        }

        return cut_vertices;
    }

    static void dfs(int curr, Integer parent, ArrayList<ArrayList<Integer>> graph, Node_Info[] info, Stack<Integer> stk,
            List<Integer> cut_vertices) {

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
                info[curr].children++;
                dfs(ngbr, curr, graph, info, stk, cut_vertices);
                info[curr].low = Math.min(info[curr].low, info[ngbr].low);
            }

            else if (is_back_edge && !is_cross_edge) {
                info[curr].low = Math.min(info[curr].low, info[ngbr].discovery);
            }

        }

        //CASE-1 : for root of the DFS tree , having atleast 2 children
        if (info[curr].parent == null && info[curr].children > 1) {
            info[curr].is_cut_vertex = true;
        }

        //CASE-2 : for non-root vertices , we check if any child of current node
        //has low >= curr's discovery
        //it means if curr is removed , can the child node still reach an ancestor of current node
        //if yes : then curr node is NOT a cut-vertex
        if (info[curr].parent != null) {
            for (Integer ngbr : graph.get(curr)) {
                //for all children of curr
                if (info[ngbr].parent != null && info[ngbr].parent == curr) {
                    if (info[ngbr].low >= info[curr].discovery) {
                        info[curr].is_cut_vertex = true;
                    }
                }
            }
        }

        //remove from stack
        info[curr].on_stack = false;
        stk.pop();

    }

}