package Tree;

public class CreateTree {

    static  int i =0;
    //根据int数组，前序遍历创建二叉树
    public static TreeNode createBinTree(int array[], int num) {
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

    public static void main(String[] args) {
        int a[] = {4,2,7,1,3,6,9};
        TreeNode tree = createBinTree(a, 0);

        //前序遍历
        preOrder(tree);
        

    }
}
