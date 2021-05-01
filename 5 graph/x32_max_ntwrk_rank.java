import java.util.*;

/**
 * 
 * leetcode id : 1615
 * 
 * There is an infrastructure of n cities with some number of roads connecting these cities. 
 * 
 * Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.
 * 
 * The network rank of two different cities is defined as the total number of directly connected roads to either city. 
 * 
 * If a road is directly connected to both cities, it is only counted once.
 * 
 * The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
 * 
 * Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
 * 
 * 
 * 
 * =========
 * example : 
 * =========
 * 
 * Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * Output: 4
 * 
 * Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are connected to either 0 or 1. 
 * The road between 0 and 1 is only counted once.
 * 
 */

/**
 * 
 * 
 * ============= 
 * APPROACH : 
 * ============= 
 * 
 * calculate degree of each node
 * and then for each pair (i,j) : find sum of degree 
 * 
 * subract 1 if (i,j) are connected
 * 
 * 
 * 
 */

class x32_max_ntwrk_rank {

    public static void main(String[] args) {

        //expected : 3
        // int n = 4;
        // int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
        // int threshold = 4;

        // int n = 4;
        // int[][] edges = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };

        int n=8;
        int[][] edges = {{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};

        int answer = new Solution().function(n, edges);
        System.out.println(answer);
    }

}

class Solution {

    int function(int n, int[][] edges) {
        int[] degree = new int[n];
        Set<String> dir = new HashSet<>();
        for (int[] e : edges) {
            degree[e[0]]++;
            degree[e[1]]++;

            dir.add(e[0] + "-" + e[1]);
            dir.add(e[1] + "-" + e[0]);
        }

        int _max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // int ans=
                int here = degree[i] + degree[j];
                if (dir.contains(i + "-" + j) || dir.contains(j + "-" + i)) {
                    here = here - 1;
                }
                _max = Math.max(_max, here);
            }
        }

        return _max;

    }
}
