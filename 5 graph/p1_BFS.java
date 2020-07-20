import java.util.*;

// Template to perform BFS on graphs and matrix

/**
 * 
 * Problem : 
 * 
 * Given a directed graph. 
 * 
 * The task is to do Breadth First Traversal of this graph starting from 0.
 * 
 * Note: One can move from node u to node v only if there's an edge from u to v
 *  
 * find the BFS traversal of the graph starting from the 0th vertex
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
 *
 * ===========
 * TC = O(v+e)
 * 
 * every edge is considered exactly twice, and every node is processed exactly once, 
 * so the complexity has to be a constant multiple of the number of edges as well as the number of vertices.
 * 
 * 
 * SC = O(v)
 * array of visited nodes , 
 * plus recursion stack , all nodes can be there , if graph is star like
 * 
 * 
 * 
 * 
 * 
 * 
 *
 * 
 */

public class p1_BFS {

    public static void main(String[] args) {
        // BFS_adjacency_list.driver_function();

        BFS_matrix.driver_function();

    }

}

class BFS_adjacency_list {

    static void driver_function() {

        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<ArrayList<Integer>>();

        // graph with 5 nodes : expected 0 1 2 3 4
        adj_list.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3))); //neighbours of 0 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 1 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(4))); //neighbours of 2 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 3 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 4 (directed - edge)

        // graph with 10 nodes : expected 0 1 2 3 4 5 6 7 8 9
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7))); //neighbours of 0 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 7, 8))); //neighbours of 1 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(3, 5, 7, 8, 9))); //neighbours of 2 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(4, 7, 8, 9))); //neighbours of 3 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(5))); //neighbours of 4 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(7, 9)));//neighbours of 5 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(8)));//neighbours of 6 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList()));//neighbours of 7 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList(9)));//neighbours of 8 (directed - edge)
        // adj_list.add(new ArrayList<Integer>(Arrays.asList()));//neighbours of 9 (directed - edge)

        ArrayList<Integer> answer = bfs(10, adj_list);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static ArrayList<Integer> bfs(int num_nodes, ArrayList<ArrayList<Integer>> adj_list) {

        ArrayList<Integer> bfs = new ArrayList<>();

        if (num_nodes == 0) {
            return bfs;
        }

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

        return bfs;

    }

}

class BFS_matrix {

    //given mxn matrix , print in BFS order
    static void driver_function() {

        // 3x3 matrix
        // int[][] graph = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // 3x5 matrix
        int[][] graph = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };

        ArrayList<Integer> answer = bfs(graph);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static ArrayList<Integer> bfs(int[][] graph) {

        int rows = graph.length;
        int cols = graph[0].length;

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];
        Queue<String> q = new LinkedList<>();

        int[] x_neighbours = { 0, 0, -1, 1 };
        int[] y_neighbours = { 1, -1, 0, 0 };

        q.add("00");
        visited[0][0] = true;

        while (q.size() > 0) {

            String front = q.poll();
            int curr_x = front.charAt(0) - '0';
            int curr_y = front.charAt(1) - '0';

            bfs.add(graph[curr_x][curr_y]);

            for (int i = 0; i < x_neighbours.length; i++) {
                int next_x = curr_x + x_neighbours[i];
                int next_y = curr_y + y_neighbours[i];

                if (is_valid_cordinate(rows, cols, next_x, next_y) && !visited[next_x][next_y]) {
                    q.add(next_x + "" + next_y);
                    visited[next_x][next_y] = true;
                }
            }
        }

        return bfs;
    }


    //to check if (x,y) is valid
    static boolean is_valid_cordinate(int rows, int cols, int x, int y) {
        return (x >= 0 && x < rows && y >= 0 && y < cols);
    }

}