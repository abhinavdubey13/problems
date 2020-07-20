import java.util.*;

/**
 * 
 * leetcode : 155 (had to use long , instead of integer)
 * 
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 * 
 * 
 * Design a Data Structure SpecialStack that supports all the stack operations like 
 * push(), 
 * pop(), 
 * isEmpty(), 
 * isFull() and 
 * getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1)
 * 
 * 
 */

/**
 * 
 * using basic math : 
 * 
 * let M : minimum element at any point of time in stack
 * 
 * 
 * ==============================
 * while pushing an element X :
 * =============================
 * 1. if X>=M  : push X simply and do not update M  (logically , M will still be the minimum elemet of stack)
 * 2. X<M      : here we do not push X directly , but 
 *      (2.1)push (2X-M) , and then 
 *      (2.2)update M as X (sequence is important)
 * 
 * since X<M , 
 * X-M  < 0  (now add X to both sides)
 * 2X-M < X  (so we push 2X-M)
 * 
 * THIS WILL WORK AS A FLAG (special condition) : Top of stack is lesser than minimum element of stack , which is used while popping
 * 
 * 
 * 
 * ==============================
 * while popping an element  :
 * =============================
 * 1. if TOP >= M : pop the to normally
 * 2. TOP < M     : this is the FLAG , we directly do not pop
 *      (2.1)element to be returned = M (ie. current min value)
 *      (2.2)update M = (2M-TOP)
 * 
 * 
 * since at this point
 * M = A
 * TOP = X (and We know that X=2A-M)
 * 
 * 
 * so , 2M-TOP = 2A - (2A-M)
 * ie we get M back
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

class p4_special_stack {

    public static void main(String[] args) {

        Special_stack stk = new Special_stack();

        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(0);
        stk.push(4);
        //Stack : 1,2,3,0,4;
        System.out.println("min : " + stk.getMin());
        System.out.println("top : " + stk.top());

        stk.pop();
        stk.pop();
        stk.pop();
        //stack : 1,2
        System.out.println("min : " + stk.getMin());
        System.out.println("top : " + stk.top());

    }

}

class Special_stack {
    private int M;
    private Stack<Integer> stk;

    public Special_stack() {
        this.stk = new Stack<>();
        this.M = -1;
    }

    public void push(int X) {

        if (stk.size() == 0) {
            M = X;
            stk.push(X);
        } else {

            if (X >= M) {
                stk.push(X);
            } else {
                stk.push(2 * X - M);
                M = X;
            }
        }

    }

    public void pop() {
        if (stk.size() == 0) {
            return;
        }
        int popped = this.stk.pop();
        if (popped < M) {
            M = 2 * M - popped;
            //we can return this value if required , but the method itself is void
        }
    }

    public int top() {
        int top = this.stk.peek();
        return Math.max(top, M);
        // if (top < M) {
        //     return M;
        // } else {
        //     return top;
        // }

    }

    public int getMin() {
        return M;
    }

}
