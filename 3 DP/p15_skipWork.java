import java.util.*;

/**
 * 
 * Given an array A[] denoting the time taken to complete N tasks, determine the MINIMUM amount of time required to finish the tasks .
 * Considering that you can skip any task, but skipping two consecutive tasks is forbidden.
 * 
 */

/**
 * solution with space = O(n)
 * in this we maintain 2 1-D arrays c/d tableExclusion(TE) and tableInclusion(TI)
 * 
 * tableInclusion[i] represents the min-time when from A[0....i] we include the i'th element (tableInclusion[0]=A[0])
 * tableExclusion[i] represents the min-time when from A[0....i] we exclude the i'th element (tableExclusion[0]=0)
 * 
 * tableExclusion[i] = tableInclusion[i-1]                                     => if we exclude A[i] , the we MUST include A[i-1]
 * tableInclusion[i] = A[i]+ MIN ( tableExlusion[i-1] , tableInclusion[i-1] )  => if we include A[i] , the we can include/exclude A[i-1]
 * 
 * 
 * solution with space = O(1)
 * is same as the above , but instead of 2 tables , we maintain 2 variale , 
 * bcz to calucate i'th value in the above 2 tables , at any time we need just the previous 2 values
 * 
 * 
 */

class p15_skipWork {

    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 4, 8, 6, 7, 10 };
        // int[] arr = { 5, 6, 7, 8, 9, 10 };
        int answer = calulator(arr);
        System.out.println(answer);
    }

    // SPACE = O(n)
    static int calulator_2(int[] arr) {
        int[] tableExclusion = new int[arr.length];
        int[] tableInclusion = new int[arr.length];

        tableExclusion[0] = 0;
        tableInclusion[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            tableExclusion[i] = tableInclusion[i - 1]; // if current is excluded then previous index value is to be included
            tableInclusion[i] = arr[i] + Math.min(tableExclusion[i - 1], tableInclusion[i - 1]); // if current is included then prev may/maynot be included
        }
        return Math.min(tableExclusion[arr.length - 1], tableInclusion[arr.length - 1]);
    }

    // space = O(1)
    static int calulator(int[] arr) {

        int prev_excluded = 0;
        int prev_included = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int curr_excluded = prev_included;
            int curr_included = arr[i] + Math.min(prev_excluded, prev_included);

            prev_excluded = curr_excluded;
            prev_included = curr_included;
        }
        
        return Math.min(prev_excluded, prev_included);
    }
}