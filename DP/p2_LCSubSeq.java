/**
 * x-axis : string 1
 * y-axis : string 2
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 * 
 * table[i][j] => 1+table[i-1][j-1]                      if string1[i]==string2[j]
 *             => MAX( table[i-1][j] , table[i][j-1])     if no match  
 *  
 */


class p2_LCSubSeq {

    public static void main(String[] args) {

        int answer = calulator("abcdef", "acbcf"); //6 , 5 
        System.out.println(answer);

    }

    static int calulator(String a, String b) {
        int[][] table = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (a.charAt(i-1) == b.charAt(j-1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else if (a.charAt(i-1) != b.charAt(j-1)) {
                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                }
            }
        }

        return table[a.length()][b.length()];
    }
}