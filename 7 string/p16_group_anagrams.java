 import java.util.*;

/**
 * leetcode id : 
 * 
 * Given an array of strings, return all groups of strings that are anagrams. 
 * 
 * 
 *  
 * =========
 * example 
 * =========
 * Input:
 * N = 5
 * words[] = {act,god,cat,dog,tac}
 * Output: 
 * god dog
 * act cat tac
 * Explanation: There are 2 groups of
 * anagrams god, dog make group 1.
 * act, cat, tac make group 2.  
 * 
 *  
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * Here, we first sort each word, use sorted word as key and then put original word in a map. 
 * 
 * The value of the map will be a list containing all the words which have same word after sorting. 
 * 
 * Lastly, we will print all values from the hashmap where size of values will be greater than 1.
 * 
 * ============
 * TC = O()
 * SC = O()
 * 
 * 
 * 
 */

class p16_group_anagrams {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();

        input.add("act");
        input.add("god");
        input.add("cat");
        input.add("tac");
        input.add("dog");
        function(input);
    }

    static void function(List<String> input) {

        Map<String, List<String>> hmap = new HashMap<>();

        for (String inp : input) {

            char[] inp_arr = inp.toCharArray();
            Arrays.sort(inp_arr);
            String sorted = String.valueOf(inp_arr);

            if (hmap.containsKey(sorted)) {
                List<String> already = hmap.get(sorted);
                already.add(inp);
            } else {
                List<String> brand_new = new ArrayList<>();
                brand_new.add(inp);
                hmap.put(sorted, brand_new);
            }

        }

        for (Map.Entry<String, List<String>> entry : hmap.entrySet()) {
            List<String> anagrams = entry.getValue();

            for (String s : anagrams) {
                System.out.print(s + " ");
            }

            System.out.println();
        }

    }

}
