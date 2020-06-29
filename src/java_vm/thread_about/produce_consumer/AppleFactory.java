package java_vm.thread_about.produce_consumer;

/**
 * AppleBall 苹果篮子
 * <p>
 * #wait()是Object里面的方法，而不是Thread里面的。它的作用是将当前线程置于预执行队列，
 * 并在wait()所在的代码处停止，等待唤醒通知。
 * #wait()只能在同步代码块或者同步方法中执行，如果调用wait()方法，而没有持有适当的锁，就会抛出异常。
 * #wait()方法调用后会释放出锁，线程与其他线程竞争重新获取锁。
 * <p>
 * #notify()方法也是要在同步代码块或者同步方法中调用的，它的作用是使停止的线程继续执行，
 * 调用notify()方法后，会通知那些等待当前线程对象锁的线程，并使它们重新获取该线程的对象锁，
 * 如果等待线程比较多的时候，则有线程规划器随机挑选出一个呈wait状态的线程。
 * #notify()调用之后不会立即释放锁，而是当执行notify()的线程执行完成，即退出同步代码块或同步方法时，才会释放对象锁。
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 14:53
 */
public class AppleFactory {

    private int apple = 0;

    public synchronized void produce() {
        if (apple == 5) {
            try {
                System.out.println("apple == 5");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        apple++;
        System.out.println("生成苹果成功:" + apple);
        notifyAll();
    }

    public synchronized void consume() {
        if (apple == 0) {
            System.out.println("apple == 0");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费苹果成功:" + apple);
        apple--;
        notifyAll();
    }

}
