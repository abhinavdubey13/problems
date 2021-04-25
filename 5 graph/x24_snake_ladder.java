import java.util.*;

/**
 * 
 * leetcode id : 909
 * 
 * 
 * On an N x N board, the numbers from 1 to N*N are written boustrophedonically 
 * starting from the bottom left of the board, and alternating direction each row.  
 * For example, for a 6 x 6 board, the numbers are written as follows:
 * 
 * 
 * 
 * You start on square 1 of the board (which is always in the last row and first column).  
 * Each move, starting from square x, consists of the following:
 * You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, 
 * provided this number is <= N*N.
 * 
 * (This choice simulates the result of a standard 6-sided die roll: ie., 
 * there are always at most 6 destinations, regardless of the size of the board.)
 * If S has a snake or ladder, you move to the destination of that snake or ladder.  
 * Otherwise, you move to S.
 * A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  
 * The destination of that snake or ladder is board[r][c].
 * 
 * 
 * 
 * 
 * 
 * Note that you only take a snake or ladder at most once per move: 
 * if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.  (For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not continue moving to `4`.
 * 
 * Return the least number of moves required to reach square N*N.  If it is not possible, return -1
 * 
 */

/**
 * 
 * 
 * =============
 * APPROACH : 
 * =============
 * 
 * 
 * using BFS
 * 
 *
 * 
 */

class x24_snake_ladder {

    public static void main(String[] args) {
        int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };

        int answer = Solution.function(board);
        System.out.println(answer);
    }

}

class Q_helper {
    int sq_num;
    int steps;

    Q_helper(int s, int steps) {
        this.sq_num = s;
        this.steps = steps;
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

    static int function(int[][] board) {

        int N = board.length;
        int MIN_STEPS = Integer.MAX_VALUE;
        Map<Integer, Cords> hmap = new HashMap<>();
        Queue<Q_helper> q = new LinkedList<>();
        boolean[] vis = new boolean[N * N + 1];

        //these are only used to map square number to cell cordinates
        int temp_x = N - 1; //last row
        int temp_y = 0;//0th column
        boolean go_right = true;

        for (int i = 1; i <= N * N; i++) {
            hmap.put(i, new Cords(temp_x, temp_y));

            if (go_right) {
                temp_y++;
                if (temp_y == N) {
                    go_right = false;
                    temp_x--;
                    temp_y = N - 1;
                }
            }

            else {
                temp_y--;
                if (temp_y == -1) {
                    go_right = true;
                    temp_x--;
                    temp_y = 0;
                }

            }
        }

        //start BFS logic
        q.add(new Q_helper(1, 0));
        vis[0] = true;
        vis[1] = true;

        while (q.size() > 0) {
            Q_helper polled = q.poll();

            for (int i = 1; i <= 6; i++) {

                int next_sq_num = polled.sq_num + i;

                if (next_sq_num < N * N) {
                    Cords c = hmap.get(next_sq_num);
                    int board_val = board[c.x][c.y];

                    //normal cell
                    if (board_val == -1 && !vis[next_sq_num]) {
                        q.offer(new Q_helper(next_sq_num, polled.steps + 1));
                        vis[next_sq_num] = true;

                    }

                    //snake or ladder cell
                    else if (board_val != N * N && !vis[next_sq_num]) {
                        q.offer(new Q_helper(board_val, polled.steps + 1));
                        vis[next_sq_num] = true;

                    }

                    else if (board_val == N * N && !vis[next_sq_num]) {
                        MIN_STEPS = Math.min(MIN_STEPS, polled.steps + 1);
                        vis[next_sq_num] = true;
                    }
                }

                else if (next_sq_num == N * N && !vis[next_sq_num]) {
                    MIN_STEPS = Math.min(MIN_STEPS, polled.steps + 1);
                    vis[next_sq_num] = true;
                }

            }
        }

        return (MIN_STEPS == Integer.MAX_VALUE) ? -1 : MIN_STEPS;
    }

}
