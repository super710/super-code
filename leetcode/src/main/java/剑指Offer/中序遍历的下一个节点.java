package 剑指Offer;

/**
 * @author Tiger
 * @date 2020/11/28 19:31
 */
public class 中序遍历的下一个节点 {
    public TreeNode nextNode(TreeNode node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.father != null) {
            if (node == node.father.left) {
                return node.father;
            }
            node = node.father;
        }
        return null;
    }
}
