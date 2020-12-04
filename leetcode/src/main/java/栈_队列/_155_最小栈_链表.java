package 栈_队列;

import 链表.ListNode;

/**
 * @author Tiger
 * @date 2020/11/22 20:35
 */
public class _155_最小栈_链表 {

    private ListNodeZhan p = new ListNodeZhan(-1,-1);
    private ListNodeZhan head = p;


    public void push(int x) {
        ListNodeZhan nodeZhan;
        if (head == p) {
            nodeZhan = new ListNodeZhan(x,x,head);
        } else {
            if (head.min >= x) {
                nodeZhan = new ListNodeZhan(x,x,head);
            } else {
                nodeZhan = new ListNodeZhan(x,head.min, head);
            }
        }
        head = nodeZhan;
    }

    public void pop() {
        ListNodeZhan node = head.next;
        head.next = null;
        head = node;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    public static void main(String[] args) {
        _155_最小栈_链表 v = new _155_最小栈_链表();
        v.push(-2);
        v.push(0);
        v.push(-1);
        System.out.println(v.getMin());
        System.out.println(v.top());
        v.pop();
        System.out.println(v.getMin());
    }
}
