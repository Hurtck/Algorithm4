package lead_to_offer;

import leetcode.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Question18 {
    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode node1 = ReverseList(head.next);
        head.next.next = head;
        head.next=null;
        return node1;
    }

    /**
     * 循环解法
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head,boolean b) {
        if(head==null||head.next==null) return head;
        ListNode p = head;
        ListNode pHead = null;
        ListNode pPre = null;
        while (p!=null){
            ListNode pNext = p.next;
            if(pNext==null) pHead = p;
            p.next = pPre;
            pPre = p;
            p = pNext;
        }
        return pHead;
    }

}
