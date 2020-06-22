package base.data_structure.queue.structure;

/**
 * 队列 - 数组单向 实现方式
 * 2020-6-21 21:11:35
 * <p>
 * 队列的3个要素：
 * 1：头部索引font
 * 2：尾部索引rear
 * 3：队列容量size
 * <p>
 * 存在方法：
 * 1：push()
 * 2:pop()
 * 3:isEmpty()
 * 4:isFull()
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
            queue[rear] = obj;
            rear++;
            isPush = true;
        }
        return isPush;
    }

    /**
     * 检出元素
     *
     * @return 待检出的元素
     */
    public T pop() {
        T obj;
        if (isEmpty()) {
            System.out.println("队列内元素为空！，无法执行pop");
            obj = null;
        } else {
            obj = queue[font];
            queue[font] = null;
            font++;
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
        obj = queue[font];
        return obj;
    }

    /**
     * 遍历队列内的元素
     */
    public void forEach() {
        if (isEmpty()) {
            System.out.println("遍历：当前队列内元素为空！");
        } else {
            for (T item : queue) {
                if (item != null) {
                    System.out.println(item.toString());
                }
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
