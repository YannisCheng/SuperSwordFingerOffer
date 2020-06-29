package java_vm.thread_about.thread_synchronized;

import java_vm.thread_about.bean.Ticker;

/**
 * ThreadSynchronized 多个线程同时执行
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 08:57
 */
public class ThreadSynchronized {
    private Ticker ticker;
    private int count = 1;
    public ThreadSynchronized(Ticker mTicker) {
        this.ticker = mTicker;
    }
    public ThreadSynchronized() {

    }


    public void sell() {
        new SellerThread1(1).start();
        new SellerThread2(5).start();
        new SellerThread3(10).start();
    }

    private /*synchronized*/ void sellerMethod() {
        while (true) {
            synchronized (this){
                if (ticker.getCount() <= 0) {
                    break;
                }
                if (ticker.getCount() % 5 == 0) {
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "执行让步了");
                    Thread.yield();
                }
                try {
                    Thread.sleep(100);
                    ticker.setCount(ticker.getCount() - 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 获取线程的名字
                String name = Thread.currentThread().getName();
                System.out.println(name + "卖了1张票，剩余: " + ticker.getCount());
            }
        }
    }

    class SellerThread1 extends Thread {

        public SellerThread1(int pro) {
            this.setPriority(pro);
        }

        @Override
        public void run() {
            super.run();
            sellerMethod();
        }
    }

    class SellerThread2 extends Thread {

        public SellerThread2(int pro) {
            this.setPriority(pro);
        }

        @Override
        public void run() {
            super.run();
            sellerMethod();
        }
    }

    class SellerThread3 extends Thread {

        public SellerThread3(int pro) {
            this.setPriority(pro);
        }

        @Override
        public void run() {
            super.run();
            sellerMethod();
        }
    }

    public static void main(String[] args) {
        ThreadSynchronized threadSynchronized = new ThreadSynchronized();
        threadSynchronized.run();
    }

    public void run() {
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        Thread thread6 = new Thread(runnable);
        thread1.setName("A");
        thread2.setName("B");
        thread3.setName("C");
        thread4.setName("D");
        thread5.setName("E");
        thread6.setName("F");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }

    Runnable runnable = () -> {
        synchronized (this) {
            count = count + 14;
            System.out.println(Thread.currentThread().getName() + ",count is : " + count);
        }
    };
}
