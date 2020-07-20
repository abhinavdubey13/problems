import java.util.*;

/**
 * 
 *
 * 
 *
 * 
 * 
 */

class p_gfg_1_shortest_uniq_prefix_for_every_word {

    public static void main(String[] args) {
        String[] arr = { "zebra", "dog", "duck", "dove" };

        // String[] arr = { "dag", "daf" };

        int n = arr.length;
        String[] answer = new Solution_using_Trie().function(arr, n);
        for (String s : answer) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

class Trie_node {

    Character data;
    boolean end_of_word;
    Trie_node[] children;
    int prefixes;

    Trie_node() {
        data = null;
        end_of_word = false;
        children = new Trie_node[26];
        prefixes = 0;
    }

    Trie_node(char d) {
        data = d;
        end_of_word = false;
        children = new Trie_node[26];
        prefixes = 0;
    }

}

class Solution_using_Trie {

    Trie_node ROOT;

    void insert(String word) {
        if (word == null) {
            return;
        }
        int n = word.length();
        if (n == 0) {
            return;
        }
        Trie_node iterator = this.ROOT;
        for (int i = 0; i < n; i++) {
            char curr = word.charAt(i);
            int idx = curr - 'a';

            if (iterator.children[idx] != null) {
                if (i > 0) {
                    iterator.prefixes++;
                }
                iterator = iterator.children[idx];
            } else {
                Trie_node temp = new Trie_node(curr);
                iterator.children[idx] = temp;
                iterator = iterator.children[idx];
                iterator.prefixes++;
            }

        }
        iterator.end_of_word = true;
    }

    String[] function(String[] arr, int n) {
        ROOT = new Trie_node();
        String[] answer = new String[n];

        for (String s : arr) {
            insert(s);
        }
        // for (int i = 0; i < n; i++) {
        //     StringBuffer curr_prefix = new StringBuffer("");
        //     String prefix = get_prefix(arr[i], arr[i].length(), 0, curr_prefix, this.ROOT);
        //     answer[i] = prefix;
        // }

        return answer;
    }

    String get_prefix(String str, int n, int idx, StringBuffer prefix, Trie_node node) {

        if (idx + 1 == n) {
            return str;
        }

        else {
            char curr = str.charAt(idx);
            prefix.append(curr);
            boolean is_valid_prefix = is_valid(node.children[curr - 'a']);
            if (is_valid_prefix) {
                return prefix.toString();
            } else {
                int next_idx = str.charAt(idx) - 'a';
                return get_prefix(str, n, idx + 1, prefix, node.children[next_idx]);
            }
        }

    }

    boolean is_valid(Trie_node node) {
        int count = 0;
        for (Trie_node n : node.children) {
            count += (n == null) ? 0 : 1;
        }
        return count <= 1;
    }

}
