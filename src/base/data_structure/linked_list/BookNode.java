package base.data_structure.linked_list;

/**
 * 单向链表节点用例
 */
public class BookNode {
    private int numIndex;
    private BookNode next;

    public BookNode() {
        this.next = null;
    }

    public BookNode(int numIndex) {
        this.numIndex = numIndex;
        this.next = null;
    }


    public int getNumIndex() {
        return numIndex;
    }

    public void setNumIndex(int numIndex) {
        this.numIndex = numIndex;
    }

    public BookNode getNext() {
        return next;
    }

    public void setNext(BookNode next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "BookNode{" +
                "numIndex=" + numIndex +
                ", next=" + next +
                '}';
    }
}
