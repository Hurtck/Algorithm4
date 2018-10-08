package leetcode;

//在链表进行排序的操作
public class SortOnLink {

    public static void main(String[] args) {
        int[] a = new int[]{3,2,1};
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i =0;i<a.length;i++){
            ListNode listNode = new ListNode(a[i]);
            p.next = listNode;
            p = p.next;
        }
        head = head.next;
        head = insertionSortList(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    //归并排序 开始
    public ListNode sortList(ListNode head) {
        if(head == null||head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode preList = sortList(head);
        ListNode lastList = sortList(midNext);
        return mergeSort(preList,lastList);
    }
    private ListNode getMid(ListNode head) {
        if(head == null||head.next == null)
            return head;
        ListNode quickNode = head;
        ListNode slowNode = head;
        while (quickNode !=null&&quickNode.next!=null){
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
    private ListNode mergeSort(ListNode n1, ListNode n2) {
        ListNode preList = n1,lastList = n2;
        ListNode head = new ListNode(0);
        ListNode curList = head;
        while (preList !=null&&lastList!=null){
            if(preList.val>lastList.val){
                curList.next = lastList;
                lastList = lastList.next;
            }else {
                curList.next = preList;
                preList = preList.next;
            }
            curList = curList.next;
        }
        if(preList == null) curList.next = lastList;
        else curList.next = preList;
        return head.next;
    }
    //归并排序 结束

    //插入排序 开始  int[] a = new int[]{3,2,1};
    public static ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode cur = head;
        while (cur!=null&&cur.next!=null){
            if(cur.val>cur.next.val){
                ListNode p = cur.next;
                cur.next = cur.next.next;
                if(p.val<=head.val){
                    p.next = head;
                    head = p;
                }else{
                    ListNode recur = head;
                    while (recur.next.val<p.val) recur = recur.next;
                    ListNode k =recur.next;
                    recur.next = p;
                    p.next = k;
                }
            }else {
                cur = cur.next;
            }
        }
        return head;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
