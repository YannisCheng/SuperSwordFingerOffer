package base.data_structure.linked_list;

import java.util.Stack;

/**
 * 单项链表
 *
 * 2020-6-19 22:50:11
 */
public class SingleLinkedList {

    private BookNode head;

    public SingleLinkedList() {
        head = new BookNode();
        System.out.println("head is " + head.toString());
    }

    private void nullCheck(BookNode node) {
        if (node == null) {
            throw new NullPointerException();
        }
    }

    /**
     * 头插 - 栈的实现方式
     *
     * @param node 待插入节点
     */
    public void pushFront(BookNode node) {
        //1.更新node节点的next
        node.setNext(head.getNext());
        //2.更新head
        head.setNext(node);
    }

    /**
     * 尾插：顺序插入链表元素 - 队列的实现方式
     *
     * @param node 链表元素
     */
    public void pushEnd(BookNode node) {
        nullCheck(node);

        if (head.getNext() == null) {
            head.setNext(node);
        } else {
            BookNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    /**
     * 删除指定元素
     */
    public void removeEnd(BookNode node) {
        BookNode temp = head;
        if (temp.getNext() == node) {
            temp.setNext(null);
        }
        while (temp != null) {
            if (temp.getNext() == node) {
                System.out.println("删除的元素为："+temp.getNext().getNumIndex());
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 头部删除
     */
    public void deleteFront(){
        BookNode temp = head;
        temp.setNext(temp.getNext().getNext());
        head = temp;
    }


    /**
     * 更新节点
     */
    public void upDataNode(BookNode node) {
        BookNode temp = head;
        if (temp.getNext() == node) {
            temp.setNext(null);
        }
        while (temp != null) {
            if (temp.getNext() == node) {
                temp.setNext(node);
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 链表翻转
     *
     * 方法中："语句：2"+"语句3"
     * == node1.setNext(null)
     * == node2.setNext(node1)
     * == node3.setNext(node2)
     * == node4.setNext(node3)
     */
    public void reverse(){
        // 通过“head.getNext()”获取原链表的首节点
        BookNode curTemp = head.getNext();
        // 暂存[curTemp]节点的下一个节点
        BookNode next = null;
        // 翻转链表时的中间临时变量（temp）。
        // 原链表中每一个节点指向的前一个节点
        // 此节点必须是null，否在在执行“curTemp.setNext(prevNode);”时就会向原有链表中
        // 中的“第1个实际节点”添加一个“BookNode{numIndex=0, next=null}”对象
        BookNode prevNode = null;
        while (curTemp != null) {
            //暂存[curTemp]节点的下一个节点
            next = curTemp.getNext();
            // 语句：2
            // 将下一个节点的指向改为新链表的暂存节点
            // （原有链表间的指向断开，建立新的指向<新链表的下一个节点，不是新链表节点本身>）
            curTemp.setNext(prevNode);
            // 为新链表的下一个节点设置具体节点
            // 语句：3
            prevNode =curTemp;
            // 继续遍历原有链表的下一个节点
            curTemp = next;
        }
        // 将新链表的实际节点赋值给头结点
        head.setNext(prevNode);
    }

    /**
     * 从尾到头打印单链表
     */
    public void reversePrint(){
        Stack<BookNode> stack = new Stack<>();
        BookNode bookNode = head.getNext();
        while (bookNode != null) {
            stack.push(bookNode);
            bookNode = bookNode.getNext();
        }

        while (stack.size()>0) {
            System.out.println(stack.pop());
        }
    }


    /**
     * 链表长度
     * @return 长度
     */
    public int len() {
        BookNode temp = head;
        int length = 0;
        while (temp.getNext() != null) {
            length++;
            temp = temp.getNext();
        }
        System.out.println("长度len为：" + length);
        return length;
    }

    /**
     * 遍历
     */
    public void forEach() {
        BookNode temp = head;
        while (temp.getNext() != null) {
            System.out.println(temp.getNext());
            System.out.println(temp.getNext().getNumIndex());
            temp = temp.getNext();
        }
    }

}
