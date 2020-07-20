
/**
 * Given a string of lowercase alphabets
 * 
 * find number of all distinct continuous palindromic sub-strings of it. 
 * 
 *
 * ===========
 * Example : 
 * ===========
 * geek
 * 
 * output = 4 (g,e,k,ee)
 * 
 * ===========
 * Example : 
 * ===========
 * abaaa
 * 
 * output =5 (a,b,aa,aaa,aba)
 * 
 */

/**
 * ==========
 * APPROACH :
 * ==========
 * 
 * 
 *
 * 
 */

public class p45_countPalindromes {
    public static void main(String[] args) {

        // String str = "geek";
        String str = "abaaa";

        int answer = calculator(str.toCharArray());
        System.out.println(answer);
    }

    static int calculator(char[] input) {
        int dp[][] = new int[input.length][input.length];

        for (int len = 1; len <= input.length; len++) {
            for (int i = 0; i + len - 1 < input.length; i++) {

                int j = i + len - 1;

                if (len == 1) {
                    dp[i][j] = 1;
                    continue;
                }

                if (input[i] == input[j]) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];

                } else {

                    for (int cutEndIdx = 0; cutEndIdx < j; cutEndIdx++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][cutEndIdx] + dp[cutEndIdx + 1][j]);
                    }

                }

            }
        }

        return dp[0][input.length - 1];
    }

}