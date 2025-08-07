package concurrent.part02;

import java.util.concurrent.TimeUnit;

/**
 * @author wangchen
 * @version 1.0
 */
public class ThreadLocalTest {

    private static class PrintTime {
        private static final ThreadLocal<Long> TIME_THREAD_LOCAL_OBJECT = new ThreadLocal<>();

        public static final void begin() {
            TIME_THREAD_LOCAL_OBJECT.set(System.currentTimeMillis());
        }

        public static final long end() {
            return System.currentTimeMillis() - TIME_THREAD_LOCAL_OBJECT.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintTime.begin();
        TimeUnit.SECONDS.sleep(2);
        long time = PrintTime.end();
        System.out.println("耗时：" + time + " 毫秒");
    }
}
