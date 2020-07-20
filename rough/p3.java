
import java.util.*;
import java.lang.*;
import java.io.*;

class Reader {
    BufferedReader br;
    StringTokenizer st;

    public Reader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}

class p3 {
    public static void main(String[] args) throws java.lang.Exception {

        try {
            Reader sc = new Reader();
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }

                int ans = fun(arr);
                System.out.println(ans);
            }
        } catch (Exception e) {
            return;
        }
    }

    static int fun(int[] arr) {

        int n = arr.length;

        if (n < 2) {
            return 0;
        }

        else if (n == 2) {
            return 1;
        }

        else {

            Set<Integer> my_set = new HashSet<>();

            int[][] max_dp = new int[n][n];
            int[][] max_2_dp = new int[n][n];

            for (int len = 2; len <= n; len++) {
                for (int i = 0; i + len - 1 < n; i++) {
                    int j = i + len - 1;
                    if (len == 2) {
                        max_dp[i][j] = Math.max(arr[i], arr[j]);
                        max_2_dp[i][j] = Math.min(arr[i], arr[j]);
                    } else if (len > 2) {
                        max_dp[i][j] = Math.max(max_dp[i][j - 1], max_dp[i + 1][j]);
                        max_2_dp[i][j] = Math.min(max_dp[i][j - 1], max_dp[i + 1][j]);
                    }
                }
            }

            for (int len = 2; len <= n; len++) {
                for (int i = 0; i + len - 1 < n; i++) {
                    int j = i + len - 1;
                    my_set.add(max_dp[i][j] - max_2_dp[i][j]);
                }
            }

            return my_set.size();
        }
    }

}
