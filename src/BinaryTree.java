import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

//二叉树先序、中序、后序遍历递归实现与非递归实现
public class BinaryTree {
    static ArrayList<Integer> alist = new ArrayList<Integer>();
    public static void main(String[] args) {
        int a[] = new int[]{2};
        TreeNode root = insertNode(null,1);
        for(int i=0;i<a.length;i++){
            insertNode(root,a[i]);
        }
        midOrderTraverse(root);
        System.out.println(alist.toString());

    }

    /**
     * 递归的遍历实现(recursive solution)
     */

    public static void preoder(TreeNode root){
        if(root !=null){
            System.out.println(root.val);
            preoder(root.left);
            preoder(root.right);
        }
    }

    public static void midoder(TreeNode root){
        if(root !=null){
            midoder(root.left);
            System.out.println(root.val);
            midoder(root.right);
        }
    }

    public static void postoder(TreeNode root){
        if(root !=null){
            postoder(root.left);
            postoder(root.right);
            System.out.println(root.val);
        }
    }

    /***
     * 迭代的遍历实现(iterative solution)
     * 一、先序遍历 基本思路，先访问每个节点的右节点然后将其压入栈保存，当右节点为空时则从栈中取出一个节点访问其左节点
     * 二、中序遍历 基本思路：访问左节点将其入栈，当访问到空节点时，出栈并将其输出，继续访问其右节点
     * 三、后序遍历 基本思路：
     */
    public static void preOrderTraverse(TreeNode root){
        TreeNode pNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (pNode!=null||stack.isEmpty()){
            if(pNode!=null){
                System.out.println(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            }else{
                pNode = stack.pop();
                pNode = pNode.right;
            }
        }
    }

    public static void midOrderTraverse(TreeNode root){
        TreeNode pNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (pNode!=null||!stack.isEmpty()){
            if(pNode!=null){
                stack.push(pNode);
                pNode = pNode.left;
            }else{
                TreeNode node = stack.pop();
                System.out.println(node.val);
                alist.add(node.val);
                pNode = node.right;
            }
        }
    }

    public static void postOrderTraverse(TreeNode root){

    }


    public static TreeNode insertNode(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(val <= root.val){
            root.left = insertNode(root.left,val);
        }
        if(val > root.val){
            root.right = insertNode(root.right,val);
        }
        return root;
    }
}
