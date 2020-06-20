package utils.stack;

import utils.bean.BookBean;

public class StackUtils {

    public static void main(String[] args) {
        StackByArray<BookBean> bookStack = new StackByArray<>();

        BookBean bean3 = new BookBean(3, "人", "outMan", 400, 345);
        bookStack.push(new BookBean(1, "人", "outMan", 400, 345));
        bookStack.push(new BookBean(2, "人", "outMan", 400, 345));
        bookStack.push(bean3);
        bookStack.push(new BookBean(4, "人", "outMan", 400, 345));
        bookStack.push(new BookBean(5, "人", "outMan", 400, 345));

        bookStack.showAllTest();

        bookStack.peek();
        BookBean bean = bookStack.pop();
        System.out.println("弹出的栈顶元素为：" + bean.toString());
        bookStack.showAllTest();
        bookStack.popWithNumber(2);
        bookStack.showAllTest();

        BookBean bean6 = new BookBean(6, "人", "outMan", 400, 345);
        bookStack.push(bean6);
        bookStack.push(new BookBean(7, "人", "outMan", 400, 345));
        bookStack.push(new BookBean(8, "人", "outMan", 400, 345));

        bookStack.showAllTest();

        bookStack.popWithObj(bean6);
        bookStack.showAllTest();
        bookStack.showAll();
    }
}

