package base.data_structure.stack;

import base.bean.BookCase;

/**
 * 自定义栈测试工具类
 */
public class StackTestUtil {

    public static void main(String[] args) {
        // 数组栈测试集合
        stackByArrayTest();
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

