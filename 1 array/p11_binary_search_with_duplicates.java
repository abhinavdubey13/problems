
/**
 * 
 * 
 * binary search program , for array having duplicates
 * 
 * find index of 1st occurance
 * 
 * 
 * 
 */

/**
 * ==========
 * approach  :
 * =========== 
 * 
 * using binary search
 * 
 * TC= O(logN)
 * SC= O(logN)
 * 
 */

class p11_binary_search_with_duplicates {

    public static void main(String[] args) {

        //1-0
        //2-2
        //3-6
        //4-12
        //5-17
        int[] arr = { 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5 };

        int req_number = 4;
        // System.out.println(function_rec(arr, req_number, 0, arr.length - 1));
        System.out.println(function_itr(arr, req_number, 0, arr.length - 1));
    }

    static int function_itr(int[] arr, int TARGET, int LOW, int HIGH) {

        while (LOW <= HIGH) {

            int MID = LOW + (HIGH - LOW) / 2;

            if (arr[MID] == TARGET) {

                // check if this is the 1st occurance of TARGET
                if (MID == 0 || arr[MID - 1] < TARGET) {
                    return MID;
                }

                // if not , then reduce HIGH
                HIGH = MID - 1;
            }

            else if (TARGET < arr[MID]) {
                HIGH = MID - 1;

            } else if (TARGET > arr[MID]) {
                LOW = MID + 1;
            }

        }
        return -1;

    }

    static int function_rec(int[] arr, int TARGET, int LOW, int HIGH) {

        if (LOW <= HIGH) {

            int MID = (HIGH + LOW) / 2;

            if (arr[MID] == TARGET) {

                if (MID == 0) {
                    return MID;
                }
                return (arr[MID - 1] < TARGET) ? MID : function_rec(arr, TARGET, LOW, MID - 1);
            }

            else if (TARGET < arr[MID]) {
                return function_rec(arr, TARGET, LOW, MID - 1);

            } else if (TARGET > arr[MID]) {
                return function_rec(arr, TARGET, MID + 1, HIGH);

            }

        }
        return -1;

    }

}