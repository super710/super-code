package offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/15
 */
public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {

    /**
     * 剑指 Offer 34. 二叉树中和为某一值的路径
     */

    /**
     * 使用递归算法，进行前序遍历，当节点为叶子结点且和为sum时，加入路径，同时回溯时删除当前节点
     */

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ints = new ArrayList<>();
        reTree(root, new ArrayList<>(), 0, sum, ints);
        return ints;
    }

    public static void reTree(TreeNode root, List<Integer> list, int num, int sum, List<List<Integer>> ints) {
        if (root != null) {
            list.add(root.val);
            num += root.val;
            if (root.left == null && root.right == null && sum == num) {
                ints.add(new ArrayList<>(list));
            }
            reTree(root.left, list, num, sum, ints);
            reTree(root.right, list, num, sum, ints);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);
        System.out.println(pathSum(treeNode, 22));
    }
}
