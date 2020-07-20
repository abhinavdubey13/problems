import java.util.*;

/**
 * 
 * Given a sorted array arr[] (distinct elements) and a value X , find the k closest elements to X in arr[].
 * 
 * if X is in the array , then ignore that index from array as if is NOT there
 * 
 * https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 * 
 * =========
 * example : 
 * ==========
 * 
 * arr[] = { 1, 2, 3, 6, 10 };
 * k = 3
 * target = 4
 * 
 * o/p : 3, 6, 2
 * 
 * 
 */

/**
 * ===========
 * approach :
 * ===========
 * 
 * step-1 : find the turnover index (index after which arr[i]>X) using binary serach
 * step-2 : Once we find the crossover point, 
 *          we can compare elements on both sides of crossover point to print k closest elements. 
 *          This step takes O(k) time
 * 
 * TC= O(logN + k)
 * SC= O(k) 
 * 
 */

class p26_K_closest_elements {

    public static void main(String[] args) {
        // int arr[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
        // int k = 4;
        // int target = 35;

        int arr[] = { 1, 2, 3, 6, 10 };
        int k = 3;
        int target = 4;

        List<Integer> my_list = function(arr, target, k);

        for (Integer i : my_list) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    static List<Integer> function(int arr[], int target, int k) {

        int left_idx = get_turn_over_idx(arr, target);
        int right_idx = left_idx + 1;

        //ignoring if target is in the array
        if (arr[left_idx] == target) {
            left_idx--;
        }

        List<Integer> my_list = new LinkedList<Integer>();
        for (int i = k; i > 0; i--) {
            int dist_left = (left_idx >= 0) ? Math.abs(target - arr[left_idx]) : -1;
            int dist_right = (right_idx < arr.length) ? Math.abs(target - arr[right_idx]) : -1;

            if (dist_left < dist_right) {
                my_list.add(arr[left_idx]);
                left_idx--;
            } else {
                my_list.add(arr[right_idx]);
                right_idx++;
            }
        }

        return my_list;
    }

    static int get_turn_over_idx(int[] arr, int target) {

        int high = arr.length - 1;
        int low = 0;

        int return_idx = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int current = arr[mid];
            if (current < target) {
                low = mid + 1;
                if (arr[low] > target) {
                    return_idx = mid;
                    break;
                }
            } else if (current > target) {

                high = mid - 1;
                if (arr[high] < target) {
                    return_idx = mid - 1;
                    break;
                }
            } else if (current == target) {
                return_idx = mid;
                break;
            }

        }

        return return_idx;

    }

}
