/* package codechef; // don't place package name! */

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

/* Name of the class has to be "Main" only if the class is public. */
class p2 {
    public static void main(String[] args) throws java.lang.Exception {

        try {
            // your code goes here
            Reader sc = new Reader();
            int t = sc.nextInt();
            while (t-- > 0) {
                //taking row and col inp
                int[] arr = new int[11];

                for (int i = 1; i <= 10; i++) {
                    arr[i] = sc.nextInt();
                }
                int k = sc.nextInt();

                int ans = fun(arr, k);
                System.out.println(ans);
            }
        } catch (Exception e) {
            return;
        }
    }

    static int fun(int[] arr, int k) {

        for (int i = 10; i > 0; i--) {

            if (k == 0) {
                break;
            }

            if (arr[i] == 0) {
                continue;
            }

            if (arr[i] >= k) {
                arr[i] = arr[i] - k;
                k = 0;

            } else if (arr[i] < k) {
                k = k - arr[i];
                arr[i] = 0;
            }

        }

        for (int i = 10; i > 0; i--) {
            if (arr[i] > 0) {
                return i;
            }
        }

        return 1;
    }

}
