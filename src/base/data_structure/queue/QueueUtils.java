package base.data_structure.queue;

import base.data_structure.queue.bean.PersonCase;
import base.data_structure.queue.structure.QueueByArray;

/**
 * 队列测试工具类
 * 2020-6-21 21:13:10
 *
 * 包中包含：
 * 1：单向数组 方式实现队列 {@link base.data_structure.queue.structure.QueueByArray}
 * 2：环向数组 方式实现队列 {@link base.data_structure.queue.structure.QueueByCircleArray}
 * 3：链表 方式实现队列 {@link base.data_structure.queue.structure.QueueByLinked}
 *
 * 队列的3个要素：
 * 1：头部索引font
 * 2：尾部索引rear
 * 3：队列容量size
 *
 * 存在方法：
 * 1：push()
 * 2:pop()
 * 3:isEmpty()
 * 4:isFull()
 */
public class QueueUtils {


    public static void main(String[] args) {
        arrayQueueTest();
    }

    private static void arrayQueueTest() {
        QueueByArray<PersonCase> personQueue = new QueueByArray<>(5);
        personQueue.forEach();
        personQueue.push(new PersonCase("zhao",0));
        personQueue.push(new PersonCase("qian",1));
        personQueue.push(new PersonCase("sun",2));
        personQueue.forEach();
    }
}
