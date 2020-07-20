import java.util.*;

/**
 * Given an array of integers arr and an integer k.
 * 
 * A value arr[i] is said to be stronger than a value arr[j] if |arr[i] - m| > |arr[j] - m| where m is the median of the array.
 * 
 * If |arr[i] - m| == |arr[j] - m|, then arr[i] is said to be stronger than arr[j] if arr[i] > arr[j].
 * 
 * Return a list of the strongest k values in the array. return the answer in any arbitrary order.
 * 
 * 
 * NOTE : Median is the middle value in an ordered integer list. More formally, if the length of the list is n, the median is the element in position ((n - 1) / 2) in the sorted list (0-indexed).
 * 
 * For arr = [6, -3, 7, 2, 11], n = 5 and the median is obtained by sorting the array arr = [-3, 2, 6, 7, 11] and the median is arr[m] where m = ((5 - 1) / 2) = 2. The median is 6.
 * 
 * For arr = [-7, 22, 17, 3], n = 4 and the median is obtained by sorting the array arr = [-7, 3, 17, 22] and the median is arr[m] where m = ((4 - 1) / 2) = 1. The median is 3.
 *
 * ==========
 * example : 
 * ==========
 * 
 * Input: arr = [1,2,3,4,5], k = 2
 * 
 * Output: [5,1]
 * 
 * Explanation: Median is 3, the elements of the array sorted by the strongest are [5,1,4,2,3]. 
 * The strongest 2 elements are [5, 1]. [1, 5] is also accepted answer.
 * 
 * Please note that although |5 - 3| == |1 - 3| but 5 is stronger than 1 because 5 > 1.
 * 
 * 
 * 

 * 
 */

/**
 *  
 * ============
 * approach : 
 * ============
 * 
 * sort input array
 * 
 * find median
 * 
 * calculate diff with median for each object
 * 
 * sort the auxillary array with custom sorting logic using comparator (MAX HEAP WILL NOT WORK HERE)
 *
 *  
 * ============
 * TC = O(N.logN)
 * SC = O(n)
 * 
 * 
 */

class HelperObject {
    double diff_with_median;
    int element;

    HelperObject(double d, int e) {
        this.diff_with_median = d;
        this.element = e;
    }
}

class x8_k_strongest_elements {

    public static void main(String[] args) {
        // int[] input = { 1, 2, 3, 4, 5 }; // expected = [5,1]
        int[] input = { -7, 22, 17, 3 }; // expected = [22,17]

        int k = 2;
        int[] answer = function(input, k);
        print_array(answer);
    }

    static int[] function(int[] arr, int k) {

        Arrays.sort(arr);

        int median = arr[(arr.length - 1) / 2];

        List<HelperObject> my_list = new ArrayList<>();
        for (int i : arr) {
            double d = Math.abs(i - median);
            my_list.add(new HelperObject(d, i));
        }

        Collections.sort(my_list, new Comparator<HelperObject>() {
            public int compare(HelperObject o1, HelperObject o2) {
                if (o1.diff_with_median == o2.diff_with_median) {
                    return -1 * (o1.element - o2.element);
                }
                return -Double.compare(o1.diff_with_median, o2.diff_with_median);
            }
        });

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = my_list.get(i).element;
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
