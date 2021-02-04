package Tree;

import org.junit.Test;

public class CreateTree {

    static  int i =0;
    //根据int数组，前序遍历创建二叉树
    public static TreeNode createBinTree(Integer array[], int num) {
        //根节点为第一个数
        TreeNode root = new TreeNode(array[num]);
        // 左孩子
        if(num * 2 + 1 < array.length){
            root.left = createBinTree(array, num * 2 + 1);
        }

        // 右孩子
        if(num * 2 + 2 < array.length){
            root.right = createBinTree(array, num * 2 + 2);
        }

        return root;
    }

    public static void preOrder(TreeNode TreeNode) {
        if (TreeNode == null)
            return;
        System.out.print(TreeNode.val + " ");
        preOrder(TreeNode.left);
        preOrder(TreeNode.right);
    }

    public void postOrder(TreeNode node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");

    }
    public static void main(String[] args) {
        Integer a[] = {4,2,7,1,3,6,9};
        TreeNode tree = createBinTree(a, 0);

        //前序遍历
        preOrder(tree);

    }

    @Test
    public void testPostOrder(){
        Integer a[] = {1,2,3,4,5,6};
        TreeNode tree = createBinTree(a, 0);
        postOrder(tree);
    }
}
