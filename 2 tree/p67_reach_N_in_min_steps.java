import java.util.*;

/**
 * 
 * leetcode id : https://www.geeksforgeeks.org/find-a-number-in-minimum-steps/
 *
 * Given an infinite number line from -INFINITY to +INFINITY and we are on zero. 
 * 
 * We can move n steps either side at each n’th time. 
 * 
 * 
 * 1st time; we can move only 1 step to both ways, means -1 1;
 * 
 * 2nd time we can move 2 steps  from -1 and 1;
 * 
 * -1 :  -3 (-1-2)  1(-1+2)
 * 1 :  -1 ( 1-2)  3(1+2)
 * 
 * 3rd time we can move 3 steps either way from -3, 1, -1, 3 
 * -3:  -6(-3-3) 0(-3+3)
 *  1:   -2(1-3)   4(1+3)
 * -1:  -4(-1-3)  2(-1+3)
 *  3:     0(0-3)   6(3+3) 
 * 
 * Find the minimum number of steps to reach a given number N
 * 
 * ==========
 * example :
 * ==========
 * 
 * i/p : 
 * o/p : 
 * 
 */

/**
 * ============
 * approach : 1
 * ============
 * 
 * draw tree like structure , u'll get the approach
 * 
 * we need to do BFS or level-order traversal
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

class Steps {
  int position;
  int steps_allowed_here;

  Steps(int p, int s) {
    this.position = p;
    this.steps_allowed_here = s;
  }
}

public class p67_reach_N_in_min_steps extends HELPER {

  public static void main(String[] args) {
    int n = 13; //expected = 5
    int answer = function(n);
    System.out.println(answer);
  }

  static int function(int N) {

    if (N == 0) {
      return 0;
    }

    if (Math.abs(N) == 1) {
      return 1;
    }

    Queue<Steps> q = new LinkedList<>();
    q.offer(new Steps(0, 1));

    while (true) {

      Steps popped = q.poll();
      int position_minus = popped.position - popped.steps_allowed_here;
      int position_plus = popped.position + popped.steps_allowed_here;
      int steps_allowed_next = popped.steps_allowed_here + 1;

      if (position_plus >= Integer.MAX_VALUE || position_minus <= Integer.MIN_VALUE) {
        return -1;
      }

      if (position_plus == N || position_minus == N) {
        return popped.steps_allowed_here;
      }

      q.add(new Steps(position_minus, steps_allowed_next));
      q.add(new Steps(position_plus, steps_allowed_next));

    }

  }

}