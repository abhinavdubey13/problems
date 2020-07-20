import java.util.Arrays;

/**
 * given an almost sorted array , task if to find the number of inversions in the array 
 * 
 * inversion is when :  
 * 1. i < j , and
 * 2. arr[i] > arr[j]
 * 
 * 
 * ==========
 * example :
 * ==========
 * 
 * arr = {8,6,7}
 * there are 2 inversions : 8-6 , 8-7
 * 
 */

/**
 * ==========
 * approach :
 * ===========
 * using merge-procedure of merge-sort to count the number of inversions
 * 
 * input array size = N
 * 
 * TC = O(N.logN)
 * SC = O(N)
 * 
 * 
 */

class p2_count_inversions {

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2 }; //expected = 2  {3,1} , {3,2}
        // int arr[] = { 1, 20, 6, 4, 5 }; //expectde=5

        System.out.println(merge_sort(arr, 0, arr.length - 1));
    }

    static int merge_sort(int[] arr, int LEFT, int RIGHT) {
        int inversions = 0;
        if (LEFT < RIGHT) {
            int MID = (LEFT + RIGHT) / 2;
            inversions += merge_sort(arr, LEFT, MID);
            inversions += merge_sort(arr, MID + 1, RIGHT);
            inversions += count_inv_and_merge(arr, LEFT, MID, RIGHT);
        }

        return inversions;
    }

    static int count_inv_and_merge(int[] arr, int LEFT, int MID, int RIGHT) {

        int inversions = 0;

        int[] left_arr = Arrays.copyOfRange(arr, LEFT, MID + 1);
        int[] right_arr = Arrays.copyOfRange(arr, MID + 1, RIGHT + 1);

        int left_ptr = 0;
        int right_ptr = 0;
        int original_ptr = LEFT;

        while (left_ptr < left_arr.length && right_ptr < right_arr.length) {

            if (left_arr[left_ptr] < right_arr[right_ptr]) {
                arr[original_ptr++] = left_arr[left_ptr++];
            } else {
                arr[original_ptr++] = right_arr[right_ptr++];

                //CHANGES ARE DONE HERE
                //inversions = { number_of_elements_in_arr[left....mid] } - left_ptr
                //ie. if left[i]>=right[j] , then all further indices in left are inversions
                //inversions are from idx=left_ptr till last index in left_arr ..................(JUST REMEMBER THIS , U'LL BE GOOD)
                int left_arr_len = MID - LEFT + 1;
                inversions += left_arr_len - left_ptr;

            }
        }

        while (left_ptr < left_arr.length) {
            arr[original_ptr++] = left_arr[left_ptr++];
        }

        while (right_ptr < right_arr.length) {
            arr[original_ptr++] = right_arr[right_ptr++];
        }

        return inversions;

    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}