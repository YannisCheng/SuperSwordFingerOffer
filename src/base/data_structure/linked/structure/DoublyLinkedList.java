package base.data_structure.linked.structure;

import base.data_structure.linked.bean.DoublyBookNode;

/**
 * 双向链表
 * 2020-6-21 14:50:28
 */
public class DoublyLinkedList {

    private final DoublyBookNode head;
    private int sizeAll = 0;

    public DoublyLinkedList() {
        head = new DoublyBookNode("");
    }

    /**
     * 是否为空
     *
     * @return true：空
     */
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    /**
     * 添加元素 - 链首添加
     */
    public void pushHead(DoublyBookNode node) {

        if (isEmpty()) {
            head.setNext(node);
            node.setPrev(head);
            sizeAll++;
        } else {

            // TODO 有问题，待修改
            head.getNext().setPrev(node);
            node.setNext(head.getNext());
            head.setNext(node);
            node.setPrev(head);
            sizeAll++;
        }
    }

    /**
     * 添加元素 - 链尾添加
     */
    public void pushEnd(DoublyBookNode node) {
        if (isEmpty()) {
            head.setNext(node);
            node.setPrev(head);
            sizeAll++;
        } else {
            DoublyBookNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
            node.setPrev(temp);
            sizeAll++;
        }
    }

    /**
     * 弹出 - 首节点元素
     */
    public DoublyBookNode popHead() {
        DoublyBookNode obj = null;
        if (isEmpty()) {
            System.out.println("链表长度为0");
        } else {
            DoublyBookNode temp = head;
            obj = temp.getNext();
            temp.setNext(temp.getNext().getNext());
            temp.getNext().getNext().setPrev(temp);
            System.out.println("当前pop的首节点元素为：" + obj);
            sizeAll--;
        }
        return obj;
    }

    /**
     * 弹出 - 尾节点元素
     */
    public DoublyBookNode popEnd() {
        DoublyBookNode obj = null;
        if (isEmpty()) {
            System.out.println("链表长度为0");
        } else {
            DoublyBookNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            obj = temp;
            System.out.println("当前pop的尾结点元素为：" + obj);
            temp.getPrev().setNext(null);
            temp.setPrev(null);
            System.out.println();
            sizeAll--;
        }
        return obj;
    }

    /**
     * 弹出 - 指定索引节点元素
     */
    public DoublyBookNode popIndex(int index) {
        DoublyBookNode obj = null;
        if (isEmpty()) {
            throw new RuntimeException("链表长度为0");
        } else if (index > sizeAll) {
            throw new RuntimeException("index=" + index + " 超过链表长度:" + sizeAll);
        } else if (index == 0) {
            throw new RuntimeException("index不能为0");
        } else if (index == sizeAll) {
            obj = popEnd();
        } else if (index == 1) {
            obj = popHead();
        } else {
            DoublyBookNode temp = head;
            int tempSize = 0;
            while (temp.getNext() != null) {
                obj = temp.getNext();
                temp = temp.getNext();
                tempSize++;
                if (tempSize == index) {
                    break;
                }
            }
            System.out.printf("当前pop的index=%d时,删除的节点为：%s\n", index, temp);

            // 使用尾插push方法时，可以
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            sizeAll--;
        }
        return obj;
    }

    /**
     * 遍历元素
     */
    public void froEach() {
        // 判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
        } else {
            DoublyBookNode temp = head;
            while (temp.getNext() != null) {
                // 输出节点的信息
                System.out.println("遍历：" + temp.getNext());
                temp = temp.getNext();
            }
        }
    }

    public int size() {
        System.out.println("链表长度为：" + sizeAll);
        return sizeAll;
    }
}
