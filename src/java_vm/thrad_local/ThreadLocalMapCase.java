package java_vm.thrad_local;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
/**
 * ThreadLocalMapCase ThreadLocal用例
 * 用例参考：https://mp.weixin.qq.com/s/TOWo4RcIda7s_e5h08I3zg
 * 原理讲解：https://blog.csdn.net/puppylpg/article/details/80433271?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-10.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-10.nonecase
 * https://blog.csdn.net/qq_33404395/article/details/82356344?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4.nonecase
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
        threadLocal.set("Hello");
        threadLocal.set((num+2));
        System.out.println(num+2);
        System.out.println(integer.addAndGet(2));
        System.out.println(Thread.currentThread().getName()+"，data is : "+threadLocal.get());
        new Thread(){
            @Override
            public void run() {
                super.run();
                threadLocal.set("world");
                threadLocal.set((num+3));
                System.out.println(num+3);
                System.out.println(integer.addAndGet(3));
                System.out.println(Thread.currentThread().getName()+"，data is : "+threadLocal.get());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                threadLocal.set("!!!");
                threadLocal.set((num+10));
                System.out.println(num+10);
                System.out.println(integer.addAndGet(10));
                System.out.println(Thread.currentThread().getName()+"，data is : "+threadLocal.get());
            }
        }.start();

        System.out.println(num+12);

    }

    public void runTl(){
        ThreadTl threadTl = new ThreadTl();
        threadTl.start();
    }

    class ThreadTl extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("---");

        }
    }
}
