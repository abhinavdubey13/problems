import java.util.*;

/**
 * 
 *
 * 
 *
 * 
 * 
 */

class p2_implement_trie_using_array {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        // trie.insert("a");
        // System.out.println(trie.search("a"));
        System.out.println(trie.search("abc"));
        // System.out.println(trie.search("abc"));
        trie.delete("abc");
        System.out.println(trie.search("abc"));

    }
}

class Trie_node {

    Character data;
    int end_of_word;
    Trie_node[] children;

    Trie_node() {
        data = null;
        end_of_word = 0;
        children = new Trie_node[26];
    }

    Trie_node(char d) {
        data = d;
        end_of_word = 0;
        children = new Trie_node[26];
    }

}

class Trie {

    private Trie_node ROOT;

    public Trie() {
        this.ROOT = new Trie_node();
    }

    public void insert(String word) {
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
                iterator = iterator.children[idx];
            } else {
                Trie_node temp = new Trie_node(curr);
                iterator.children[idx] = temp;
                iterator = iterator.children[idx];
            }
        }
        iterator.end_of_word++;
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        int n = word.length();
        if (n == 0) {
            return false;
        }
        Trie_node iterator = this.ROOT;
        for (int i = 0; i < n; i++) {
            char curr = word.charAt(i);
            int idx = curr - 'a';
            if (iterator.children[idx] != null) {
                iterator = iterator.children[idx];
            } else {
                return false;
            }
        }
        return (iterator.end_of_word > 0);
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        int n = prefix.length();
        if (n == 0) {
            return false;
        }
        Trie_node iterator = this.ROOT;
        for (int i = 0; i < n; i++) {
            char curr = prefix.charAt(i);
            int idx = curr - 'a';
            if (iterator.children[idx] != null) {
                iterator = iterator.children[idx];
            } else {
                return false;
            }
        }
        return true;

    }

    public void delete(String word) {
        boolean word_exist = this.search(word);
        if (!word_exist) {
            return;
        }
        delete_util(word);
    }

    private void delete_util(String word) {
        Trie_node iterator = this.ROOT;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char curr = word.charAt(i);
            int idx = curr - 'a';
            iterator = iterator.children[idx];
        }

        iterator.end_of_word--;
    }

}
