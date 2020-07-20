import java.util.*;

/**
 * leetcode id : 560
 * 
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: nums = [1,1,1], k = 2
 * 
 * Output: 2
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
 * using DP , find all possible sub-arrays and their sum 
 * then count number of cells whose value = k
 * 
 * ============
 * TC = O(n^2)
 * SC = O(n^2)
 * 
 * ============
 * approach : 2
 * ============
 * 
 * using prefix-sum , 
 * 
 * From solution 1, we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
 * 
 * To achieve this, we just need to go through the array, calculate the current sum and save number of all seen PreSum to a HashMap. 
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class x37_subarrays_with_given_sum {

    public static void main(String[] args) {

        int[] arr = { 3, 4, 7, -2, 2, 1, 4, 2 };
        int req_sum = 7;

        int answer = function(arr, req_sum);

        System.out.println(answer);

    }

    static int function(int[] arr, int req_sum) {

        Map<Integer, Integer> my_map = new HashMap<>();
        my_map.put(0, 1);

        int cur_sum = 0, answer = 0;
        for (int i = 0; i < arr.length; i++) {

            cur_sum += arr[i];

            // cur_sum - x = req_sum
            // or , cur_sum - req_sum = x
            // the number of subrrays , whose sum is req_sum = the number of prefix-subarrays whose sum is (cur_sum - req_sum)
            answer += my_map.getOrDefault(cur_sum - req_sum, 0);

            my_map.put(cur_sum, my_map.getOrDefault(cur_sum, 0) + 1);

        }

        return answer;

    }

}
