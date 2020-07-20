import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/count-occurrences-of-anagrams/
 * 
 * Given a word and a text, return the count of the occurrences of anagrams of the word in the text(
 * For eg: anagrams of word for are for, ofr, rof ....
 * 
 * 
 * 
 * Input : 
 * text = forxxorfxdofr
 * word = for
 * 
 * Output : 3
 * Explanation : Anagrams of the word for - for, orf, ofr appear in the text and hence the count is 3.
 * 
 * 
 * Input : 
 * text = aabaabaa
 * word = aaba
 * Output : 4
 * Explanation : Anagrams of the word aaba - aaba, abaa each appear twice in the text and hence the count is 4.
 * 
 * 
 */

/**
 * 
 * 
 * we can construct current count window from previous window in O(1) time using sliding window concept. 
 * 
 * 
 * TC = O(n)
 * SC = O(1) //counter array is fixed in size and checking the counter array to have all zeros is also O(k)
 * 
 * 
 * 
 */

class p6_anagram_occurances {

    public static void main(String[] args) {

        String text = "forxxorfxdofr";
        String word = "for";

        int answer = Solution.function(text, word);

        System.out.println(answer);

    }

}

class Solution {

    static int function(String text, String word) {

        int N = text.length();
        int n = word.length();

        int[] count = new int[26];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            count[text.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            count[word.charAt(i) - 'a']--;
        }

        if (occurance_found(count)) {
            answer++;
        }

        for (int i = n; i < N; i++) {

            int idx_to_add = i; //last index of curr window
            int idx_to_sub = i - n; //last index of prev winodw

            count[text.charAt(idx_to_add) - 'a']++;
            count[text.charAt(idx_to_sub) - 'a']--;

            if (occurance_found(count)) {
                answer++;
            }
        }

        return answer;

    }

    static boolean occurance_found(int[] count) {
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}