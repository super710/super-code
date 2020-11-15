package aqs;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.IntStream;

/**
 * @author Tiger
 * @date 2020/11/15 8:14
 */
public class MyLockBaseOnAqs {
    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }

    private final Sync sync = new Sync();

    private static int count = 0;

    public void lock() {
        sync.tryAcquire(1);
    }

    public void unlock() {
        sync.tryRelease(1);
    }

    public static void main(String[] args) throws InterruptedException {
        MyLockBaseOnAqs lockBaseOnAqs = new MyLockBaseOnAqs();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        IntStream.range(0, 1000).forEach(i -> new Thread(() -> {
            lockBaseOnAqs.lock();
            try {
                IntStream.range(0, 1000).forEach(j -> {
                    count++;
                });
            } finally {
                lockBaseOnAqs.unlock();
            }
            countDownLatch.countDown();
        }).start());
        countDownLatch.await();
        System.out.println(count);
    }
}
