import java.util.*;

/**
 * Given two arrays A and B of equal size, 
 * 
 * the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 * 
 * Return any permutation of A that maximizes its advantage with respect to B.
 * 
 * 
 * ===========
 * example -1
 * ===========
 * Input: 
 * A = [2,7,11,15], 
 * B = [1,10,4,11]
 * 
 * Output: [2,11,7,15]
 * 
 * 
 */

/**
 *  
 * ===========
 * approach : 
 * ===========
 * 
 * Count elements in A to a map m.
 * 
 * For each element in B, find the least bigger element in map m.
 * 
 * Otherwise, we'll take the smallest element.
 * 
 * Then we update the m (reduce count , or remove if count =0)
 *  
 * ============
 * TC = O(n.logn)
 * SC = O(n)
 * 
 * 
 */

class x11_advantage_sort {

    public static void main(String[] args) {
        int[] B = { 13, 25, 32, 11 };
        int[] A = { 12, 24, 8, 32 };

        int[] answer = function(A, B);
        print_array(answer);
    }

    static int[] function(int[] A, int[] B) {
        TreeMap<Integer, Integer> sorted_map = new TreeMap<>();
        for (int i : A) {
            int count_of_i = sorted_map.getOrDefault(i, 0);
            count_of_i++;
            sorted_map.put(i, count_of_i);
        }

        int[] answer = new int[A.length];

        for (int i = 0; i < A.length; i++) {

            Integer x = sorted_map.higherKey(B[i]);

            if (x == null) {
                x = sorted_map.firstKey();
            }
            answer[i] = x;
            sorted_map.put(x, sorted_map.get(x) - 1);
            if (sorted_map.get(x) == 0) {
                sorted_map.remove(x);
            }
        }

        return answer;
    }

    static void print_array(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
