package lead_to_offer;

import leetcode.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Question19 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if (list2==null) return list1;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = p1.val>p2.val?p2:p1;
        while (p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                ListNode pNext = p1.next;
                p1.next = p2;
                p1 = pNext;
            }else {
                ListNode pNext = p2.next;
                p2.next = p1;
                p2 = pNext;
            }
        }
        return head;
    }
}
