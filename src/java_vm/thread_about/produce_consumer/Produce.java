package java_vm.thread_about.produce_consumer;

/**
 * Produce 生产者
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 14:48
 */
public class Produce extends Thread{

    private AppleFactory factory;

    public Produce(AppleFactory mf) {
        this.factory = mf;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 1; i < 11; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System. out .println("生产: i " +i);
            factory.produce();
        }

    }
}
