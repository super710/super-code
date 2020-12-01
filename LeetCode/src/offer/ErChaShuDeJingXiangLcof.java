package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/1
 */
public class ErChaShuDeJingXiangLcof {

    /**
     * 剑指 Offer 27. 二叉树的镜像
     */

    /**
     * 使用递归的方法，根节点不为空且左右节点不同时为空，交换左右节点，递归进入
     * 左右节点，最后返回根节点
     */

    public static TreeNode mirrorTree(TreeNode root) {
        if (root != null && (root.left != null || root.right != null)){
            TreeNode right = root.right;
            root.right = root.left;
            root.left = right;
            mirrorTree(root.right);
            mirrorTree(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        TreeNode treeNode1 = mirrorTree(treeNode);
        System.out.println(treeNode1);
    }
}
