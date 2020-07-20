
/**
 * sort an array which has only 0,1 in random order
 * 
 * ==========
 * example :
 * ==========
 * input  = { 0, 1, 1, 0, 1, 1, 0, 0, 0, 1 };
 * output = { 0, 0, 0, 0 ,0 ,1 ,1, 1, 1, 1 };
 * 
 */

/**
 * =============
 * approach   : 
 * =============
 * using single linear traversal 
 *  
 * TC= O(n)
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p20_sort_0_1 {

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 1, 0, 0, 0, 1 };

        // function(arr);
        Practise.fun(arr);


        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void function(int arr[]) {

        //approach-1
        // int low = 0, mid = 0, high = arr.length - 1;
        // while (mid <= high) {
        //     if (arr[mid] == 0) {
        //         swap(arr, low, mid);
        //         low++;
        //         mid++;
        //     } else if (arr[mid] == 1) {
        //         swap(arr, high, mid);
        //         high--;
        //     }
        // }

        //approach-2
        int low = -1; //the last index at which we have 0 , since we are beginning , we have -1 as low
        int high = arr.length - 1; //used as runner

        while (low < high) {
            if (arr[high] == 0) {
                low++;
                swap(arr, low, high);
            } else {
                high--;
            }
        }

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

class Practise {

    static void fun(int arr[]) {

        //approach-3
        int i0 = -1; //the last index at which we have 0 , since we are beginning , we have -1 as low
        int i1 = 0; //used as runner

        while (i1 < arr.length) {
            if (arr[i1] == 0) {
                i0++;
                p20_sort_0_1.swap(arr, i0, i1);
                i1++;
            } else {
                i1++;
            }
        }
    }

}