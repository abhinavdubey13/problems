
/**
 * 
 * problem : https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37
 * 
 * 
 * Given 2 Strings
 *      1. string having T and F 
 *      2. string having boolean operators &, | and ^
 * 
 * Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
 * Let the input be in form of two arrays one contains the symbols (T and F) in order and other contains operators (&, | and ^}
 * 
 * ===========
 * example : 
 * ==========
 * 
 * symbols =   TFT
 * operators = ^|
 * 
 * answer = 2 ways to get true
 * 
 * ( (T^F) | F)
 * 
 * (T ^ (F|F) )
 * 
 *
 * */

/**
 * ==========
 * APPROACH :
 * ==========
 * 
 * 
 * dp-array = 2D , 2 such arrays
 * array-filling = diagonal 
 * 
 * 
 * dp_true[i][j] => number of ways to parenthesise symbols[i...j] so that output is true
 * 
 * dp_true[i][j] => number of ways to parenthesise symbols[i...j] so that output is false
 * 
 * 
 * ============================================
 * let number of symbols = n
 * 
 * TC = O(n^3)
 * SC = O(n^2)
 * 
 */

public class p46_booleanParenthesis {
    public static void main(String[] args) {

        //4
        String symbols = "TTFT";
        String operators = "|&^";

        //2
        // String symbols = "TFT";
        // String operators = "^&";

        //2
        // String symbols = "TFF";
        // String operators = "^|";

        int answer = calculator(symbols.toCharArray(), operators.toCharArray());
        System.out.println(answer);
    }

    static int calculator(char[] symbols, char[] operators) {
        int[][] dp_true = new int[symbols.length][symbols.length];
        int[][] dp_false = new int[symbols.length][symbols.length];

        for (int i = 0; i < symbols.length; i++) {
            dp_false[i][i] = (symbols[i] == 'F') ? 1 : 0;
            dp_true[i][i] = (symbols[i] == 'T') ? 1 : 0;
        }

        for (int len = 2; len <= symbols.length; len++) {
            for (int i = 0; i + len - 1 < symbols.length; i++) {

                int j = i + len - 1;

                for (int cutIdx = i; cutIdx < j; cutIdx++) {

                    int ways_to_parenth_till_cut = dp_true[i][cutIdx] + dp_false[i][cutIdx];

                    int ways_to_parenth_after_cut = dp_true[cutIdx + 1][j] + dp_false[cutIdx + 1][j];

                    int total_ways_to_parenth = ways_to_parenth_till_cut * ways_to_parenth_after_cut;

                    char oper = operators[cutIdx];

                    if (oper == '&') {

                        dp_true[i][j] += dp_true[i][cutIdx] * dp_true[cutIdx + 1][j];

                        dp_false[i][j] += (total_ways_to_parenth - dp_true[i][cutIdx] * dp_true[cutIdx + 1][j]);
                    }

                    else if (oper == '|') {

                        dp_true[i][j] += (total_ways_to_parenth - dp_false[i][cutIdx] * dp_false[cutIdx + 1][j]);

                        dp_false[i][j] += dp_false[i][cutIdx] * dp_false[cutIdx + 1][j];

                    }

                    else if (oper == '^') {

                        dp_true[i][j] += dp_false[i][cutIdx] * dp_true[cutIdx + 1][j]
                                + dp_true[i][cutIdx] * dp_false[cutIdx + 1][j];

                        dp_false[i][j] += dp_true[i][cutIdx] * dp_true[cutIdx + 1][j]
                                + dp_false[i][cutIdx] * dp_false[cutIdx + 1][j];
                    }
                }
            }
        }

        int x = dp_true[0][symbols.length - 1];
        return x;
    }

}