import java.util.*;

/**
 * 
 * leetcode id : 218
 * 
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.
 * 
 * The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
 * lefti is the x coordinate of the left edge of the ith building.
 * righti is the x coordinate of the right edge of the ith building.
 * heighti is the height of the ith building.
 * 
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * 
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...].
 * Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, 
 * which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. 
 * 
 * 
 * Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline. 
 * For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output 
 * as such: [...,[2 3],[4 5],[12 7],...]
 * 
 *
 * 
 * 
 * 
 */

/**
 * 
 * 
 * https://www.youtube.com/watch?v=GSBLe8cKu0s&t=1067s&ab_channel=TusharRoy-CodingMadeSimple
 * 
 * using max heap
 * 
 * skyline points are either start or end of the buildings
 * 
 * so we make a heap , breaking each point into 2 points : 1 for start , 1 for end
 * 
 * if on addition : max height changes in heap :  we need to add new heigth's (x,height) in answer
 * if on removal  : max height changes in heap :  we need to add (remove ht.x , curr_max) in answer
 *
 *
 * 
 * 
 */

class Building_point implements Comparable<Building_point> {
    int x;
    int height;
    boolean isStart;

    @Override
    public int compareTo(Building_point o2) {

        if (this.x != o2.x) {
            return this.x - o2.x;
        }
        //with same x , if both are start points : higher one should come first
        else if (this.isStart && o2.isStart) {
            return o2.height - this.height;
        }
        //with same x , if both are end points  : lower one should come first
        else if (!this.isStart && !o2.isStart) {
            return this.height - o2.height;
        }

        //with same x , if one is star and other is end : start of next should come first
        // else if (!this.isStart && o2.isStart) {
        //     return -1;
        // }
        else {
            return -1;
        }
    }
}

class p43_skyline_problem {

    public static void main(String[] args) {

        int[][] arr = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };

        //corner cases : start of 2 builidngs same
        // int[][] arr = { { 0, 1, 2 }, { 0, 2, 3 } };
        //corner cases : end of 2 builidngs same
        // int[][] arr = { { 3, 5, 3 }, { 4, 5, 2 } };
        //corner cases : end of 2 builidngs same
        // int[][] arr = { { 6, 7, 2 }, { 7, 8, 3 } };

        List<List<Integer>> answer = Solution.function(arr);
        for (List<Integer> list : answer) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}

class Solution {
    static List<List<Integer>> function(int[][] arr) {

        int n = arr.length;
        Building_point[] building_point = new Building_point[n * 2];
        int i = 0;

        List<List<Integer>> answer = new ArrayList<>();

        for (int[] b : arr) {
            //start point
            building_point[i] = new Building_point();
            building_point[i].x = b[0];
            building_point[i].height = b[2];
            building_point[i].isStart = true;

            //end point
            i++;
            building_point[i] = new Building_point();
            building_point[i].x = b[1];
            building_point[i].height = b[2];
            building_point[i].isStart = false;

            i++;
        }

        Arrays.sort(building_point);

        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        max_heap.offer(0);
        int prev_max = 0;

        for (Building_point bp : building_point) {

            if (bp.isStart) {
                max_heap.offer(bp.height);
            } else {
                max_heap.remove(bp.height);
            }

            int curr_max = max_heap.peek().intValue();
            if (prev_max != curr_max) {
                answer.add(new LinkedList<>(Arrays.asList(bp.x, curr_max)));
                prev_max = curr_max;
            }

        }

        return answer;

    }
}