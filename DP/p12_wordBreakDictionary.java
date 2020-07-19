//given a dictionary of words and a string, find whether the string can be broken into substring , such that each substring belongs to that Dictionary

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
 */

import java.util.ArrayList;
import java.util.Arrays;
class p12_wordBreakDictionary {

    public static void main(String[] args) {

        // String word = "iamace";

        String word = "okigoi";
        // String word = "okigoio";

        boolean answer = calulator(word.toCharArray());
        System.out.println(answer);

    }

    static boolean calulator(char[] word) {

        String wordString = new String(word);

        boolean[][] table = new boolean[word.length][word.length];

        for (int considerLength = 1; considerLength <= word.length; considerLength++) {
            for (int startIndex = 0; startIndex + considerLength - 1 < word.length; startIndex++) {
                int endIndex = startIndex + considerLength - 1;

                if (considerLength == 1) {
                    String subStr = Character.toString(wordString.charAt(startIndex));
                    boolean temp = isInDictionary(subStr);
                    table[startIndex][endIndex] = temp;
                    continue;
                }

                for (int cutEndIdx = startIndex; cutEndIdx < endIndex; cutEndIdx++) {
                    String subStr = wordString.substring(startIndex, endIndex + 1);

                    boolean cut1 = table[startIndex][cutEndIdx];
                    boolean cut2 = table[cutEndIdx + 1][endIndex];

                    boolean temp = isInDictionary(subStr) || (cut1 && cut2);

                    table[startIndex][endIndex] = temp || table[startIndex][endIndex];
                }

            }
        }
        return table[0][word.length - 1];
    }

    static boolean isInDictionary(String str) {
        // String[] dictionary = { "i", "a", "am", "ace" };
        String[] dictionary = { "i", "ok", "go" };

        return Arrays.stream(dictionary).anyMatch(str::equals);
    }

}