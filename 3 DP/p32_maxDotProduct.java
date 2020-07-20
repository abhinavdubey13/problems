/**
 * 
 * Given 2 int-arrays :  A[N] ,  B[M]  such that N>M. 
 * You have to insert (N-M) zeroes in between array B such that the dot product of array A and array B is maximum. 
 * Find the max DOT-Product
 * 
 * Dot Product : A.B = A[0]*B[0] + A[1]*B[1]+ .... + A[N]*B[N].
 * 
 * ===========
 * Example :
 * ===========
 * 
 * A = [2,3,1,7,8]
 * B = [3,6,7]
 * 
 * output = 107
 * 
 * A[4]*B[2] = 8*7 = 56
 * A[3]*B[1] = 7*6 = 42
 * A[1]*B[0] = 3*3 = 9
 * 
 * 
 */

/**
 * 
 * ==========
 * APPROACH :
 * ==========
 *  
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 * 
 * x-axis : B[]
 * y-axis : A[]
 *
 * table[i][j] = max dot product for B[0-i] , A[0-j]
 * 
 * table[i][j] = A[j] has 2 choices :
 *      1. get multiplied by B[i] , or
 *      2. get multiplied by 0
 * 
 * we have to select max of these 2 cases
 * 
 * ======================
 * TC = O(A.B)
 * SC = O(A.B)
 * 
 */

public class p32_maxDotProduct {
    public static void main(String[] args) {

        int[] A = { 2, 3, 1, 7, 8 };
        int[] B = { 3, 6, 7 };
        int answer = calculator(A, B);
        System.out.println(answer);

    }

    static int calculator(int[] A, int[] B) {

        int[][] table = new int[B.length + 1][A.length + 1];

        //init the array cell as -1

        for (int i = 0; i <= B.length; i++) {
            for (int j = 0; j <= A.length; j++) {

                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                    continue;
                }

                int multiply_current_a_with_b = A[j - 1] * B[i - 1] + table[i - 1][j - 1];
                int multiply_current_a_with_0 = table[i][j - 1];

                table[i][j] = Math.max(multiply_current_a_with_0, multiply_current_a_with_b);
            }

        }

        return table[B.length][A.length];

    }

}