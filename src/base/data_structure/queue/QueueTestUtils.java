package base.data_structure.queue;

import base.data_structure.queue.bean.PersonCase;
import base.data_structure.queue.bean.QueueNode;
import base.data_structure.queue.structure.QueueByArray;
import base.data_structure.queue.structure.QueueByCircleArray;
import base.data_structure.queue.structure.QueueByLinked;

import java.util.Scanner;

/**
 * 队列测试工具类
 * 2020-6-21 21:13:10
 * <p>
 * 包中包含：
 * 1：单向数组 方式实现队列 {@link base.data_structure.queue.structure.QueueByArray}
 * 2：环向数组 方式实现队列 {@link base.data_structure.queue.structure.QueueByCircleArray}
 * 3：链表 方式实现队列 {@link base.data_structure.queue.structure.QueueByLinked}
 */
public class QueueTestUtils {


    public static void main(String[] args) {
        // arrayQueueTest();
        // linkedQueueTest();
        arrayCircleQueueTest();
    }

    private static void arrayCircleQueueTest() {
        // 创建一个环形队列
        QueueByCircleArray<String> circleArray = new QueueByCircleArray<>(6);
        boolean loop = true;
        // 初始化Scanner对象
        Scanner scanner = new Scanner(System.in);
        // 接收用户输入
        char key = ' ';
        System.out.println("s(show)：显示队列");
        System.out.println("e(exit)：退出程序");
        System.out.println("a(add)：添加数据到队列");
        System.out.println("g(get)：从队列取出数据");
        System.out.println("h(head)：查看队列头的数据");
        while (loop) {

            // 获取用户键盘输入
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArray.forEach();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个字符串");
                    String value = scanner.next();
                    circleArray.push(value);
                    break;
                case 'g':
                    String result = circleArray.pop();
                    System.out.printf("取出的数据是%s\n", result);
                    break;
                case 'h':
                    String head = circleArray.getHead();
                    System.out.printf("头部的数据是%s\n", head);
                    break;
                default:
            }
        }

        System.out.println("程序退出");

        /*circleArray.push("one");
        circleArray.push("two");
        circleArray.push("three");
        circleArray.forEach();
        System.out.println("pop------------");
        circleArray.pop();
        circleArray.pop();
        circleArray.forEach();
        System.out.println("push------------");
        circleArray.push("four");
        circleArray.push("five");
        circleArray.push("six");
        circleArray.push("seven");
        circleArray.push("six");
        circleArray.push("seven");
        circleArray.push("eight");
        circleArray.forEach();*/
    }

    private static void linkedQueueTest() {
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
        QueueByArray<PersonCase> personQueue = new QueueByArray<>(5);
        /*personQueue.push(new PersonCase("zhao", 0));
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
        System.out.println("---push---");*/
        personQueue.push(new PersonCase("zhao", 0));
        personQueue.push(new PersonCase("qian", 1));
        personQueue.push(new PersonCase("sun", 2));
        personQueue.push(new PersonCase("li", 3));
        personQueue.push(new PersonCase("zhou", 4));
        personQueue.push(new PersonCase("wu", 5));
        personQueue.forEach();
    }
}
