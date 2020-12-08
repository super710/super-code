package Tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class TreeToDoublyList {

    /*List<Node> list = new LinkedList<>();
    public Node treeToDoublyList(Node root) {

        if(root==null)
            return null;

        recur(root);



        for(int i = 0;i<list.size();i++){
            if(i==list.size()-1) {
                list.get(i).right = list.get(0);
            }else{
                list.get(i).right = list.get(i + 1);
                list.get(i + 1).left = list.get(i);
            }
        }

        list.get(0).left = list.get(list.size()-1);
        return list.get(0);
    }

    void recur(Node node){
        if(node!=null){
            recur(node.left);
            list.add(node);
            recur(node.right);
        }
    }*/

    //大佬代码

        Node pre, head;
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }
        void dfs(Node cur) {
            //中序遍历，左中右，pre是前驱节点，cur是当前节点，head是头节点
            if(cur == null) return;
            dfs(cur.left);
            //如果前驱节点不为空，则前驱节点的右节点指向当前节点
            if(pre != null)
                pre.right = cur;
            else//如果前驱节点为空，则当前节点为头结点
                head = cur;
            //当前节点做指针指向前驱结点，然后当前节点变前驱结点
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }




    @Test
    public void test(){
        Node node = new Node(4,new Node(2,new Node(1),new Node(3)),new Node(5));
        Node root = treeToDoublyList(node);
    }
}
