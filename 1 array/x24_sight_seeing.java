import java.util.*;

/**
 * leetcode id : 1014
 * 
 * given an int array , find maximum of (arr[i] + arr[j] + j - i) , such that i<j
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: [8,1,5,2,6]
 * Output: 11
 * 
 * Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11 
 * 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *
 * store the index of best_i 
 * 
 * at each j (i....n) : check arr[best_i] + best_i + arr[j] - j
 * 
 * also update best_i_idx
 * 
 *  
 *
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x24_sight_seeing {

    public static void main(String[] args) {

        int[] arr = { 8, 1, 5, 2, 6 };

        int answer = function(arr);

        System.out.println(answer);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
    }

    static int function(int[] arr) {

        int n = arr.length;

        if (arr.length == 2) {
            return arr[0] + arr[1] - 1;
        }

        PriorityQueue<Integer> max_heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1.intValue() - o2.intValue());
            }
        });

        max_heap.add(arr[0] + 0);

        int max_score = Integer.MIN_VALUE;

        for (int j = 1; j < n; j++) {
            int max_i = max_heap.peek().intValue();

            if (max_i + arr[j] - j > max_score) {
                max_score = max_i + arr[j] - j;
            }

            max_heap.add(j + arr[j]);

        }

        return max_score;

    }

    static int function_2(int[] arr) {

        int n = arr.length;

        if (arr.length == 2) {
            return arr[0] + arr[1] - 1;
        }

        int best_i_idx = 0;

        int max_score = Integer.MIN_VALUE;

        for (int j = 1; j < n; j++) {

            max_score = Math.max(max_score, arr[best_i_idx] + best_i_idx + arr[j] - j);

            if (arr[best_i_idx] + best_i_idx < j + arr[j]) {
                best_i_idx = j;
            }

        }

        return max_score;

    }

}
