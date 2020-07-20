import java.util.*;

/**
 * https://www.geeksforgeeks.org/merge-k-sorted-arrays/
 * 
 */

/**
 * =============
 * approach   : 
 * =============
 * using min-heap
 * 
 *  
 * TC= O(n)
 * SC= O(k)
 * 
 * 
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

class p22_merge_k_sorted_arrays {

    public static void main(String[] args) {
        // int arr[][] = { { 2, 6, 12, 34 }, { 1, 9, 20, 80 }, { 23, 34, 50, 90 } };
        int arr[][] = { { 2 }, { 1, 9 }, { 23, 34, 50, 90 }, { 11, 12, 13, 14, 15, 16 } };
        List<Integer> mergedArr = merge_function_using_priority_queue(arr);
        print_array(mergedArr);
    }

    static List<Integer> merge_function_using_priority_queue(int arr[][]) {

        PriorityQueue<HeapHelper> min_heap = new PriorityQueue<>(new Comparator<HeapHelper>() {
            public int compare(HeapHelper o1, HeapHelper o2) {
                return o1.element - o2.element;
            }
        });

        int result_arr_size = 0;

        //adding 0th element of each array in min-heap
        for (int i = 0; i < arr.length; i++) {
            min_heap.offer(new HeapHelper(arr[i][0], i, 1));
            result_arr_size += arr[i].length;
        }

        List<Integer> result_arr = new LinkedList<>();

        //fill the result_arr , starting from index 0
        for (int i = 0; i < result_arr_size; i++) {

            HeapHelper popped = min_heap.poll();
            result_arr.add(popped.element);

            //insert new element in heap 
            //if the popped element's array has more elements
            if (popped.next_element_idx < arr[popped.array_id].length) {
                int ele = arr[popped.array_id][popped.next_element_idx];
                int ai = popped.array_id;
                int nxt_idx = (popped.next_element_idx + 1);
                min_heap.offer(new HeapHelper(ele, ai, nxt_idx));
            }
        }

        return result_arr;

    }

    static void print_array(List<Integer> arr) {
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}