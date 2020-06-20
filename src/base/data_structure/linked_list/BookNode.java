package base.data_structure.linked_list;

public class BookNode {
    private String bnName;
    private int numIndex;
    private BookNode next;

    public BookNode() {
        this.next = null;
    }

    public BookNode(String bnName, int numIndex) {
        this.bnName = bnName;
        this.numIndex = numIndex;
        this.next = null;
    }

    public String getBnName() {
        return bnName;
    }

    public void setBnName(String bnName) {
        this.bnName = bnName;
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
                "bnName='" + bnName + '\'' +
                ", numIndex=" + numIndex +
                ", next=" + next +
                '}';
    }
}
