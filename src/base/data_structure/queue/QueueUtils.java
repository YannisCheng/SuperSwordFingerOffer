package base.data_structure.queue;

import base.data_structure.queue.bean.PersonCase;
import base.data_structure.queue.bean.QueueNode;
import base.data_structure.queue.structure.QueueByArray;
import base.data_structure.queue.structure.QueueByLinked;

/**
 * 队列测试工具类
 * 2020-6-21 21:13:10
 * <p>
 * 包中包含：
 * 1：单向数组 方式实现队列 {@link base.data_structure.queue.structure.QueueByArray}
 * 2：环向数组 方式实现队列 {@link base.data_structure.queue.structure.QueueByCircleArray}
 * 3：链表 方式实现队列 {@link base.data_structure.queue.structure.QueueByLinked}
 */
public class QueueUtils {


    public static void main(String[] args) {
        arrayQueueTest();
        //linkedQuueTest();
    }

    private static void linkedQuueTest() {
        QueueByLinked queue = new QueueByLinked();
        QueueNode pseron0 = new QueueNode("zhao", 0);
        QueueNode pseron1 = new QueueNode("qian", 1);
        QueueNode pseron2 = new QueueNode("sun", 2);
        QueueNode pseron3 = new QueueNode("li", 3);

        queue.push(pseron0);
        queue.push(pseron1);
        queue.push(pseron2);
        queue.push(pseron3);
        queue.forEach();
    }

    private static void arrayQueueTest() {
        QueueByArray<PersonCase> personQueue = new QueueByArray<>(10);
        personQueue.push(new PersonCase("zhao", 0));
        personQueue.push(new PersonCase("qian", 1));
        personQueue.push(new PersonCase("sun", 2));
        personQueue.push(new PersonCase("li", 3));
        personQueue.forEach();

        System.out.println("---pop---");
        personQueue.pop();
        personQueue.pop();
        personQueue.forEach();
        System.out.println("---push---");
        personQueue.push(new PersonCase("zhou", 4));
        personQueue.push(new PersonCase("wu", 5));
        personQueue.forEach();

        System.out.println("---pop---");
        personQueue.pop();
        personQueue.pop();
        personQueue.pop();
        personQueue.pop();
        personQueue.pop();
        personQueue.forEach();
    }
}
