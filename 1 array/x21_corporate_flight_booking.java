import java.util.*;

/**
 * leetcode ID : 1109
 * 
 * There are n flights, and they are labeled from 1 to n.
 * 
 * We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.
 * 
 * Return an array answer of length n, representing the number of seats booked on each flight in order of their label.
 * 
 * Example 1:
 * Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * Output: [10,55,45,25,25]
 * 
 *
 */

/**
 *   
 * ===========
 * approach : 
 * ===========
 * 
 * Think all the flights are combined as a busline and each flight as a bus stop. And for each flight booking, we can restate as following:
 * 
 * Assume bookings: [[1,2,10],[2,3,20],[3,5,25]],and n=5
 * 
 * For booking : [1,2,10], it can be restated as : 10 passengers aboard at bus stop 1 and alight at bus stop 3(2+1)
 * For booking : [2,3,20], it can be restated as : 20 passengers aboard at bus stop 2 and alight at bus stop 4(3+1
 * For booking : [3,5,25], it can be restated as : 25 passengers aboard at bus stop 3 and alight at bus stop 6(5+1). 
 * It doesn't matter whether stop 6 exists because we just consider 5 stops(n=5)
 * 
 * Then the problem can be restaed as : How many passengers in the bus at the each bus stop[i] (namely result[i])?
 * 
 * From this view, the problem become simpler.
 * 
 * To solve this problem, we need a status[i] to store the total people aboard or alight at bus stop[i] (positive means aboard and negetive means alight) , 
 * and then, just accumulate from status[0] to status[i] to calculate the how many passengers in the bus at each stop[i] (result[i]).
 * 
 * 
 * Notice the number of passengers at stop[i] is equal to the number of passengers at stop[i] plus the status[i], result[i] = result[i-1] + status[i]
 *  
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 * 
 */

class x21_corporate_flight_booking {

    public static void main(String[] args) {

        int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        int number_of_flights = 5;

        int[] answer = function(bookings,number_of_flights);

        // System.out.println(answer);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }

    static int[] function(int[][] arr, int n) {

        int[] result = new int[n];

        for (int[] booking : arr) {
            int start_flight = booking[0] - 1; //flights are numbered from 1-n , but our array is 0-n-1
            int end_flight = booking[1]; //donot subtract 1 here , as it
            int number_of_seats = booking[2];

            result[start_flight] += number_of_seats;
            if (end_flight < n) {
                result[end_flight] -= number_of_seats;
            }
        }

        for (int i = 1; i < n; i++) {
            result[i] = result[i] + result[i - 1];
        }

        return result;

    }

}
