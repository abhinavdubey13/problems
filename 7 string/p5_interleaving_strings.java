
/**
 * 
 * 
 * Given three strings A, B and C. Write a function that checks whether C is an interleaving of A and B. 
 * C is said to be interleaving A and B, if 
 *      1. A and B are sub-seq of C , and
 *      2. lenght(C) = length(A) + length(B)
 *      2. C conatins all characters of A and B  (nothing outside of those characters)
 *
 * ===========
 * Example : 
 * ===========
 * A = aab
 * B = axy
 * C = aaxaby
 * Output: true 
 * 
 * 
 * ===========
 * Example : 
 * ===========
 * A = aab
 * B = axy
 * C = abaaxy
 * Output: false 
 * 
 * 
    
 */

/**
 * ==========
 * APPROACH :
 * ==========
 * x-axis : string A
 * y-axis : string B
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 * 
 * table[i][j] => considering A[0...i] , B[0...j] and C[0... i+j-1]
 * 
 * 
 * 
 * if C[i+j-1] matches A[i] => we check the same with A[0 ... i-1] , B[0 ... j] , C[0.... i+j-2]
 * which is stored in table[i-1][j]
 * 
 * 
 * else if C[i+j-1] matches B[j] => we check the same with A[0 ... i] , B[0 ,,, j-1] , C[0.... i+j-2]
 * which is stored in table[i][j-1]
 * 
 * 
 * else => table[i][j]=false
 * 
 */

public class p5_interleaving_strings {
    public static void main(String[] args) {

        String A = "axy";
        String B = "aab";
        String C = "abaaxy";
        //false

        // String A = "axy";
        // String B = "aab";
        // String C = "aaxaby";
        //true

        boolean answer = calculator(A.toCharArray(), B.toCharArray(), C.toCharArray());
        System.out.println(answer);
    }

    static boolean calculator(char[] A, char[] B, char[] C) {

        boolean table[][] = new boolean[A.length + 1][B.length + 1];

        table[0][0] = true;

        //first column
        for (int i = 1; i <= A.length; i++) {
            //if equal , then current cell =  above cell 
            table[0][i] = (C[i-1] == A[i-1]) ? table[0][i - 1] : false;
        }

        //first row
        for (int i = 1; i <= B.length; i++) {
            //if equal , then current cell =  left cell 
            table[i][0] = (C[i-1] == B[i-1]) ? table[i - 1][0] : false;
        }

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {

                table[i][j] = false;

                boolean last_char_in_C_equals_last_char_in_A = (C[i + j - 1] == A[i - 1]);
                boolean last_char_in_C_equals_last_char_in_B = (C[i + j - 1] == B[j - 1]);

                if (last_char_in_C_equals_last_char_in_A) {
                    table[i][j] = table[i][j] || table[i - 1][j];
                }

                if (last_char_in_C_equals_last_char_in_B) {
                    table[i][j] = table[i][j] || table[i][j - 1];
                }

            }
        }

        return table[A.length][B.length];
    }

}
