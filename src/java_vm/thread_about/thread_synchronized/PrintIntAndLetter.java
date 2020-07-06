package java_vm.thread_about.thread_synchronized;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * PrintIntAndLetter 交替打印数字和字母
 * 1.开启两个线程，一个线程打印A～Z，两一个线程打印1～52的数据。
 * <p>
 * 2.实现交替打印，输出结果为12A34B...........5152Z.
 * <p>
 * 3.请用多线程方式实现。
 * <p>
 * 运行结果：
 * 12A34B56C78D910E1112F1314G1516H1718I1920J2122K2324L2526M2728N2930O3132P3334Q3536R3738S3940T4142U4344V4546W4748X4950Y5152Z
 * <p>
 * Condition：
 * https://www.cnblogs.com/windy-xmwh/p/9175058.html
 * https://www.cnblogs.com/fsmly/p/10721459.html
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/7/2 - 10:01
 */
public class PrintIntAndLetter {

    public static void main(String[] args) {
        PrintIntAndLetter printer = new PrintIntAndLetter();
        new Thread() {
            @Override
            public void run() {
                super.run();
                // 打印字母
                while (printer.letterFlag) {
                    printer.printLetter();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                super.run();
                // 打印数字
                while (printer.numFlag) {
                    printer.printInt();
                }
            }
        }.start();

    }

    /**
     * 字母线程结束标记
     */
    public boolean letterFlag = true;
    /**
     * 数字线程结束标记
     */
    public boolean numFlag = true;

    /**
     * 数字的初始值
     */
    int num = 1;
    /**
     * 这里A~Z的字母对应的阿拉伯数字为65～90，
     */
    int letter = 65;

    /**
     * 线程等待标记：全局
     */
    boolean flag = true;

    /**
     * 锁
     */
    Lock lock = new ReentrantLock();
    /**
     * Condition中的await()方法相当于Object的wait()方法，Condition中的signal()方法相当于Object的notify()方法,
     * Condition中的signalAll()相当于Object的notifyAll()方法。
     * <br>
     * Object中的wait(),notify(),notifyAll()方法是和"同步锁"(synchronized关键字)捆绑使用的；
     * 而Condition是需要与"互斥锁"/"共享锁"捆绑使用的。
     */
    Condition condLetter = lock.newCondition();
    Condition condNum = lock.newCondition();


    private void printLetter() {
        if (letter > 90) {
            letterFlag = false;
            return;
        }
        lock.lock();
        try {
            if (flag) {
                condLetter.await();
            }

            System.out.print((char) letter);
            letter++;
            flag = true;
            condNum.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void printInt() {
        if (num > 52) {
            numFlag = false;
            return;
        }
        lock.lock();
        try {
            if (!flag) {
                condNum.await();
            }
            System.out.print(num);
            num++;
            System.out.print(num);
            num++;
            flag = false;
            condLetter.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


