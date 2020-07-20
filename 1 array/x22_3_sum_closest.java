import java.util.*;

/**
 * leetcode id : 16
 * 
 * Given an array nums of n integers and an integer target, 
 * find three integers in nums such that the sum is closest to target. 
 * Return the sum of the three integers. 
 * 
 * You may assume that each input would have exactly one solution.
 *
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2) 
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
 * using 2 pointer technique
 * sort the input array
 * 
 * for each element in the array , 
 * 
 * initialize i=current index
 * use j,k as the 2 pointer , as used in 2 pointer technique
 * 
 * j=i+1
 * k=n-1
 *
 *  
 * 
 * ============
 * TC = O(n^2)
 * SC = O(1)
 * 
 * 
 * 
 */

class x22_3_sum_closest {

    public static void main(String[] args) {

        int[] arr = { -1, 2, 1, -4 };
        int x = 1;

        int answer = function(arr, x);

        System.out.println(answer);
        // for (int i = 0; i < len; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
    }

    static int function(int[] arr, int x) {

        int n = arr.length;

        Arrays.sort(arr);

        int answer = arr[0] + arr[1] + arr[n - 1];

        for (int i = 0; i < n - 2; i++) {

            int j = i + 1, k = n - 1;

            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];

                if (Math.abs(x - sum) < Math.abs(x - answer)) {
                    answer = sum;
                }

                if (sum < x) {
                    j++;
                } else if (sum == x) {
                    return x;
                } else if (sum < x) {
                    k--;
                }

            }

        }

        return answer;

    }

}
