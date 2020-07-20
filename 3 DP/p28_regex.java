/**
 * 
 * given a regex-pattern and string  , check if the string belongs to that pattern
 * NOTE : in the given pattern : * means 0 or more occurance of the character before it
 * NOTE : in the given pattern : # means exactly 1 character (it can be any char)
 * 
 * =========
 * Example :
 * =========
 * 
 * pattern = "xa*b#c"
 * sample = "xaabyc"
 * 
 * output = true
 * 
 */

/**
 * 
 * x-axis : sample-string
 * y-axis : pattern
 * 
 * dp-array = 1D
 * array-filling => left-to-right , top-to-bottom
 * 
 * 
 * if(string[i]==pattern[j] or pattern[i]== # ) then its a match and , table[i][j] = table[i-1][j-1]
 * 
 * else if(pattern [j]== *) then we check for zero or more occurance of string[i]
 * 
 * else 
 *  table[i][j] = false : as the chars donot match
 * 
 * ===================================
 * TC = O(sample . pattern)
 * SC = O(sample . pattern)
 * 
 * 
 */

public class p28_regex {
    public static void main(String[] args) {

        // expected = true
        // String pattern = "xa*b#c";
        // String sample = "xaabyc";

        // expected  is false
        String pattern = "a*ab*bbbbc*";
        String sample = "abbbba";

        // String pattern = "a*ab*bc*";
        // String sample = "aba";

        boolean answer = calculator(pattern.toCharArray(), sample.toCharArray());
        System.out.println(answer);

    }

    static boolean calculator(char[] pattern, char[] sample) {
        boolean[][] table = new boolean[sample.length + 1][pattern.length + 1];

        table[0][0] = true;

        // filling the first row , handling the case when pattern like : a*b* and sample-string is epsilon
        for (int i = 1; i <= pattern.length; i++) {
            table[0][i] = (pattern[i - 1] == '*') ? table[0][i - 2] : false;
        }

        // 2nd row onwards
        for (int i = 1; i <= sample.length; i++) {
            for (int j = 0; j <= pattern.length; j++) {

                //with pattern as epsilon , we cannot form any string
                if (j == 0) {
                    table[i][j] = false;
                    continue;
                }

                if (sample[i - 1] == pattern[j - 1] || pattern[j - 1] == '#') {
                    table[i][j] = table[i - 1][j - 1];
                    continue;
                }

                else if (pattern[j - 1] == '*') {
                    // considering either zero or atleast 1 occurance of pattern in sample
                    boolean a = table[i][j - 2]; //zero
                    boolean b = (pattern[j - 2] == '#' || pattern[j - 2] == sample[i - 1]) ? true : false; //atleast 1
                    table[i][j] = a || b;
                    continue;
                }

                else {
                    table[i][j] = false;
                }

            }
        }
        return table[sample.length][pattern.length];
    }

}