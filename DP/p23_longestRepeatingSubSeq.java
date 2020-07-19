//Given a string, find length of the longest repeating subseequence such that the two subsequence don’t have same string character at same position, 
// i.e : all i’th character in the two subsequences should have the difffrent index in the original string.
 

/**
 * almost same as LCSubSeq
 * 
 * x-axis : string 1
 * y-axis : string 1 (same as x-axis)
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 * 
 * table[i][j] => 1+table[i-1][j-1]                      if string1[i]==string2[j] && INDEX NOT EQUAL (this 2nd condition is the difference)
 *             => MAX( table[i-1][j] , table[i][j-1])     if no match  
 *  
 */

class p23_longestRepeatingSubSeq {

    public static void main(String[] args) {
        String str = "aabcbdtd";
        int answer = calulator(str.toCharArray());
        System.out.println(answer);
    }

    static int calulator(char[] STR) {
        int[][] table = new int[STR.length + 1][STR.length + 1];

        for (int i = 0; i <= STR.length; i++) {
            for (int j = 0; j <= STR.length; j++) {

                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (STR[i - 1] == STR[j - 1] && i != j) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        return table[STR.length][STR.length];
    }
}