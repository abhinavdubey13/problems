import java.util.*;

/**
 * 
 * leetcode id : 378
 * 
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * 
 * 
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * 
 * 
 * 
 *  
 */

/**
 * 
 *
 * using heaps 
 * 
 * enter 1st row in heap : an then keep moving downwards , in least val element's column
 * 
 *
 * TC = k+row
 * SC = row
 * 
 * 
 * 
 */

class p31_kth_smallest_in_sorted_matrix {

    public static void main(String[] args) {

        int[][] arr = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;

        int answer = Solution.function(arr, k);
        System.out.println(answer);

    }
}

class Heap_obj implements Comparable<Heap_obj> {
    int x, y, val;

    Heap_obj(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.val = v;
    }

    @Override
    public int compareTo(Heap_obj o) {
        return this.val - o.val;
    }
}

class Solution {

    static int function(int[][] arr, int k) {

        int rows = arr.length;
        int cols = arr[0].length;

        PriorityQueue<Heap_obj> min_heap = new PriorityQueue<>();

        for (int i = 0; i < cols; i++) {
            min_heap.add(new Heap_obj(0, i, arr[0][i]));
        }

        // int counter;
        for (int i = 0; i < k - 1; i++) {
            Heap_obj polled = min_heap.poll();
            if (polled.x < rows - 1) {
                int nx = polled.x + 1;
                int ny = polled.y;
                int v = arr[nx][ny];
                min_heap.offer(new Heap_obj(nx, ny, v));
            }

        }

        return min_heap.peek().val;

    }
}
