package utils.stack;

import java.util.Arrays;

/**
 * 栈的实现方式1：通过数组实现
 * 注意点：
 * 1：数组容量是固定不变的，向栈内push元素时要时时检测容量是否已满
 * 2：pop元素时，要时时检测当前栈内是否还有元素
 * 3：数组的扩容问题。因为在栈初始化时使用的是默认大小
 *
 * @param <T> 栈内的对象类型
 */
public class StackByArray<T> {

    private Object[] stack = null;
    private int size = 0;
    final int DEFAULT_SIZE = 10;

    public StackByArray() {
        stack = new Object[DEFAULT_SIZE];
    }

    /**
     * 入栈
     *
     * @param item 待插入的元素
     * @return 是否插入成功
     */
    public T push(T item) {

        automaticExpansion(size);
        System.out.println("当前入栈index=" + size);
        stack[size] = item;
        size++;
        return item;
    }

    private void automaticExpansion(int newSize) {
        int len = stack.length;
        if (newSize >= len) {
            newSize = newSize * 3 / 2;
            System.out.println("当前栈已经扩容，扩容后size：" + newSize);
            stack = Arrays.copyOf(stack, newSize);
            System.out.println("当前栈已经扩容，容量为：" + stack.length);
        }
    }

    /**
     * 出栈
     *
     * @return 取出栈顶元素
     */
    public T pop() {
        T item = (T) stack[size - 1];
        stack[size - 1] = null;
        size--;
        System.out.println("当前出栈index=" + size);
        return item;
    }

    /**
     * 栈顶元素
     *
     * @return 获取栈顶元素，不出栈
     */
    public T peek() {
        System.out.println("当前栈顶元素为：" + (T) stack[size - 1]);
        return (T) stack[size - 1];
    }

    public void clearStack() {
        Arrays.fill(stack, null);
    }

    /**
     * 是否为空
     *
     * @return true为空
     */
    public boolean empty() {
        System.out.println(size == 0 ? "当前栈内元素为空" : "不为空");
        return size == 0;
    }

    /**
     * 遍历栈中的元素
     */
    public void showAll() {
        for (Object item : stack) {
            if (item != null) {
                System.out.println(((T) item).toString());
            }
        }
    }
}
