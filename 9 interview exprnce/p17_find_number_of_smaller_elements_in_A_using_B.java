import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/element-1st-array-count-elements-less-equal-2nd-array/
 * 
 * 
 * Given two unsorted arrays arr1[] and arr2[]. 
 * They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[]
 * 
 * 
 * Input : 
 * arr1[] = [1, 2, 3, 4, 7, 9]
 * arr2[] = [0, 1, 2, 1, 1, 4]
 * Output : [4, 5, 5, 6, 6, 6]
 * So the number of elements less than or equal to 
 * 1 is 4, 2 is 5, 3 is 5, 4 is 6, 7 is 6 and 9 is 6.
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
 * 
 * Approach: Sort the elements of 2nd array, i.e., array arr2[]. 
 * 
 * Then perform a modified binary search on array arr2[]. 
 * 
 * For each element x of array arr1[], find the last index of the largest element smaller than or equal to x in sorted array arr2[]. 
 * 
 * The index of the largest element will give the count of elements.
 * 
 * 
 * ============
 * TC = O((a+b)logb)
 * SC = O(1)
 * 
 * 
 * 
 * 
 * similary we can do for predecessor
 * 
 *  
 * 
 * 
 * 
 * 
 * 
 */

class p17_find_number_of_smaller_elements_in_A_using_B {

    public static void main(String[] args) {

        // int[] A = { 1, 2, 3, 4, 7, 9 };
        // int[] B = { 0, 1, 2, 1, 1, 4 };

        int[] A = { 5, 10, 2, 6, 1, 8, 6, 12 };
        int[] B = { 6, 5, 11, 4, 2, 3, 7};

        int[] answer = Solution.function(A, B);
        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();

        //testing helper method
        // int[] C = { 0, 1, 1, 1, 2, 4 };
        // int num = 2;
        // int answer = Solution.find_last_occurance(C, num);
        // System.out.println(answer);

    }

}

class Solution {

    static int[] function(int[] A, int[] B) {

        int[] answer = new int[A.length];

        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {

            int a = A[i];

            if (a < B[0]) {
                answer[i] = 0;
            }

            else if (a > B[B.length - 1]) {
                answer[i] = B.length;
            }

            else {
                int idx = find_last_occurance(B, a);

                if (a == B[idx]) {
                    answer[i] = idx + 1;
                } else if (a < B[idx]) {
                    answer[i] = idx;
                }

            }

        }

        return answer;
    }

    //if x exist : return last occurnace of x
    //else return index of element just greater than x in arr
    static int find_last_occurance(int[] arr, int x) {

        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int mid;
        int curr;

        while (start <= end) {

            mid = (start + end) / 2;
            curr = arr[mid];

            if (curr == x) {
                if (mid == n - 1) {
                    return mid;
                } else if (arr[mid + 1] > arr[mid]) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }

            else if (curr < x) {
                start = mid + 1;
            }

            else if (curr > x) {
                int prev = arr[mid - 1];
                if (prev < x) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }

        }

        return -1;

    }

}
