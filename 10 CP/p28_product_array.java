import java.util.*;

/**
 * 
 * leetcode id : 238
 * 
 * Given an array nums of n integers where n > 1,  
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * 
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 * Note: Please solve it without division and in O(n).
 *  
 */

/**
 * 
 * 
 * move from 0 till n-1 : ans[i]=ans[i-1]*num[i-1] : this way every LHS number except current number is multiplied store
 * 
 * now we need to do this again , moving from n-1 to 0
 * 
 * TC = n
 * SC = 1 (answer is not counter as extra space)
 * 
 */

class p28_product_array {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4 };
        int[] answer = Solution.function(arr);

        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

class Solution {

    static int[] function(int[] arr) {
        int n = arr.length;
        int[] answer = new int[n];

        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * arr[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= arr[i];
        }

        return answer;

    }

}
