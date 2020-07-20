import java.util.*;

import sun.launcher.resources.launcher;

class p2 {

    public static void main(String[] args) {
        // int[] arr = { 2, 2, 2 };
        int[] arr = { 2, 3, 6, 6 };
        int ans = Solution.solve(arr.length, arr);
        System.out.println(ans);
    }

}

class Solution {

    static int solve(int n, int[] arr) {

        // List<Integer> s = new ArrayList<Integer>();
        // int max_ele = Integer.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        // s.add(arr[i]);
        // max_ele = Math.max(max_ele, arr[i]);
        // }

        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i : arr) {
            hmap.put(i, 1 + hmap.getOrDefault(i, 0));
        }

        Arrays.sort(arr);
        int max_ele = arr[n - 1];

        Set<Integer> res = new HashSet<Integer>();
        // List<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                for (int j = arr[i] * 1; j <= max_ele; j += arr[i]) {
                    int idx = bs(arr, j);
                    if (idx > -1 && idx + 1 < n && arr[idx + 1] == j) {
                        res.add(j);
                    }
                }
            }
        }

        int count = 0;
        for (int i : res) {

            count += hmap.get(i);

        }

        return count;

        // return res.size();
    }

    static int bs(int[] arr, int TARGET) {
        int LOW = 0;
        int HIGH = arr.length - 1;
        while (LOW <= HIGH) {
            int MID = LOW + (HIGH - LOW) / 2;
            if (arr[MID] == TARGET) {
                if (MID == 0 || arr[MID - 1] < TARGET) {
                    return MID;
                }
                HIGH = MID - 1;
            }

            else if (TARGET < arr[MID]) {
                HIGH = MID - 1;

            } else if (TARGET > arr[MID]) {
                LOW = MID + 1;
            }
        }
        return -1;
    }
}
