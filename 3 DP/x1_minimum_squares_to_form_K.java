
/**
 * Given a positive integer K, 
 * 
 * find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum-up to K.
 * 
 */

/**
 * ==========
 * APPROACH :
 * ==========
 * 
 * similar to p31_maximizeNumberOfCuts
 * 
 * for each num<k
 * 
 * we subtract all possible squares (such that j*j <= num) and find the minimum number of squares required
 * 
 * 
 * TC = O(n)
 * SC = O(n)
 * 
 *
 * 
 *
 * 
 */

public class x1_minimum_squares_to_form_K {

    public static void main(String[] args) {
        int K = 12;
        int answer = calculator(K);
        System.out.println(answer);
    }

    static int calculator(int K) {

        if (K < 0) {
            return 0;
        }

        if (K == 0 || K == 1) {
            return K;
        }

        int[] table = new int[K + 1];

        for(int i=0 ; i<=K ; i++){
            table[i]=Integer.MAX_VALUE;
        }

        table[0] = 0;
        table[1] = 1;

        for (int num = 2; num <= K; num++) {
            for (int j = 1; j * j <= num; j++) {
                table[num] = Math.min(1 + table[num - j * j], table[num]);
            }
        }

        return table[K];

    }

}
