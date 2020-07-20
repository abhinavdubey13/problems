import java.util.*;

/**
 * 
 * leetcode id : 13
 * 
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * 
 * For example, 2 is written as II in Roman numeral, just two one's added together. 
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. 
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four. 
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * 
 * Example:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * Example:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * 
 */

/**
 * 
 * scan from left to right , the numbers must come in descing order
 * 
 * if increasing order is found : we need to subtract 
 * else continue adding
 * 
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

class p1_roman_num_to_decimal {

    public static void main(String[] args) {

        // String input = "MCMXCIV"; //1994

        // String input = "LVIII"; //58

        String input = "III"; //3

        int answer = Solution.function(input);
        System.out.println(answer);

    }

}

class Solution {

    static int function(String input) {

        int n = input.length();

        Map<Character, Integer> hmap = new HashMap<>();

        hmap.put('M', 1000);
        hmap.put('D', 500);
        hmap.put('C', 100);
        hmap.put('L', 50);
        hmap.put('X', 10);
        hmap.put('V', 5);
        hmap.put('I', 1);

        if (n == 1) {
            return hmap.get(input.charAt(0));
        }

        if (n == 2) {
            int first = hmap.get(input.charAt(0));
            int second = hmap.get(input.charAt(1));
            if (first < second) {
                return second - first;
            } else {
                return second + first;
            }
        }

        int i = 1;
        int answer = 0;
        while (i < n) {
            char prev = input.charAt(i - 1);
            char curr = input.charAt(i);

            int prev_num = hmap.get(prev);
            int curr_num = hmap.get(curr);

            if (prev_num < curr_num) {
                answer += (curr_num - prev_num);
                i += 2;
            } else {
                answer += prev_num;
                i += 1;
            }
        }

        if (i == n) {
            answer += hmap.get(input.charAt(n - 1));
        }
        return answer;
    }

}