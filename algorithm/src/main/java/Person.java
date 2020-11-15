import lombok.Data;

/**
 * @author Tiger
 * @date 2020/11/14 18:20
 */
@Data
public class Person {
    private Integer age;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("i=" + (i + 1));
            }
        });
        thread.start();
        thread.interrupt();
        System.out.println("第一次调用thread.isInterrupted()：" + thread.isInterrupted());
        System.out.println("第二次调用thread.isInterrupted()：" + thread.isInterrupted());
        System.out.println("thread是否存活：" + thread.isAlive());
        Thread.sleep(500);
        System.out.println("thread是否存活：" + thread.isAlive());
        System.out.println("第二次调用thread.isInterrupted()：" + thread.isInterrupted());

    }
}
