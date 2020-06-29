package java_vm.thread_about.thread_volatile;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Counter volatile 网上示例
 * 参考：https://www.cnblogs.com/frankcui/p/10815436.html
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 18:54
 */
public class Counter {
    //使用原子操作类
    public static AtomicInteger num = new AtomicInteger(0);
    //使用CountDownLatch来等待计算线程执行完
    static CountDownLatch countDownLatch = new CountDownLatch(30);

    public static void main(String[] args) throws InterruptedException {
        //开启30个线程进行累加操作
        for (int i = 0; i < 30; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        //原子性的num++,通过循环CAS方式
                        num.incrementAndGet();
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        //等待计算线程执行完
        countDownLatch.await();
        System.out.println(num);
    }

    // 等价于：
    /*
     *     //使用原子操作类
     *     public static int num;
     *     //使用CountDownLatch来等待计算线程执行完
     *     static CountDownLatch countDownLatch = new CountDownLatch(30);
     *     public static void main(String []args) throws InterruptedException {
     *         //开启30个线程进行累加操作
     *         for(int i=0;i<30;i++){
     *             new Thread(){
     *                 @Override
     *                 public void run(){
     *                     add();
     *                     countDownLatch.countDown();
     *                 }
     *             }.start();
     *         }
     *         //等待计算线程执行完
     *         countDownLatch.await();
     *         System.out.println(num);
     *     }
     *
     *     private synchronized static void add() {
     *         for(int j=0;j<10000;j++){
     *             num++;//原子性的num++,通过循环CAS方式
     *         }
     *     }
     */
}
