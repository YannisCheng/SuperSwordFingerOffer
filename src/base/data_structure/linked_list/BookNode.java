package base.data_structure.linked_list;

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
