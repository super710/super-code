package offer;

import java.util.*;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/3
 */
public class CongShangDaoXiaSaYinErChaShuLcof {

    /**
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     */

    /**
     * 使用队列进行广度优先遍历
     */

    public static int[] levelOrder(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        List<Integer> lists = new ArrayList<>();
         if (root == null){
            return new int[0];
        }
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()){
            TreeNode treeNode = treeNodes.poll();
            lists.add(treeNode.val);
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            if (left != null){
                treeNodes.offer(left);
            }
            if (right != null){
                treeNodes.offer(right);
            }
        }
        int[] res = new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            res[i] = lists.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(levelOrder(treeNode)));
    }
}
