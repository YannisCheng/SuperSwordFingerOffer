package base.data_structure.stack.structure;

import base.data_structure.stack.bean.NodeCase;

/**
 * 栈：链表实现方式
 * 2020-6-21 21:32:34
 */
public class StackByLinked<T> {

    /**
     * 头结点
     */
    private NodeCase<T> head = null;

    /**
     * 栈内元素数量
     */
    private int sizeAll = 1;

    public StackByLinked() {
        head = new NodeCase<>("");
    }

    /**
     * 栈内添加元素
     *
     * @param obj 待添加元素
     * @return 是否添加成功，true：成功
     */
    public boolean push(NodeCase<T> obj) {
        boolean isPsuh = false;
        if (isEmpty()) {
            head.setNext(obj);
        } else {
            NodeCase<T> temp = head;
            // 采用头插
            obj.setNext(temp.getNext());
            head.setNext(obj);
            sizeAll++;
        }
        return isPsuh;
    }

    /**
     * 检出元素
     *
     * @return 检出的元素
     */
    public NodeCase<T> pop() {
        NodeCase<T> obj = null;
        if (isEmpty()) {
            System.out.println("栈内元素已空！");
        } else {
            NodeCase<T> temp = head;
            obj = temp.getNext();
            System.out.println("pop: " + obj);
            temp.setNext(temp.getNext().getNext());
            sizeAll--;
        }
        return obj;
    }

    /**
     * 遍历
     */
    public void forEach() {
        if (isEmpty()) {
            System.out.println("栈内元素数量为0");
        } else {
            NodeCase<T> temp = head;
            while (temp.getNext() != null) {
                // System.out.println("遍历：" + temp.getNext());
                System.out.println("遍历：" + temp.getNext().getData());
                temp = temp.getNext();
            }
        }
    }

    /**
     * 查看头部元素，不检出
     *
     * @return 头部元素
     */
    public NodeCase<T> peek() {
        NodeCase<T> obj = null;
        if (isEmpty()) {
            System.out.println("栈内元素数量为0");
        } else {
            obj = head.getNext();
            System.out.println("peek:"+obj);
        }
        return obj;
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
     * 栈内元素数量
     *
     * @return 数据
     */
    public int size() {
        System.out.println("栈内元素数量为：" +sizeAll);
        return sizeAll;
    }
}
