import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/ 
 * 
 * 
 * Given a 2D screen and location of a pixel in the screen and a new color, 
 * 
 * replace color of the given pixel and all adjacent same colored pixels with the given color.
 * 
 * 
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
 * This problem can be done using BFS and DFS 
 * 
 * here we have done BFS approach
 *
 * 
 * 
 */

class Queue_helper {
    int x;
    int y;

    Queue_helper(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class p12_flood_fill {

    public static void main(String[] args) {

        int[][] graph = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 }, { 1, 0, 0, 1, 1, 0, 1, 1 },
                { 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 2, 2, 0 },
                { 1, 1, 1, 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1, 2, 2, 1 } };

        int init_x = 4;
        int init_y = 4;
        int new_color = 3;
        Flood_fill_BFS.function(init_x, init_y, new_color, graph);
    }
}

class Flood_fill_BFS {

    static int[] x_ngbr = { 0, 0, 1, -1 };
    static int[] y_ngbr = { 1, -1, 0, 0 };

    static void function(int init_x, int init_y, int new_clr, int[][] graph) {

        int rows = graph.length;
        int cols = graph[0].length;
        print_graph(rows, cols, graph);

        int old_clr = graph[init_x][init_y];

        Queue<Queue_helper> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();


        q.add(new Queue_helper(init_x, init_y));
        visited.add(init_x + "" + init_y);
        graph[init_x][init_y] = new_clr;


        while (q.size() > 0) {
            Queue_helper popped = q.poll();

            for (int i = 0; i < x_ngbr.length; i++) {
                int nx = popped.x + x_ngbr[i]; //neighbour's x
                int ny = popped.y + y_ngbr[i]; //neighbour's y
                String key = nx + "" + ny;
                boolean safe = is_safe_xy(nx, ny, rows, cols);

                if (safe && !visited.contains(key) && graph[nx][ny] == old_clr) {
                    q.add(new Queue_helper(nx, ny));
                    visited.add(key);
                    graph[nx][ny] = new_clr;
                }
            }
        }

        System.out.println("~~~~~~~~~");
        print_graph(rows, cols, graph);

    }

    static void print_graph(int r, int c, int[][] graph) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean is_safe_xy(int x, int y, int rows, int cols) {
        return (x >= 0 && x < rows && y >= 0 && y < cols);
    }

}