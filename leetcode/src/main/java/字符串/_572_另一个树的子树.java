package 字符串;

/**
 * @author Tiger
 * @date 2020/11/26 10:16
 */
public class _572_另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        if (post(s).contains(post(t))) {
            return true;
        }
        return false;
    }

    private String post(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        return post(root, sb);
    }

    private String post(TreeNode root, StringBuffer sb) {
        if (root.left == null) {
            sb.append("#!");
        } else {
            post(root.left, sb);
        }
        if (root.right == null) {
            sb.append("#!");
        } else {
            post(root.right, sb);
        }
        sb.append(root.val).append("!");
        return sb.toString();
    }
}
