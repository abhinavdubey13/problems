
/**
 *  
 * Initially the zoo have a single chick. A chick gives birth to 2 chicks everyday and the life expectancy of a chick is 6 days. 
 * Zoo officials want to buy food for chicks so they want to know the number of chicks on a nth day. Help the officials for this task.
 *
 * ===========
 * Example : 
 * ===========
 * 
 * 
 * on 3rd day , total chicks will be = 9 
 * on 7th day , total chicks will be = 726
 *  
 */

/**
 * ===========
 * APPROACH :
 * ===========
 * 
 * dp : 1-d (left-to-right)
 *
 * maintain an array , A[i] is an object containing new chicks born on ith day and total chicks on ith day
 * 
 * to calculate A[i] , find the alive chicks on day (i-1) , by : 
 *      1. find total chicks on day (i-1)
 *      2. subtract the chicks which died , bcz life=6 days
 * 
 * A[i].new-chicks = alive-chicks*2
 * A[i].total-chicks = alive-chick*3  (A[i].new-chicks + alive-chicks)
 * 
 * 
 * ==================================
 * TC = O(n)
 * SC = O(n)
 * 
 *
 * 
 */

import java.util.ArrayList;
import java.util.Collections;

class Diary {
    int newChicks;
    int totalChicks;

    Diary(int nc, int tc) {
        this.newChicks = nc;
        this.totalChicks = tc;
    }
}

public class p41_chicksInZoo {
    public static void main(String[] args) {

        int Nth_day = 3;

        // int Nth_day = 7;

        int numOfChicks = calculator(Nth_day);
        System.out.println(numOfChicks);

    }

    static int calculator(int Nth_day) {

        ArrayList<Diary> diaryList = new ArrayList<>();

        //on Oth day , there were no chicks
        diaryList.add(new Diary(0, 0));

        //on 1st day , new = total = 1;
        diaryList.add(new Diary(1, 1));

        for (int i = 2; i <= Nth_day; i++) {

            int chicks_alive_today = diaryList.get(i - 1).totalChicks;

            if (i >= 7) {
                chicks_alive_today = chicks_alive_today - diaryList.get(i - 6).newChicks;
            }

            int newChicks = chicks_alive_today * 2;
            int totalChicks = chicks_alive_today * 3;

            diaryList.add(new Diary(newChicks, totalChicks));
        }

        return diaryList.get(diaryList.size() - 1).totalChicks;

    }

}