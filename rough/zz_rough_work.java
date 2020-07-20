import java.util.*;

class helper {
    int idx;
    int number;

    helper(int n, int i) {
        number = n;
        idx = i;
    }
}

class zz_rough_work {

    public static void main(String[] args) {

        double d1 = (double) 3 / 5;

        double d2 = (double) 1 / 2;

        //   System.out.println(Double.compare(d1, d2));
        // System.out.println(Double.compare(d2, d1));
        // System.out.println(Double.compare(d1, d1));
        // char c = '*';
        // System.out.println(c == '*');

        // int r1 = 1;
        // int r2 = 2;
        // int n = 8;
        // String s = new String("########");

        // int r1 = 1;
        // int r2 = 5;
        // int n = 5;
        // String s = new String("#***#");

        int r1 = 2;
        int r2 = 3;
        int n = 11;
        String s = new String("#*#*#*#*#*#");

        // int ans = function_util(r1, r2, n, s);
        // System.out.println(ans);

        function_util(r1, r2, n, s);
    }

    static void function_util(int r1, int r2, int n, String str) {
        function(r1, r2, n, str.toCharArray());
    }

    static void function(int r1, int r2, int n, char[] str) {

        int MAX = 200000;

        double d2 = (double) r1 / r2;

        int[] primes = getPrimes(n);

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            // dp[i] = Integer.MAX_VALUE;
            dp[i] = MAX;

        }
        dp[0] = 0;

        for (int source = 0; source <= n - 1; source++) {

            if (str[source] == '*') {
                continue;
            }

            if (source + 1 < n && str[source + 1] != '*') {
                dp[source + 1] = Math.min(dp[source + 1], dp[source] + 1);
            }

            if (source + 2 < n && str[source + 2] != '*') {
                dp[source + 2] = Math.min(dp[source + 2], dp[source] + 1);
            }

            int A = primes[source];
            double d1 = (double) A / (source + 1);
            boolean isSpcl = (Double.compare(d1, d2) >= 0);

            if (isSpcl && source + A < n && str[source + A] != '*') {
                dp[source + A] = Math.min(dp[source + A], dp[source] + 1);
            }

        }

        if (dp[n - 1] != MAX) {
            System.out.println(dp[n - 1]);
        } else {
            System.out.println("No way!");

        }
        // return 0;

    }

    static int[] getPrimes(int n) {
        int[] arr = new int[n];
        arr[0] = 0;

        for (int i = 1; i < n; i++) {
            boolean isP = isPrime(i + 1);
            arr[i] = (isP) ? 1 + arr[i - 1] : arr[i - 1];

        }
        return arr;
    }

    static boolean isPrime(int n) {

        for (int j = 2; j <= n / 2; ++j) {
            if (n % j == 0) {
                return false;
            }
        }

        return true;
    }

}
