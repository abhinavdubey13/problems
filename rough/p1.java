/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class p1
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    
	    try{
		// your code goes here
		 Reader sc = new Reader();
        int t = sc.nextInt();
        while (t-- > 0) {
            //taking row and col inp
            int n = sc.nextInt();
            int k = sc.nextInt();
            int ans = fun(n, k);
            System.out.println(ans);
        }
	    }catch(Exception e){
	        return ;
	    }
	}
	
	
	static int fun(int n, int k) {

        if (k == 0) {
            return n;
        }

        else if (n == k) {
            return 0;
        }

        else if (k > n) {
            return n;
        }

        else {
            int times = n / k;
            return n - times * k;

        }

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
