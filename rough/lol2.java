import java.util.*;

class lol2 {

    public static void main(String[] args) {

        String str = "abbcccaa";
        // String str = "zzzzz";

        // String str = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";


        Solution s = new Solution();
        int ans = s.function(str);
        System.out.println(ans);

    }

}

class Solution {

    int MOD = 1000000007;

    int answer = 0;

    int function(String str) {

        Stack<Character> stk = new Stack<>();

        int n = str.length();

        if (n < 2) {
            return n;
        }

        stk.push(str.charAt(0));

        answer = 0;

        for (int i = 1; i < n; i++) {

            char curr = str.charAt(i);

            char top = stk.peek().charValue();

            if (curr == top) {

            } else {
                int count = 0;
                while (stk.size() > 0) {
                    count++;
                    stk.pop();
                }
                add_to_ans(count);
            }

            stk.push(curr);
        }

        int count = 0;
        while (stk.size() > 0) {
            count++;
            stk.pop();
        }

        add_to_ans(count);

        return answer;

    }

    void add_to_ans(int n) {

        if (n <= 0)
            return;
        else if (n == 1) {
            // answer += 1;
            answer = (answer + 1) % MOD;

        }

        else {
            int x = n % MOD;
            int y = (n + 1) % MOD;
            int z = (x * y) % MOD;
            z = z / 2;
            answer = (answer + z) % MOD;
        }
    }

}
