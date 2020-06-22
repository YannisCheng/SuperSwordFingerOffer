package base.data_structure.linked.bean;

/**
 * 双向链表节点用例
 */
public class DoublyBookNode {
    private String data;
    private DoublyBookNode prev;
    private DoublyBookNode next;

    public DoublyBookNode(String data) {
        this.data = data;
        prev = null;
        next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DoublyBookNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyBookNode prev) {
        this.prev = prev;
    }

    public DoublyBookNode getNext() {
        return next;
    }

    public void setNext(DoublyBookNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoublyBookNode{" +
                "data='" + data +
                '}';
    }
}
