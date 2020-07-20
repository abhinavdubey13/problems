import java.util.*;

/**
 *
 * https://practice.geeksforgeeks.org/problems/269f61832b146dd5e6d89b4ca18cbd2a2654ebbe/1/
 * 
 * 
 * she is the head nurse at city hospital. City hospital contains R*C number of wards and structure of hospital is in the form of a 2-D matrix.
 * Given a matrix of dimension R*C where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
 * 0 : Empty ward
 * 1 : Cells have uninfected patients
 * 2 : Cells have infected patients
 * 
 * An infected patient at ward [i,j] can infect other uninfected patient at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] 
 * (up, down, left and right) in 1 unit time. 
 * 
 * Help Aterp determine the minimum units of time after which there won't remain any uninfected patient i.e all patients would be infected. 
 * 
 * If all patients are not infected after infinite units of time then simply return -1.
 * 
 * 
 * ==========
 * example :
 * ==========
 * Input:
 * 2 1 0 2 1
 * 1 0 1 2 1
 * 1 0 0 2 1 
 * 
 * Output: 2
 * 
 * 
 * Input:
 * 2 1 0 2 1
 * 0 0 1 2 1
 * 1 0 0 2 1
 * 
 * Output : -1
 * Explanation : All patients will not be infected.
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
 * using BFS , as all next will be affected in parallel
 * 
 * 
 * 1. get initially infected patients
 * 2. use BFS (queue)
 * 3. scan the helper [][] to check if there is un-infected left at last
 *
 * 
 * 
 *   
 * 
 * 
 */

class p6_virus_spread {

    public static void main(String[] args) {

        //expected = -1
        int[][] graph = { { 2, 1, 0, 2, 1 }, { 0, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };

        //expceted = 2
        // int[][] graph = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };

        int answer = Solution.function(graph);
        System.out.println(answer);
    }

}

class Helper {
    int x;
    int y;
    int time;

    Helper(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.time = t;
    }

}

class Solution {

    static int EMPTY = 0;
    static int UN_INFECTED = 1;
    static int INFECTED = 2;

    static int[] X_NGBHR = { 1, -1, 0, 0 };
    static int[] Y_NGBHR = { 0, 0, 1, -1 };

    static int function(int[][] graph) {

        int rows = graph.length;
        int cols = graph[0].length;

        // boolean[][] vis = new boolean[rows][cols];
        int[][] time = new int[rows][cols];

        Queue<Helper> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (graph[i][j] == INFECTED) {
                    q.add(new Helper(i, j, 0));
                    time[i][j] = 0;
                }
            }
        }

        if (q.size() == 0) {
            return -1;
        }

        while (q.size() > 0) {
            Helper front = q.poll();

            int x = front.x;
            int y = front.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + X_NGBHR[i];
                int ny = y + Y_NGBHR[i];

                // if (is_safe(rows, cols, nx, ny) && !vis[nx][ny] && graph[nx][ny] == 1) {
                if (is_safe(rows, cols, nx, ny) && graph[nx][ny] == UN_INFECTED) {
                    q.add(new Helper(nx, ny, front.time + 1));
                    time[nx][ny] = front.time + 1;
                    graph[nx][ny] = INFECTED;
                    // vis[nx][ny] = true;
                }

            }
        }

        int answer = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (graph[i][j] == UN_INFECTED) {
                    return -1;
                }
                answer = Math.max(answer, time[i][j]);
            }
        }

        return answer;

    }

    static boolean is_safe(int r, int c, int x, int y) {
        return (x >= 0 && x < r && y >= 0 && y < c);
    }

}