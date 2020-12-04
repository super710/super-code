package 剑指Offer;

/**
 * @author Tiger
 * @date 2020/11/28 18:09
 */
public class 重建二叉树 {
    static int preIndex;
    static int inIndex;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, null);
    }

    private static TreeNode dfs(int[] preorder, int[] inorder, TreeNode finish) {
        if (preIndex == preorder.length || (finish != null && inorder[inIndex] == finish.val)) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);
        root.left = dfs(preorder, inorder, root);
        inIndex++;
        root.right = dfs(preorder, inorder, finish);
        return root;
    }

    public static void main(String[] args) {
        buildTree(new int[]{3, 9, 20}, new int[]{9, 3, 20});
    }

}
