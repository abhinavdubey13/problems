import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/find-index-of-an-extra-element-present-in-one-sorted-array/
 *
 * Given two sorted arrays. 
 * There is only 1 difference between the arrays. 
 * The first array has one element extra added in between. 
 * Find the index of the extra element.
 * 
 * ==========
 * example :
 * ==========
 * 
 * Input: 
 * {2, 4, 6, 8, 9, 10, 12}
 * {2, 4, 6, 8, 10, 12};
 * 
 * Output: 4
 * Explanation: The first array has an extra element 9.
 * The extra element is present at index 4.
 * 
 *  Input: 
 * {3, 5, 7, 9, 11, 13}
 * {3, 5, 7, 11, 13}
 * Output: 3
 * Explanation: The first array has an extra element 9.
 * The extra element is present at index 3.
 * 
 */

/**
 * ================================
 * approach : 1 : linear traversal
 * ================================
 * 
 * Traverse through the array from start to end.
 * Check if the element at i’th element of the two arrays is similar or not.
 * If the elements are not similar then print the index and break
 * 
 * ===============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * ================================
 * approach : 1 : binary search
 * ================================
 * 
 * To find the index of the missing element in less than linear time, binary search can be used, 
 * 
 * the idea is all the indices greater than or equal to the index of the missing element will have different elements in both the arrays 
 * and all the indices less than that index will have the similar elements in both arrays.
 * 
 * ===============
 * TC = O(logn)
 * SC = O(1)
 * 
 * 
 */

class p48_find_index_of_extra_element {

    public static void main(String[] args) {

        int[] arr1 = { 2, 4, 6, 8, 9, 10, 12 };
        int[] arr2 = { 2, 4, 6, 8, 10, 12 };

        int answer = function(arr1, arr2);
        System.out.println(answer);

    }

    static int function(int[] arr1, int[] arr2) {

        int n2 = arr2.length;

        int low = 0;
        int high = n2 - 1; //this is imp

        int answer_idx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr1[mid] == arr2[mid]) {
                low = mid + 1;
            } else {
                answer_idx = mid;
                high = mid - 1;
            }
        }

        return answer_idx;

    }

}
