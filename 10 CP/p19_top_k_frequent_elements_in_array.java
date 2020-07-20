import java.util.*;

/**
 * 
 * leetcode id : 347
 * 
 * Given a non-empty array of integers, return the k most frequent elements.

 Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]




You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *  
 */

/**
 * 
 * 
 * using heaps
 * 
 * 
 * TC = n
 * SC = n
 * 
 */

class p19_top_k_frequent_elements_in_array {

    public static void main(String[] args) {

        //expected : 1,2
        // int[] arr = { 1, 1, 1, 2, 2, 3 };
        // int k = 2;

        // expected : 1,2
        int[] arr = { 1 };
        int k = 1;

        int[] answer = Solution.function(arr, k);
        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class heap_obj implements Comparable<heap_obj> {

    int num;
    int freq;

    heap_obj(int n, int f) {
        this.num = n;
        this.freq = f;
    }

    public int compareTo(heap_obj x) {
        return (-1 * (this.freq - x.freq));
    }

}

class Solution {

    static int[] function(int[] arr, int k) {

        int[] ans = new int[k];

        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i : arr) {
            hmap.put(i, hmap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<heap_obj> max_heap = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            max_heap.add(new heap_obj(entry.getKey(), entry.getValue()));
        }

        for (int i = 0; i < k; i++) {
            heap_obj removed = max_heap.poll();
            ans[i] = removed.num;
        }

        return ans;

    }

}
