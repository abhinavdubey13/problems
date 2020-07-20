import java.util.*;

/**
 * leetcode id : 799
 * We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  
 * Each glass holds one cup of champagne.
 * 
 * Then, some champagne is poured into the first glass at the top. 
 * When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.  
 * When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.  
 * (A glass at the bottom row has its excess champagne fall on the floor.)
 * 
 * For example, after one cup of champagne is poured, the top most glass is full.  
 * After two cups of champagne are poured, the two glasses on the second row are half full.  
 * After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  
 * After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full
 * 
 *
 * 
 * ===========
 * example -1
 * ===========
 * Input: poured = 2, query_row = 1, query_glass = 1
 * Output: 0.50000
 * Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). 
 * There is one cup of excess liquid. 
 * The glass indexed as (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, and each will get half cup of champange
 * 
 * 
 */

/**
 *  
 * 
 * ============
 * approach : 
 * ============
 *  
 * If the glass >=1, we should split the diff (glass - 1) into next level.
 *  
 *
 *  
 * 
 * ============
 * TC = O(n)
 * SC = O(1)
 * 
 * 
 * 
 */

class x16_champaign_tower {

    public static void main(String[] args) {

        // int poured = 2;
        // int row = 1;
        // int col = 1;

        // int poured = 100000009;
        // int row = 33;
        // int col = 17;

        //expected = 0.18750
        // int poured = 25;
        // int row = 6;
        // int col = 1;

        // expected = 0.68750
        int poured = 12;
        int row = 4;
        int col = 1;

        double answer = function(poured, row, col);

        System.out.println(answer);
    }

    static double function(int poured, int query_row, int query_col) {

        double[][] dp = new double[100][100];

        dp[0][0] = poured;

        for (int i = 0; i <= 98; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) {
                    double overflown = dp[i][j] - 1;
                    dp[i + 1][j]+= overflown / 2.0;
                    dp[i + 1][j + 1]+= overflown / 2.0;
                    
                    dp[i][j] = 1.0;
                }
            }
        }

        return dp[query_row][query_col];

    }

}
