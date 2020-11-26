package Tree;
//对称的二叉树

import org.junit.Test;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */

/*
思路：

先判断根节点，然后
递归左子树的左结点和右子树的右节点，左子树的右节点和右子树的左结点
 */
public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root==null||(root.left==null&&root.right==null))
            return true;
        else if(root.left==null||root.right==null)
            return false;

        if(root.left.val==root.right.val){
            return isSame(root.left,root.right);
        }
        return false;
    }

    public boolean isSame(TreeNode A,TreeNode B){
        if(A==null&&B==null)
            return  true;
        else if(A==null||B==null)
            return false;

        if(A.val == B.val){
            return isSame(A.left,B.right)&&isSame(A.right, B.left);
        }else
            return false;
    }

    /**
     * 大神代码
     *  public boolean isSymmetric(TreeNode root) {
     *         return root == null ? true : recur(root.left, root.right);
     *     }
     *     boolean recur(TreeNode L, TreeNode R) {
     *         if(L == null && R == null) return true;
     *         if(L == null || R == null || L.val != R.val) return false;
     *         return recur(L.left, R.right) && recur(L.right, R.left);
     *     }
     *
     */

    @Test
    public void test(){
       // int arrar[]={1,2,2,3,4,4,3};
        Integer array[] = new Integer[]{1,2,2,null,3,null,3};
        TreeNode tree = CreateTree.createBinTree(array, 0);
        System.out.println(isSymmetric(tree));
    }
}
