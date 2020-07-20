import java.util.*;

/**
 * 
 * leetcode id :
 * 
 */

/**
 * 
 * 
 * =============
 * APPROACH : 
 * =============
 * 
 *
 * 
 * 
 * 
 */

class x13_reach_home {

    public static void main(String[] args) {

        //expected : 3
        // int a = 3, b = 15, x = 9;
        // int[] forbidden = { 14, 4, 18, 1, 15 };

        //expected : 2
        // int a = 16, b = 9, x = 7;
        // int[] forbidden = { 1, 6, 2, 14, 5, 17, 4 };

        //expected : -1
        // int a = 15, b = 13, x = 11;
        // int[] forbidden = { 8, 3, 16, 6, 12, 20 };

        //expected : -1
        // int a = 3, b = 8, x = 6;
        // int[] forbidden = { 18, 13, 3, 9, 8, 14 };

        //expected : 121
        int a = 29, b = 98, x = 80;
        int[] forbidden = { 162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36,
                103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16,
                108, 111, 6, 168, 31, 134, 164, 136, 72, 98 };

        int ans = new Solution().function(forbidden, a, b, x);
        System.out.println(ans);

    }

}

class Q_obj {

    int curr;
    int steps;
    boolean is_back_jump;

    Q_obj(int c, int s, boolean is) {
        curr = c;
        steps = s;
        is_back_jump = is;
    }
}

class Solution {

    final int INFINITE = 5000;

    int answer;

    int function(int[] forbid, int a, int b, int dest) {

        if (dest == 0) {
            return 0;
        }

        Set<Integer> forbidden = new HashSet<>();
        for (int i : forbid) {
            forbidden.add(i);
        }

        answer = INFINITE;

        Set<Integer> visited_by_frwd_jump = new HashSet<>();
        Set<Integer> visited_by_back_jump = new HashSet<>();

        Queue<Q_obj> q = new LinkedList<>();
        q.add(new Q_obj(0, 0, false));

        while (q.size() > 0) {
            Q_obj popped = q.poll();

            int frwd = popped.curr + a;
            int back = popped.curr - b;
            int step = popped.steps + 1;

            if (step >= INFINITE) {
                continue;
            }

            if (frwd == dest || back == dest) {
                return step;
            }

            if (!forbidden.contains(frwd) && !visited_by_frwd_jump.contains(frwd)) {
                q.add(new Q_obj(frwd, step, false));
                visited_by_frwd_jump.add(frwd);
            }

            if (!forbidden.contains(back) && !popped.is_back_jump && back > 0 && !visited_by_back_jump.contains(frwd)) {
                q.add(new Q_obj(back, step, true));
                visited_by_back_jump.add(back);
            }

        }

        return -1;
    }

}
