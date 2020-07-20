
/**
 * 
 * 
 * binary search program
 * 
 * 
 * 
 */

/**
 * ==========
 * approach  :
 * =========== 
 * TC=(logN)
 * SC=O(logN)
 * 
 * 
 * 
 * 
 */

class p10_binary_search {

    public static void main(String[] args) {
        // int[] arr = { 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5 };

        int[] arr = { 1, 2, 3, 4, 5 };

        int req_number = 5;
        System.out.println(function_recursive(arr, req_number, 0, arr.length - 1));
        System.out.println(function_iterative(arr, req_number, 0, arr.length - 1));

    }

    static int function_iterative(int[] arr, int TARGET, int LOW, int HIGH) {

        while (LOW <= HIGH) {

            int MID = LOW + ((HIGH - LOW) / 2);

            if (arr[MID] == TARGET) {
                return MID;
            }

            else if (arr[MID] < TARGET) {
                LOW = MID + 1;
            }

            else if (arr[MID] > TARGET) {
                HIGH = MID - 1;
            }

        }

        return -1;

    }

    static int function_recursive(int[] arr, int TARGET, int LOW, int HIGH) {

        if (LOW <= HIGH) {

            int MID = LOW + ((HIGH - LOW) / 2);

            //&& MID > 0 && arr[MID - 1] < TARGET

            if (arr[MID] == TARGET) {
                return MID;
            }

            else if (arr[MID] > TARGET) {
                return function_recursive(arr, TARGET, LOW, MID - 1);

            } else if (arr[MID] < TARGET) {
                return function_recursive(arr, TARGET, MID + 1, HIGH);

            }

        }
        return -1;

    }

}