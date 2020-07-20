import java.util.*;

/**
 * leetcode id : 213
 * 
 * You are a professional robber planning to rob houses along a street. 
 * 
 * Each house has a certain amount of money stashed. 
 * 
 * All houses at this place are arranged in a circle. 
 * 
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected. 
 * 
 * And it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers nums representing the amount of money of each house, 
 * return the maximum amount of money you can rob tonight without alerting the police.
 * 
 *
 * ==========
 * example : 
 * ==========
 * 
 * Example 1:
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * 
 * Example 2:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
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
 * if we rob 1st house : we cannot rob last house 
 * array to consider : 0....n-2
 * 
 * 
 * 
 * if we do not rob 1st house :  
 * array to consider : 1....n-1
 * 
 * ===========
 * TC=O(n)
 * SC=O(1)
 * 
 * 
 * 
 */

class x29_house_robber_circular_array {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 1 };

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        else if (n == 2) {
            return Math.max(arr[0], arr[1]);
        }

        else if (n == 3) {
            return Math.max(arr[0], Math.max(arr[1], arr[2]));
        }

        return Math.max(fun(arr, 0, arr.length - 2), fun(arr, 1, arr.length - 1));

    }


    static int fun(int[] arr, int start, int end) {
        int include = 0, exclude = 0;
        for (int j = start; j <= end; j++) {
            int i = include, e = exclude;
            include = e + arr[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
}
