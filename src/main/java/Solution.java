import java.util.Stack;

public class Solution {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
     * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //定义出栈序列指针
        int j =0;
        //定义栈
        Stack<Integer> stack = new Stack();
        //遍历进栈序列
        for (int i : pushed) {
            stack.push(i);
            //如果出栈序列指针项，是进栈数，则出栈

            while(!stack.isEmpty()&&popped[j]==stack.peek()){
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
