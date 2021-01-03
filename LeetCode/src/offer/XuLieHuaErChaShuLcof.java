package offer;

import sun.plugin2.message.GetAppletMessage;

import java.util.*;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/18
 */
public class XuLieHuaErChaShuLcof {

    /**
     * 剑指 Offer 37. 序列化二叉树
     */

    /**
     * 利用队列，循环入队，序列化时null也入队，一个个出队打印，反序列化时非空入队。
     */

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        ArrayList<Integer> nodes1 = new ArrayList<>();
        if (root == null) {
            return "[]";
        }
        nodes.offer(root);
        while (nodes.size() > 0) {
            TreeNode poll = nodes.poll();
            if (poll != null) {
                nodes.offer(poll.left);
                nodes.offer(poll.right);
            }
            nodes1.add(poll == null ? null : poll.val);
        }
        return nodes1.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if ("[]".equals(data)){
            return null;
        }
        List<String> nodes = Arrays.asList(data.substring(1, data.length() - 1).split(", "));
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.parseInt(nodes.get(0)));
        treeNodes.offer(head);
        int i = 1;
        while (!treeNodes.isEmpty()){
            TreeNode node = treeNodes.poll();
            if (i < nodes.size()){
                if (!"null".equals(nodes.get(i))){
                    node.left = new TreeNode(Integer.parseInt(nodes.get(i)));
                    treeNodes.offer(node.left);
                }
                i++;
                if (i < nodes.size() && !"null".equals(nodes.get(i))){
                    node.right = new TreeNode(Integer.parseInt(nodes.get(i)));
                    treeNodes.offer(node.right);
                }
                i++;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
//        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(4);
//        treeNode.right.left.right = new TreeNode(6);
//        treeNode.right.right.right = new TreeNode(4);
        System.out.println(serialize(treeNode));
        deserialize("[1, 2, 3, null, null, 4, 5]");
    }
}
