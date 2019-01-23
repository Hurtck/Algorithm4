package lead_to_offer;

import leetcode.TreeNode;

/**
 * 翻转二叉树
 */
public class Question21 {
    public void Mirror(TreeNode root) {
        if(root==null) return;
        TreeNode p = root.left;
        root.left = root.right;
        root.right = p;
        Mirror(root.right);
        Mirror(root.left);
    }
}
