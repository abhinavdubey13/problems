
/**
 * 
 * Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
 * 
 */

/**
 * ==============
 * solution -1
 * ===============
 * x-axis = any 1 of the 2 strings
 * y-axis = the other string
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom  
 * 
 * 
 * 
 * if string[i]==string[j] , table[i][j]= 1+diagonal cell 
 * else : 1 + MIN(length of string having s1[0....i] and s2[0...j-1]  , length of string having s1[0....i-1], s2[0....j] )
 * 
 * 
 * 
 * ==============================================================================
 * solution-2 : (sum of length of 2 strings) - (length of Longest Common SubSeq)
 * ==============================================================================
 * 
 * 
 * TC = O(s1.s2)
 * SC = O(s1.s2)
 * 
 */

class p24_shortestCommonSuperSeq {

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        int answer = calulator(str1.toCharArray(), str2.toCharArray());
        System.out.println(answer);
    }

    static int calulator(char[] str1, char[] str2) {
        int[][] table = new int[str1.length + 1][str2.length + 1];

        for (int i = 0; i <= str1.length; i++) {
            for (int j = 0; j <= str2.length; j++) {

                if (i == 0 || j == 0) {
                    table[i][j] = Math.max(i, j);

                } else if (str1[i - 1] == str2[j - 1]) {
                    table[i][j] = 1 + table[i - 1][j - 1];

                } else {
                    table[i][j] = 1 + Math.min(table[i][j - 1], table[i - 1][j]);

                }
            }
        }

        return table[str1.length][str2.length];
    }
}