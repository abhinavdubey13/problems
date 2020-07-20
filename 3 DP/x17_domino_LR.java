import java.util.*;

/**
 * leetcode id : 838
 * 
 * There are N dominoes in a line, and we place each domino vertically upright.
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 * 
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
 * Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
 * Return a string representing the final state. 
 * 
 * ===========
 * Input: ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * since only  '.' character can get affected by only the left and right immediatiate neighbours
 *  
 * we use prev and next state concept
 * 
 * untill both states become same
 *
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class x17_domino_LR {

    public static void main(String[] args) {

        String d = ".L.R...LR..L..";
        String answer = function(d);
        System.out.println(answer);
    }

    static String function(String input) {
        return fun(input.toCharArray());
    }

    static String fun(char[] arr) {

        int n = arr.length;
        char[][] dp = new char[2][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = arr[i];
        }

        while (true) {

            for (int i = 0; i < n; i++) {

                // considering only un-fallen dominos
                if (dp[0][i] == '.') {

                    char left = (i - 1 >= 0) ? dp[0][i - 1] : '.';
                    char right = (i + 1 < n) ? dp[0][i + 1] : '.';

                    if (left == '.') {
                        if (right == 'L') {
                            dp[1][i] = 'L';
                        } else {
                            dp[1][i] = '.';
                        }
                    }

                    else if (left == 'L') {
                        if (right == 'L') {
                            dp[1][i] = 'L';
                        } else {
                            dp[1][i] = '.';
                        }
                    }

                    else if (left == 'R') {
                        if (right == 'L') {
                            dp[1][i] = '.';
                        } else {
                            dp[1][i] = 'R';
                        }
                    }
                }

                //not considering dominos already fallen
                else {
                    dp[1][i] = dp[0][i];
                }

            }

            boolean same = state_same(dp);
            if (same) {
                String s = new String(dp[0]);
                return s;
            } else {
                copy_arr(dp);
            }
        }

    }

    static void copy_arr(char[][] dp) {
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = dp[1][i];
        }
    }

    static boolean state_same(char[][] dp) {
        for (int i = 0; i < dp[0].length; i++) {
            if (dp[0][i] != dp[1][i]) {
                return false;
            }
        }
        return true;
    }

}
