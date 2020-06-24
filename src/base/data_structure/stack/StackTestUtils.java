package base.data_structure.stack;

import base.data_structure.stack.bean.BookCase;
import base.data_structure.stack.bean.NodeCase;
import base.data_structure.stack.structure.StackByArray;
import base.data_structure.stack.structure.StackByLinked;

/**
 * 自定义栈测试工具类
 * 2020-6-20 21:31:16
 * <p>
 * 目前2种栈的实现方式：
 * 1：数组 {@link StackByArray}
 * 2：链表 {@link base.data_structure.stack.structure.StackByLinked}
 */
public class StackTestUtils {

    public static void main(String[] args) {
        // 数组栈测试集合
        // stackByArrayTest();
        // 链表栈测试集合
        stackByLinkedTest();
    }

    private static void stackByLinkedTest() {
        StackByLinked<String> linked = new StackByLinked<>();
        linked.push(new NodeCase<>("one"));
        linked.push(new NodeCase<>("two"));
        linked.push(new NodeCase<>("three"));
        linked.push(new NodeCase<>("four"));
        linked.forEach();
        linked.size();
        linked.peek();
        linked.pop();
        linked.pop();
        linked.forEach();
    }

    private static void stackByArrayTest() {
        StackByArray<BookCase> bookStack = new StackByArray<>();

        BookCase bean3 = new BookCase(3, "人", "outMan", 400, 345);
        bookStack.push(new BookCase(1, "人", "outMan", 400, 345));
        bookStack.push(new BookCase(2, "人", "outMan", 400, 345));
        bookStack.push(bean3);
        bookStack.push(new BookCase(4, "人", "outMan", 400, 345));
        bookStack.push(new BookCase(5, "人", "outMan", 400, 345));

        bookStack.showAllTest();

        bookStack.peek();
        bookStack.showAllTest();
        BookCase bean = bookStack.pop();
        System.out.println("弹出的栈顶元素为：" + bean.toString());
        bookStack.showAllTest();
        bookStack.popWithNumber(2);
        bookStack.showAllTest();

        BookCase bean6 = new BookCase(6, "人", "outMan", 400, 345);
        bookStack.push(bean6);
        bookStack.push(new BookCase(7, "人", "outMan", 400, 345));
        bookStack.push(new BookCase(8, "人", "outMan", 400, 345));

        bookStack.showAllTest();

        bookStack.popWithObj(bean6);
        bookStack.showAllTest();
        bookStack.showAll();
    }
}

