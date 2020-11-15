package unsafe;

import lombok.AllArgsConstructor;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Tiger
 * @date 2020/11/11 22:28
 */
public class UnsafeTest {
    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        //只会给对象分配内存，并不会调用构造方法 此时user里的name为null
//        unsafe.User user = (unsafe.User) unsafe.allocateInstance(unsafe.User.class);

        User user = new User();
        System.out.println(user);

        Field name = user.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(user, "aaa");
        System.out.println(user);

    }
}

@AllArgsConstructor
class User {
    private String name;

    public User() {
        this.name = "tiger";
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "unsafe.User{" +
                "name='" + name + '\'' +
                '}';
    }
}

class SpinLock {
    private volatile int count;
    private static Unsafe unsafe;
    private static Long offset;

    static {
        Field theUnsafe = null;
        try {
            theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            offset = unsafe.objectFieldOffset(SpinLock.class.getDeclaredField("count"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void increment() {
        int before = count;
        while (!unsafe.compareAndSwapInt(this, offset, before, before + 1)) {
            before = count;
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    spinLock.increment();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(spinLock.getCount());
        threadPool.shutdown();
    }
}
