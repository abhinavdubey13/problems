import java.util.*;

/**
 * 
 *
 * https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/ 
 *
 *
 * 
 */

/**
 * 
 * 
 * 1.Create a temp string and store concatenation of str1 to str1 in temp.
 *  temp = str1.str1
 * 
 * 2. If str2 is a substring of temp then str1 and str2 are rotations of each other.
 * 
 * 
 *
 * 
 * 
 */

class x41_check_if_string1_is_rotation_of_string2 {

    public static void main(String[] args) {
        String str1 = "AACD";
        String str2 = "ACDA";

        if (Solution.function(str1, str2))
            System.out.println("Yes");
        else
            System.out.printf("no");
    }

}

class Solution {

    static boolean function(String str1, String str2) {
        // There lengths must be same and str2 must be a substring of str1 concatenated with str1.   
        return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);
    }
}