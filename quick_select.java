import java.util.*;

/**
 * 
 * https://www.youtube.com/watch?v=fnbImb8lo88&ab_channel=Pepcoding
 * 
 * finding kth largest element in place
 * 
 * using quick select algo
 * 
 * =======================================================
 * other use cases : wiggle sort( sorting in wave form)
 * 
 * partition algo in key here
 * 
 *
 * 
 * 
 */

class quick_select {

    public static void main(String[] args) {

        int[] arr = { 1, 10, 2, 20, 3, 30, 5 };
        int k = 3;

        int kth_smallest_element = Solution_kth_smallest.find(arr, k);
        System.out.println(kth_smallest_element);

        int kth_largest_element = Solution_kth_largest.find(arr, k);
        System.out.println(kth_largest_element);
    }

}

class Solution_kth_smallest {

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

        int i = low;
        int j = low - 1;

        //idea is : 
        //arr[low......j] will have elements less or equal to pivot val
        //arr[j+1 .....i] will have elements strictly  greater than PV
        //arr[i+1...high] are yet to be scanned 

        //stop before last element : as it is pivot
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

class Solution_kth_largest {

    static int find(int[] arr, int k) {
        k--; //kth smalest element will come at idx k-1 as index start from 0
        return quick_select(arr, 0, arr.length - 1, k);
    }

    static int quick_select(int[] arr, int low, int high, int k) {
        int pivot_val = arr[high];
        int idx_of_pivot = partition(arr, low, high, pivot_val);

        if (idx_of_pivot > k) {
            return quick_select(arr, low, idx_of_pivot - 1, k);
        } else if (idx_of_pivot < k) {
            return quick_select(arr, idx_of_pivot + 1, high, k);
        } else {
            return arr[idx_of_pivot];
        }

    }

    static int partition(int[] arr, int low, int high, int pivot_val) {

        int i = low;
        int j = low - 1;

        //idea is : 
        //arr[low......j] will have elements greater or equal to pivot val
        //arr[j+1 .....i] will have elements strictly less than PV
        //arr[i+1...high] are yet to be scanned 

        while (i < high) {
            int curr = arr[i];

            if (curr >= pivot_val) {
                j++;
                swap(arr, i, j);
                i++;
            } else if (curr < pivot_val) {
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
