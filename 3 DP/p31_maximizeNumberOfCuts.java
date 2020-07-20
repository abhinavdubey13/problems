
/**
 * given length of a rod , and 3 possible lengths (x,y,z) into which we can cut the rod.
 * 
 * find maximum number of cuts , into which the rod can be cut 
 * 
 * NOTE : any cut except the possible cuts will NOT be valid
 * 
 * ===========
 * example : 
 * ===========
 * 
 * rod-length = 5
 * cuts = {2,3,5}
 * 
 * 
 * max-number-of-cuts =2
 * 5= 2+3
 * 
 */

/**
 * 
 * dp = 1-d
 * 
 * init every element as -1 : meaning that cut is not possible
 * 
 * dp[i] = max-number-of-cuts for length = i
 * dp[0] = 0 : bcz no cuts if length =0
 * 
 * iterate from 0 till lenth of rod
 *  if(dp[i] == -1 ) continue
 *  
 *  else update dp[i+cut-1] , dp[i+cut-2] and dp[i+cut-3]
 * 
 * 
 * ========================
 * let rod-length = n
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class p31_maximizeNumberOfCuts {

    public static void main(String[] args) {

        int rodLength = 5;
        int cut1 = 2;
        int cut2 = 3;
        int cut3 = 5;
        int answer = calculator(rodLength, cut1, cut2, cut3);
        System.out.println(answer);

    }

    static int calculator(int rodLength, int cut1, int cut2, int cut3) {

        int[] dp = new int[rodLength + 1];

        //init the array cell as -1
        for (int i = 0; i <= rodLength; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;

        for (int i = 1; i <= rodLength; i++) {

            // for each length we check if this length is possible or not by given cuts
            // if yes , we find max of cuts

            if (i - cut1 >= 0 && dp[i - cut1] > -1) {
                dp[i] = Math.max(dp[i], 1 + dp[i - cut1]);
            }

            if (i - cut2 >= 0 && dp[i - cut2] > -1) {
                dp[i] = Math.max(dp[i], 1 + dp[i - cut2]);
            }

            if (i - cut3 >= 0 && dp[i - cut3] > -1) {
                dp[i] = Math.max(dp[i], 1 + dp[i - cut3]);
            }

        }

        return dp[rodLength];

    }

}