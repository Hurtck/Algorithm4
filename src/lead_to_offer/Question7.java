package lead_to_offer;

import leetcode.TreeNode;

/**
 * 根据中序遍历和先序遍历构建二叉树
 * 思路，先序遍历的第一个值是把中序遍历分为两部分，分为一个更小的先序遍历、中序遍历子序列，递归的用先序遍历划分中序遍历
 * 划分、构造二叉树
 */
public class Question7 {
    public static void main(String[] args) {
        try {
            reBuildTree(new int[] {1,2,4,7,3,5,6,8},new int[] {4,7,2,1,5,3,8,6});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static TreeNode reBuildTree(int[] preOrder,int[] inOrder) throws Exception {
        if(inOrder==null||preOrder==null||inOrder.length == 0||preOrder.length==0) return null;
        if (inOrder.length!=preOrder.length){
            throw new Exception("invalid input 2");
        }
        TreeNode root= new TreeNode(preOrder[0]);
        root.left = null;
        root.right = null;
        if(inOrder.length==1 ){
                if(preOrder[0]==inOrder[0])
                    return root;
                else{
                    throw new Exception("invalid input 3");
                }
        }
        int i;
        //找到中序遍历中间节点
        for(i =0;i<inOrder.length;i++){
            if (inOrder[i]==preOrder[0]) break;
        }
        //划分中序遍历
        int[] leftInOrder = new int[i];
        int[] rightInOrder = new int[inOrder.length-i-1];
        for(int j=0;j<inOrder.length;j++){
            if(j<i) leftInOrder[j] = inOrder[j];
            if(j>i) rightInOrder[j-i-1] = inOrder[j];
        }
        //划分先序遍历
        int[] leftPreOrder = new int[leftInOrder.length];
        int[] rightPreOrder = new int[rightInOrder.length];
        for(int k = 1;k<preOrder.length;k++){
            if(k<=leftInOrder.length) leftPreOrder[k-1] = preOrder[k];
            if(k>leftInOrder.length) rightPreOrder[k-leftInOrder.length-1] = preOrder[k];
        }
        root.left = reBuildTree(leftPreOrder,leftInOrder);
        root.right = reBuildTree(rightPreOrder,rightInOrder);
        return root;
    }
}
