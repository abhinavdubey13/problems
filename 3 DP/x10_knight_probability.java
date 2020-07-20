import java.util.*;

/**
 * leetcode id : 688  https://leetcode.com/problems/knight-probability-in-chessboard/
 * 
 * 
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. 
 * The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 * 
 * A chess knight has 8 possible moves it can make.
 * 
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
 * 
 * ====================================
 * The knight stops only if :
 * 1. it has made exactly K moves , OR 
 * 2. has moved off the chessboard
 * ====================================
 * 
 * Return the probability that the knight remains on the board after it has stopped moving.
 * 
 * ========
 * Example:
 * ========
 * Input: 3, 2, 0, 0
 * Output: 0.0625
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * 
 * The total probability the knight stays on the board is 0.0625.
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * similar to previous qstn
 * 
 * if currently we are out of chess board , we retunr probality as 0
 * else if we are inside the board with no jumps left , we return 1
 * 
 * 
 * A knight can move 8 different ways in a certain point at the board. Therefore, any result that move 1 step from the current point will contribute 1/8 to the final probability.
 * 
 *
 * 
 * ============
 * TC = 
 * SC = 
 * 
 * 
 * 
 */

class x10_knight_probability {

    public static void main(String[] args) {
        int n = 3;
        int jumps = 2;
        int r = 0;
        int c = 0;

        double answer = function(n, jumps, r, c);
        System.out.println(answer);
    }

    static double function(int N, int jumps, int r, int c) {
        Map<String, Double> dp = new HashMap<>();
        return paths(N, r, c, jumps, dp);
    }

    static double paths(int N, int row, int col, int jumps_left, Map<String, Double> dp) {

        if (row < 0 || row >= N || col < 0 || col >= N) {
            return 0.0;
        }

        //trivial case
        if (jumps_left == 0) {
            return 1.0;
        }

        String key = row + "_" + col + "_" + jumps_left;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        //non trivial case
        double probability = ((paths(N, row - 2, col + 1, jumps_left - 1, dp))
                + paths(N, row - 2, col - 1, jumps_left - 1, dp) + paths(N, row - 1, col + 2, jumps_left - 1, dp)
                + paths(N, row - 1, col - 2, jumps_left - 1, dp) + paths(N, row + 1, col - 2, jumps_left - 1, dp)
                + paths(N, row + 1, col + 2, jumps_left - 1, dp) + paths(N, row + 2, col - 1, jumps_left - 1, dp)
                + paths(N, row + 2, col + 1, jumps_left - 1, dp));

        //this is important
        probability = (0.125) * probability;

        //update dp map
        dp.put(key, probability);
        return probability;

    }

}
