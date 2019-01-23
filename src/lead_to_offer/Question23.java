package lead_to_offer;

import java.util.Stack;

public class Question23 {
    Stack<Integer> data_stack = new Stack<>();
    Stack<Integer> assistant_stack = new Stack<>();

    public void push(int node) {
        data_stack.push(node);
        if(assistant_stack.isEmpty()||node<=assistant_stack.peek()){
            assistant_stack.push(node);
        }else{
            assistant_stack.push(assistant_stack.peek());
        }
    }

    public void pop() {
        assert (data_stack.size()>0&&assistant_stack.size()>0);
        data_stack.pop();
        assistant_stack.pop();
    }

    public int top() {
        return data_stack.peek();
    }

    public int min() {
        return assistant_stack.peek();
    }
}
