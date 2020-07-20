import java.util.*;

/**
 * 
 * leetcode id : 973
 * 
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * 
 * 
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * 
 * 
 * 
 *  
 */

/**
 * 
 * 
 * using min heap
 * 
 * TC = n.logn
 * SC = n
 * 
 */

class p21_k_closest_to_origin {

    public static void main(String[] args) {

        int[][] arr = { { 1, 3 }, { -2, 2 } };
        int k = 1;

        int[][] points = Solution.function(arr, k);

        for (int[] pt : points) {
            System.out.println(pt[0] + " , " + pt[1]);
        }
        System.out.println();
    }
}

class Coordinate implements Comparable<Coordinate> {

    //dfo : dist form origin
    int x, y;
    double dfo;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.dfo = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public int compareTo(Coordinate c2) {
        return Double.compare(this.dfo, c2.dfo);
    }
}

class Solution {

    static int[][] function(int[][] arr, int k) {

        PriorityQueue<Coordinate> min_heap = new PriorityQueue<>();

        for (int[] pt : arr) {
            min_heap.offer(new Coordinate(pt[0], pt[1]));
        }

        int[][] answer = new int[k][2];

        for (int i = 0; i < k; i++) {
            Coordinate polled = min_heap.poll();
            answer[i][0] = polled.x;
            answer[i][1] = polled.y;

        }

        return answer;

    }

}
