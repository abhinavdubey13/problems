/**
 * Given two sequences, find the length of longest subsequence present in both of them. 
 * 
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
 * 
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 */

/**
 * ==========
 * APPROACH :
 * ==========
 *  
 * x-axis : string 1 (length = s1)
 * y-axis : string 2 (length = s2)
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 * 
 * table[i][j] => 1+table[i-1][j-1]                      if string1[i]==string2[j]
 *             => MAX( table[i-1][j] , table[i][j-1])     if no match  
 * 
 * ======================
 * TC = O(s1.s2)
 * SC = O(s1.s2)
 *  
 */

class p2_LCSubSeq {

    public static void main(String[] args) {

        int answer = calulator("abcdef".toCharArray(), "acbcf".toCharArray()); //6 , 5 
        System.out.println(answer);

    }

    static int calulator(char[] a, char[] b) {
        int[][] table = new int[a.length + 1][b.length + 1];

        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= b.length; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (a[i - 1] == b[j - 1]) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else if (a[i - 1] != b[j - 1]) {
                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                }
            }
        }

        return table[a.length][b.length];
    }
}