package java_vm.thread_about;

import java_vm.thread_about.bean.Seller;
import java_vm.thread_about.bean.Ticker;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TickerSellerUtils 买票测试
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 08:31
 */
public class TickerSellerUtils {
    public static void main(String[] args) {
        Ticker ticker = new Ticker(10);

        Thread thread1 = new Thread(new Seller(ticker), "A");
        Thread thread2 = new Thread(new Seller(ticker), "B");
        Thread thread3 = new Thread(new Seller(ticker), "C");

        thread1.start();
        thread2.start();
        thread3.start();

        /*TickerSellerUtils utils = new TickerSellerUtils();
        utils.save();*/

        /*SellerByThread byThread = new SellerByThread(ticker);
        byThread.sell();*/

        /*ThreadAsync threadAsync = new ThreadAsync();
        threadAsync.doFor();*/
    }

    private int value = 100;
    // 注意这个地方
    private Lock lock = new ReentrantLock();
    // 同步调用保存方法
    private synchronized void saveMoney(int time,int money,String tName){
        //synchronized (ThreadTestUtils.class){
        //lock.lock();
        try {
            Thread.sleep(100);
            value += money;
            System.out.println("线程："+tName+"，第【"+time+"】次存钱，账户="+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //lock.unlock();
        }
        //}
    }

    /**
     * 运行结果：
     * 线程：Thread-0，第【1】次存钱，账户=110
     * 线程：Thread-2，第【3】次存钱，账户=140
     * 线程：Thread-1，第【2】次存钱，账户=180
     * 最后账户=180
     */
    public void save(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                saveMoney(1,10,Thread.currentThread().getName());
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                saveMoney(2,40,Thread.currentThread().getName());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                saveMoney(3,30,Thread.currentThread().getName());
            }
        }.start();

        try {
            Thread.sleep(1000);
            System.out.println("最后账户="+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
