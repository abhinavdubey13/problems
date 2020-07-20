import java.util.*;

/**
 * leetcode id : https://www.geeksforgeeks.org/weighted-job-scheduling-set-2-using-lis/
 * 
 * Given N jobs where every job is represented by following three elements of it.
 * 1. Start Time 
 * 2. Finish Time 
 * 3. Profit or Value Associated
 * 
 * find the maximum profit subset of jobs such that no two jobs in the subset overlap
 *  
 * =========
 * example:
 * =========
 * Input:  Number of Jobs n = 4
 * Job Details {Start Time, Finish Time, Profit}
 * Job 1: {1, 2, 50}
 * Job 2: {3, 5, 20}
 * Job 3: {6, 19, 100}
 * Job 4: {2, 100, 200}
 * 
 * Output: 250
 * 
 * Explanation: We can get the maximum profit by scheduling jobs 1 and 4 and maximum profit is 250.
 * 
 *
 *
 * 
 */

/**
 *  
 * 
 * ==========
 * approach : 
 * ==========
 * 
 * DP solution is discussed where we also print the Jobs. This problem is a variation of standard Longest Increasing Subsequence (LIS) problem. We need a slight change in the Dynamic Programming solution of LIS problem.
 * 
 * We first need to sort jobs according to start time. 
 * 
 * Let job[0..n-1] be the array of jobs after sorting. 
 * 
 * We define vector L such that L[i] is itself is a vector that stores Weighted Job Scheduling of job[0..i] that ends with job[i]. 
 * 
 * 
 * 
 *
 * ===========
 * TC = O(n.n)
 * SC = O(n)
 * 
 * 
 * 
 * 
 */

class Job {
    int start, finish, profit;

    public Job(int start, int finish, int profit) {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }
};

public class p69_job_scheduling {
    public static void main(String[] args) {

        Job[] a = { new Job(3, 10, 20), new Job(1, 2, 50), new Job(6, 19, 100), new Job(2, 100, 200) };

        ArrayList<Job> arr = new ArrayList<>(Arrays.asList(a));

        int answer = function(arr);

        System.out.println(answer);
    }

    static int function(ArrayList<Job> arr) {

        int n = arr.size();
        int[] dp = new int[n];

        // Sort arr[] by start time.
        Collections.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job x, Job y) {
                return x.start - y.start;
            }
        });

        for (int i = 0; i < n; i++) {
            dp[i] = arr.get(i).profit;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(i).start >= arr.get(j).finish) {
                    dp[i] = Math.max(dp[i], arr.get(i).profit + dp[j]);
                }
            }
        }

        int answer = 0;
        for (int i : dp) {
            answer = Math.max(answer, i);
        }
        return answer;
    }

}
