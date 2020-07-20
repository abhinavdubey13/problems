import java.util.*;

/**
 * 
 * Problem : https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
 * 
 * 
 * Consider a 2-D map with a horizontal river passing through its center. 
 * There are n cities on the southern bank with x-coordinates a(1) … a(n) and n cities on the northern bank with x-coordinates b(1) … b(n). 
 * You want to connect as many north-south pairs of cities as possible with bridges such that no two bridges cross. 
 * When connecting cities, you can only connect city a(i) on the northern bank to city b(i) on the southern bank. 
 * Maximum number of bridges that can be built to connect north-south pairs with the aforementioned constraints.
 * 
 *
 * 
 */

/**
 * =============
 * APPROACH : 
 * =============
 * 
 * https://www.youtube.com/watch?v=o1h3aoeSTOU&ab_channel=Pepcoding
 * 
 * its an application on LIS 
 * 
 * 1. sort on the basis of north (asceding)
 * 2. find LIS on south
 * 
 * why this works ? 
 * 
 * when do form left to right in input array , we have north always increasing
 * and max number of bridges is calculated using LIS in south
 * 
 * ===========
 * TC = O(n^2)
 * SC = O(n)
 * 
 * 
 * 
 * 
 *
 * 
 */

class Bridge_cordinate implements Comparable<Bridge_cordinate> {
    int north;
    int south;

    Bridge_cordinate(int n, int s) {
        this.north = n;
        this.south = s;
    }

    public int compareTo(Bridge_cordinate b2) {
        if (this.north != b2.north) {
            return (this.north - b2.north);
        } else {
            return (this.south - b2.south);
        }
    }
}

public class p50_max_non_overlapping_bridges {

    public static void main(String[] args) {

        Bridge_cordinate[] bridge = new Bridge_cordinate[4];

        bridge[0] = new Bridge_cordinate(6, 2);
        bridge[1] = new Bridge_cordinate(4, 3);
        bridge[2] = new Bridge_cordinate(2, 6);
        bridge[3] = new Bridge_cordinate(1, 5);

        int answer = function(bridge);
        System.out.println(answer);
    }

    static int function(Bridge_cordinate[] arr) {
        int n = arr.length;

        if (n < 2) {
            return n;
        }

        Arrays.sort(arr);

        int[] dp = new int[n];
        dp[0] = 1;
        int answer = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                boolean compatible = is_compatible(arr[j], arr[i]);
                if (compatible) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        return answer;

    }

    static boolean is_compatible(Bridge_cordinate before, Bridge_cordinate after) {
        if (before.north < after.north && before.south < after.south) {
            return true;
        }
        return false;
    }

}