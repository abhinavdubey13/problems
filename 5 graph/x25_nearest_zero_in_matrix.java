import java.util.*;

/**
 * 
 * leetcode id : 542
 * 
 * 
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * 
 * The distance between two adjacent-cells(top,down,left,right) is 1
 * 
 * 
 */

/**
 * 
 * 
 * =============
 * APPROACH : 
 * =============
 * 
 * BFS ,
 * visited set ,  
 * distance variable
 *
 * 
 */

class x25_nearest_zero_in_matrix {

    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

        int[][] answer = new Solution().function(board);

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

    }

}

class Cords {
    int x;
    int y;

    Cords(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    int[] x_ngbr = { -1, 1, 0, 0 };
    int[] y_ngbr = { 0, 0, -1, 1 };

    int[][] function(int[][] board) {

        int R = board.length;
        int C = board[0].length;

        Set<String> vis = new HashSet<>();
        Queue<Cords> q = new LinkedList<>();
        int[][] answer = new int[R][C];

        //collect all 0 cells initially
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 0) {
                    q.offer(new Cords(i, j));
                    vis.add(i + "@" + j);
                }
            }
        }

        int dist = 0;

        //BFS logic
        while (q.size() > 0) {

            int n = q.size();
            for (int i = 0; i < n; i++) {
                Cords pollled = q.poll();

                answer[pollled.x][pollled.y] = dist;

                for (int j = 0; j < x_ngbr.length; j++) {
                    int nx = pollled.x + x_ngbr[j];
                    int ny = pollled.y + y_ngbr[j];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !vis.contains(nx + "@" + ny)) {
                        q.add(new Cords(nx, ny));
                        vis.add(nx + "@" + ny);
                    }
                }

            }

            dist++;

        }

        return answer;

    }

}
