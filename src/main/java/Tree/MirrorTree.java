package Tree;

import org.junit.Test;

/**\
 * 题目：
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        //递归

        if(root == null) return null;

        TreeNode leftRoot = mirrorTree(root.right);
        TreeNode rightRoot = mirrorTree(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;

        /*
        栈：
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>() {{ add(root); }};
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
         */
    }




    @Test
    public void test(){
        int num[]={4,2,7,1,3,6,9};
        TreeNode tree = CreateTree.createBinTree(num, 0);
        tree= mirrorTree(tree);
        CreateTree.preOrder(tree);
    }
}
