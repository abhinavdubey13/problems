
/** 
 * given 2 sorted arrays , find median of the 2 arrays combined
 * 
 * for sorted odd length array  : median is middle element
 * for sorted even length array : median is avg of 2 middle element
 * 
 * ===========
 * example : 1
 * ===========
 * 
 * int[] x = { 1, 3, 8, 9, 15 };
 * int[] y = { 7, 11, 18, 19, 21, 25 };
 * 
 * when both sorted n merged = 1,3,7,8,9,11,15,18,19,21,25
 * median = 11 
 * lengh = odd : middle element
 * 
 * 
 * ===========
 * example : 2
 * ===========
 * 
 * int[] x = { 1, 3, 8, 9, 15 };
 * int[] y = { 7, 11, 18, 19, 21 };
 * 
 * when both sorted n merged = 1,3,7,8,9,11,15,18,19,21
 * median = 10 
 * lengh = even : (9+11)/2
 * 
 * 
 */

/**
 * =========================
 * approach 1  : brute-force
 * =========================
 * merge 2 arrays using merge procedure of merge sort , and find middle
 * TC=(N)
 * SC=O(N)
 * 
 * 
 * 
 * =========================
 * approach 2  : optimal
 * =========================
 * 
 * https://www.youtube.com/watch?v=LPFhl65R7ww&ab_channel=TusharRoy-CodingMadeSimple
 * 
 * let size of 2 arrays = m,n (m >= n) 
 * 
 * if m+n = even :
 * partition 2 arrays so that [size-of-combined-left-partition] is same as [size-of-combined-right-partition] 
 * 
 * if m+n = odd :
 * partition 2 arrays so that [size-of-combined-left-partition] is 1 more that  [size-of-combined-right-partition]
 * 
 * for each partition check max-left is less than min right 
 * 
 * ==========================
 * TC= O(log (MIN(n , m)))
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p12_median_of_2_sorted_arrays {

    public static void main(String[] args) {

        //expected = 11
        int[] x = { 1, 3, 8, 9, 15 };
        int[] y = { 7, 11, 18, 19, 21, 25 };

        //expected = 10
        // int[] x = { 1, 3, 8, 9, 15 };
        // int[] y = { 7, 11, 18, 19, 21 };

        double median = function(x, y);
        System.out.println(median);

    }

    // X.len <= Y.len
    //shorter len = m
    //larger len = n
    static double function(int[] arr_X, int[] arr_Y) {

        if (arr_X.length > arr_Y.length) {
            return function(arr_Y, arr_X);
        }

        //m <= n
        int n = arr_Y.length;
        int m = arr_X.length;
        int total_len = m + n;

        int low = 0;
        int high = m - 1;

        while (low <= high) {

            //part_x and part_y are number of elements from arr_x and arr_y respectively in the left-overall-partition  
            //partition is : [0....partx-1] , [partx.....n] 
            int part_X = low + (high - low) / 2;
            int part_Y = (total_len + 1) / 2 - part_X; //total+1 is mandatory for answer

            // System.out.println(part_X + " " + part_Y);

            // max in left of X[] and Y[]
            // (part_X - 1) is done bcz from (part_x....n-1) belong to right partition
            int max_left_x = (part_X == 0) ? Integer.MIN_VALUE : arr_X[part_X - 1];
            int max_left_y = (part_Y == 0) ? Integer.MIN_VALUE : arr_Y[part_Y - 1];

            //min in right of X[] and Y[]
            int min_right_x = (part_X == m) ? Integer.MAX_VALUE : arr_X[part_X];
            int min_right_y = (part_Y == n) ? Integer.MAX_VALUE : arr_Y[part_Y];

            if (max_left_x <= min_right_y && max_left_y <= min_right_x) {
                if (total_len % 2 == 0) {
                    return (double) (Math.max(max_left_x, max_left_y) + Math.min(min_right_x, min_right_y)) / 2;
                } else {
                    return Math.max(max_left_x, max_left_y);
                }

            } else if (max_left_x > min_right_y) {
                high = part_X - 1;
                // System.out.println("moved high");
            } else {
                low = part_X + 1;
                // System.out.println("moved low");

            }

        }

        // throw new Exception();
        return -1;

    }

}
