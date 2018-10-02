package leetcode;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Ace {
    public static void main(String[] args) {
    }


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

}
