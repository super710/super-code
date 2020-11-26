package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 */
class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


public class SubStructure {

   //先序遍历A中每个节点,并与B比较

    /**
     *特例处理： 当 树 AA 为空 或 树 BB 为空 时，直接返回 falsefalse ；
     * 返回值： 若树 BB 是树 AA 的子结构，则必满足以下三种情况之一，因此用或 || 连接；
     * 1.以 节点 AA 为根节点的子树 包含树 BB ，对应 recur(A, B)；
     * 2.树 BB 是 树 AA 左子树 的子结构，对应 isSubStructure(A.left, B)；
     * 3.树 BB 是 树 AA 右子树 的子结构，对应 isSubStructure(A.right, B)；
     * @return
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null)
            return false;

        if(recur(A,B)){
            return true;
        }else{
           if(isSubStructure(A.left,B)||isSubStructure(A.right,B))
               return true;
        }

        return false;
        //return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }


    //判断A中是否包含B

    /**
     * 终止条件：
     * 1、当节点B为空：说明树B已匹配完成，返回true
     * 2、当A节点为空：匹配失败，返回false
     * 3、节点A和B不相同，匹配失败false
     *
     * return
     * 1、判断A和B的左子节点是否相等，即recur(A.left,B.left)
     * 2、判断A和B的右子节点是否相等，即recur(A.right,B.right)
     */
    static boolean  recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);

        TreeNode node = new TreeNode(3);
        System.out.println(isSubStructure(treeNode,node));
    }

}
