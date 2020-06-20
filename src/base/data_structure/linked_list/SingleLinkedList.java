package base.data_structure.linked_list;

/**
 * 单项链表
 */
public class SingleLinkedList {

    private BookNode head;

    public SingleLinkedList() {
        head = new BookNode();
    }

    public void push(BookNode node){
        if (node == null) {
            throw new NullPointerException();
        }

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
     * 遍历
     */
    public void forEach(){
        BookNode temp = head.getNext();
        while (temp.getNext() != null) {
            System.out.println(temp);
            System.out.println(temp.getNumIndex());
            temp = temp.getNext();
        }
    }

}
