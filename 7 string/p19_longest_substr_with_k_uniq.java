import java.util.*;

/**
 * 
 * leetcode id : 
 * 
 * Given a string you need to print length of longest possible substring that has exactly k unique characters. 
 * 
 * 
 * 
 *  
 * =========
 * example 
 * =========
 * i/p : aabbcc , k=1
 * o/p : 2
 * Max substring can be any one from {"aa" , "bb" , "cc"}.
 * 
 * 
 * i/p : aabbcc , k=2
 * o/p : 4
 * Max substring can be any one from {"aabb" , "bbcc"}.
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *
 * Idea is to maintain a window and add elements to the window till it contains less or equal k, update our result if required while doing so. 
 * If unique elements exceeds than required in window, start removing the elements from left side.
 * 
 * ============
 * TC = O(n)
 * SC = O(1) //hasmamp can have atmost 26 entries
 * 
 * 
 * 
 */

class p19_longest_substr_with_k_uniq {

    public static void main(String[] args) {
        String input = "aabacbebebe";
        int K = 3;

        int answer = function(input, K);
        System.out.println(answer);
    }

    static int function(String input, int K) {

        char[] arr = input.toCharArray();
        int n = arr.length;

        Map<Character, Integer> freq_map = new HashMap<>();
        int count_uniques = 0;

        for (char c : arr) {
            int curr_freq = freq_map.getOrDefault(c, 0);
            count_uniques += (curr_freq == 0) ? 1 : 0;
            freq_map.put(c, ++curr_freq);
        }

        if (count_uniques < K) {
            System.out.println("not possible");
            return 0;
        }

        freq_map.clear();

        // start and end variables. 
        int curr_start = 0, curr_end = 0;

        // Also initialize values for result longest window 
        int max_window_size = 1, max_window_start = 0;

        freq_map.put(arr[0], 1); // put the first character 

        for (int i = 1; i < n; i++) {
            int curr_freq = freq_map.getOrDefault(arr[i], 0);
            freq_map.put(arr[i], curr_freq + 1);

            curr_end++;

            while (!isValid(freq_map, K)) {
                int cnt = freq_map.get(arr[curr_start]);
                freq_map.put(arr[curr_start], --cnt);
                curr_start++;
            }

            // Update the max window size if required 
            int curr_window_size = curr_end - curr_start + 1;
            if (curr_window_size > max_window_size) {
                max_window_size = curr_window_size;
                max_window_start = curr_start; //one of the possible answer starts from this variable's value
            }

        }

        return max_window_size;

    }

    // This function calculates number of unique characters 
    // using a associative array count[]. Returns true if 
    // no. of characters are less than required else returns 
    // false. 
    static boolean isValid(Map<Character, Integer> freq_map, int K) {
        int uniq_chars = 0;

        for (Map.Entry<Character, Integer> entry : freq_map.entrySet()) {
            if (entry.getValue() > 0) {
                uniq_chars++;
            }
        }

        // unique chars must be atmost K for window to be valid
        return (uniq_chars <= K);
    }

}
