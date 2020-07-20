import java.util.*;

/**
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * 
 * given arrival and departure times of N trains  , find minimum number of platforms needed so that no train waits
 * 
 * arr[i] : arrival time of i'th train
 * dep[i] : departure time of the same (i'th) train
 * 
 * ==========
 * example :
 * ==========
 * 
 * 
 */

/**
 * ==========
 * approach :
 * ===========
 * sort both : arrival[] and departure[]
 * use i : index pointer in arrival[] , initialize ar 1
 * use j : index pointer in departure[] , initialize at 0
 *
 * loop while(i and j < N)
 *  - whenever we move j , we de-crement the number of platforms , bcz a train has departed , 
 *  - whenever we move i , we in-crement the number of platforms , bcz train has arrived
 * 
 * =======================================================
 * input array size = N 
 * 
 * TC = O(N.logN)
 * SC = O(1)
 * 
 * =======================================================
 * brute force = O(N^2)
 * 
 */

class p8_number_of_platforms {

    public static void main(String[] args) {
        //expected = 3
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int answer = function(arr, dep);

        System.out.println(answer);
    }

    static int function(int arrival[], int[] dep) {

        int n = arrival.length;// arrival.length = dep.length

        // considering arrival[0] to have already arrived , we have answer = current = 1
        int answer = 1;
        int current = 1;

        int i = 1; // pointer for arrival[] , considering arrival[0] to have already arrived
        int j = 0; // pointer for departure[]

        Arrays.sort(arrival);
        Arrays.sort(dep);

        while (i < n && j < n) {

            // i arrives before j departs
            if (arrival[i] <= dep[j]) {
                current++;
                i++;
            }

            // i arrives after j departs
            else if (arrival[i] > dep[j]) {
                current = (current - 1 >= 0) ? current - 1 : 0; //number of platforms cannot be -ive
                j++;
            }

            answer = Math.max(answer, current);
        }

        return answer;
    }

}