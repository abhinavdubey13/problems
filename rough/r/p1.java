import java.util.*;

class p1 {

    public static void main(String[] args) {

        String[] input = {"hacker" , "wiki" , "google" , "hacker" , "hacker"};

        String[] ans = Solution.solve(input, input.length);
        for(String s: ans){
            System.out.print(s + "  ");
        }
        System.out.println();
    }

}

class Arr_obj implements Comparable<Arr_obj> {
    String str;
    int freq;

    Arr_obj(String s, int f) {
        this.str = s;
        this.freq = f;
    }

    @Override
    public int compareTo(Arr_obj o) {
        if (this.freq != o.freq) {
            return -1 * (this.freq - o.freq);
        } else {
            return this.str.compareTo(o.str);
        }
    }

}

class Solution {

    static String[] solve(String[] arr, int N) {

        Map<String, Integer> hmap = new HashMap<>();

        for (String s : arr) {
            hmap.put(s, 1 + hmap.getOrDefault(s, 0));
        }

        List<Arr_obj> helper_list = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
            helper_list.add(new Arr_obj(entry.getKey(), entry.getValue().intValue()));
        }

        Collections.sort(helper_list);
        String[] ans = new String[helper_list.size()];

        int i = 0;

        for (Arr_obj ao : helper_list) {
            ans[i] = ao.str;
            i++;
        }

        return ans;

    }

}
