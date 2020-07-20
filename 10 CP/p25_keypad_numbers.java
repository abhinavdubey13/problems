import java.util.*;

/**
 * 
 * leetcode id : 17
 * 
 * Given a string containing digits from 2-9 inclusive, 
 * return all possible letter combinations that the number could represent. Return the answer in any order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 
 * 
 * 
Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 *  
 */

/**
 * 
 * 
 * dfs and backtracking
 * 
 * 
 * TC = 
 * SC = 
 * 
 */

class p25_keypad_numbers {

    public static void main(String[] args) {
        String input = "79";

        List<String> answer = new Solution().function(input);

        for (String s : answer)
            System.out.print(s + " ");
        System.out.println();
    }

}

class Solution {

    List<String> answer;
    Map<Character, char[]> hmap;

    List<String> function(String input) {

        answer = new LinkedList<>();

        int n = input.length();

        if (input == null || n == 0) {
            return answer;
        }

        hmap = new HashMap<>();
        hmap.put('2', new char[] { 'a', 'b', 'c' });
        hmap.put('3', new char[] { 'd', 'e', 'f' });
        hmap.put('4', new char[] { 'g', 'h', 'i' });
        hmap.put('5', new char[] { 'j', 'k', 'l' });
        hmap.put('6', new char[] { 'm', 'n', 'o' });
        hmap.put('7', new char[] { 'p', 'q', 'r', 's' });
        hmap.put('8', new char[] { 't', 'u', 'v' });
        hmap.put('9', new char[] { 'w', 'x', 'y', 'z' });

        dfs(input, n, 0, "");
        return answer;
    }

    void dfs(String input, int n, int idx, String str) {
        if (idx == n) {
            answer.add(str);
        } else {

            char curr = input.charAt(idx);
            for (char c : hmap.get(curr)) {
                String str2 = str + c;
                dfs(input, n, idx + 1, str2);

            }

        }
    }

}
