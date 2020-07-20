

/**
 * You are given n days and for each day (i) you could either perform a high effort tasks (high[i]) or a low effort tasks (low[i]) or no task 
 * 
 * the constraint is :  you can choose a high-effort tasks only if you chose no task on the previous day. 
 * 
 * find the MAXIMUM amount of tasks you can  , perform within these n days.
 * 
 */

/**
 * dp-array = not required , we need few variables only
 * solution with space = O(1)
 * 
 * is almost same as the skip_work problem ,
 * 
 * if i am performing a high task today , then yesterday i must be on-leave
 * if i am performing a low task today , then yesterday i could have performed any (high/low) task : take max
 * if i am on leave today , then yesterday i could have performed any : take max
 * 
 */


class p27_lowHighEffort {

    public static void main(String[] args) {

        int[] high = { 3, 6, 8, 7, 6 };
        int[] low = { 1, 5, 4, 5, 3 };
        int answer = calulator(high, low);
        System.out.println(answer);
    }

    static int calulator(int[] high, int[] low) {

        int highTask = high[0];
        int lowTask = low[0];
        int leave = 0;

        for (int i = 1; i < high.length; i++) {

            int prevDayHigh = highTask;
            int prevDayLow = lowTask;
            int prevDayLeave = leave;

            highTask = prevDayLeave + high[i];
            lowTask = Math.max(prevDayHigh, prevDayLow) + low[i];
            leave = Math.max(prevDayHigh, prevDayLow);

        }

        return Math.max(highTask, Math.max(lowTask, leave));
    }
}