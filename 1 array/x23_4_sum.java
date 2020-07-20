import java.util.*;

/**
 * leetcode id : 18
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums 
 * 
 * such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * 
 * NOTE : the solution set must not contain duplicate quadruplets.
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * 
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
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
 * we have generalised the problem for k-sum
 * 
 * we use 2 concepts :
 * 
 * 1. 2-sum Problem
 * 2. Reduce K sum problem to K – 1 sum Problem
 * 
 * use recursion to solve this problem
 * 
 * 
 * ============ 
 * TC = O(K.n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x23_4_sum {

    public static void main(String[] args) {

        int[] arr = { -1, -2, 1, 0, 2, 0 };
        int target_sum = 0;
        int group_size = 4;

        List<List<Integer>> answer = function_util(arr, 0, group_size, target_sum);

        // System.out.println(answer);
        for (List<Integer> li : answer) {
            for (Integer i : li) {
                System.out.print(i + " ");
            }
            System.out.println();

        }
        System.out.println();
    }

    static List<List<Integer>> function_util(int[] arr, int start_idx, int group_size, int target_sum) {
        Arrays.sort(arr);
        return function(arr, start_idx, group_size, target_sum);
    }

    static ArrayList<List<Integer>> function(int[] arr, int start_idx, int group_size, int target_sum) {

        int n = arr.length;

        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();

        if (group_size == 2) {

            int end_idx = n - 1;

            while (start_idx < end_idx) {
                if (arr[start_idx] + arr[end_idx] == target_sum) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[start_idx]);
                    temp.add(arr[end_idx]);
                    answer.add(temp);

                    //skipping duplicates
                    while (start_idx < end_idx && arr[start_idx + 1] == arr[start_idx])
                        start_idx++;
                    while (start_idx < end_idx && arr[end_idx - 1] == arr[end_idx])
                        end_idx--;

                    //without the below , all pairs will not be found , it will go into infinite loop
                    //consider this as the operation when all elements are unique
                    start_idx++;
                    end_idx--;

                } else if (arr[start_idx] + arr[end_idx] < target_sum) {
                    start_idx++;
                } else {
                    end_idx--;
                }
            }

        } else {

            //it must be possible to grup k-elements together
            int last_possible_i = n - group_size;

            for (int i = start_idx; i <= last_possible_i; i++) {

                //avoid duplicate
                if (i > start_idx && arr[i - 1] == arr[i])
                    continue;

                int new_target_sum = target_sum - arr[i];

                List<List<Integer>> temp = function(arr, i + 1, group_size - 1, new_target_sum);

                //for each posible solution , add current number to complete the solution
                for (List<Integer> t : temp) {
                    t.add(0, arr[i]);
                }

                answer.addAll(temp);

            }

        }

        return answer;

    }

}
