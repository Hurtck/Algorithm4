package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Dobt {
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
}
