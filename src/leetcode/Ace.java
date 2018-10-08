package leetcode;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ace {
    public static void main(String[] args) {
        //(0,9),(138,429),(115,359),(115,359),(-30,-102),(230,709),(-150,-686),(-135,-613),(-60,-248),(-161,-481),(207,639),(23,79),(-230,-691),(-115,-341),(92,289),(60,336),(-105,-467),(135,701),(-90,-394),(-184,-551),(150,774)
        Point[] points = new Point[]{new Point(0,9),new Point(138,429),new Point(115,359),
                new Point(115,359),new Point(-30,-102),new Point(230,709),
                new Point(-150,-686),new Point(-135,-613),new Point(-60,-248),
                new Point(-161,-481),new Point(207,639),new Point(23,79),
                new Point(-230,-691),new Point(-115,-341),new Point(92,28),new Point(60,336),
                new Point(-105,-467),new Point(135,701),new Point(-90,-394),new Point(-184,-551),new Point(150,774)
        };
        System.out.println(maxPoints(points));
    }

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

    //max-points-on-a-line
    public static int maxPoints(Point[] points) {
        if(points.length<=2) return points.length;

        int maxNumbers = 2;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int count = 2;
                for(int k = j+1;k<points.length;k++){
                    //重复点直接++
                    if ((points[k].x == points[i].x && points[k].y == points[i].y) ||
                            (points[k].x == points[j].x && points[k].y == points[j].y)) {
                        count++;
                        if (count > maxNumbers)
                            maxNumbers = count;
                        continue;
                    }

                    //垂直点判断
                    if (points[k].x == points[j].x) {
                        if (points[j].x == points[i].x) {
                            count++;
                            if (count > maxNumbers)
                                maxNumbers = count;
                            continue;
                        } else
                            continue;
                    } else if (points[j].x == points[i].x) {
                        continue;
                    }

                    if((points[k].y-points[j].y)/(float)(points[k].x-points[j].x) ==
                            (points[j].y-points[i].y)/(float)(points[j].x-points[i].x)) count++;
                    if(count>maxNumbers) maxNumbers = count;
                }
            }
        }
        return maxNumbers;

    }


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

    //minimum-depth-of-binary-tree
    public int run(TreeNode root) {
        Queue<TreeNode> list = new LinkedList<>();
        if (root  == null) return 0;
        TreeNode ln = root;
        int depth = 0;
        list.offer(root);
        while(!list.isEmpty()){
            depth += depth;
            int size = list.size();
            for(int i=0;i<size;i++){
                TreeNode node = list.poll();
                if(node.right !=null){
                    list.offer(node.right);
                }
                if(node.left !=null){
                    list.offer(node.left);
                }
                if(node.right == null&&node.left==null) return depth;
            }
        }
        return depth;
    }
    //二维数组寻找最小值
    public static boolean Find(int target, int [][] array) {
        int rowMaxIndex = array.length-1;
        int listMaxtIndex = array[0].length-1;
        int i =rowMaxIndex;
        if(rowMaxIndex == 0&&listMaxtIndex==-1) return false;
        int j =0;
        while(i>=0&&j<=listMaxtIndex){
            if(array[i][j] == target) return true;
            else if(array[i][j] < target) j++;
            else if(array[i][j] > target) i--;
        }
        return false;
//        for(i=0;i<rowMaxIndex;i++){
//            int low = 0;
//            int hi = listMaxtIndex;
//            if(array[i][low]==target) return true;
//            if(array[i][hi]==target) return true;
//            while(low<hi){
//                int mid = (low+hi)/2;
//                if(array[i][mid]==target) return true;
//                if(array[i][mid]<target){
//                    low = mid+1;
//                }
//                if(array[i][mid]>target){
//                    hi = mid-1;
//                }
//            }
//        }
//        return false;
    }

    static class Point {
        int x;int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

     class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

}
