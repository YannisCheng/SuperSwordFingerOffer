package java_vm.thread_about.produce_consumer;

/**
 * Consumer 消费者
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 14:49
 */
public class Consumer extends Thread {

    private AppleFactory factory;

    public Consumer(AppleFactory mf) {
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
            System. out .println("消费  i:" +i);
            factory.consume();
        }

    }
}
