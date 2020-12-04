package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *

 */
public class levelOrder {
    int i=0;
    public int[] levelOrder(TreeNode root) {

        if (root==null)
            return new int[0];
        preOrder(root);
        //找出二叉树的层数n,2^n次方减一是数组的容量
        int[] res =new int[i];
        int j =0;
        //BFS一般用队列来实现
        Queue<TreeNode> queue =new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            /*TreeNode node = queue.poll();
            if(node!=null) {
                res[j++] = node.val;
                queue.add(node.left);
                queue.add(node.right);
            }*/
            TreeNode node = queue.poll();
                res[j++] = node.val;
                if(node.left!=null)
                queue.add(node.left);
                if(node.right!=null)
                queue.add(node.right);

        }

        return res;
    }

    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root!=null)
            queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list =new ArrayList<>();
            for (int i = queue.size();i>0;i--){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            res.add(list);
        }

        return res;
    }


    /**
     * 请实现一个函数按照之字形顺序打印二叉树，
     * 即第一行按照从左到右的顺序打印，
     * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     *
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        int flag =1;//标记为0表示从左到右，1表示从右到左
        List<List<Integer>> res = new ArrayList<>();//最终的数据列表
        Queue<TreeNode> queue = new LinkedList<>();//bfs用消息队列来实现
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            //两个队列
            LinkedList<Integer> list = new LinkedList<>();

            for(int i =queue.size();i>0;i--) {
                TreeNode node = queue.poll();
                if (flag == 1) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            flag=flag == 1 ? 0 : 1 ;
            res.add(list);
        }
            return  res;
    }

    //前序遍历,找出节点个数，初始化
    public void preOrder(TreeNode node){
        if(node!=null){
            i++;
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    @Test
    public void test(){
        Integer[] a = {1,2,3,4,5,6,7};
        TreeNode tree = CreateTree.createBinTree(a, 0);
        int[] order = levelOrder(tree);
        for (int k : order) {
            System.out.printf("%d",k);
        }
    }
}
