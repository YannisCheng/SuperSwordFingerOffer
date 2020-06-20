package utils.stack;

import utils.bean.BookBean;

public class StackUtils {

    public static void main(String[] args) {
        StackByArray<BookBean> bookStack = new StackByArray<>();
        bookStack.push(new BookBean(0,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(1,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(2,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(3,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(4,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(5,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(6,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(7,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(8,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(9,"人月神话","outMan",400,345));

        bookStack.push(new BookBean(10,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(11,"人月神话","outMan",400,345));

        bookStack.push(new BookBean(0,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(1,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(2,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(3,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(4,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(5,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(6,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(7,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(8,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(9,"人月神话","outMan",400,345));

        bookStack.push(new BookBean(10,"人月神话","outMan",400,345));
        bookStack.push(new BookBean(11,"人月神话","outMan",400,345));
       /* bookStack.peek();
        bookStack.pop();
        bookStack.empty();*/
        bookStack.showAll();

    }
}

