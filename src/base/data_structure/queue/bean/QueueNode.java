package base.data_structure.queue.bean;

/**
 * 链表队列node用例
 * 2020-6-21 23:52:50
 */
public class QueueNode {
    private String name;
    private int index;
    private QueueNode next;

    public QueueNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "QueueNode{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", next=" + next +
                '}';
    }
}
