import java.util.*;

class p3 {

    public static void main(String[] args) {

        int n = 14;

        // String ans = Solution2.getPureNumber(n);
        String ans = Solution3.getPureNumber(n);

        System.out.println(ans);
    }

}

class Solution {

    static boolean pow2(int n) {
        double number = Math.log(n) / Math.log(2);
        int checker = (int) number;
        return number - checker == 0;
    }

    static boolean all4(int n, int digits) {
        int up = (int) (Math.pow(2, digits) + Math.pow(2, digits - 1) - 1);
        int low = (int) (Math.pow(2, digits) - 1);
        return (n >= low) && (n < up);
    }

    static String getPureNumber(int n) {
        String[] dp = new String[n + 1];
        dp[0] = "";
        int blocks = 0;
        int disp = 0;
        for (int i = 1; i < n + 1; i++) {
            if (pow2(i + 1)) {
                blocks = blocks + 1;
            }
            if (all4(i, blocks)) {
                disp = (int) Math.pow(2, blocks - 1);
                dp[i] = "4" + dp[i - disp] + "4";
            } else {
                disp = (int) Math.pow(2, blocks);
                dp[i] = "5" + dp[i - disp] + "5";
            }
        }

        return dp[n];
    }

}

class Solution2 {

    static String getPureNumber(int n) {

        if (n == 1) {
            return "44";
        }

        else if (n == 2) {
            return "55";
        }

        else {

            Queue<String> q = new LinkedList<>();
            List<String> ans = new LinkedList<>();

            q.offer("44");
            q.offer("55");

            // int count = 2;

            while (ans.size() < n) {
                String temp = q.poll();
                ans.add(temp);
                q.offer("4" + temp + "4");
                q.offer("5" + temp + "5");
            }

            Collections.sort(ans, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() == o2.length())
                        return o1.compareTo(o2);
                    else
                        return o1.length() - o2.length();

                }

            });

            return ans.get(ans.size() - 1);

        }

    }

}

class Solution3 {
    static String getPureNumber(int n) {
        String res="", p="";
        long nd = 0, k, curr = 0;
        k = n;
        while (k - (1 << (curr)) >= 0) {
            k -= (1 << curr);
            curr++;
            nd++;
        }
        curr = 1;
        while (curr <= n) {
            n -= curr;
            curr *= 2;
        }
        for (int i = 0; i < nd; i++) {
            if ((n & 1) == 1)
                res = res + '5';
            else
                res += '4';
            n >>= 1;
        }

        p = res;

        StringBuffer sbp = new StringBuffer();
        sbp.append(p);
        sbp.reverse();
        p = sbp.toString();
        res = p + res;
        return res;
    }
}