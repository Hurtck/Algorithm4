package lead_to_offer;

import leetcode.TreeNode;

/**
 * 给定二叉树中和其中一个节点，找出中序遍历的下一个节点
 * 思路一：中序遍历二叉树，判断当前节点与要查找的节点是否相同，是的话输出下一节点
 * 思路二:可以分为二种情况
 * 1、当前节点有右节点：右节点的最左节点是下一个节点，若有节点没有左节点，则右节点是下一个节点
 * 2、当前节点没有右节点：如果他是父节点的左节点则下一节点是父节点，如过它是父节点的右节点则下一节点是父节点向上遍历当节点是父结点的左节点时
 *
 */
public class Question8 {
    public static TreeNode findNextNode(TreeNode node){
        if(node == null) return null;
        if(node.right !=null){
            node = node.right;
            while (node.left!=null) node = node.left;
            return node;
        }else if(node.father!=null&&node.father.left == node) return node.father;
        else {
            while (node.father!=null&&node.father.left != node){
                node = node.father;
            }
            return node;
        }
    }
}
