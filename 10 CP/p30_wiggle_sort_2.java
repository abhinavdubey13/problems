import java.util.*;

/**
 * 
 * leetcode id : 324
 * 
 * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * 
 * You may assume the input array always has a valid answer.
 * 
 * 
 * 
 *  
 */

/**
 * 
 * using quick select
 * 
 * 
 * 
 *
 * TC = n^2
 * SC = n
 * 
 * 
 * 
 */

class p30_wiggle_sort_2 {

    public static void main(String[] args) {

        int[] arr = { 1, 5, 1, 1, 6, 4 };
        // int[] arr = { 1, 1, 2, 1, 2, 2, 1 };
        // int[] arr = { 1, 3, 2, 2, 3, 1 }; //1,3,1,3,2,1

        Helper.print_arr(arr);
        Solution.function(arr);
        Helper.print_arr(arr);

    }

}

class Solution {

    static void function(int[] arr) {

        int n = arr.length;

        int m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(arr, n);
        int median = kth_smallest.find(copy, m);

        for (int i = 0, j = 0, k = n - 1; j <= k;) {
            if (copy[j] < median) {
                kth_smallest.swap(copy, i++, j++);
            } else if (copy[j] > median) {
                kth_smallest.swap(copy, j, k--);
            } else {
                j++;
            }
        }
            
        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) arr[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2) arr[j] = copy[i];


        

    }

}

class kth_smallest {

    static int find(int[] arr, int k) {
        k--; //kth smalest element will come at idx k-1 as index start from 0
        return quick_select(arr, 0, arr.length - 1, k);
    }

    static int quick_select(int[] arr, int low, int high, int k) {
        int pivot_val = arr[high];
        int idx_of_pivot = partition(arr, low, high, pivot_val);

        if (k < idx_of_pivot) {
            return quick_select(arr, low, idx_of_pivot - 1, k);
        } else if (k > idx_of_pivot) {
            return quick_select(arr, idx_of_pivot + 1, high, k);
        } else {
            return arr[idx_of_pivot];
        }

    }

    static int partition(int[] arr, int low, int high, int pivot_val) {

        int i = low; //i is used as iterator : and represent the 1st index whose val > pivot
        int j = low - 1; //j represents the last index , whose val <= pivot

        while (i < high) {
            int curr = arr[i];

            if (curr <= pivot_val) {
                j++;
                swap(arr, i, j);
                i++;
            } else if (curr > pivot_val) {
                i++;
            }

        }

        //place pivot element at its correct position at last
        swap(arr, high, j + 1);

        return j + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int n = arr.length;
        if (i >= 0 && i < n && j >= 0 && j < n) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}

class Helper {

    static void print_arr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
