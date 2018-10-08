package leetcode;

import java.util.Stack;

public class Eval {
    //evaluate-reverse-polish-notation
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String symbol:tokens){
            if("+".equals(symbol)){
                int a = Integer.valueOf(stack.pop());
                int b =Integer.valueOf(stack.pop());
                stack.push((b+a)+"");
            }
            else if("-".equals(symbol)){
                int a = Integer.valueOf(stack.pop());
                int b =Integer.valueOf(stack.pop());
                stack.push((b-a)+"");
            }
            else if("*".equals(symbol)){
                int a = Integer.valueOf(stack.pop());
                int b =Integer.valueOf(stack.pop());
                stack.push((b*a)+"");
            }
            else if("/".equals(symbol)){
                int a = Integer.valueOf(stack.pop());
                int b =Integer.valueOf(stack.pop());
                stack.push((b/a)+"");
            }else stack.push(symbol);
        }
        return Integer.valueOf(stack.pop());
    }
}
