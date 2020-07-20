import java.util.*;

/**
 * 
 *
 * https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/ 
 *
 * 
 */

/**
 * 
 * graph based solution
 * using BFS 
 *
 *
 * 
 * 
 */

class x39_word_ladder {

    public static void main(String[] args) {

        //expected : 7
        // Set<String> D = new HashSet<>();
        // D.add("poon");
        // D.add("plee");
        // D.add("same");
        // D.add("poie");
        // D.add("plie");
        // D.add("poin");
        // D.add("plea");
        // String start = "toon";
        // String end = "plea";

        //expected : 4
        Set<String> D = new HashSet<>();
        D.add("abcd");
        D.add("ebad");
        D.add("ebcd");
        D.add("poie");
        D.add("xyza");
        String start = "abcv";
        String end = "ebad";

        int answer = Solution.function(start, end, D);
        System.out.println(answer);
    }

}

class Solution {

    static int function(String start, String end, Set<String> valid_words) {

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(start);

        int counter = 0;

        while (q.size() > 0) {
            int n = q.size();
            String removed = q.poll();
            counter++;

            if (end.equals(removed)) {
                return counter;
            }

            for (int i = 0; i < n; i++) {
                for (String v : valid_words) {
                    boolean adj = is_adjacent(removed, v);

                    //might fall into infinite loop is not keeping track of visited
                    if (adj && !visited.contains(v)) {
                        q.add(v);
                        visited.add(v);
                    }
                }
            }
        }

        return counter;
    }

    static boolean is_adjacent(String a, String b) {
        int diff = 0;
        for (int ai = 0, bi = 0; ai < a.length() && bi < b.length(); ai++, bi++) {
            if (a.charAt(ai) != b.charAt(bi)) {
                diff++;
            }
        }

        return diff == 1;
    }
}
