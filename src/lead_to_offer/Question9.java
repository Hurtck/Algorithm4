package lead_to_offer;

import java.util.Stack;

/***
 * 用两个栈实现队列
 * 思路：一个栈用于存放入队数据一个栈用于存放出队数据，当出队栈没有数据的时候从入栈堆去取数据
 */
public class Question9 {

    class TwoStackQueue{
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;
        public TwoStackQueue(){
            inStack = new Stack<Integer>();
            outStack = new Stack<Integer>();
        }
        public void inQueue(int i){
            inStack.push(i);
        }
        public int deQueue(){
            if(outStack.empty()){
                while (!inStack.empty()) outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
    }
}
