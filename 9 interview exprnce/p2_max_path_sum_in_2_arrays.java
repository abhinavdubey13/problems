import java.util.*;

/**
 * 
 * leetcode id : https://practice.geeksforgeeks.org/problems/max-sum-path-in-two-arrays/1
 * 
 * 
 * Given two sorted arrays A and B of size n1 and n2 respectively. 
 * 
 * Each array contains only distinct elements but may have some elements in common with the other array. 
 * 
 * Find the maximum sum of a path from the beginning of any array to the end of any of the two arrays.
 * 
 * We can switch from one array to another array only at the common elements.
 * 
 * Note: Only one repeated value is considered in the valid path sum.
 *
 * 
 * ==========
 * example :
 * ==========
 *
 * Input:
 * A[] = {2,3,7,10,12}
 * B[] = {1,5,7,8}
 * Output: 35
 * 
 * Explanation: The path will be 1+5+7+10+12 = 35 
 *
 */

/**
 * ============
 * approach : 1
 * =============
 * 
 * 
 * using merge process in merge sort
 * 
 * https://prismoskills.appspot.com/lessons/Arrays/Maximum_sum_path_in_two_arrays.jsp
 * 
 * 
 * ===============
 * TC = O(n1+n2)
 * SC = O(1)
 * 
 * 
 */

class p2_max_path_sum_in_2_arrays {

    public static void main(String[] args) {

        int A[] = { 2, 3, 7, 10, 12 };
        int B[] = { 1, 5, 7, 8 };

        int answer = function(A, B);
        System.out.println(answer);

    }

    static int function(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0;
        int sum1 = 0;
        int sum2 = 0;
        int result = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        // This part is very similar to merge sort
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j])
                sum1 += arr1[i++];

            else if (arr1[i] > arr2[j])
                sum2 += arr2[j++];

            else {
                // Found a common point
                result += Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;

                while (i < n1 && j < n2 && arr1[i] == arr2[j]) {
                    int common_ele = arr1[i]; //or arr2[j]
                    result = result + common_ele;
                    i++;
                    j++;
                }
            }
        }

        // The loop ends when one of the array reached its end.
        // That means we still have to choose the array whose elements will end the maximum-sum-path (since last pair of equals)
        while (i < n1) {
            sum1 += arr1[i++];
        }

        while (j < n2) {
            sum2 += arr2[j++];
        }

        result += Math.max(sum1, sum2);
        return result;

    }

}
