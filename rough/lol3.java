import java.util.*;

class lol3 {

    public static void main(String[] args) {

        // int[] arr = { 2, 4, 8, 2 };
        // int ops = 4;

        // int[] arr = { 7,17 };
        // int ops = 2;

        int[] arr = { 9 };
        int ops = 2;

        Solution s = new Solution();
        int ans = s.function(arr, ops);
        System.out.println(ans);

    }

}

class Solution {

    PriorityQueue<Integer> pq;
    int answer;

    int function(int[] arr, int ops) {

        pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer first, Integer second) {
                return -1 * (first.intValue() - second.intValue());
            }
        });
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
        }

        fun(ops);

        return answer;
    }

    void fun(int ops) {

        if (ops == 0) {
            count();
            return;
        }

        int max = pq.poll();

        for (int i = 1; i <= max / 2; i++) {

            pq.offer(i);
            pq.offer(max - i);
            fun(ops - 1);
            // count();
            pq.remove(i);
            pq.remove(max - i);
        }

        pq.offer(max);
    }

    void count() {

        Object[] n = pq.toArray();

        int minn = Integer.MIN_VALUE;
        for (int i = 0; i < n.length; i++) {
            minn = Math.max(minn, (int) n[i]);
        }

        answer = Math.min(answer, minn);

    }

}
