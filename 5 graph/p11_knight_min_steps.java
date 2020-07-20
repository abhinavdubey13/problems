import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
 *
 * Given a square chessboard of N x N size, the position of Knight and position of a target is given. 
 * We need to find out the minimum steps a Knight will take to reach the target position.
 * 
 * 
 * 
 * ==========
 * example :
 * ==========
 * 
 *
 * 
 *
 *  
 */

/**
 * 
 * ============
 * approach :
 * ============
 * 
 * This problem can be seen as shortest path in unweighted graph. 
 * 
 * Therefore we use BFS to solve this problem. 
 * 
 * We try all 8 possible positions where a Knight can reach from its position. 
 * 
 * If reachable position is not already visited and is inside the board, 
 * 
 * we push this state into queue with distance 1 more than its parent state. 
 * 
 * Finally we return distance of target position, when it gets pop out from queue.
 * 
 *
 * 
 * 
 */

class Queue_helper {
    int x;
    int y;
    int num_steps_till_here;

    Queue_helper(int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.num_steps_till_here = n;
    }
}

class p11_knight_min_steps {

    public static void main(String[] args) {

        int n = 30;
        int[] init_pos = { 0, 0 };
        int[] target_pos = { 29, 29 };

        int answer = Knight_min_steps.function(init_pos, target_pos, n);
        System.out.println("min steps : " + answer);
    }
}

class Knight_min_steps {

    static int[] x_ngbr = { -2, -2, 2, 2, -1, 1, -1, 1 };
    static int[] y_ngbr = { -1, 1, -1, 1, -2, -2, 2, 2 };

    static int function(int[] src, int[] dest, int n) {

        Queue<Queue_helper> q = new LinkedList<>();

        q.add(new Queue_helper(src[0], src[1], 0));

        Set<String> visited = new HashSet<>();

        boolean reached = false;

        int answer = -1;

        visited.add(src[0] + "" + src[1]);

        while (q.size() > 0 && !reached) {

            Queue_helper popped = q.poll();

            for (int i = 0; i < x_ngbr.length; i++) {

                int nx = popped.x + x_ngbr[i]; //neighbour's x
                int ny = popped.y + y_ngbr[i]; //neighbour's y

                boolean safe = is_safe_xy(nx, ny, n);

                if (safe) {
                    if (nx == dest[0] && ny == dest[1]) {
                        reached = true;
                        answer = popped.num_steps_till_here + 1;
                        break;
                    } else {
                        String key = nx + "" + ny;

                        if (!visited.contains(key)) {
                            q.offer(new Queue_helper(nx, ny, popped.num_steps_till_here + 1));
                            visited.add(key);
                        }
                    }

                }

            }

            if (reached) {
                break;
            }

        }

        if (!reached) {
            return -1;
        } else {
            return answer;
        }

    }

    static boolean is_safe_xy(int x, int y, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

}