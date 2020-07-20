import java.util.*;

/**
 * leetcode id : 1481
 * 
 * Given an array of integers arr and an integer k. 
 * 
 * Find the least number of unique integers after removing exactly k elements.
 * 
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: arr = [4,3,1,1,3,3,2], k = 3
 * 
 * Output: 2
 * 
 * Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 * 
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 * Use a map to count the frequencies of the numbers in the array. 
 * An optimal strategy is to remove the numbers with the smallest count first.  
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class x39_unique_elements_after_deletion {

    public static void main(String[] args) {

        int[] arr = { 4, 3, 1, 1, 3, 3, 2 };
        int k = 3;

        int answer = function(arr, k);

        System.out.println(answer);

    }

    static int function(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> uniques = new ArrayList<>(map.keySet());

        Collections.sort(uniques, (a, b) -> map.get(a) - map.get(b));

        int n = map.size(), remove = 0, idx = 0;
        
        while (k > 0 && idx < n) {
            k -= map.get(uniques.get(idx++));
            if (k >= 0)
                remove++;
        }
        return n - remove;

    }

}
