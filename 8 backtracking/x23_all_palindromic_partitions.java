import java.util.*;

/**
 * leetcode id : 131
 * 
 * 
 * Given a string s, 
 * 
 * partition s such that every substring of the partition is a palindrome. 
 * 
 * Return all possible palindrome partitioning of s
 * 
 * 
 * 
 * ============
 * example : 1
 * ============
 * 
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * 
 * 
 * 
 * 
 * 
 */

class x23_all_palindromic_partitions {

    public static void main(String[] args) {
        String str = "abxba";

        List<List<String>> answer = function_util(str);

        for (List<String> list_i : answer) {
            for (String s : list_i) {
                System.out.print(s + "  ");
            }
            System.out.println();
        }
    }

    static List<List<String>> function_util(String str) {
        if(str == null || str.length() == 0) return new ArrayList<>();

        List<List<String>> answer = new ArrayList<List<String>>();

        dfs(str, 0, answer, new ArrayList<String>());
        return answer;
    }

    static void dfs(String input_string, int start_idx, List<List<String>> answer, List<String> possible_partition) {

        int n = input_string.length();

        if (start_idx >= n) {
            answer.add(new ArrayList<>(possible_partition));
            return;
        }

        for (int end_idx = start_idx; end_idx < n; end_idx++) {

            String partition = input_string.substring(start_idx, end_idx + 1);
            boolean is_palindrome = is_str_palindrom(partition);

            if (is_palindrome) {
                possible_partition.add(partition);//add
                dfs(input_string, end_idx + 1, answer, possible_partition);
                possible_partition.remove(possible_partition.size() - 1);//remove added string
            }
        }

    }

    static boolean is_str_palindrom(String str) {
        if (str.length() < 2) {
            return true;
        }

        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}
