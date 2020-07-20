import java.util.*;

class lol {

    public static void main(String[] args) {

        // String str = "0100";

        // String str = "10";
        String str = "1111";



        Solution s = new Solution();
        int ans = s.function(str);
        System.out.println(ans);

    }

}

class Solution {

    int function(String str) {

        int n = str.length();

        if (n < 2) {
            return 0;
        }

        int last1 = 1;
        String opt1 = "0";

        int last2 = 0;
        String opt2 = "1";

        for (int i = 1; i < n; i++) {
            opt1 += last1;
            opt2 += last2;

            last1 = 1 - last1;
            last2 = 1 - last2;

        }

        return Math.min(countDiff(str, opt1), countDiff(str, opt2));

    }

    int countDiff(String s1, String s2) {

        int answ = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                answ++;
            }
        }
        return answ;
    }

}
