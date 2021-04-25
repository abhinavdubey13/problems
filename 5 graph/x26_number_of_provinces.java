import java.util.*;

/**
 * 
 * leetcode id : 547
 * 
 * There are n cities. Some of them are connected, while some are not. 
 * 
 * If city a is connected directly with city b, and city b is connected directly with city c, 
 * then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities ONLY .
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city 
 * and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * 
 * Return the total number of provinces.
 * 
 * 
 * 
 * =========
 * example : 
 * =========
 * 
 * Input: 
 * [
 *  [1,1,0],
 *  [1,1,0],
 *  [0,0,1]
 * ]
 * 
 * Output: 2
 * 
 */

/**
 * 
 * 
 * =============
 * APPROACH : 
 * =============
 * 
 * classical problem to use DSU data structure
 * 
 * 
 * perform union when board[i][j]=1
 * 
 *
 *
 * 
 */

class x26_number_of_provinces {

    public static void main(String[] args) {

        // //expected : 2
        // int[][] board = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        //expected : 3
        int[][] board = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };

        int answer = new Solution().function(board);
        System.out.println(answer);

    }

}

class Solution {

    int function(int[][] board) {

        int N = board.length;

        DSU dsu = new DSU(N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && board[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }


        Set<Integer> hset = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hset.add(dsu.find(i));
        }

        return hset.size();
    }

}

class DSU {
    int n;
    int[] rank;
    int[] parent;

    DSU(int n) {
        this.n = n;
        this.rank = new int[n];
        this.parent = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        } else {
            int px = find(parent[x]);
            parent[x] = px;
            return parent[x];
        }
    }

    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return false;
        }

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[py] < rank[px]) {
            parent[py] = px;
        } else if (rank[px] == rank[py]) {
            parent[py] = px;
            rank[px]++;
        }

        return true;
    }
}