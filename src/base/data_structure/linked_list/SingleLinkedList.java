package base.data_structure.linked_list;

/**
 * 单项链表
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
    public void pushOrder(BookNode node) {
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
     * 删除节点
     */
    public void remove(BookNode node) {
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
     * 更新节点
     */
    public void upDataNode() {

    }

    /**
     * 插入节点
     */
    public void insertNode(BookNode node, int index) {
        BookNode temp = head;
        while (temp.getNext() != null) {

        }
    }

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
