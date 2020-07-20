/**
 * given 2 string , find longest common sub-string among those
 * 
 * ==========
 * example :
 * ==========
 * s1 = "abcdaf"
 * s2 = "zbcdf"
 * 
 * longest substring = bcd 
 * length = 3 
 * 
 */



/**
 * x-axis = any 1 of the 2 strings
 * y-axis = the other string
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom  
 * 
 * 
 * 
 * if string[i]==string[j] , table[i][j]= 1+diagonal cell
 * 
 * else table[i][j] = 0
 * 
 * at last we need to check all cell of the table to find the max value , 
 * OR we can maintain a variable for MAX to avoid this
 * 
 * ===================
 * TC = O(s1.s2)
 * SC = O(s1.s2)
 * 
 * 
 * 
 */

class p11_longestCommonSubStr {

    public static void main(String[] args) {

        String s1 = "abcdaf";
        String s2 = "zbcdf";
        int answer = calulator(s1, s2);
        System.out.println(answer);

    }

    static int calulator(String a, String b) {

        int[][] table = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    table[i][j] = 0;
                }
            }
        }

        //traverse the entire table , to check the maximum cell
        int maxCell = 0;
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (table[i][j] > maxCell) {
                    maxCell = table[i][j];
                }
            }
        }

        return maxCell;
    }
}