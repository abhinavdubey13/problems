/**
 * 
 * given A[], find the subarray , whose sum is max (subarray => elements must be contigous)
 * 
 * KADANE"S Algorithm
 * 
 */

/**
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 */

public class p30_maxSumSubArray {
    public static void main(String[] args) {

        //expected = 7 
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int answer = calculator(arr);
        System.out.println(answer);

        int answer2 = Practise.calculator(arr);
        System.out.println(answer2);

    }

    static int calculator(int[] arr) {

        int max_ending_here = arr[0]; //sum of subarray , till i'th index
        int max_so_far = arr[0]; //sum of subarray , which is max overall

        for (int i = 1; i < arr.length; i++) {

            max_ending_here = max_ending_here + arr[i];

            max_ending_here = Math.max(arr[i], max_ending_here);

            max_so_far = Math.max(max_ending_here, max_so_far);
        }
        return max_so_far;
    }

}

class Practise {

    static int calculator(int[] arr) {
        int answer = arr[0];
        int cur_max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cur_max = Math.max(arr[i], arr[i] + cur_max);
            answer = Math.max(answer, cur_max);
        }
        return answer;
    }

}