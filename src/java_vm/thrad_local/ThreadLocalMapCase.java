package java_vm.thrad_local;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * ThreadLocalMapCase ThreadLocal用例
 * <p>
 * <br>
 * 用例参考：https://mp.weixin.qq.com/s/TOWo4RcIda7s_e5h08I3zg
 * 原理讲解：https://blog.csdn.net/puppylpg/article/details/80433271?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-10.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-10.nonecase
 * https://blog.csdn.net/qq_33404395/article/details/82356344?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4.nonecase
 * <p>
 * <br>
 * 摘抄：https://www.jianshu.com/p/f956857a8304
 * ThreadLocal<T>其实是与线程绑定的一个变量。ThreadLocal和Synchonized都用于解决多线程并发访问。
 * 但是ThreadLocal与synchronized有本质的区别：
 * Synchronized用于线程间的数据共享，而ThreadLocal则用于线程间的数据隔离；
 * Synchronized是利用锁的机制，使变量或代码块在某一时该只能被一个线程访问。
 * 而ThreadLocal为每一个线程都提供了变量的副本，使得每个线程在某一时间访问到的并不是同一个对象，这样就隔离了多个线程对数据的数据共享。
 * 而Synchronized却正好相反，它用于在多个线程间通信时能够获得数据共享。
 *
 * <p>
 * <br>
 * 一句话理解：
 * 向ThreadLocal中存入数据就是向当前线程内的threadLocals变量（ThreadLocal.ThreadLocalMap）存入数据。
 * <p>
 * <br>
 * 为什么一定会是：当前线程？？
 * 因为在调用ThreadLocal#set()或者ThreadLocal#get()时，均是在某一个线程的内部调用的，当在这个线程内部调用方法时，会执行Thread#currentThread()。
 * 而这个#currentThead()是一个native方法。
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 16:53
 */
public class ThreadLocalMapCase {

    public static final ThreadLocal<String> tlStr = ThreadLocal.withInitial(() -> "Hello Word");
    private static final ThreadLocal<Integer> tlInt = ThreadLocal.withInitial(new Supplier<Integer>() {
        @Override
        public Integer get() {
            return 6;
        }
    });

    public static void main(String[] args) {
        /*System.out.println("int 1: " +tlInt.get());
        System.out.println("str: " +tlStr.get());
        tlInt.set(tlInt.get()+1);
        System.out.println("int 2: " +tlInt.get());
        tlInt.remove();
        System.out.println("int 3: " +tlInt.get());
        tlStr.remove();
        System.out.println("str remove : " +tlStr.get());*/
        int num = 10;
        AtomicInteger integer = new AtomicInteger(10);

        final ThreadLocal threadLocal = new ThreadLocal();
        final ThreadLocal threadLocal2 = new ThreadLocal();
        threadLocal.set("Hello");
        threadLocal2.set((num + 2));
        System.out.println(Thread.currentThread().getName() + "，AtomicInteger is : " + integer.addAndGet(2));
        System.out.println(Thread.currentThread().getName() + "，tl data is : " + threadLocal.get());
        System.out.println(Thread.currentThread().getName() + "，tl data is : " + threadLocal2.get());
        System.out.println(Thread.currentThread().getName() + "，null is : " + (num + 2));
        System.out.println();

        new Thread() {
            @Override
            public void run() {
                super.run();
                threadLocal.set("world");
                threadLocal2.set((num + 3));
                System.out.println(Thread.currentThread().getName() + "，AtomicInteger is : " + integer.addAndGet(3));
                System.out.println(Thread.currentThread().getName() + "，tl data is : " + threadLocal.get());
                System.out.println(Thread.currentThread().getName() + "，tl data is : " + threadLocal2.get());
                System.out.println(Thread.currentThread().getName() + "，null is : " + (num + 3));
                System.out.println();

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                threadLocal.set("!!!");
                threadLocal2.set((num + 10));

                System.out.println(Thread.currentThread().getName() + "，AtomicInteger is : " + integer.addAndGet(10));
                System.out.println(Thread.currentThread().getName() + "，tl data is : " + threadLocal.get());
                System.out.println(Thread.currentThread().getName() + "，tl data is : " + threadLocal2.get());
                System.out.println(Thread.currentThread().getName() + "，null is : " + (num + 10));
            }
        }.start();

    }

    public void runTl() {
        ThreadTl threadTl = new ThreadTl();
        threadTl.start();
    }

    class ThreadTl extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("---");

        }
    }
}
