import java.util.*;

/**
 * 
 * 
 * 
 */

/**
 * 
 * 
 * 
 */

class xyz2 {

    public static void main(String[] args) {

        int[] base = { 1, 7 };
        int[] cost = { 3, 4 };
        int target = 10;

        int ans = Solution.function(base, cost, target);
        System.out.println(ans);

    }

}

class Solution {

    static int function(int[] base, int[] top, int target) {

        int m = top.length;
        int[] used_top = new int[m];
        Arrays.fill(used_top, 2);
        int answer = 0;

        Set<Integer> nums = dfs(top);

        for (int i = 0; i < base.length; i++) {

            for (Integer j : nums) {

            }

            // int temp = base[i] + dfs(top, used_top, target, base[i]);
            // if (Math.abs(target - answer) >= Math.abs(target - temp)) {
            //     answer = Math.min(answer, temp);
            // }
        }

        return answer;

    }

    static Set<Integer> dfs(int[] top) {

        Set<Integer> nums = new HashSet<>();

        // int[] copy = Arrays.copyOf(top, top.length);

        nums.add(0);

        for (int i = 0; i < top.length; i++) {
            nums.add(top[i]);
            for (int j = 0; j < top.length; j++) {
                nums.add(top[i] + top[j]);
            }
        }

        return nums;

    }

}
