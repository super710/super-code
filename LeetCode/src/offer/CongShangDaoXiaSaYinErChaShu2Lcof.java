package offer;

import java.util.*;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/4
 */
public class CongShangDaoXiaSaYinErChaShu2Lcof {

    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     */

    /**
     * 每层放进去然后遍历全部队列
     */

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
             return new ArrayList<>();
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            Queue<TreeNode> tempNodes = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (!treeNodes.isEmpty()){
                TreeNode node = treeNodes.poll();
                list.add(node.val);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null){
                    tempNodes.offer(left);
                }
                if (right != null){
                    tempNodes.offer(right);
                }
            }
            lists.add(list);
            treeNodes = tempNodes;
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(levelOrder(treeNode));
    }
}
