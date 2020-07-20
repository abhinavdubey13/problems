import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/minimum-maximum-values-expression/
 * 
 * Given an expression which contains numbers and two operators ‘+’ and ‘*’
 * 
 * we need to find maximum and minimum value which can be obtained by evaluating this expression by different parenthesization
 * 
 * ============
 * example : 1
 * ============
 * Input  : expr = “1+2*3+4*5” 
 * Output : Minimum Value = 27, Maximum Value = 105 
 * 
 * Explanation:
 * Minimum evaluated value = 1 + (2*3) + (4*5) = 27
 * Maximum evaluated value = (1 + 2)*(3 + 4)*5 = 105
 *
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *
 * We can solve this problem by dynamic programming method, 
 * 
 * we can see that this problem is similar to boolean parenthesis , 
 * 
 * In below code first we have separated the operators and numbers from given expression 
 * 
 * then two 2D arrays are taken for storing the intermediate result which are updated 
 * 
 * 
 * ===========================================
 * let number of digits = n
 * 
 * TC = O(n^3)
 * SC = O(n^2)
 * 
 * 
 * 
 * 
 */

class p55_max_min_val_of_expression {

    public static void main(String[] args) {

        // String expression = "1+2*3+4*5";

        String expression = "9*5+4";

        int[] answer = function(expression);
        System.out.println("min : " + answer[0]);
        System.out.println("max : " + answer[1]);

    }

    static int[] function(String expression) {

        if (expression.length() == 0) {
            return 0;
        }

        else if (expression.length() == 1) {
            return Integer.parseInt(String.valueOf(digits.charAt(0)));
        }

        StringBuffer digits = new StringBuffer();
        StringBuffer operators = new StringBuffer();

        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '*') {
                operators.append(c);
            } else {
                digits.append(c);
            }
        }

        // System.out.println(operators);
        // System.out.println(digits);

        int n = digits.length();

        int[][] dp_max = new int[n][n];
        int[][] dp_min = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                dp_min[i][j] = Integer.MAX_VALUE;
                dp_max[i][j] = Integer.MIN_VALUE;

                //  initializing main diagonal by num values 
                if (len == 1) {
                    dp_max[i][j] = dp_min[i][j] = Integer.parseInt(String.valueOf(digits.charAt(i)));
                    continue;
                }

                for (int cut = i; cut < j; cut++) {
                    char oper = operators.charAt(cut);

                    if (oper == '+') {
                        int val_min = dp_min[i][cut] + dp_min[cut + 1][j];
                        int val_max = dp_max[i][cut] + dp_max[cut + 1][j];

                        dp_min[i][j] = Math.min(dp_min[i][j], val_min);
                        dp_max[i][j] = Math.max(dp_max[i][j], val_max);
                    }

                    else if (oper == '*') {
                        int val_min = dp_min[i][cut] * dp_min[cut + 1][j];
                        int val_max = dp_max[i][cut] * dp_max[cut + 1][j];

                        dp_min[i][j] = Math.min(dp_min[i][j], val_min);
                        dp_max[i][j] = Math.max(dp_max[i][j], val_max);
                    }

                }

            }
        }

        return new int[] { dp_min[0][n - 1], dp_max[0][n - 1] };
    }

}
