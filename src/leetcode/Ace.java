package leetcode;

public class Ace {
    public static void main(String[] args) {
        //(0,9),(138,429),(115,359),(115,359),(-30,-102),(230,709),(-150,-686),(-135,-613),(-60,-248),(-161,-481),(207,639),(23,79),(-230,-691),(-115,-341),(92,289),(60,336),(-105,-467),(135,701),(-90,-394),(-184,-551),(150,774)
//        Point[] points = new Point[]{new Point(0,9),new Point(138,429),new Point(115,359),
//                new Point(115,359),new Point(-30,-102),new Point(230,709),
//                new Point(-150,-686),new Point(-135,-613),new Point(-60,-248),
//                new Point(-161,-481),new Point(207,639),new Point(23,79),
//                new Point(-230,-691),new Point(-115,-341),new Point(92,28),new Point(60,336),
//                new Point(-105,-467),new Point(135,701),new Point(-90,-394),new Point(-184,-551),new Point(150,774)
//        };
//        System.out.println(maxPoints(points));
        int[] a = new int[]{2,3,4,5,6,7};
        ListNode head  = new ListNode(1);
        ListNode pNode = head;
        for(int i=0;i<a.length;i++){
            pNode.next = new ListNode(a[i]);
            pNode = pNode.next;
        }
        reorderList(head);
    }

    public static ListNode reversList(ListNode head){
        ListNode curNode = head;
        ListNode preNode = null;
        while (curNode!=null){
            ListNode tNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = tNode;
        }
        return preNode;
    }

    public static void reorderList(ListNode head) {
        if(head==null) return;
        ListNode quickNode = head;
        ListNode slowNode = head;
        while (quickNode!=null&&quickNode.next!=null){
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
        }
        ListNode ahead = head;
        ListNode bhead = slowNode.next;
        slowNode.next = null;
        bhead = reversList(bhead);
        while (bhead!=null){
            ListNode pNode = ahead.next;
            ahead.next = bhead;
            bhead = bhead.next;
            ahead.next.next = pNode;
            ahead = pNode;
        }
    }
}
