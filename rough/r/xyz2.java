import java.util.*;
import java.lang.*;
import java.io.*;

class Range {
    int L;
    int R;

    Range() {
        this.L = 0;
        this.R = 0;
    }

    Range(int l, int r) {
        this.L = l;
        this.R = r;
    }
}

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

class xyz2 {

    public static void main(String[] args) {

        Reader sc = new Reader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Range[] arr = new Range[m];
            for (int i = 0; i < m; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                arr[i] = new Range(l, r);
            }
            Solution.function(arr, n, m);
            System.out.println();
        }
    }

}

class Heap_helper implements Comparable<Heap_helper> {
    int shop_id;
    int freq;

    @Override
    public int compareTo(Heap_helper o) {

        if (this.freq != o.freq) {
            return -1 * (this.freq - o.freq);
        } else {
            return this.shop_id - o.shop_id;
        }
    }

    Heap_helper(int id, int f) {
        this.shop_id = id;
        this.freq = f;
    }
}

class List_helper implements Comparable<List_helper> {
    int shop_id;
    int freq;

    @Override
    public int compareTo(List_helper o) {
        if (this.freq != o.freq) {
            return (this.freq - o.freq);
        } else {
            return this.shop_id - o.shop_id;
        }
    }

    List_helper(int id, int f) {
        this.shop_id = id;
        this.freq = f;
    }
}

class Solution {

    static void function(Range[] arr, int shops, int people) {

        Map<Integer, Integer> hmap = new HashMap<>();

        for (Range r : arr) {
            for (int i = r.L; i <= r.R; i++) {
                hmap.put(i, 1 + hmap.getOrDefault(i, 0));
            }
        }

        PriorityQueue<Heap_helper> pq = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            pq.offer(new Heap_helper(entry.getKey(), entry.getValue()));
        }

        List<List_helper> answer = new ArrayList<>();
        for (int i = 2; i >= 0; i--) {
            Heap_helper p = pq.poll();
            answer.add(new List_helper(p.shop_id, p.freq));
        }

        Collections.sort(answer);

        for (List_helper i : answer) {
            System.out.print(i.shop_id + " ");
        }

    }

}
