import java.util.*;

class p5 {

    public static void main(String[] args)  {

        int[] arr = {100,-10,10};

        int ans = Solution.solve(arr.length, arr);
        System.out.println(ans);
    }

}

class Solution {

    static int solve(int n, int[] arr) {
        // Your code goes here

        if (n == 1) {
            return arr[0];
        }

        int ans = arr[0];
        int diff = Math.abs(arr[0]);

        for (int i = 1; i < n; i++) {
            int ab = Math.abs(arr[i]);
            if (ab == 0) {
                return 0;
            }

            if (ab < diff) {
                diff = ab;
                ans = arr[i];
            }

            else if (ab == diff) {
                int prev_ans = ans;
                ans = Math.max(prev_ans, arr[i]);
            }
        }

        return ans;

    }

}
