package base.data_structure.linked_list;

public class LinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.push(new BookNode("ren",0));
        singleLinkedList.push(new BookNode("ren",1));
        singleLinkedList.push(new BookNode("ren",2));
        singleLinkedList.push(new BookNode("ren",3));
        singleLinkedList.push(new BookNode("ren",4));
        singleLinkedList.forEach();

    }
}
