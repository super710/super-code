package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cy
 * @Description
 * @Date 2020/11/11
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ChongJianErChaEhuLcof {

    /**
     * 剑指 Offer 07. 重建二叉树
     */

    /**
     * 采用递归算法去重建二叉树，由于数组不好分割，在递归的时候用两个索引来分割数组，实现递归
     */

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return reBuildTree(preorder, 0, inorder.length - 1,inorder,0, inorder.length - 1, map);
    }

    public static TreeNode reBuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inoStart, int inoEnd, Map<Integer, Integer> map) {
        int rootNum;
        TreeNode root;
        //若果开始的索引大于结束的索引，返回null，递归停止标志
        if (preStart > preEnd){
            return null;
        }
        //前序遍历的第一个是根节点
        rootNum = preorder[preStart];
        root = new TreeNode(rootNum);
        //根据前序遍历素组获取中序遍历数组中的左右子树分割的下标
        Integer index = map.get(rootNum);
        //计算左子树节点的个数
        int lefts = index - inoStart;
        //计算右子树子树节点的个数
        int rights = inoEnd - index;
        //递归获取左子树
        root.left = reBuildTree(preorder, preStart + 1, preStart + lefts, inorder, inoStart, index - 1, map);
        //递归获取右子树
        root.right = reBuildTree(preorder, preEnd - rights + 1, preEnd, inorder, index + 1, inoEnd, map);
        return root;
    }

    
    public static void main(String[] args) {
        TreeNode a = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(a);
    }
}
