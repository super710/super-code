package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Tiger
 * @date 2020/11/21 8:52
 */
public class ThreadLocalDemo {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

//    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = ThreadLocal.withInitial(() -> {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    });

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.execute(() -> {

                printDate(finalI);

            });
        }
        threadPool.shutdown();
    }

    private static void printDate(int seconds) {

        System.out.println(simpleDateFormatThreadLocal.get().format(new Date(1000 * seconds)));
    }
}
