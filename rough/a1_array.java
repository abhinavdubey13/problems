import java.util.*;

class a1_array {

    public static void main(String[] args) throws Exception {

        int[] arr = { 1, 3, 50, 10, 9, 7, 6 };
        // int arr[] = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
        // int[] arr = { 10, 20, 30, 40, 50 };
        // int[] arr = { 120, 100, 80, 20, 0 };

        int answer = Solution.function(arr);
        System.out.println(answer);
    }

}

class Solution {

    static int function(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int curr = arr[mid];
            Integer prev = (mid >= 1) ? arr[mid - 1] : null;
            Integer next = (mid + 1 < n) ? arr[mid + 1] : null;

            if (mid == 0 || mid == n - 1) {
                return curr;

            }

            if (prev != null && next != null && curr > prev && curr > next) {
                return curr;
            }

            //search in RHS
            else if (prev != null && curr > prev) {
                low = mid + 1;
            }

            //search in LHS
            else if (next != null && curr > next) {
                high = mid - 1;

            }

        }

        return -1;

    }

}
