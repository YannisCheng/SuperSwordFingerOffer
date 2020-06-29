package java_vm.thread_about.thread_synchronized;

/**
 * DeadLock 线程死锁
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 14:06
 */
public class DeadLock {

    static Printer p = new Printer();
    static Scan s = new Scan();

    public static void main(String[] args) {
        Runnable run1 = new Runnable() {

            @Override
            public void run() {
                synchronized (p) {
                    showState("run1..p",Thread.currentThread());
                    p.print();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    showState("run1..p--end",Thread.currentThread());
                    synchronized (s) {
                        showState("run1..s",Thread.currentThread());
                        s.scan();
                    }
                }
            }
        };


        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                synchronized (s) {
                    showState("run2..s",Thread.currentThread());
                    s.scan();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    showState("run2..s--end",Thread.currentThread());
                    synchronized (p) {
                        showState("run2..p",Thread.currentThread());
                        p.print();
                    }
                }
            }
        };

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        showState("end 1",thread1);
        showState("end 2",thread2);
    }

    private static void showState(String msg,Thread thread){
        System.out.println(msg+", "+thread.getName()+",state: "+ thread.getState());
    }
}

// 代表打印机的类
class Printer {
    public void print() {
        System.out.println("打印机在吱呦吱呦的打印~~~");
    }
}

// 代表扫描仪的类
class Scan {
    public void scan() {
        System.out.println("扫描仪在哼哧哼哧的扫描-----");
    }
}