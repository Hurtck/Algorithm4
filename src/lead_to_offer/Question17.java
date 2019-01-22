package lead_to_offer;

import java.util.List;

public class Question17 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k<=0) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 1; i < k; i++) {
            p2 = p2.next;
            if(p2 == null) return null;
        }
        while (p2.next !=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
