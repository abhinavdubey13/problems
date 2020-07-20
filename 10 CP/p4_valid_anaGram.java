import java.util.*;

/**
 * 
 * leetcode id : 242
 * 
 * 
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * 
 * You may assume the string contains only lowercase alphabets.
 * 
 *  
 */

/**
 * 
 * using : You may assume the string contains only lowercase alphabets.
 * 
 * create 2 freq arrays and compare the 2 arrays
 *
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class p4_valid_anaGram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        boolean answer = Solution.function(s, t);
        System.out.println(answer);

    }

}

class Solution {

    static boolean function(String s, String t) {

        int n1 = s.length();
        int n2 = t.length();

        if (n1 != n2) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        int[] temp1 = new int[26];
        int[] temp2 = new int[26];

        for (int i = 0; i < n1; i++) {
            temp1[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n2; i++) {
            temp2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (temp1[i] != temp2[i]) {
                return false;
            }
        }

        return true;

    }

}