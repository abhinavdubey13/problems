import java.util.*;

// Template to perform DFS on graphs and matrix

/**
 * 
 * Problem : 
 * 
 * Given a un-directed graph. 
 * 
 * The task is to do DFS of this graph starting from 0.
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
 * using recursion stack
 *
 * ==============
 * TC = O(v+e) : 
 * 
 * every edge is considered exactly twice, and every node is processed exactly once, 
 * so the complexity has to be a constant multiple of the number of edges as well as the number of vertices.
 * 
 * 
 * SC = O(v) : 
 * array of visited nodes , 
 * plus recursion stack , all nodes can be there , if graph is straight line
 * 
 * 
 * 
 * 
 * ==============TEST CODE===================
 * int i=0;
 * for(ArrayList<Integer>ll:adj){
 * System.out.print("neighbours of " + i++ + " : ");
 * for(Integer l :ll){
 * System.out.print(l+" ");}
 * System.out.println();}
 * return false;
 * 
 * ==============================================
 * 
 */

public class p2_DFS {

    public static void main(String[] args) {
        // DFS_adjacency_list.driver_function();
        DFS_matrix.driver_function();
    }

}

class DFS_adjacency_list {

    static void driver_function() {

        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();

        // graph with 5 nodes : expected 0 1 2 4 3
        adj_list.add(new ArrayList<Integer>(Arrays.asList(1, 2, 4))); //neighbours of 0 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 1 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 2 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 3 (undirected - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(3))); //neighbours of 4 (undirected - edge)
        ArrayList<Integer> answer = dfs_util(5, adj_list);

        // graph with 10 nodes : expected 0 1 2 3 4 5 6 7 8 9
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7))); //neighbours of 0 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 7, 8))); //neighbours of 1 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(3, 5, 7, 8, 9))); //neighbours of 2 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(4, 7, 8, 9))); //neighbours of 3 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(5))); //neighbours of 4 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(7, 9)));//neighbours of 5 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(8)));//neighbours of 6 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList()));//neighbours of 7 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(9)));//neighbours of 8 (undirected - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList()));//neighbours of 9 (undirected - edge)
        // ArrayList<Integer> answer = dfs_util(10, adj_list);

        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static ArrayList<Integer> dfs_util(int num_nodes, ArrayList<ArrayList<Integer>> adj_list) {
        ArrayList<Integer> dfs = new ArrayList<>();
        if (num_nodes == 0) {
            return dfs;
        }
        boolean[] visited = new boolean[num_nodes];
        visited[0] = true;
        dfs(adj_list, 0, dfs, visited);
        return dfs;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj_list, int current, List<Integer> dfs_seq, boolean[] visited) {
        dfs_seq.add(current);
        ArrayList<Integer> neighbours = adj_list.get(current);
        for (Integer n : neighbours) {
            if (!visited[n]) {
                visited[n] = true;
                dfs(adj_list, n, dfs_seq, visited);
            }
        }
    }

}

class DFS_matrix {

    static int[] x_neighbours = { 0, 0, -1, 1 };
    static int[] y_neighbours = { 1, -1, 0, 0 };

    //given mxn matrix , print in DFS order
    static void driver_function() {

        // 3x3 matrix
        int[][] graph = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // 3x5 matrix
        // int[][] graph = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };

        ArrayList<Integer> answer = dfs_util(graph);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static ArrayList<Integer> dfs_util(int[][] graph) {

        int rows = graph.length;
        int cols = graph[0].length;

        ArrayList<Integer> dfs_seq = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];

        visited[0][0] = true;

        dfs(graph, dfs_seq, 0, 0, visited);
        return dfs_seq;

    }

    static void dfs(int[][] graph, ArrayList<Integer> dfs_seq, int curr_x, int curr_y, boolean[][] visited) {

        dfs_seq.add(graph[curr_x][curr_y]);

        for (int i = 0; i < x_neighbours.length; i++) {
            int next_x = curr_x + x_neighbours[i];
            int next_y = curr_y + y_neighbours[i];

            boolean is_valid_ngbhr = is_valid_cordinate(graph.length, graph[0].length, next_x, next_y);

            if (is_valid_ngbhr && !visited[next_x][next_y]) {
                visited[next_x][next_y] = true;
                dfs(graph, dfs_seq, next_x, next_y, visited);
            }
        }

    }

    //to check if (x,y) is valid
    static boolean is_valid_cordinate(int rows, int cols, int x, int y) {
        return (x >= 0 && x < rows && y >= 0 && y < cols);
    }

}