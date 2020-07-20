import java.util.*;

/**
 * leetcode id : 1049
 * 
 * We have a collection of rocks, each rock has a positive integer weight.
 * 
 * Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  
 * The result of this smash is:
 * 
 * 1. If x == y, both stones are totally destroyed;
 * 
 * 2. If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * 
 * At the end, there is at most 1 stone left.  
 * Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation: 
 * We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * let say array be [a,b,c,d]
 * 
 * answer = (a+b)-(c+d) OR
 * answer = a-(b+c+d) Or
 * answer = (d+b)-(a+c) and so on.. any combination could be possible
 * notice that in general I can say that
 * answer = S1-S2 ................................................eq(1)
 * 
 * where S1 is sum of some of the numbers and S2 is sum of rest of numbers
 * also note that S1+S2 = SUM (sum of all numbers) ..............eq(2)
 * 
 * S1 >= S2 beacuse negative answer is not possible
 * now we have to minimise answer
 * answer = SUM - 2*S2 ...........................................from 1 n 2
 * 
 * To minimise answer S2 has to be maximum
 * Now, max value of S2 is SUM/2 .................................(CORE LOGIC)
 * 
 * so the question reduces to find closest sum (sum of numbers) to (SUM/2)
 * now this could be understood as subset sum problem or 0/1 knapsack problem


 *
 *  
 * 
 * ============
 * s = sum
 * n = arr.len
 * TC = O(n.s)
 * SC = O(n.s)
 * 
 * 
 * 
 */

class x11_stone_weight_2 {

    public static void main(String[] args) {
        int[] arr = { 2, 7, 4, 1, 8, 1 };
        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int[] arr) {

        int n = arr.length;

        int total_sum = 0;

        for (int a : arr) {
            total_sum += a;
        }

        int required_sum = total_sum / 2;

        boolean[][] possible_sum = new boolean[n + 1][required_sum + 1];

        for (int i = 0; i < possible_sum.length; i++) {
            for (int current_sum = 0; current_sum <= required_sum; current_sum++) {

                //init 1st column
                if (current_sum == 0) {
                    possible_sum[i][current_sum] = true;
                    continue;
                }

                //init 1st row
                if (i == 0) {
                    possible_sum[i][current_sum] = (current_sum == 0) ? true : false;
                    continue;
                }

                boolean excluding_ith_ele = possible_sum[i - 1][current_sum];

                int sum_remaining = current_sum - arr[i - 1];
                boolean including_ith_ele = (sum_remaining >= 0) ? possible_sum[i - 1][sum_remaining] : false;

                possible_sum[i][current_sum] = excluding_ith_ele || including_ith_ele;

            }
        }

        //finding wat is max sum of s2 possible
        int max_s2 = 0;
        for (int i = required_sum; i >= 0; i--) {
            if (possible_sum[n][i]) {
                max_s2 = Math.max(max_s2, i);
            }
        }

        // answer = total - (2*s2)
        return total_sum - 2 * max_s2;

    }

}
