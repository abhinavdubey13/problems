import java.util.*;

// NOT DP but back-tracking problem

/**
 * 
 * Given an array of integers nums and a positive integer k, 
 * find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * 
 * ==========
 * example :
 * ==========
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * 
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * 
 */



/**
 * ==========
 * APPROACH :
 * ==========
 * 
 * 1st check if sum is divisible by K or not
 * 
 * if yes , then proceed to form the subsets
 * 
 * 
 * 
 * 
 * TC = O(n)
 * SC = O(n)
 * 
 */

public class x2_check_K_equal_partitions {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 3, 2, 1 };
        int K = 4;
        boolean answer = calculator(nums, K);
        System.out.println(answer);
    }

    static boolean calculator(int[] nums, int K) {

        int sum_of_arr = 0;
        for (int i : nums) {
            sum_of_arr += i;
        }

        if (sum_of_arr % K != 0) {
            return false;
        }

        int sum_of_each_part = sum_of_arr / K;
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);
        boolean answer = check_partitions(nums, visited, sum_of_each_part, nums.length - 1, K, 0);
        return answer;
    }

    static boolean check_partitions(int[] nums, boolean[] visited, int sum_of_each_part, int start_idx,
            int partition_number, int partition_sum) {

        if (partition_number == 0) {
            return true;
        }

        if (partition_sum == sum_of_each_part) {
            boolean next_partition_satisfied = check_partitions(nums, visited, sum_of_each_part, nums.length-1,
                    partition_number - 1, 0);

          return next_partition_satisfied;
        }

        for (int i = start_idx; i >= 0; i--) {

            if (!visited[i] && partition_sum + nums[i] <= sum_of_each_part) {
                visited[i] = true;

                boolean further_satisfied = check_partitions(nums, visited, sum_of_each_part, i - 1, partition_number,
                        partition_sum + nums[i]);

                if (further_satisfied) {
                    return true;
                }

                visited[i] = false;
            }

        }

        return false;
    }

}