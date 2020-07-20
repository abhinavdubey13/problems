import java.util.*;

/**
 * 
 * leetcode id : 268
 * 
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * 
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 *
 * 
 *  
 */

/**
 * 
 * using XOR
 * 
 * 
 * xor of 0....n 
 * xor of arr[0]...arr[n-1]
 * 
 * 
 * (0^1^2^3........^n) ^ (arr[0]^arr[1]..........^arr[n-1]) will give the answer
 * 
 * every number will get cancelled out , except the one which is missing
 * 
 * 
 * we can also do by sum(0..n)-sum(arr[0]...arr[n])
 * 
 *
 * 
 * 
 * TC = n
 * SC = 1
 * 
 */

class p10_find_missing_number {

    public static void main(String[] args) {

        int[] arr = { 3, 0, 1 };
        int answer = Solution.function(arr);
        System.out.println(answer);
    }
}

class Solution {

    static int function(int[] arr) {

        int n = arr.length;

        int answer = n;

        for (int i = 0; i < n; i++) {
            answer = answer ^ i;

            answer = answer ^ arr[i];
        }

        return answer;

    }

}
