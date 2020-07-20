import java.util.*;

/**
 * 
 * Given a set of n nuts of different sizes and n bolts of different sizes. 
 * There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.
 * 
 * 
 * Constraint: Comparison of a nut to another nut or a bolt to another bolt is not allowed. 
 * It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.
 * https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem-set-2-hashmap/
 *  
 * 
 */

/**
 * =========================
 * approach 1  : quicksort
 * ========================
 * 
 * 
 * 
 * =========================
 * approach 2  : hashmap
 * ========================= 
 * TC= O(n)
 * SC= O(n)
 * 
 * 
 * 
 * 
 */

class p15_nuts_and_bolts {

    public static void main(String[] args) {

        char nuts[] = { 'a', 'c', 'b', 'd', 'f', 'e' };
        char bolts[] = { 'b', 'd', 'e', 'f', 'a', 'c' };
        function(nuts, bolts);
    }

    static void function(char[] nuts, char bolts[]) {

        Map<Character, Integer> my_map = new HashMap<Character, Integer>();

        //hashmap for nuts and its count
        for (int i = 0; i < nuts.length; i++) {
            my_map.put(nuts[i], i);
        }

        for (int i = 0; i < bolts.length; i++) {
            if (my_map.get(bolts[i]) == null) {
                System.out.println("invalid sequence");
                return;
            }

            nuts[i] = bolts[i];
        }

        for (int i = 0; i < nuts.length; i++) {
            System.out.print(nuts[i] + " " + bolts[i]);
            System.out.println();
        }

    }

}