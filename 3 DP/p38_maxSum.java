
/**
 * 
 * Given a number n, we can divide it in only three parts n/2, n/3 and n/4 (we will consider only integer part). 
 * The task is to find the maximum sum we can make by dividing number in three parts recursively and summing up them together.
 * Note: Sometimes, the maximum sum can be obtained by not dividing n.
 * 
 * ===========
 * EXAMPLE : 
 * ===========
 * We break n = 12 in three parts {12/2, 12/3, 12/4} = {6, 4, 3},  now current sum is = (6 + 4 + 3) = 13
 * 
 * Again, we break 6 = {6/2, 6/3, 6/4} = {3, 2, 1} = 3 + 2 + 1 = 6 .
 *  
 * so breaking 6 in three parts produces maximum sum 6 only 
 * 
 * similarly breaking 4 in three parts we can get maximum sum 4 and same for 3,2,1 also. 
 * 
 * Thus maximum sum by breaking 12 in parts  is=13
 * 
 */


/**
 * 
 * dp = 1-d array
 * 
 * dp[i] = max sum on breaking i 
 * 
 * ==========================================
 * let input number = n
 * TC = O(n)
 * SC = o(n)
 * 
 */

public class p38_maxSum {
    public static void main(String[] args) {

        int num = 12;
        // int num = 24;

        int answer = calculator(num);
        System.out.println(answer);

    }

    static int calculator(int num) {
        int[] table = new int[num + 1];
        table[0] = 0;
        table[1] = 1;
        table[2] = 2;

        for (int i = 3; i <= num; i++) {
            int maxOnDivideBy_2 = (i / 2 > 0) ? table[i / 2] : 0;
            int maxOnDivideBy_3 = (i / 3 > 0) ? table[i / 3] : 0;
            int maxOnDivideBy_4 = (i / 4 > 0) ? table[i / 4] : 0;

            int total = maxOnDivideBy_2 + maxOnDivideBy_3 + maxOnDivideBy_4;

            table[i] = Math.max(total, i);

        }

        return table[num];

    }
}