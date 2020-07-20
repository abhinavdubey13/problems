import java.util.*;

/**
 * 
 * leetcode id : 752
 * 
 * You have a lock in front of you with 4 circular wheels. 
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. 
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. 
 * 
 * Each move consists of turning one wheel one slot.
 * 
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * 
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, 
 * the wheels of the lock will stop turning and you will be unable to open it.
 * 
 * 
 *  Given a target representing the value of the wheels that will unlock the lock, 
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * 
 * 
 */

/**
 * 
 * 
 * =============
 * APPROACH : 
 * =============
 * 
 * BFS
 * 
 * trick : mark dead ends as visited before starting the loop of BFS
 * 
 * 
 *
 * 
 * 
 * 
 */

class x15_opening_lock {

    public static void main(String[] args) {

        //expected : 1
        // String[] deadends = { "8888" };
        // String target = "0009";

        //expected = 6
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";

        // String[] deadends = { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" };
        // String target = "8888";

        int answer = Solution.function(deadends, target);
        System.out.println(answer);

    }

}

class Solution {
    static int function(String[] deadends, String target) {

        if (is_dead_end(deadends, "0000")) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        q.offer("0000");

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        visited.add("0000");

        int steps = 0;

        while (q.size() > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                String polled = q.poll();

                if (polled.equals(target)) {
                    return steps;
                }

                List<String> ngbrs = get_neighbours(polled);
                for (String n : ngbrs) {
                    if (!visited.contains(n)) {
                        visited.add(n);
                        q.offer(n);
                    }
                }
            }

            steps++;

        }

        return -1;

    }

    static boolean is_dead_end(String[] deadends, String curr) {
        for (int i = 0; i < deadends.length; i++) {
            if (deadends[i].equals(curr)) {
                return true;
            }
        }
        return false;
    }

    static List<String> get_neighbours(String current) {
        int a = Integer.parseInt(String.valueOf(current.charAt(0)));
        int b = Integer.parseInt(String.valueOf(current.charAt(1)));
        int c = Integer.parseInt(String.valueOf(current.charAt(2)));
        int d = Integer.parseInt(String.valueOf(current.charAt(3)));

        List<String> neighbours = new LinkedList<>();

        if (a == 0) {
            neighbours.add("9" + b + c + d);
            neighbours.add("1" + b + c + d);
        } else if (a == 9) {
            neighbours.add("8" + b + c + d);
            neighbours.add("0" + b + c + d);
        } else if (a > 0 && a < 9) {
            neighbours.add((a - 1) + "" + b + c + d);
            neighbours.add((a + 1) + "" + b + c + d);
        }

        if (b == 0) {
            neighbours.add("" + a + "9" + c + d);
            neighbours.add("" + a + "1" + c + d);
        } else if (b == 9) {
            neighbours.add("" + a + "8" + c + d);
            neighbours.add("" + a + "0" + c + d);
        } else if (b > 0 && b < 9) {
            int plus = b + 1;
            int minus = b - 1;
            neighbours.add("" + a + plus + c + d);
            neighbours.add("" + a + minus + c + d);
        }

        if (c == 0) {
            neighbours.add("" + a + b + "9" + d);
            neighbours.add("" + a + b + "1" + d);
        } else if (c == 9) {
            neighbours.add("" + a + b + "8" + d);
            neighbours.add("" + a + b + "0" + d);
        } else if (c > 0 && c < 9) {
            int plus = c + 1;
            int minus = c - 1;
            neighbours.add("" + a + b + plus + d);
            neighbours.add("" + a + b + minus + d);
        }

        if (d == 0) {
            neighbours.add("" + a + b + c + "9");
            neighbours.add("" + a + b + c + "1");
        } else if (d == 9) {
            neighbours.add("" + a + b + c + "8");
            neighbours.add("" + a + b + c + "0");
        } else if (d > 0 && d < 9) {
            int plus = d + 1;
            int minus = d - 1;
            neighbours.add("" + a + b + c + plus);
            neighbours.add("" + a + b + c + minus);
        }

        return neighbours;

    }

}