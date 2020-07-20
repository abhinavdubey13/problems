
/**
 * 
 * given dimensions of a rectangular paper (L,B) . 
 * Find minimum possible number of squares which can be cut from it
 * 
 * 
 */

/**
 * 
 * 
 * dp-array = 1D
 * array-filling = 
 * 
 * 
 */

public class p34_minSquares {
    public static void main(String[] args) {

        // int L = 30;
        // int B = 35;

        int L = 10;
        int B = 3;

        int table[][] = new int[L + 1][B + 1];
        int answer = calculator(L, B, table);
        System.out.println(answer);

    }

    static int calculator(int L, int B, int[][] table) {

        // int min_ver = Integer.MAX_VALUE;
        // int min_hor = Integer.MAX_VALUE;

        int min_ver = 1000;
        int min_hor = 100;

        for (int i = 1; i <= L / 2; i++) {
            min_hor = Math.min(calculator(i, B, table) + calculator(L - i, B, table), min_hor);

        }
        // minimum number of squares if you split vertically:
        // int min_ver := min { min_squares(m, i) + min_squares(m, n-i)  |  i ∈ [1, n/2] }

        for (int i = 1; i <= B / 2; i++) {
            min_ver = Math.min(calculator(L, i, table) + calculator(L, B - i, table), min_ver);
        }
        // minimum number of squares if you split horizontally:
        // min_hor := min { min_squares(i, n) + min_squares(m-i, n)  |  i ∈ [1, m/2] }

        return table[L][B] = Math.min(min_hor, min_ver);

    }
}