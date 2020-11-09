import java.util.Stack;

/**
 * @Author Jinshihong
 * @Date 2020/11/9 20:44
 * @Version 1.0
 */
public class offer_09 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public offer_09() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);


    }

    public int deleteHead() {
        if (stack2.isEmpty()){
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());

            }
        }
        if (stack2.isEmpty())
            return -1;
        else {
            Integer val=stack2.pop();
            return  val;
        }
    }


}
