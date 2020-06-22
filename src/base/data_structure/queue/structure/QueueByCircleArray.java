package base.data_structure.queue.structure;

/**
 * 队列 - 数组环状 实现方式
 * 2020-6-21 21:12:04
 */
public class QueueByCircleArray<T> {

    /**
     * 数组环状队列内元素的实际容量 = maxSize-1
     * 实现"数组下标index"循环旋转的关键条件之一
     */
    private final int maxSize;
    /**
     * 数组环状队列内指向头部元素index
     */
    private int font = 0;
    /**
     * 数组环状队列内指向下一个元素的index
     */
    private int rear = 0;
    private T[] queue = null;

    public QueueByCircleArray(int tagSize) {
        this.maxSize = tagSize;
        this.queue = (T[]) new Object[maxSize];
    }

    /**
     * 队列内的有效元素数量是否已满
     *
     * @return true：满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == font;
    }

    /**
     * 队列内的有效元素数量是否为空
     *
     * @return true 空
     */
    public boolean isEmpty() {
        return rear == font;
    }

    /**
     * 向队列内添加元素
     *
     * @param item 待添加元素
     * @return 是否添加成功
     */
    public boolean push(T item) {
        boolean isPush = false;
        if (isFull()) {
            System.out.println("push队列容量已满！");
        } else {
            queue[rear] = item;
            // 实现"数组下标index"循环旋转的关键条件之一
            // 例如在队列容量未满的情况下,巧值：5->0
            rear = (rear + 1) % maxSize;
            isPush = true;
        }
        return isPush;
    }

    public T pop() {
        T item = null;
        if (isEmpty()) {
            System.out.println("pop：队列已空！");
        } else {
            item = queue[font];
            // 实现"数组下标index"循环旋转的关键条件之一
            font = (font + 1) % maxSize;
        }
        System.out.println("弹出元素：" + item);
        return item;
    }

    public void forEach() {
        if (isEmpty()) {
            System.out.println("遍历：队列已空！");
        } else {
            for (int i = font; i < font + totalSize(); i++) {
                System.out.printf("queue[%d] = %s\n", i % maxSize, queue[i % maxSize]);
            }
        }

    }

    /**
     * 队列内有效元素的数量
     *
     * @return 有效元素数量
     */
    public int totalSize() {
        return (rear + maxSize - font) % maxSize;
    }

}
