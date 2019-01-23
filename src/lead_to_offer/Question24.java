package lead_to_offer;

import java.util.Stack;

public class Question24 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||pushA.length!=popA.length) return false;
        Stack stack = new Stack<Integer>();
        int j=0;//j计数器指向pushA
        for (int i = 0; i < popA.length; i++) {
            while (stack.isEmpty()||!stack.peek().equals(popA[i])){
                if(j>=pushA.length) return false;//全部入栈但未找到则不是有效序列
                stack.push(pushA[j++]);
            }
             stack.pop();
        }
        return true;
    }
}
