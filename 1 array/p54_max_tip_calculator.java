
import java.util.*;

/**
 * A and B are the only two waiters in Royal Restaurant. Today, the restaurant received N orders. 
 * The amount of tips may differ when handled by different waiters .
 * if A takes the ith order, he would be tipped Ai rupees and 
 * if B takes this order, the tip would be Bi rupees.
 * 
 * In order to maximize the total tip value they decided to distribute the order among themselves. One order will be handled by one person only. 
 * 
 * Also, due to time constraints A cannot take more than X orders and B cannot take more than Y orders. 
 * It is guaranteed that X + Y is greater than or equal to N, which means that all the orders can be handled by either A or B. 
 * Find out the maximum possible amount of total tip money after processing all the orders.
 *
 * ===========
 * Example : 
 * ===========
 * total orders = 5 
 * 
 * max orders by A => X =3
 * max orders by B => Y =3
 * 
 * A[] = {1,2,3,4,5}
 * B[] = {5,4,3,2,1}
 * 
 * =================================================
 * ANSWER = 21  | B[0] + B[1] + A[2] + A[3] + A[4]
 * =================================================
 * 
 */

/**
 * ===========
 * APPROACH :
 * ===========
 * 
 * dp : not required
 * 
 * step1 : sort the indices in the decreasing order of absolute difference
 * step2 : now consider this sorted help-object-list elements one by one starting with max absolute diff
 * step3 : to determine who will pick the order , check the below condition
 * 
 * an order can be picked by A when both these satisfy: 
 *      1. order-left-for-A > 0  , and
 *      2. tipA >= tipB  OR order-left-for-B = 0 
 * 
 * an order can be picked by B when both these satisfy: 
 *      1. order-left-for-B > 0  , and
 *      2. tipB >= tipA  OR order-left-for-A = 0 
 * 
 * 
 * ============================================================
 * let number of orders = N
 * 
 * TC = O(N.logN)
 * SC = O(N)
 * 
 */

class HelpObject implements Comparable<HelpObject> {
    int abs_difference;
    int index;

    HelpObject(int absDiff, int idx) {
        this.abs_difference = absDiff;
        this.index = idx;
    }

    @Override
    public int compareTo(HelpObject helpObject) {
        return -(this.abs_difference - helpObject.abs_difference);
    }
}

public class p54_max_tip_calculator {
    public static void main(String[] args) {

        // int totalOrders = 8;
        // int maxOrdersByA = 4;
        // int maxOrdersByB = 4;
        // int[] tipA = { 1, 4, 3, 2, 7, 5, 9, 6 };
        // int[] tipB = { 1, 2, 3, 6, 5, 4, 9, 8 };

        int totalOrders = 5;
        int maxOrdersByA = 3;
        int maxOrdersByB = 3;
        int[] tipA = { 1, 2, 3, 4, 5 };
        int[] tipB = { 5, 4, 3, 2, 1 };

        int answer = calculator(totalOrders, maxOrdersByA, maxOrdersByB, tipA, tipB);
        System.out.println(answer);

    }

    static int calculator(int totalOrders, int maxOrdersByA, int maxOrdersByB, int[] tipA, int[] tipB) {

        ArrayList<HelpObject> helpObjectList = new ArrayList<HelpObject>();

        //init helper-object
        for (int i = 0; i < tipA.length; i++) {
            int absDiff = Math.abs(tipA[i] - tipB[i]);
            helpObjectList.add(new HelpObject(absDiff, i));
        }

        //sort(descending) based on max-abs-difference
        Collections.sort(helpObjectList);

        int maxTip = 0;

        for (int i = 0; i < helpObjectList.size(); i++) {

            int idxToConsider = helpObjectList.get(i).index;
            int tipFor_A_inCurrentOrder = tipA[idxToConsider];
            int tipFor_B_inCurrentOrder = tipB[idxToConsider];

            if (maxOrdersByA > 0 && (tipFor_A_inCurrentOrder >= tipFor_B_inCurrentOrder || maxOrdersByB == 0)) {
                maxTip += tipFor_A_inCurrentOrder;
                maxOrdersByA--;
            }

            else if (maxOrdersByB > 0 && (tipFor_B_inCurrentOrder >= tipFor_A_inCurrentOrder || maxOrdersByA == 0)) {
                maxTip += tipFor_B_inCurrentOrder;
                maxOrdersByB--;
            }
        }

        return maxTip;

    }

}