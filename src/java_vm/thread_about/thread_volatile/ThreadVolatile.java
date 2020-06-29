package java_vm.thread_about.thread_volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadVolatile Volatile 关键字测试
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 17:59
 */
public class ThreadVolatile {
    private static AtomicInteger ato = new AtomicInteger(0);
    private volatile int count = 0;

    public static void main(String[] args) {
        ThreadVolatile threadVolatile = new ThreadVolatile();
        threadVolatile.runTest();
        // threadVolatile.runCount();
        // originRun();
    }

    private static void originRun() {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10000; j++) {
                // count++;
                // 原子性的num++,通过循环CAS方式
                ato.incrementAndGet();
            }
        }
        System.out.println("count: " + ato);
    }

    public void runCount() {
        for (int i = 0; i < 30; i++) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    for (int j = 0; j < 10000; j++) {
                        count++;
                        /**
                         * count++的运算结果不是300000，而是个不确定的值。因为：
                         *      num++不是个原子性的操作，而是个复合操作。
                         *
                         * count++ 预算步骤：
                         *      第1步：读取count数据
                         *      第2步：count+1
                         *      第3步：赋值
                         */
                    }
                }
            }.start();
        }
        System.out.println("count: " + count);
    }

    public void runTest() {
        TestVolatile testVolatile = new TestVolatile();

        for (int i = 0; i < 100; i++) {

            new Thread() {
                @Override
                public void run() {
                    super.run();
                    testVolatile.changeStatus();
                }
            }.start();

            new Thread() {
                @Override
                public void run() {
                    super.run();
                    testVolatile.run();
                }
            }.start();
        }
    }
}




