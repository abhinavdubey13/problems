import java.util.*;

/**
 * leetcode id : 1024
 * 
 * 
 * You are given a series of video clips from a sporting event that lasted T seconds.  
 * 
 * These video clips can be overlapping with each other and have varied lengths.
 * 
 * Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1].  
 * 
 * We can cut these clips into segments freely: for example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
 * 
 * Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event ([0, T]).  
 * 
 * If the task is impossible, return -1.
 * 
 * 
 * 
 * ============
 * example : 1
 * ============
 * 
 * Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * Output: 3
 * Explanation: We take the clips [0,2], [8,10], [1,9]; a total of 3 clips. Then, we can reconstruct the sporting event as follows:
 * We cut [1,9] into segments [1,2] + [2,8] + [8,9]. Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].
 * 
 * 
 * ============
 * example : 2
 * ============ 
 * Input: clips = [[0,1],[1,2]], T = 5
 * Output: -1
 * Explanation: 
 * We can't cover [0,5] with only [0,1] and [1,2].
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
 * variation on Longest incresing subseq
 * 
 * sort in ascending order of clip[0] , ie beginning time of the clip
 * 
 * ==============
 * TC = n^2
 * SC = n
 * 
 * 
 * 
 */

class x22_video_stiching {

    public static void main(String[] args) {

        //expected = 3
        // int[][] clips = { { 0, 1 }, { 6, 8 }, { 0, 2 }, { 5, 6 }, { 0, 4 }, { 0, 3 }, { 6, 7 }, { 1, 3 }, { 4, 7 },
        //         { 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 4 }, { 4, 5 }, { 5, 7 }, { 6, 9 } };
        // int T = 9;

        //expected = 2
        // int[][] clips = { { 0, 4 }, { 2, 8 } };
        // int T = 2;

        //expected = -1
        // int[][] clips = { { 0, 1 }, { 1, 2 } };
        // int T = 5;

        //expected = 3
        // int[][] clips = { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } };
        // int T = 10;

        //expected = -1
        // int[][] clips = { { 0, 2 }, { 4, 8 } };
        // int T = 5;

        //expected = -1
        // int[][] clips = { {5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10} };
        // int T = 5;

        //expected = -1
        int[][] clips = { { 8, 10 }, { 17, 39 }, { 18, 19 }, { 8, 16 }, { 13, 35 }, { 33, 39 }, { 11, 19 },
                { 18, 35 } };
        int T = 20;

        int answer = function(clips, T);

        System.out.println("answer : " + answer);
    }

    static int function(int[][] arr, int T) {

        int n = arr.length;

        if (T == 0) {
            return 0;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return (o1[0] - o2[0]);
                } else {
                    return (o1[1] - o2[1]);
                }
            }
        });


        if (arr[n - 1][1] < T) {
            return -1;
        }

        int[] dp = new int[n];

        //all the clips starting with 0 , will hava dp[i]=1
        int i = 0;
        for (; arr[i][0] == 0; i++) {
            dp[i] = 1;
        }

        for (; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {

                //if i'th clip starts before j'th ends , then only we can include
                if (arr[j][1] >= arr[i][0]) {
                    dp[i] = (dp[j] != Integer.MAX_VALUE) ? Math.min(dp[i], 1 + dp[j]) : Integer.MAX_VALUE;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (arr[k][1] >= T) {
                answer = Math.min(answer, dp[k]);
            }
        }

        return (answer == Integer.MAX_VALUE) ? -1 : answer;

    }

}