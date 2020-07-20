import java.util.*;

/**
 * 
 * https://www.geeksforgeeks.org/minimum-initial-energy-required-to-cross-street/
 */

/**
 * =============
 * approach   : 
 * =============
 * using single linear traversal 
 *  
 * TC= O(n)
 * SC= O(1)
 * 
 * 
 * 
 * 
 */

class p19_min_energy {

    public static void main(String[] args) {
        // int arr[] = { 4, -10, 4, 4, 4 };

        int arr[] = { -5, 4, -10, -9 };

        int answer = function(arr);
        System.out.println(answer);
    }

    static int function(int arr[]) {

        int answer_energy = 0;
        int current_energy = 0;

        for (int energy : arr) {
            current_energy += energy;
            if (current_energy <= 0) {
                answer_energy += 1 + Math.abs(current_energy);
                current_energy = 1;
            }
        }

        return (answer_energy);
    }

}