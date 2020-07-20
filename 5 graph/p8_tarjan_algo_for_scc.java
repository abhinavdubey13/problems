import java.util.*;

/**
 *
 * https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/
 * 
 * find number of Strongly connected components in a directed graph
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
 * 1. https://www.youtube.com/watch?v=wUgWX0nc4NY&t=9s&ab_channel=WilliamFiset
 * 
 * 2. https://www.youtube.com/watch?v=ZeDNSeilf-Y&t=1494s&ab_channel=TECHDOSE
 * 
 * 3. https://www.youtube.com/watch?v=trvJsdNCEVA&ab_channel=KashishMehndiratta
 * 
 * 
 * graph = a tree with cross-edge and back edge (...ref 3)
 * 
 * for tree edge   : low[i] = min(low[i], low[j])           ===> on back-tracking
 * for back edge   : low[i] = min(low[i] , discovery[j])    ===> on confirming a back-edge
 * for cross edge  : do nothing
 *  
 * 
 * 
 * low : represents the minimum reachable discovery time , with atmost 1 back edge
 * 
 *   
 * 
 * 
 */

class p8_tarjan_algo_for_scc {

    public static void main(String[] args) {
        // Tarjan.driver();
        Revise.driver();
    }
}

class Tarjan {

    static void driver() {
        ArrayList<ArrayList<Integer>> graph = get_graph();
        int nodes = graph.size();
        int answer = find_num_scc_using_tarjan(nodes, graph);
        System.out.println("number of SCC : " + answer);
    }

    static ArrayList<ArrayList<Integer>> get_graph() {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        // // graph with 7 nodes : expected 2
        // graph.add(new ArrayList<Integer>(Arrays.asList(1))); //neighbours of 0 (directed - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(2, 4))); //neighbours of 1 (directed - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(3))); //neighbours of 2 (directed - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(0))); //neighbours of 3 (directed - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(5))); //neighbours of 4 (directed - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(6))); //neighbours of 5 (directed - edge)
        // graph.add(new ArrayList<Integer>(Arrays.asList(4))); //neighbours of 6 (directed - edge)

        // // graph with 11 nodes : expected 5
        graph.add(new ArrayList<Integer>(Arrays.asList(1, 3))); //neighbours of 0 (directed - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(2, 4))); //neighbours of 1 (directed - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(0, 6))); //neighbours of 2 (directed - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(2))); //neighbours of 3 (directed - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(5, 6))); //neighbours of 4 (directed - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(6, 7, 8, 9))); //neighbours of 5 (directed - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(4))); //neighbours of 6 (directed - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(9))); //neighbours of 7 (directed - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(9))); //neighbours of 8 (directed - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList(8))); //neighbours of 9 (directed - edge)
        graph.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 10 (directed - edge)

        return graph;
    }

    static int find_num_scc_using_tarjan(int num_nodes, ArrayList<ArrayList<Integer>> graph) {
        int[] discovery = new int[num_nodes]; //this array is also used as visited 
        int[] low = new int[num_nodes];
        boolean[] onStack = new boolean[num_nodes];
        Stack<Integer> stk = new Stack<>();

        int[] num_scc = { 0 };
        int[] time = { -1 };

        Arrays.fill(discovery, -1); //none of the nodes is discoved/visited in the start : -1 is used to denote it

        for (int i = 0; i < num_nodes; i++) {
            boolean is_visted = discovery[i] != -1;
            if (!is_visted) {
                dfs(i, graph, discovery, low, onStack, stk, time, num_scc);
            }
        }
        return num_scc[0];
    }

    static void dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] disc, int[] low, boolean[] onStack,
            Stack<Integer> stk, int[] time, int[] num_scc) {

        time[0]++;
        disc[curr] = time[0];
        low[curr] = time[0];

        stk.push(curr);
        onStack[curr] = true;

        ArrayList<Integer> nghbrs = graph.get(curr);

        for (Integer v : nghbrs) {
            boolean visited = (disc[v] != -1);

            //tree-edge
            if (!visited) {
                dfs(v, graph, disc, low, onStack, stk, time, num_scc);
                low[curr] = Math.min(low[curr], low[v]);
            }

            //back-edge
            else if (visited && onStack[v]) {
                low[curr] = Math.min(low[curr], disc[v]);
            }

            // cross edge condition : visited && !onStack[v] 
        }

        //head or beginning of a SCC
        if (low[curr] == disc[curr]) {

            num_scc[0]++;

            System.out.print("SCC : ");
            while (stk.size() > 0 && stk.peek() != curr) {
                int popped = stk.pop();
                onStack[popped] = false;
                System.out.print(popped + " ");
            }

            if (stk.size() > 0) {
                int popped = stk.pop();
                onStack[popped] = false;
                System.out.print(popped + " ");
                System.out.println();
            }

        }

    }

}

class Node_Info {
    int low;
    int discovery;
    boolean onStack;

    Node_Info(int l, int d, boolean is) {
        low = l;
        discovery = d;
        onStack = is;
    }
}

class Revise {

    static int TIMER;

    static void driver() {
        ArrayList<ArrayList<Integer>> graph = Tarjan.get_graph();
        int nodes = graph.size();
        int answer = find_num_scc_using_tarjan(nodes, graph);
        System.out.println("number of SCC in revise : " + answer);
    }

    static int find_num_scc_using_tarjan(int num_nodes, ArrayList<ArrayList<Integer>> graph) {

        Node_Info[] info = new Node_Info[num_nodes];

        //initially no node is discovered
        for (int i = 0; i < num_nodes; i++) {
            info[i] = new Node_Info(Integer.MAX_VALUE, -1, false);
        }

        TIMER = -1;
        int[] num_of_scc = { 0 };

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < num_nodes; i++) {
            boolean visited = info[i].discovery != -1;
            if (!visited) {
                dfs(i, graph, info, stk, num_of_scc);
            }
        }

        return num_of_scc[0];
    }

    static void dfs(int curr, ArrayList<ArrayList<Integer>> graph, Node_Info[] info, Stack<Integer> stk,
            int[] num_scc) {

        TIMER++;

        info[curr].onStack = true;
        info[curr].discovery = TIMER;
        info[curr].low = TIMER;
        stk.push(curr);

        for (Integer ngbr : graph.get(curr)) {

            boolean is_tree_edge = (info[ngbr].discovery == -1);

            //if curr --> ngbr is back edge 
            boolean is_back_edge = (info[ngbr].discovery > -1 && info[ngbr].onStack);

            //if curr --> ngbr is cross edge 
            boolean is_cross_edge = (info[ngbr].discovery > -1 && !info[ngbr].onStack);

            if (is_tree_edge) {
                dfs(ngbr, graph, info, stk, num_scc);
                info[curr].low = Math.min(info[curr].low, info[ngbr].low);
            }

            else if (is_back_edge && !is_cross_edge) {
                info[curr].low = Math.min(info[curr].low, info[ngbr].discovery);
            }

        }

        if (info[curr].low == info[curr].discovery) {
            num_scc[0]++;

            System.out.print("SCC : ");
            while (stk.size() > 0 && stk.peek() != curr) {
                int popped = stk.pop();
                info[popped].onStack = false;
                System.out.print(popped + " ");
            }

            if (stk.size() > 0) {
                int popped = stk.pop();
                info[popped].onStack = false;
                System.out.print(popped + " ");
            }
            System.out.println();

        }

    }

}