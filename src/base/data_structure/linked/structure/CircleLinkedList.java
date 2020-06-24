package base.data_structure.linked.structure;

import base.data_structure.linked.bean.BookNode;

/**
 * 环状链表
 * 2020-6-21 21:22:25
 */
public class CircleLinkedList {
    private BookNode head;
    private int sizeAll = 0;

    public CircleLinkedList() {
        head = new BookNode(-1);
    }

    public boolean push(BookNode node) {
        boolean isPush = false;

        return isPush;
    }

    public BookNode pop() {
        BookNode obj = null;

        return obj;
    }

    public void forEach() {

    }

    public BookNode peek(){
        BookNode obj = null;

        return obj;
    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    public int size() {
        return sizeAll;
    }
}
