package aqs;

import lombok.NoArgsConstructor;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @author Tiger
 * @date 2020/11/13 7:53
 * 手写一个锁 需要哪些东西  一个状态位 一个队列 CAS park/unpark
 */
public class CustomLock {
    //状态位
    private volatile int state;
    private static Long stateOffset;
    private static Long tailOffset;
    private static Unsafe unsafe;
    private volatile Node head;
    private volatile Node tail;
    private final Node EMPTY = new Node();

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            stateOffset = unsafe.objectFieldOffset(CustomLock.class.getDeclaredField("state"));
            tailOffset = unsafe.objectFieldOffset(CustomLock.class.getDeclaredField("tail"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @NoArgsConstructor
    private static class Node {
        Node prev;
        Node next;
        Thread currentThread;

        public Node(Node prev, Thread currentThread) {
            this.prev = prev;
            this.currentThread = currentThread;
        }
    }

    public CustomLock() {
        head = tail = EMPTY;
    }

    //利用unsafe CAS
    public boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    //原子更新tail字段
    public boolean compareAndSetTail(Node expect, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
    }

    public void lock() {
        if (compareAndSetState(0, 1)) {
            return;
        }
        Node node = enqueue();
        Node prev = node.prev;
        while (prev != head || !compareAndSetState(0, 1)) {
            unsafe.park(false, 0L);
        }
        head = node;
        node.currentThread = null;
        node.prev = null;
        prev.next = null;
    }

    public void unlock() {
        state = 0;
        Node next = head.next;
        if (null != next) {
            unsafe.unpark(next.currentThread);
        }
    }

    private Node enqueue() {
        while (true) {
            Node t = tail;
            Node currentNode = new Node(t, Thread.currentThread());
            //这里成功就已经把tail节点更新成currentNode
            if (compareAndSetTail(t, currentNode)) {
                t.next = currentNode;
                return currentNode;
            }
        }
    }

    private static int[] ints = {0};

    public static void main(String[] args) throws Exception {
        CustomLock customLock = new CustomLock();
        CountDownLatch countDownLatch = new CountDownLatch(1000);

        IntStream.range(0, 1000).forEach(i -> new Thread(() -> {
            customLock.lock();

            try {
                IntStream.range(0, 10000).forEach(j -> {
                    ints[0]++;
                });
            } finally {
                customLock.unlock();
            }
            countDownLatch.countDown();
        }, "tt-" + i).start());

        countDownLatch.await();

        System.out.println(ints[0]);
    }
}
