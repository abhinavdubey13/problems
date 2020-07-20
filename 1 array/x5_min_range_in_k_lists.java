import java.util.*;

/**
 * You have k lists of sorted integers in non-decreasing order. 
 * 
 * Find the smallest range that includes at least one number from each of the k lists.
 * 
 * We define the range [a, b] is smaller than range [c, d] if 
 * 
 * 1. b - a < d - c or 
 * 2. a < c if b - a == d - c.
 *
 * ==========
 * example : 
 * =========
 * 
 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
 * Output: [20,24]
 * Explanation: 
 * 
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * 
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * 
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * 
 */

/**
 *  
 * ============
 * approach : 1
 * ============
 *
 * similar to merging k-sorted arrays , using min-heap
 * 
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class HeapHelper {
    int element;
    int array_id;
    int next_element_idx;

    HeapHelper(int e, int ai, int n) {
        this.element = e;
        this.array_id = ai;
        this.next_element_idx = n;
    }
}

class x5_min_range_in_k_lists {

    public static void main(String[] args) {
        // int[][] input = { { 1, 3, 5, 7, 9 }, { 0, 2, 4, 6, 8 }, { 2, 3, 5, 7, 11 } }; // expected 1-2
        int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }; //expected 4-9

        int[] answer = function(input);

        //printing 
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static int[] function(int[][] arr) {

        int answer_min = Integer.MAX_VALUE;
        int answer_max = Integer.MIN_VALUE;
        int answer_range_len = Integer.MAX_VALUE;

        int temp_min = Integer.MAX_VALUE;
        int temp_max = Integer.MIN_VALUE;
        int temp_range_len = Integer.MAX_VALUE;

        int[] answer_range = new int[2];

        //min-heap init
        PriorityQueue<HeapHelper> min_heap = new PriorityQueue<>(new Comparator<HeapHelper>() {
            public int compare(HeapHelper o1, HeapHelper o2) {
                return o1.element - o2.element;
            }
        });

        //adding 0th element of each array to min-heap
        for (int i = 0; i < arr.length; i++) {
            min_heap.offer(new HeapHelper(arr[i][0], i, 1));
            temp_max = Math.max(temp_max, arr[i][0]);
            answer_max = temp_max;
        }

        // as soon as any 1 of the array is fully explored, we will have our answer
        while (min_heap.size() == arr.length) {

            HeapHelper top = min_heap.poll();

            temp_min = top.element;
            temp_range_len = temp_max - temp_min;

            if (temp_range_len < answer_range_len) {
                answer_min = temp_min;
                answer_max = temp_max;
                answer_range_len = temp_range_len;
            }

            if (top.next_element_idx < arr[top.array_id].length) {
                int ele = arr[top.array_id][top.next_element_idx];
                int ai = top.array_id;
                int n = (1 + top.next_element_idx);

                temp_max = Math.max(temp_max, ele);
                min_heap.offer(new HeapHelper(ele, ai, n));
            }

        }

        answer_range[0] = answer_min;
        answer_range[1] = answer_max;
        return answer_range;

    }

}
