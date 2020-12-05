package offer;

import sun.net.www.http.HttpClient;

import java.util.*;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/4
 */
public class CongShangDaoXiaSaYinErChaShu3Lcof {

    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     */

    /**
     * 找规律，第三层开始都是栈，一左一右入栈
     */

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        boolean flag = true;
        int num = 0;
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            LinkedList<TreeNode> tempNodes = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (!treeNodes.isEmpty()) {
                TreeNode node;
                TreeNode left;
                TreeNode right;
                if (num < 2) {
                    node = treeNodes.poll();
                    left = node.left;
                    right = node.right;
                } else {
                    node = treeNodes.pollLast();
                    left = node.left;
                    right = node.right;
                    if (flag) {
                        TreeNode temp = left;
                        left = right;
                        right = temp;
                    }
                }
                if (right != null) {
                    tempNodes.offer(right);
                }
                if (left != null) {
                    tempNodes.offer(left);
                }
                list.add(node.val);
            }
            num = ++num % 4;
            flag = !flag;
            lists.add(list);
            treeNodes = tempNodes;
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.left.left = new TreeNode(7);
        treeNode.left.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(6);
        treeNode.left.left.right = new TreeNode(4);
        treeNode.left.right.left = new TreeNode(3);
        treeNode.left.right.right = new TreeNode(1);
        System.out.println(levelOrder(treeNode));
    }
}
