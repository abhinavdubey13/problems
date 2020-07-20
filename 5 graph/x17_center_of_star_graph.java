import java.util.*;

/**
 * 
 * leetcode id : 1791
 * 
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. 
 * 
 * A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
 * 
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. 
 * 
 * Return the center of the given star graph.
 * 
 */

/**
 * 
 * 
 * =============
 * APPROACH : 
 * =============
 * 
 * maintain a map of degress
 * 
 * the node whose degree = n-1 will be the center
 * 
 *
 * 
 */

class x17_center_of_star_graph {

    public static void main(String[] args) {

       

    }

}

class Solution {

    static int function(int[][] edges) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            map.put(u, 1 + map.getOrDefault(u, 0));
            map.put(v, 1 + map.getOrDefault(v, 0));
        }

        int center = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() == map.size() - 1) {
                center = entry.getKey();
            }
        }

        return center;
    }

}