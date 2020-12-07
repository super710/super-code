package offer;

import java.util.Stack;

/**
 * @Author cy
 * @Description
 * @Date 2020/12/7
 */
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {

    /**
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     */

    /**
     * 借鉴答案，根据二叉搜索树的定义使用递归完成，二叉搜索树的左子树一定
     * 小于根节点，右子树一定大于根节点，而且每个子树也是一样
     */

    public static boolean verifyPostorder(int[] postorder) {
        return re(postorder, 0, postorder.length - 1);
    }

    static boolean re(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int tempStart = start;
        while (postorder[tempStart] < postorder[end]){
            tempStart++;
        }
        int temp = tempStart;
        while (postorder[temp] > postorder[end]){
            temp++;
        }
        return temp == end && re(postorder, start, tempStart - 1) && re(postorder, tempStart, end - 1);
    }

    /**
     * 根据答案，利用后续遍历的倒序规律和栈进行实现
     */
    public static boolean verifyPostorder1(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >=0 ; --i) {
            if (postorder[i] > root){
                return false;
            }
            //获取最接近postorder[i]的根节点
            while (!stack.isEmpty() && stack.peek() > postorder[i]){
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
        System.out.println(verifyPostorder1(new int[]{1, 3, 2, 6, 5}));
    }
}
