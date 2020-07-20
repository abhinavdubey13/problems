import java.util.*;

/**
 * leetcode id : 1122
 * 
 * Given two arrays arr1 and arr2, 
 * 
 * the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * 
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  
 * 
 * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 * 
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * 
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
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
 * 1. used hashmap to store <element of arr1 , count>
 * 
 * 2. iterate over arr2 and decement count of hashmap , use a list here to store
 * 
 * 3. for remaining elements , use a seperate list
 * 
 * 4. merge 2 lists
 *
 *  
 * 
 * ============
 * TC = O(n.logn)
 * SC = O(n)
 * 
 * 
 * 
 */

class x29_relative_sort {

    public static void main(String[] args) {

        // int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        // int[] arr2 = { 2, 1, 4, 3, 9, 6 };

        int arr1[] = { 28, 6, 22, 8, 44, 17 };
        int[] arr2 = { 22, 28, 8, 6 };

        int[] list_1 = function(arr1, arr2);

        // System.out.println(list_1);
        for (int i = 0; i < list_1.length; i++) {
            System.out.print(list_1[i] + " ");
        }
        System.out.println();
    }

    static int[] function(int[] arr1, int[] arr2) {

        Map<Integer, Integer> my_map = new HashMap<>();

        for (int i : arr1) {
            int x = my_map.getOrDefault(i, 0);
            x++;
            my_map.put(i, x);
        }

        List<Integer> list_1 = new ArrayList<>();

        for (int i : arr2) {

            int count = my_map.getOrDefault(i, 0);
            while (count > 0) {
                list_1.add(i);
                count--;
                my_map.put(i, count);
            }

        }

        List<Integer> list_2 = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : my_map.entrySet()) {
            for (int count = 1; count <= entry.getValue().intValue(); count++) {
                list_2.add(entry.getKey().intValue());
            }
        }

        Collections.sort(list_2);

        int[] answerArr = new int[arr1.length];
        int i = 0;
        for (i = 0; i < list_1.size(); i++) {
            answerArr[i] = list_1.get(i);
        }

        for (int j = 0; j < list_2.size(); j++) {
            answerArr[i + j] = list_2.get(j);
        }

        return answerArr;
    }

}
