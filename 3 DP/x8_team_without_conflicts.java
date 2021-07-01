import java.util.*;

/**
 * leetcode id : 1626
 * 
 * You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. 
 * The score of the team is the sum of scores of all the players in the team.
 * 
 * However, the basketball team is not allowed to have conflicts. 
 * A conflict exists if a younger player has a strictly higher score than an older player. 
 * A conflict does not occur between players of the same age.
 * 
 * Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, 
 * return the highest overall score of all possible basketball teams.
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
 * similar to using Longest increasing subseq (LIS)
 * 
 * 1. sort the players in ascending order of ages (if age same , use scores to sort)
 * 2. use LIS concept , but here we want age and scores both to be non-decreasing (ie increasing/ same)
 * 
 * 
 * ============
 * TC = O(n^2)
 * SC = O(n)
 * 
 * 
 * 
 */


class helper {
    int score;
    int age;

    helper(int s, int a) {
        score = s;
        age = a;
    }
}

class x8_team_without_conflicts {

    public static void main(String[] args) {

        //expected = 16
        // int[] scores = { 4, 5, 6, 5 };
        // int[] ages = { 2, 1, 2, 1 };

        //expected = 6
        // int[] scores = { 5, 1, 2, 3 };
        // int[] ages = { 1, 8, 9, 10 };

        int[] scores = { 1, 3, 5, 10, 15 };
        int[] ages = { 1, 2, 3, 4, 5 };

        int answer = function(scores, ages);
        System.out.println(answer);
    }

    static int function(int[] scores, int[] ages) {

        int n = scores.length;
        int[] dp = new int[n];
        List<helper> input = new ArrayList<helper>();

        for (int i = 0; i < n; i++) {
            input.add(new helper(scores[i], ages[i]));
        }

        Collections.sort(input, new Comparator<helper>() {
            @Override
            public int compare(helper o1, helper o2) {
                if (o1.age != o2.age)
                    return o1.age - o2.age;
                return o1.score - o2.score;
            }
        });

        for (int i = 0; i < n; i++) {
            dp[i] = input.get(i).score;
        }

        // core -logic
        for (int i = 1; i < n; i++) {

            helper ith = input.get(i);
            int initial_score = ith.score;

            for (int j = 0; j < i; j++) {
                helper jth = input.get(j);

                boolean noConflict = (jth.age <= ith.age && jth.score <= ith.score);

                if (noConflict) {
                    dp[i] = Math.max(dp[i], initial_score + dp[j]);
                }

            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
