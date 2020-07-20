import java.util.*;

/**
 * leetcode id : 1423
 * 
 * There are several cards arranged in a row, and each card has an associated number of points The points are given in the integer array cardPoints.
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 * Your score is the sum of the points of the cards you have taken.
 * 
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1. 
 * However, choosing the rightmost card first will maximize your total score. 
 * The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * https://www.youtube.com/watch?v=x6BQ5XXUxbU&ab_channel=NideeshTerapalli
 * 
 * 1. for recursive approach , we have exponential complexity
 * 2. for dynamic prog with 3-D array , we have TC = SC = n^2
 * 
 * 3. for sliding window we use a subtle approach
 * Problem Translation: Find the smallest subarray sum of length = [len(cardPoints) - k]
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x13_max_in_1_player_coin_game {

    public static void main(String[] args) {

        //epected = 12
        int[] arr = { 1, 2, 3, 4, 5, 6, 1 };
        int chances = 3;

        //recursive approach
        int answer1 = Recursive_approach.function_util(arr, chances);
        System.out.println(answer1);

        //dynamic using 3-d array
        int answer2 = Dynamic_approach.function_util(arr, chances);
        System.out.println(answer2);

        //using sliding window
        int answer3 = Sliding_window_approach.function_util(arr, chances);
        System.out.println(answer3);
    }

}

class Sliding_window_approach {

    static int function_util(int[] arr, int chances) {

        int total = 0;
        for (int i : arr) {
            total += i;
        }

        int n = arr.length;
        if (chances >= n) {
            return total;
        }

        int number_of_items_to_unselect = n - chances;

        int window_sum_of_unselected = 0;
        for (int i = 0; i < number_of_items_to_unselect; i++) {
            window_sum_of_unselected += arr[i];
        }

        int answer = total - window_sum_of_unselected;

        for (int i = 1; i + number_of_items_to_unselect - 1 < n; i++) {
            int j = i + number_of_items_to_unselect - 1;

            window_sum_of_unselected += arr[j];
            window_sum_of_unselected -= arr[i - 1];

            answer = Math.max(answer, total - window_sum_of_unselected);
        }

        return answer;

    }

}

class Dynamic_approach {

    static int function_util(int[] arr, int chances) {

        int n = arr.length;

        int[][][] dp = new int[2][n][n];

        for (int c = 1; c <= chances; c++) {

            for (int len = 1; len <= n; len++) {
                for (int i = 0; i + len - 1 < n; i++) {
                    int j = i + len - 1;

                    if (c == 1) {
                        dp[1][i][j] = Math.max(arr[i], arr[j]);
                        continue;
                    }

                    if (c >= len) {
                        dp[1][i][j] = sum_of_arr(arr, i, j);
                        continue;
                    }

                    int a = (i + 1 < n) ? (arr[i] + dp[0][i + 1][j]) : 0;
                    int b = (j - 1 >= 0) ? (arr[j] + dp[0][i][j - 1]) : 0;

                    dp[1][i][j] = Math.max(dp[1][j][j], Math.max(a, b));
                }

            }

            copyArr(dp);
        }

        return dp[0][0][n - 1];

    }

    static void copyArr(int[][][] dp) {

        int rows = dp[0].length;
        int cols = dp[0][0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[0][i][j] = dp[1][i][j];
                dp[1][i][j] = 0;
            }
        }

    }

    static int sum_of_arr(int[] arr, int i, int j) {
        int r = 0;
        for (int p = i; p <= j; p++) {
            r += arr[p];
        }
        return r;
    }

}

class Recursive_approach {

    static int function_util(int[] arr, int chances) {
        return function(arr, 0, arr.length - 1, chances);
    }

    static int function(int[] arr, int i, int j, int chances) {
        if (chances > 0 && i < arr.length && j >= 0) {
            int a = arr[i] + function(arr, i + 1, j, chances - 1);
            int b = arr[j] + function(arr, i, j - 1, chances - 1);
            return Math.max(a, b);
        }
        return 0;
    }

}
