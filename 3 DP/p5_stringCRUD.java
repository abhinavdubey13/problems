/**
 * 
 * given source_String(SS) and target_string(TS) , we need to find minimum operations (insert , delete , change) to form TS from SS
 * 
 * =========
 * example :
 * =========
 * 
 * source = "abcdef"
 * target = "azced"
 * 
 * 
 * min-ops = 3
 * 
 * 1. b -> z    : s[1] -> t[1]
 * 2. drop 'd'  : drop s[3]
 * 3. f -> d    : s[5] -> t[4]
 * 
 * 
 * 
 */


/**
 * ==========
 * approach :
 * ==========
 * 
 * x-axis = TS
 * y-axis = SS
 * 
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 * 
 * 
 * if(characters match){
 *      table[i][j] = table[i-1][j-1]
 * }
 * 
 * else{
 *  case1 = 1 + steps to form TS(0...i-1) from SS(0...j)     ie. (1 + above cell) ......INSERT
 *  case2 = 1 + steps to form TS(0...i) from SS(0...j-1)     ie. (1 + left cell)........INSERT
 *  case3 = 1 + steps to form TS(0...i-1) from SS(0...j-1)   ie. (1 + diagonal cell)....CHANGE
 *  table[i][j] = MIN(case 1,2,3) 
 * }
 * 
 * 
 * ========================================
 * TC = O(str-1 . str-2)
 * SC = O(str-1 . str-2)
 * 
 */

class p5_stringCRUD {

    public static void main(String[] args) {

        String target = "azced";
        String source = "abcdef";
        int answer = calulator(target, source);
        System.out.println(answer);

    }

    static int calulator(String target, String source) {
        //target on x-axis
        //source on y-axis
        int[][] table = new int[target.length() + 1][source.length() + 1];

        //init 1st col
        for (int i = 0; i <= target.length(); i++) {
            table[i][0] = i;
        }

        //init 1st row
        for (int j = 0; j <= source.length(); j++) {
            table[0][j] = j;
        }

        //others
        for (int i = 1; i <= target.length(); i++) {
            for (int j = 1; j <= source.length(); j++) {

                if (target.charAt(i - 1) == source.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];

                } else {
                    int a = table[i - 1][j - 1];
                    int b = table[i][j - 1];
                    int c = table[i - 1][j];
                    table[i][j] = 1 + Math.min(a, Math.min(b, c));
                }

            }
        }

        return table[target.length()][source.length()];
    }
}