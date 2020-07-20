import java.util.*;

/**
 * 
 * leetcode id : 
 *
 * https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1
 * 
 * print k largest/smallest element in array 
 *
 *  
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 1
 * ============
 *
 * https://www.youtube.com/watch?v=taL2G6jDLog&t=62s&ab_channel=Pepcoding
 * 
 * for largest K : use min heap
 * for smallest K : use max heap
 * 
 * 
 * ============
 * TC = O(n.logK)
 * SC = O(k)
 * 
 * 
 *  
 * 
 * 
 * 
 * 
 * 
 */

class p28_K_elements_smallest_largest {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 4, 4, 5 };

        int k = 3;
        Solution_largest_k.function(arr, k);

    }

}

class Solution_largest_k {

    static void function(int[] arr, int k) {

        int n = arr.length;

        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            if (i < k) {
                min_heap.offer(curr);
            } else {
                int min_ele = min_heap.peek();
                if (curr > min_ele) {
                    min_heap.poll();
                    min_heap.offer(curr);
                }
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(min_heap.poll() + " ");
        }
        System.out.println();

    }

}