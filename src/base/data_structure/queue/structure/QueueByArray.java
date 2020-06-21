package base.data_structure.queue.structure;

import org.omg.CORBA.Object;

/**
 * 队列 - 数组单向 实现方式
 * 2020-6-21 21:11:35
 */
public class QueueByArray<T> {

    private T[] queue = null;
    /**
     * 队列容量
     */
    private int size = 0;
    /**
     * 队列头部位置索引
     */
    private int font = 0;
    /**
     * 队列尾部位置索引
     */
    private int rear = 0;

    public QueueByArray(int size) {
        this.size = size;
        queue = (T[]) new Object[size];
    }

    /**
     * 添加元素
     *
     * @param obj 元素
     */
    public boolean push(T obj) {
        boolean isPush;
        if (isFull()) {
            System.out.println("队列已满！");
            isPush = false;
        } else {
            queue[rear++] = obj;
            isPush = true;
        }
        return isPush;
    }

    /**
     * 检出头部元素
     *
     * @return 待检出的元素
     */
    public T pop() {
        T obj = null;
        if (isEmpty()) {
            System.out.println("队列为空！");
            obj = null;
        } else {
            obj = queue[font++];
        }
        return obj;
    }

    /**
     * 查看头部元素
     *
     * @return 待查看的元素
     */
    public T peek() {
        T obj = null;
        return obj;
    }

    /**
     * 遍历队列内的元素
     */
    public void forEach() {
        if (isEmpty()) {
            System.out.println("当前队列内元素为空！");
        } else {
            for (T item : queue) {
                System.out.println(item.toString());
            }
        }
    }

    /**
     * 队列是否已空
     *
     * @return true：kong
     */
    public boolean isEmpty() {
        return font == rear;
    }

    /**
     * 队列是否已满
     *
     * @return true：满
     */
    public boolean isFull() {
        return rear == size;
    }
}
