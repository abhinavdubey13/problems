import java.util.*;

/**
 * 
 * leetcode id : 283
 * 
 * 
 *
 * 
 *  
 */

/**
 * 
 * 
 * 
 * 
 */

class p6_excel_sheet {

    public static void main(String[] args) {

        String s = "A";
        int answer = Solution.function(s);
        System.out.println(answer);

    }

}

class Solution {

    static int function(String s) {

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;

    }

}
