import java.util.*;

/**
 * leetcode id : 1338
 * 
 * Given an array arr (even length).  
 * 
 * You can choose a set of integers and remove all the occurrences of these integers in the array.
 * 
 * Return the minimum size of the set so that ATLEAST** half of the integers of the array are removed.
 * 
 *  
 * ===========
 * example -1
 * ===========
 * Input: arr = [3,3,3,3,5,5,5,2,2,7]
 * Output: 2
 * 
 * Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] 
 * which has size 5 (i.e equal to half of the size of the old array).
 * 
 * Possible sets of size 2 are {3,5},{3,2},{5,2}.
 * 
 * Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] 
 * which has size greater than half of the size of the old array.
 * 
 * 
 * ===========
 * example -2
 * ===========
 * Input: arr = [1000,1000,3,7]
 * Output: 1
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
 * 
 *
 * 1. make frequency hashtable
 * 2. extract all frequency in a list
 * 3. sort that list
 * 4. now question becomes , the number of elements required to make the sum >= n/2
 * 
 *  
 * 
 * ============
 * let number of unique elemets = k
 * TC = O(K.logK)
 * SC = O(K)
 * 
 * 
 * 
 */

class x32_reduce_array_to_half {

    public static void main(String[] args) {

        // int[] arr = { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 }; //expected = 2
        // int[] arr = { 1,2,3,4,5,6,7,8,9,10 }; //expected = 5
        // int[] arr = {7,7,7,7,7,7} ;//expected =1;
        int[] arr = { 1, 1, 2, 3 }; //expected = 1

        int answer = function(arr);

        System.out.println(answer);
        // for (int i = 0; i < len; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
    }

    static int function(int[] arr) {

        int n = arr.length;

        if (n < 2) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        Map<Integer, Integer> count = new HashMap<>();

        for (int i : arr) {
            int c = count.getOrDefault(i, 0);
            c++;
            count.put(i, c);
        }

        List<Integer> frequency_list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            frequency_list.add(entry.getValue().intValue());
        }

        //sorting in descing order
        Collections.sort(frequency_list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        });

        int set_size = 0;
        int total_elements_removed = 0;

        for (int i = 0; i < frequency_list.size(); i++) {
            total_elements_removed += frequency_list.get(i);
            set_size++;

            if (total_elements_removed >= n / 2) {
                break;
            }
        }

        return set_size;

    }

}
