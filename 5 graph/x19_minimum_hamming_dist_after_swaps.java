import java.util.*;

/**
 * 
 * leetcode id : 1722
 * 
 * 
 * You are given two integer arrays, source and target, both of length n. 
 * You are also given an array allowedSwaps where each 
 * allowedSwaps[i] = [ai, bi] indicates that you are allowed to swap the elements at index ai and index bi 
 * (0-indexed) of array source. 
 * 
 * 
 * Note that you can swap elements at a specific pair of indices multiple times and in any order.
 * 
 * The Hamming distance of two arrays of the same length, source and target, 
 * is the number of positions where the elements are different. 
 * Formally, it is the number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed).
 * 
 * 
 * Return the minimum Hamming distance of source and target 
 * after performing any amount of swap operations on array source.
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
 * disjoint sets
 * 
 * 
 * 1. The source array can be imagined as a graph 
 * where each index is a node and each allowedSwaps[i] is an edge.
 * 
 * 2. Nodes within the same component can be freely swapped with each other.
 * 
 * 3. For each component, find the number of common elements. 
 * The elements that are not in common will contribute to the total Hamming distance.
 *
 *
 * 
 */

class x19_minimum_hamming_dist_after_swaps {

    public static void main(String[] args) {

        //expected : 1
        // int[] src = { 1, 2, 3, 4 };
        // int[] dst = { 2, 1, 4, 5 };
        // int[][] swaps = { { 0, 1 }, { 2, 3 } };

        //expected : 0 
        // int[] src = { 5, 1, 2, 4, 3 };
        // int[] dst = { 1, 5, 4, 2, 3 };
        // int[][] swaps = { { 0, 4 }, { 4, 2 }, { 1, 3 }, { 1, 4 } };

        //expected : 1
        int[] src = { 2, 3, 1 };
        int[] dst = { 1, 2, 2, };
        int[][] swaps = { { 0, 2 }, { 1, 2 } };

        int answer = new Solution().function(src, dst, swaps);

        System.out.println(answer);

    }

}

class DSU {

    int n;
    int[] parent;
    int[] rank;

    DSU(int n) {
        this.n = n;
        this.parent = new int[n];
        this.rank = new int[n];
        init();
    }

    void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        } else {
            int far = find(parent[x]);
            parent[x] = far;
            return parent[x];
        }
    }

    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return false;
        }

        if (rank[py] < rank[px]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }

        return true;
    }

}

class Solution {

    int function(int[] src, int[] dst, int[][] swaps) {

        int N = src.length;

        DSU dsu = new DSU(N);

        for (int[] pair : swaps) {
            int x = pair[0];
            int y = pair[1];
            dsu.union(x, y);
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int child = i;
            int parent = dsu.find(i);

            Set<Integer> group = map.getOrDefault(parent, new HashSet<>());
            group.add(child);

            map.put(parent, group);
        }

        int diff = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {

            List<Integer> src_elements = new LinkedList<>();
            List<Integer> dst_elements = new LinkedList<>();

            //pick all elements from src
            for (Integer idx : entry.getValue()) {
                src_elements.add(src[idx]);
            }

            //compare with dest
            for (Integer idx : entry.getValue()) {
                dst_elements.add(dst[idx]);
            }

            Collections.sort(src_elements);
            Collections.sort(dst_elements);

            diff += Math.abs(src_elements.size() - dst_elements.size());

            for (int i = 0; i < src_elements.size(); i++) {

                boolean found = false;

                for (int j = 0; j < dst_elements.size(); j++) {
                    if (dst_elements.get(j) == src_elements.get(i)) {
                        found = true;
                    }
                }

                if (!found) {
                    diff++;
                }
            }

        }

        return diff;

    }

}
