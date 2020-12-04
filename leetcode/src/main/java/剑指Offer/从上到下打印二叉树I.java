package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Tiger
 * @date 2020/12/4 9:26
 */
public class 从上到下打印二叉树I {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        //存储根节点
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        ArrayList<Integer> integers = new ArrayList<>();


        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pop();
            integers.add(pop.val);
            if (pop.left != null) {
                treeNodes.add(pop.left);
            }
            if (pop.right != null) {
                treeNodes.add(pop.right);
            }
        }

        int[] ints = new int[integers.size()];

        for (int i = 0; i < integers.size(); i++) {
            ints[i] = integers.get(i);
        }
        return ints;
    }
}
