
/**
 * 
 * program for merge sort
 * 
 * input array size = N
 * 
 * TC = O(N.logN)
 * SC = O(N)
 * 
 * 
 */

class p1_merge_sort {

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7, 1 };

        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        merge_sort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    static void merge_sort(int[] arr, int LEFT, int RIGHT) {

        //if we do left <= right
        //it will fall into infinite loop , with left = right = 0

        if (LEFT < RIGHT) {
            int MID = (LEFT + RIGHT) / 2;
            merge_sort(arr, LEFT, MID);
            merge_sort(arr, MID + 1, RIGHT);
            merge_sorted_arr(arr, LEFT, MID, RIGHT);
        }
    }

    static void merge_sorted_arr(int[] arr, int LEFT, int MID, int RIGHT) {

        int left_size = MID - LEFT + 1;
        int right_size = RIGHT - MID;

        int[] left_arr = new int[left_size];
        int[] right_arr = new int[right_size];

        //setup left array
        for (int i = 0; i < left_size; i++) {
            left_arr[i] = arr[LEFT + i];
        }

        //setup right array
        for (int i = 0; i < right_size; i++) {
            right_arr[i] = arr[MID + 1 + i];
        }

        int left_ptr = 0;
        int right_ptr = 0;
        int original_ptr = LEFT;

        while (left_ptr < left_arr.length && right_ptr < right_arr.length) {
            if (left_arr[left_ptr] < right_arr[right_ptr]) {
                arr[original_ptr++] = left_arr[left_ptr++];
            } else {
                arr[original_ptr++] = right_arr[right_ptr++];
            }
        }

        while (left_ptr < left_arr.length) {
            arr[original_ptr++] = left_arr[left_ptr++];
        }

        while (right_ptr < right_arr.length) {
            arr[original_ptr++] = right_arr[right_ptr++];
        }

    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
