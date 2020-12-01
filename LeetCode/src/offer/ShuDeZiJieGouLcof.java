package offer;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/30
 */
public class ShuDeZiJieGouLcof {

    /**
     * 剑指 Offer 26. 树的子结构
     */

    /**
     * 先遍历，找到与子树根节点相同的节点，再进行比较，如果相同返回true，否则继续
     * 遍历直到A树为空
     */

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null){
            return false;
        }
        return getHeadTree(A, B);
    }

    static boolean getHeadTree(TreeNode A, TreeNode B){
        if (A != null && B != null ){
            if (A.val == B.val){
                boolean compare = compare(A, B);
                if (compare){
                    return true;
                }
            }
            return getHeadTree(A.left, B) || getHeadTree(A.right, B);
        }
        return false;
    }

    static boolean compare(TreeNode A, TreeNode B){
        if (A == null && B != null){
            return false;
        }
        if (B == null){
            return true;
        }
        if (A.val != B.val){
            return false;
        }
        boolean c1 = compare(A.left, B.left);
        boolean c2 = compare(A.right, B.right);
        return c1 & c2;
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(8);
        treeNode.left.left.right = new TreeNode(9);
        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(8);
        treeNode1.right = new TreeNode(9);
        System.out.println(isSubStructure(treeNode, treeNode1));
    }
}
