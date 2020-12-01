package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/1
 */
public class DuiChengDeErChaShuLcof {

    /**
     * 剑指 Offer 28. 对称的二叉树
     */

    /**
     * 使用递归，首先传入根节点的左右子节点，判断这两个节点值是否相等，如果相等则递归比较左节点的左子节点
     * 和右节点的右子节点以及左节点右子节点和右节点的左子节点
     */

    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        } else if (left != null && right != null && left.val == right.val){
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        System.out.println(isSymmetric(treeNode));
    }
}
