package lead_to_offer;

import java.util.Stack;

/**
 * 从尾到头输出链表
 */
public class Question6 {
    static class Node{
        public int value;
        public Node node;
        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node p = head;
        int a[] = {1,2,3,4,5,6};
        for(int i = 0;i<a.length;i++){
            p.node = new Node(a[i]);
            p = p.node;
        }
        p = head;
        while (p!=null){
            System.out.print(p.value);
            p = p.node;
        }
        System.out.println();
        recursionMethod(head);
    }
    //使用栈实现
    public static void stackMethod(Node head){
        if(head == null) return;
        Node p = head;
        Stack stack = new Stack();
        while (p!=null){
            stack.push(p.value);
            p = p.node;
        }
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
    }
    //递归实现
    public static void recursionMethod(Node head){
        if(head==null) return;
        recursionMethod(head.node);
        System.out.print(head.value);
    }
}
