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
