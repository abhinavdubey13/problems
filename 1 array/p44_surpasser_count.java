import java.util.*;


/**
 * A surpasser of an element of an array is a greater element to its right, 
 * 
 * therefore x[j] is a surpasser of x[i] if i < j and x[i] < x[j]. 
 * 
 * The surpasser count of an element is the number of surpassers. 
 * 
 * Given an array of distinct integers, for each element of the array find its surpasser count i.e. 
 * 
 * count the number of elements to the right that are greater than that element
 * 
 * NOTE : all elements in given array will be unique
 * 
 * 
 * ==========
 * example :
 * ==========
 * 
 * i/p : [2, 7, 5, 3, 0, 8, 1]
 * o/p : [4, 1, 1, 1, 2, 0, 0]
 * 
 */

/**
 * ============
 * approach : 1
 * =============
 * Method 1 (Naive)
 * 
 * The naive solution would be to run two loops. 
 * For each element of the array, we count all elements greater than it to its right.
 *  
 * ============
 * TC = O(n^2)
 * 
 * 
 * =======================================================
 * approach : works only if all unique elements are there
 * =======================================================
 * 
 * Method 2 (Uses Merge Sort)
 * 
 * For any element of the array, we can easily find out number of elements to the right that are greater than that element 
 * if we know number of elements to its right that are less than that element. 
 * 
 * The idea is to count the number of inversions for each element of the array using merge sort. 
 * So, surpasser count of an element at position i will be equal to “n – i – inversion-count” at that position where n is the size of the array
 * 
 * ===============
 * TC = O(n.logn)
 * SC = O(n)
 * 
 * 
 */

class p44_surpasser_count {

    public static void main(String[] args) {
        int arr[] = { 2, 7, 5, 3, 0, 8, 1 };

        int[] answer = function(arr);

        for(int i:answer){
            System.out.print(i + " ");
        }
        System.out.println();

    }

    static int[] function(int[] arr) {

        Map<Integer, Integer> my_map = new HashMap<>();

        int[] copy_arr = new int[arr.length];

        int[] surpassers = new int[arr.length];

        copy_arr = Arrays.copyOfRange(arr, 0, arr.length);

        Helper.merge_sort(copy_arr, 0, copy_arr.length - 1, my_map);

        for (int i = 0; i < copy_arr.length; i++) {
            surpassers[i] = arr.length - 1 - i - my_map.getOrDefault(arr[i], 0);

            // System.out.println(copy_arr[i] + " " + surpassers[i]);
        }
        return surpassers;

    }

}

class Helper {

    static void merge_sort(int[] arr, int low, int high, Map<Integer, Integer> my_map) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            merge_sort(arr, low, mid, my_map);
            merge_sort(arr, mid + 1, high, my_map);
            merge_sorted_arr(arr, low, mid, high, my_map);
        }
    }

    static void merge_sorted_arr(int[] arr, int low, int mid, int high, Map<Integer, Integer> my_map) {

        int left_len = mid - low + 1;
        int right_len = high - mid;

        int[] left = new int[left_len];
        int[] right = new int[right_len];

        left = Arrays.copyOfRange(arr, low, mid + 1);
        right = Arrays.copyOfRange(arr, mid + 1, high + 1);

        int inversion_count = 0;
        int i = 0;
        int j = 0;
        int k = low;

        while (i < left_len && j < right_len) {

            //all elements are unique : no 2 elements can be same
            if (left[i] < right[j]) {

                int inversions_known = my_map.getOrDefault(left[i], 0);
                inversions_known += inversion_count;
                my_map.put(left[i], inversions_known);
                arr[k++] = left[i++];

            } else if (left[i] > right[j]) {
                arr[k++] = right[j++];
                inversion_count++;
            }
        }

        while (i < left_len) {
            int inversions_known = my_map.getOrDefault(left[i], 0);
            inversions_known += inversion_count;
            my_map.put(left[i], inversions_known);

            arr[k++] = left[i++];
        }

        /* Copy the remaining elements of R[], if 
        there are any */
        while (j < right_len)
            arr[k++] = right[j++];

    }

}
