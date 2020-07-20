import java.util.*;

/**
 * 
 * 
 * leetcode id : 210
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 * 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * 
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them. 
 * If it is impossible to finish all courses, return an empty array. 
 * 
 *
 * =========
 * example : 
 * ========
 * 
 * 
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * 
 *  Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: []
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible
 * 
 * 
 */

/**
 * =============
 * APPROACH : 
 * =============
 * 
 * 1. convert graph to adj list representation
 * 
 * 2. check if there is any cycle : if yes :  return false
 * 
 * 3. if no cycles , do topological sorting to check if all nodes are there in the topological order
 *  
 * 
 * 
 */

public class x6_course_schedule_2 {

    public static void main(String[] args) {

        //expected false
        // int numCourses = 2;
        // int[][] prerequisites = { { 1, 0 }, { 0, 1 } };

        //expected true
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };

        int[] answer = Solution.function(numCourses, prerequisites);

        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}

class Solution {

    static int[] function(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
        }
        boolean has_cycle = check_cycle(graph, numCourses);
        if (has_cycle) {
            return new int[] {};
        }

        List<Integer> topological_order = new LinkedList<>();
        int[] answer = new int[numCourses];
        topological_util(graph, numCourses, topological_order);

        if (topological_order.size() == numCourses) {
            for (int i = 0; i < numCourses; i++) {
                answer[i] = topological_order.get(numCourses - 1 - i);
            }
            return answer;
        } else {
            return new int[] {};
        }
    }

    static boolean check_cycle(ArrayList<ArrayList<Integer>> graph, int num_nodes) {

        boolean[] done = new boolean[num_nodes];
        boolean[] being_explored = new boolean[num_nodes];
        boolean[] leads_to_cycle = new boolean[num_nodes];

        for (int i = 0; i < num_nodes; i++) {
            check_cycle_helper(i, graph, done, being_explored, leads_to_cycle);
        }

        for (boolean b : leads_to_cycle) {
            if (b) {
                return true;
            }
        }

        return false;
    }

    static boolean check_cycle_helper(int curr, ArrayList<ArrayList<Integer>> graph, boolean[] done,
            boolean[] being_explored, boolean[] leads_to_cycle) {

        if (done[curr]) {
            return leads_to_cycle[curr];
        }

        if (being_explored[curr]) {
            return true;
        }

        being_explored[curr] = true;

        for (Integer n : graph.get(curr)) {
            boolean ngbr_leads_to_cycle = check_cycle_helper(n, graph, done, being_explored, leads_to_cycle);
            if (ngbr_leads_to_cycle) {
                leads_to_cycle[curr] = true;
            }
        }

        done[curr] = true;
        being_explored[curr] = false;

        return leads_to_cycle[curr];

    }

    static void topological_util(ArrayList<ArrayList<Integer>> graph, int num_nodes, List<Integer> topo_order) {
        boolean[] vis = new boolean[num_nodes];
        for (int i = 0; i < num_nodes; i++) {
            if (!vis[i]) {
                dfs(i, graph, vis, topo_order);
            }
        }
    }

    static void dfs(int curr, ArrayList<ArrayList<Integer>> graph, boolean[] vis, List<Integer> topo_order) {
        for (Integer n : graph.get(curr)) {
            if (!vis[n]) {
                dfs(n, graph, vis, topo_order);
            }
        }
        vis[curr] = true;
        topo_order.add(curr);
    }

}
