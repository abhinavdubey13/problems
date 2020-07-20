import java.util.*;

/**
 * 
 *
 * 
 *
 * 
 * 
 */

class p1_implement_trie_using_map {

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
    Map<Character, Trie_node> children;

    Trie_node() {
        data = null;
        end_of_word = 0;
        children = new HashMap<>();
    }

    Trie_node(char d) {
        data = d;
        end_of_word = 0;
        children = new HashMap<>();
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
            if (iterator.children.containsKey(curr)) {
                iterator = iterator.children.get(curr);
            } else {
                Trie_node temp = new Trie_node(curr);
                iterator.children.put(curr, temp);
                iterator = iterator.children.get(curr);
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
            if (iterator.children.containsKey(curr)) {
                iterator = iterator.children.get(curr);
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
            if (iterator.children.containsKey(curr)) {
                iterator = iterator.children.get(curr);
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
        delete_util(word, 0, word.length(), this.ROOT.children.get(word.charAt(0)));
    }

    private void delete_util(String word, int idx, int n, Trie_node node) {

        if (idx + 1 == n) {
            node.end_of_word--;
            return;
        }

        char curr = word.charAt(idx);
        char next = word.charAt(idx + 1);

        delete_util(word, idx + 1, n, node.children.get(next));

        if (node.children.get(next) != null && node.children.get(next).end_of_word <= 0) {
            node.children.remove(curr);
        }

    }

}
