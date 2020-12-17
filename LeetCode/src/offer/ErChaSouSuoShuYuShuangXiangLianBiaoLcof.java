package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/17
 */
public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
    /**
     * 剑指 Offer 36. 二叉搜索树与双向链表
     */

    /**
     * 中序遍历，利用一个队列，在进行遍历的时候构建左右关系
     */
    static List<Node> list = new ArrayList<>();
    static Queue<Node> lists = new LinkedList<>();
    static Node head;
    static Node end;

    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        middleOrder(root);
        head.left = end;
        end.right = head;
        return head;
    }

    static void middleOrder(Node root) {
        if (root == null) {
            return;
        }
        middleOrder(root.left);
        lists.add(new Node(root.val));
        if (lists.size() == 1) {
            head = lists.peek();
            end = head;
        }
        middleOrder(root.right);
        if (lists.size() >= 2) {
            Node left = lists.poll();
            Node right = lists.peek();
            left.right = right;
            right.left = left;
            end = right;
        }
    }

    /**
     * 中序遍历，加入到list集合中，之后重新构建左右关系
     */
    public static Node treeToDoublyList1(Node root) {
        if (root == null) {
            return null;
        }
        middleOrder1(root);
        Node head = list.get(0);
        list.get(0).left = list.get(list.size() - 1);
        list.get(list.size() - 1).right = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                list.get(i).left = list.get(i - 1);
            }
            if (i < list.size() - 1) {
                list.get(i).right = list.get(i + 1);
            }
        }
        return head;
    }

    static void middleOrder1(Node root) {
        if (root == null) {
            return;
        }
        middleOrder1(root.left);
        list.add(root);
        middleOrder1(root.right);
    }

    public static void main(String[] args) {
        Node node = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
        System.out.println(treeToDoublyList(node));
        System.out.println(treeToDoublyList1(node));
    }
}
