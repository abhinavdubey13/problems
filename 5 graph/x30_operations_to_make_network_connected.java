import java.util.*;

/**
 * 
 * leetcode id : 1319
 * 
 * 
 * There are n computers numbered from 0 to n-1 connected by ethernet cables 
 * connections forming a network where connections[i] = [a, b] 
 * represents a connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.
 * 
 * 
 * Given an initial computer network connections. 
 * You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected. 
 * 
 * 
 * Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible, return -1
 * 
 * 
 * =========
 * example : 
 * =========
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
 * using DSU
 * 
 * keep track of reduant connections and number of components at last
 * 
 * depending on these 2 we will have our answer
 * 
 * 
 * 
 */

class x30_operations_to_make_network_connected {

    public static void main(String[] args) {

        int[][] edges = { { 1, 5 }, { 1, 7 }, { 1, 2 }, { 1, 4 }, { 3, 7 }, { 4, 7 }, { 3, 5 }, { 0, 6 }, { 0, 1 },
                { 0, 4 }, { 2, 6 }, { 0, 3 }, { 0, 2 } };

        int answer = new Solution().function(12, edges);
        System.out.println(answer);
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

class Solution {

    int function(int n, int[][] edges) {

        DSU dsu = new DSU(n);

        int redundant_connections = 0;

        for (int[] e : edges) {
            if (dsu.union(e[0], e[1]) == false) {
                redundant_connections++;
            }
        }

        Set<Integer> components = new HashSet<>();
        for (int i = 0; i < n; i++) {
            components.add(dsu.find(i));
        }

        if (redundant_connections == 0) {
            return 0;
        }

        if (redundant_connections >= components.size() - 1) {
            return Math.min(redundant_connections, components.size() - 1);
        }

        return -1;

    }
}
