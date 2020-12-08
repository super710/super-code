package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class PathSum {
    List<List<Integer>> res = new LinkedList<>();
    int tempSum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        /**
         * 先序遍历+节点记录  dfs 递归
         */
        LinkedList<Integer> path = new LinkedList<>();
        recur(root,path,tempSum,sum);
        return res;
    }

    private void recur(TreeNode node,LinkedList<Integer> path, int tempSum,int sum) {
        if(node!=null){
            path.add(node.val);
            tempSum+=node.val;
        }else
            return;

        //题目要求是一条路径，故必须遍历到叶子结点符合要求才能添加进结果。
        if(tempSum==sum&&node.left==null&&node.right==null)
            res.add(new LinkedList<Integer>(path));

        recur(node.left,path,tempSum,sum);
        recur(node.right,path,tempSum,sum);
        path.removeLast();
        tempSum-=node.val;

    }

    @Test
    public void test(){
        //TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left=new TreeNode(11);
//        root.left.left.left=new TreeNode(7);
//        root.left.left.right=new TreeNode(2);
//
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);
//
//        pathSum(root,22);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        pathSum(root,1);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }


}
