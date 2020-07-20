import java.util.*;

/**
 * 
 * leetcode id : 204
 * 
 * Given a non-negative integer x, compute and return the square root of x.
 * 
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * 
 *
 * 
 *  
 */

/**
 * 
 *
 * seive of erasthonesisi
 * 
 * 
 * TC = n.log(log(n))
 * SC = n
 * 
 */

class p11_find_prime_numbers {

    public static void main(String[] args) {

        int n = 25; //9
        // int n = 10; //expected : 4
        int answer1 = Solution_brute_force.function(n);
        int answer2 = Solution_seive.function(n);

        System.out.println(answer1);
        System.out.println(answer2);

    }
}

class Solution_brute_force {

    static int function(int n) {

        List<Integer> primes = new LinkedList<>();//required if we want the list of primes , instread of count
        int count = 0;

        if (n < 2) {
            return 0;
        }

        for (int i = 2; i < n; i++) {
            if (is_prime(i)) {
                count++;
                primes.add(i);
            }
        }

        return count;

    }

    //check from 2- sqrt(n)
    static boolean is_prime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}

class Solution_seive {

    static int function(int n) {

        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        List<Integer> primes = new LinkedList<>(); //required if we want the list of primes , instread of count
        int count = 0;

        arr[0] = arr[1] = false;//0 and 1 are not prime numbers

        if (n < 2) {
            return 0;
        }

        for (int i = 2; i * i <= n; i++) {
            if (arr[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    arr[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                count++;
                primes.add(i);
            }
        }

        return count;

    }

}
