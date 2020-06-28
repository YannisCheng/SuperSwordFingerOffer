package java_vm.thread_about;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ThreadTestUtils 线程测试工具类
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 16:53
 */
public class ThreadTestUtils {


    public static void main(String[] args) {
        ThreadTestUtils utils = new ThreadTestUtils();
        utils.save();
    }


    public static void showThreadState(Thread thread) {
        System.out.println(thread.getName() + "'s state is :" + thread.getState());
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

    public void save(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                saveMoney(1,10,Thread.currentThread().getName());
            }
        }.start();

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
