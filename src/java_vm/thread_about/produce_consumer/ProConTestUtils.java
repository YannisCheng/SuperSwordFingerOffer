package java_vm.thread_about.produce_consumer;

/**
 * ProConTestUtils 生产者、消费者测试工具类
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 15:15
 */
public class ProConTestUtils {

    public static void main(String[] args) {
        AppleFactory factory = new AppleFactory();

        Consumer consumer = new Consumer(factory);
        Produce produce = new Produce(factory);
        consumer.start();
        produce.start();
    }
}
