
/**
 * 
 * leetcode : 91
 * 
 * given coding : a=1 , b=2 .... z=26
 * given a string of numbers , find the number of possible decodings
 * 
 * assume the input string is valid (doesn't begin with 0 , and has digits only) 
 * 
 * ===========
 * example :
 * ===========
 * str = 2563
 * 
 * total decoding = 2
 * 
 * 1. (25) (6) (3)
 * 2. (2) (5) (6) (3)
 * 
 * 
 * 
 */

/**
 * 
 * 
 * dp-array = 1D
 * array-filling = left-to-right   (dp[i] => number of decodings possible from 0...ith in input)
 * 
 * scan the input string of digits from L->R
 * 
 * the current digit(ith) has 2 choices :
 *      1. to be indivisual char in decoding , UNLESS IT IS '0' , or
 *      2. get mixed with prev digit (if combination is <=26)
 * 
 * 
 * =====================================
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class p33_numberOfDecodings {
    public static void main(String[] args) {

        // String str = "121321269";
        // String str = "2563";

        String str = "12";

        int answer = calculator(str);
        System.out.println(answer);

    }

    static int calculator(String s) {
        char[] input = s.toCharArray();

        //if leading zeros : then answer = 0 : as the string is invalid
        if (input[0] == 0) {
            return 0;
        }

        int[] dp = new int[input.length + 1];
        dp[0] = 1; //with no input , only 1 possiblity , ie. no decoding
        dp[1] = 1; //if only 1 digit , then only 1 decoding possible

        for (int i = 2; i <= input.length; i++) {
            // input[i-1] represent the current digit we are scanning
            char cur_digit = input[i - 1];
            char prev_digit = input[i - 2];

            //'0' has NO de-codings , decoding is from 1....26 
            int cur_not_merged_with_prev = (cur_digit != '0') ? dp[i - 1] : 0;
            int cur_merged_with_prev = (prev_digit == '1' || prev_digit == '2' && cur_digit <= '6') ? dp[i - 2] : 0;
            dp[i] = cur_not_merged_with_prev + cur_merged_with_prev;
        }

        return dp[input.length];
    }

}