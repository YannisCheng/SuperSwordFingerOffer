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

    private T[] stack = null;
    private int size = 0;
    final int DEFAULT_SIZE = 4;

    public StackByArray() {
        stack = (T[]) new Object[DEFAULT_SIZE];
    }

    /**
     * 入栈
     *
     * @param item 待插入的元素
     * @return 是否插入成功
     */
    public T push(T item) {
        automaticExpansion(size);
        System.out.println("当前入栈 index =" + size);
        stack[size] = item;
        size++;
        return item;
    }

    /**
     * 数组自动扩容
     *
     * @param oldSize 原栈容量
     */
    private void automaticExpansion(int oldSize) {
        if (oldSize >= stack.length) {
            oldSize = oldSize * 3 / 2;
            stack = Arrays.copyOf(stack, oldSize);
            System.out.println("当前栈已经自动扩容，容量为：" + stack.length);
        }
    }

    /**
     * 弹出栈顶的元素
     *
     * @return 取出栈顶元素
     */
    public T pop() {
        T item = stack[size - 1];
        stack[size - 1] = null;
        size--;
        System.out.println("当前出栈index=" + size);
        return item;
    }

    /**
     * 弹出指定数量的栈元素
     *
     * @param number 指定数量
     */
    public void popWithNumber(int number) {
        System.out.println("弹出栈内的" + number + "个元素");
        if (number <= (size - 1)) {
            for (int i = 0; i < number; i++) {
                stack[size - 1] = null;
                size--;
            }
            System.out.println("popWithIndex == 当前栈顶的元素index为：" + size);
        } else {
            throw new ArrayIndexOutOfBoundsException("当前index：" + number + "，大于栈内的实际元素数量");
        }
    }

    /**
     * 栈顶元素
     *
     * @return 获取栈顶元素，不出栈
     */
    public T peek() {
        System.out.println("仅仅获取当前栈顶元素：" + stack[size - 1] + "，不弹出");
        return stack[size - 1];
    }

    /**
     * 清空栈
     */
    public void clearStack() {
        Arrays.fill(stack, null);
    }

    /**
     * 清除栈内的指定对象本身及其之上的所有数据
     *
     * @param obj 指定的对象
     */
    public void popWithObj(T obj) {
        int actualIndex = -1;
        for (int i = 0; i < size; i++) {
            if (stack[i] == obj) {
                actualIndex = i;
                System.out.println("当前对象在栈内的index是：" + i);
                break;
            }
        }
        if (actualIndex == -1) {
            System.out.println("当前栈内不存在改元素" + obj.toString());
            return;
        }

        System.out.println("弹出栈内index为：" + actualIndex + "的自身及其之上的所有元素");
        for (int i = size - 1; i >= actualIndex; i--) {
            stack[i] = null;
        }
        size = size - Math.abs(actualIndex - size);
    }

    /**
     * 栈内元素是否为空
     *
     * @return true为空
     */
    public boolean empty() {
        boolean isHas = false;
        for (Object o : stack) {
            isHas = o != null;
        }
        return isHas;
    }

    /**
     * 遍历栈中的元素
     */
    public void showAll() {
        boolean isHas = false;
        for (Object o : stack) {
            if (o != null) {
                isHas = true;
                System.out.println(o.toString());
            }
        }
        if (!isHas) {
            System.out.println("栈内暂无元素");
        }
    }

    /**
     * 共测试使用：查看stack内各个index上数据的状态
     * （以防：数据在插入栈内时index位置错误）
     */
    public void showAllTest() {
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] == null) {
                System.out.println("当前index元素为：" + "null");
            } else {
                System.out.println("当前index元素为：" + stack[i].toString());
            }
        }
    }
}
