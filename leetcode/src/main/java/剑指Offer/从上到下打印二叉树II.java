package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tiger
 * @date 2020/12/4 10:51
 */
public class 从上到下打印二叉树II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        while (!treeNodes.isEmpty()){
            ArrayList<Integer> integers = new ArrayList<>();
            

            lists.add(integers);
        }

        return lists;
    }
}
