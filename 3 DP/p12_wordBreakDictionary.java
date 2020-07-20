import java.util.*;

/**
 * 
 * given a dictionary of words and a string, find whether the string can be broken into substring , such that each substring belongs to that Dictionary
 * 
 * =========
 * example :
 * =========
 * 
 * dictionary = [i , ok , go]
 * 
 * for input = okigoi : output = true
 * for input = goki   : output = false
 * 
 * 
 */

/**
 * dp-array = 2D
 * array-filling = diagonally , considering the lenght of substring from 1 till length = length of input string
 * 
 * if (length of substring considered =1) then , just check that substring is in dictionary or not
 * 
 * else , we can have 2 cases :
 * case1 = the entire substring is in dictionary , in this case table[][] is TRUE 
 * case2 = cut the sub string into 2 parts , and check if BOTH parts are present in the Dictionary
 *  
 * in case2 , the cut can be at startIdx or startIdx+1 ...and so on
 * 
 * 
 * =======================================
 * let length of string = n
 * 
 * TC = O(n^3)
 * SC = O(n^2)
 * 
 * 
 */

class p12_wordBreakDictionary {

    public static void main(String[] args) {

        // String word = "iamace";

        // String word = "okigoi"; //true
        // String word = "okigoio"; //false
        String word = "goki"; //false

        boolean answer = calulator(word);
        System.out.println(answer);

    }

    static boolean calulator(String wordString) {

        int n = wordString.length();
        boolean[][] table = new boolean[n][n];

        for (int considerLength = 1; considerLength <= n; considerLength++) {
            for (int startIndex = 0; startIndex + considerLength - 1 < n; startIndex++) {
                int endIndex = startIndex + considerLength - 1;

                if (considerLength == 1) {
                    String subStr = Character.toString(wordString.charAt(startIndex));
                    boolean temp = isInDictionary(subStr);
                    table[startIndex][endIndex] = temp;
                    continue;
                }

                for (int cutEndIdx = startIndex; cutEndIdx < endIndex; cutEndIdx++) {
                    String subStr = wordString.substring(startIndex, endIndex + 1);

                    boolean is_sub_str_in_dictionary = isInDictionary(subStr);
                    boolean is_cut1_in_dictionary = table[startIndex][cutEndIdx];
                    boolean is_cut2_in_dictionary = table[cutEndIdx + 1][endIndex];

                    boolean temp = is_sub_str_in_dictionary || (is_cut1_in_dictionary && is_cut2_in_dictionary);

                    table[startIndex][endIndex] = temp || table[startIndex][endIndex];
                }

            }
        }
        return table[0][n - 1];
    }

    static boolean isInDictionary(String str) {
        // String[] dictionary = { "i", "a", "am", "ace" };

        String[] dictionary = { "i", "ok", "go" };
        return Arrays.stream(dictionary).anyMatch(str::equals);
    }

}