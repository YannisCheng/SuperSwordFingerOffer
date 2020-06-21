package base.data_structure.queue.structure;

import base.data_structure.queue.bean.QueueNode;

/**
 * 队列 - 链表 实现方式
 * 2020-6-21 21:12:34
 */
public class QueueByLinked {

    private QueueNode head = null;
    private QueueNode rear = null;
    /**
     * 队列容量
     */
    private int size = 0;


    public QueueByLinked() {
        head = rear = new QueueNode("", -1);
    }

    /**
     * 添加节点
     *
     * @param node 待添加的节点
     */
    public void push(QueueNode node) {

        if (isEmpty()) {
            head.setNext(node);
        } else {
            QueueNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }

        System.out.println(head);
        rear.setNext(node);
        size++;
    }

    /**
     * 检出节点
     */
    public QueueNode pop() {
        QueueNode item = null;
        if (isEmpty()) {
            System.out.println("队列为空");
        } else {
            QueueNode temp = head;
            item = temp.getNext();
            head.setNext(temp.getNext().getNext());
            size--;
        }
        return item;
    }

    public void forEach(){
        if (isEmpty()) {
            System.out.println("队列内容为空");
        } else {
            System.out.println("head is : "+head);
            QueueNode temp = head.getNext();
            while (temp != null) {
                System.out.println("index is : "+temp.getIndex() +", content is : " + temp);
                temp = temp.getNext();
            }
        }
    }

    private boolean isEmpty() {
        return (head.getNext() == null && rear.getNext() == null);
    }

    public int getSize() {
        return size;
    }
}
