
import java.util.*;

/**
 *
 * leetcode id : 886
 * 
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * 
 * Each person may dislike some other people, and they should not go into the same group. 
 * 
 * formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 * 
 * Return true if and only if it is possible to split everyone into two groups in this way
 *
 * 
 * =========
 * example :
 * =========
 *
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
 * 
 * back tracking
 * 
 * 
 */

class x36_possible_bipartition {

    public static void main(String[] args) {

        //expected : true
        // int n = 4;
        // int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 }

        //expecred : true
        int n = 10;
        int[][] dislikes = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 6, 7 }, { 8, 9 }, { 7, 8 } };

        boolean answer = new Solution().function(n, dislikes);

        System.out.println(answer);
    }

}

class Solution {

    public boolean function(int N, int[][] dislikes) {
        int[] color = new int[N + 1];
        List<List<Integer>> adj = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++)
            adj.add(new ArrayList<Integer>());
        for (int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }

        for (int i = 1; i <= N; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int nb : adj.get(cur)) {
                        if (color[nb] == 0) {
                            color[nb] = color[cur] == 1 ? 2 : 1;
                            q.add(nb);
                        } else {
                            if (color[nb] == color[cur])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}