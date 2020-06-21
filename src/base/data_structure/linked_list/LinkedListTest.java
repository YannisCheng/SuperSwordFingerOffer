package base.data_structure.linked_list;

public class LinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        BookNode node0 = new BookNode(0);
        BookNode node1 = new BookNode(1);
        BookNode node2 = new BookNode(2);
        BookNode node3 = new BookNode(3);
        BookNode node4 = new BookNode(4);
        BookNode node5 = new BookNode(5);
        BookNode node6 = new BookNode(6);
        BookNode node7 = new BookNode(7);
        BookNode node8 = new BookNode(8);
        BookNode node9 = new BookNode(9);
        BookNode node10 = new BookNode (10);

        // 尾插测试
        singleLinkedList.pushEnd(node0);
        singleLinkedList.pushEnd(node1);
        singleLinkedList.pushEnd(node2);
        singleLinkedList.pushEnd(node3);
        singleLinkedList.pushEnd(node4);
        /*singleLinkedList.len();
        singleLinkedList.forEach();
        // 头插测试
        singleLinkedList.pushFront(node5);
        singleLinkedList.pushFront(node6);
        singleLinkedList.pushFront(node7);
        singleLinkedList.pushFront(node8);
        singleLinkedList.pushFront(node9);
        singleLinkedList.len();
        singleLinkedList.forEach();
        System.out.println("---------------");
        singleLinkedList.removeEnd(node2);
        singleLinkedList.removeEnd(node7);
        singleLinkedList.len();
        singleLinkedList.forEach();*/
        singleLinkedList.reverse();
        singleLinkedList.forEach();
        singleLinkedList.deleteFront();
        singleLinkedList.forEach();
        node3.setNumIndex(33);
        singleLinkedList.upDataNode(node4);
        singleLinkedList.forEach();
    }
}
