import java.util.*;

/**
 * 
 * leetcode id : 
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
 * 
 */

class x33_minimum_vertices_to_reach_all_nodes {

    public static void main(String[] args) {
        int n = 6;

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new LinkedList<>(Arrays.asList(0, 1)));
        edges.add(new LinkedList<>(Arrays.asList(0, 2)));
        edges.add(new LinkedList<>(Arrays.asList(2, 5)));
        edges.add(new LinkedList<>(Arrays.asList(3, 4)));
        edges.add(new LinkedList<>(Arrays.asList(4, 2)));

        List<Integer> answer = new Solution().function(n, edges);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

class Node {
    int i;
    int in;
    int out;

    Node(int i, int in, int o) {
        this.i = i;
        this.in = in;
        out = o;
    }
}

class Solution {

    List<Integer> function(int n, List<List<Integer>> edges) {

        List<Node> arr = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new Node(i, 0, 0));
        }

        for (int i = 0; i < edges.size(); i++) {
            List<Integer> ith = edges.get(i);
            int u = ith.get(0);
            int v = ith.get(1);
            arr.get(u).out++;
            arr.get(v).in++;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.out != b.out) {
                return -1 * (a.out - b.out);
            } else if (a.in != b.in) {
                return (a.in - b.in);
            } else {
                return (a.i - b.i);
            }
        });

        for (int i = 0; i < arr.size(); i++) {
            pq.add(arr.get(i));
        }

        return new ArrayList<>();
    }
}
