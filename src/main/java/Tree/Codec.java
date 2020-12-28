package Tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *

 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(final TreeNode root) {

        /**
         * 特例处理： 若 root 为空，则直接返回空列表 "[]" ；
         * 初始化： 队列 queue （包含根节点 root ）；序列化列表 res ；
         * 层序遍历： 当 queue 为空时跳出；
         * 节点出队，记为 node ；
         * 若 node 不为空：① 打印字符串 node.val ，② 将左、右子节点加入 queue ；
         * 否则（若 node 为空）：打印字符串 "null" ；
         * 返回值： 拼接列表，用 ',' 隔开，首尾添加中括号；
         */
        if(root==null)
            return "[]";
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root); }};
        StringBuilder res = new StringBuilder("[");

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                res.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }else
                res.append("null,");
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return  res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        /**
         * 设 mm 为列表区间 [0, n][0,n] 中的 null 节点个数，
         * 则可总结出根节点、左子节点、右子节点的列表索引的递推公式：
         * n为node的列表索引，node.left =2(n-m)+1;node.right = 2(n-m)+2
         * 如果node为空 node.left无，node.right无
         */
        if(data.equals("[]"))
            return null;
        String[] strings = data.substring(1, data.length() - 1).split(",");
        //根节点
        TreeNode root =new TreeNode(Integer.parseInt(strings[0]));
        int i =1;//从第二个节点开始遍历

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!strings[i].equals("null")){
                node.left=new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.left);

            }

            i++;

            if(!strings[i].equals("null")){
                node.right=new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.right);
            }
            i++ ;
        }

            return root;
    }

    @Test
    public void test(){
        String s ="[]";
        System.out.println(s.length());
    }
}
