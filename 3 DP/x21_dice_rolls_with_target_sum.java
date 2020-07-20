import java.util.*;

/**
 * leetcode id : 1155
 * 
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * 
 * You have D dice, 
 * each die has F faces numbered 1, 2, ...F.
 * 
 * 
 * Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.
 * 
 * 
 * ==========
 * examples : 
 * ==========
 * Example 1:
 * Input: d = 1, f = 6, target = 3
 * Output: 1
 * Explanation: You throw one die with 6 faces.  There is only one way to get a sum of 3.
 * 
 * 
 * Example 2:
 * Input: d = 2, f = 6, target = 7
 * Output: 6Explanation: You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1
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
 * using hashmap as DP
 * 
 * ==============
 * TC=O(d*F*Target)
 * SC=O(d*F*target)
 * 
 * 
 */

class x21_dice_rolls_with_target_sum {

    public static void main(String[] args) {

        // //expected = 0
        // int D = 1;
        // int F = 2;
        // int target = 3;

        // //expected = 6
        // int D = 2;
        // int F = 6;
        // int target = 7;

        // //expected = 6
        // int D = 2;
        // int F = 6;
        // int target = 7;

        // // //expected = 374894389
        // int D = 10;
        // int F = 10;
        // int target = 60;

        //expected = 222616187
        // int D = 30;
        // int F = 30;
        // int target = 500;

        // //expected = 936470088
        int D = 30;
        int F = 9;
        int target = 239;

        // int answer = Brute_force.function_util(D, F, target);
        int answer = Optimal.function_util(D, F, target);

        System.out.println("answer : " + answer);
    }

}

class Brute_force {

    static int MOD = 1000000007;

    static int function_util(int D, int F, int target) {

        if (D * F < target) {
            return 0;
        }

        int answer = 0;
        answer = function(D, F, target, 0);
        return answer;
    }

    static int function(int D, int F, int target, int curr_sum) {

        if (curr_sum < 0) {
            return 0;
        }

        if (D == 0 && curr_sum == target) {
            return 1;
        }

        if (D == 0 && curr_sum != target) {
            return 0;
        }

        if (D > 0 && curr_sum >= target) {
            return 0;
        }

        int sum_here = 0;
        int ways = 0;
        for (int i = 1; i <= F; i++) {
            sum_here = curr_sum + i;
            ways += function(D - 1, F, target, answer, sum_here);
        }

        return ways % MOD;
    }

}

class Optimal {

    static int MOD = 1000000007;

    static int function_util(int D, int F, int target) {

        if (D * F < target) {
            return 0;
        }

        int answer = 0;

        Map<String, Integer> dp = new HashMap<>();

        answer = function(D, F, target, 0, dp);
        return answer;
    }

    static int function(int D, int F, int target, int curr_sum, Map<String, Integer> dp) {

        if (curr_sum < 0) {
            return 0;
        }

        if (D == 0 && curr_sum == target) {
            return 1;
        }

        if (D == 0 && curr_sum != target) {
            return 0;
        }

        if (D > 0 && curr_sum >= target) {
            return 0;
        }

        String key = D + "" + F + "" + curr_sum;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int sum_here = 0;
        int ways = 0;

        for (int i = 1; i <= F; i++) {
            sum_here = curr_sum + i;
            ways += function(D - 1, F, target, sum_here, dp);
            ways = ways % MOD;
        }

        dp.put(key, ways);
        return ways;

    }

}