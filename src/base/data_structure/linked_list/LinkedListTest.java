package base.data_structure.linked_list;

public class LinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        BookNode node0 = new BookNode("ren", 0);
        BookNode node1 = new BookNode("ren", 1);
        BookNode node2 = new BookNode("ren", 2);
        BookNode node3 = new BookNode("ren", 3);
        BookNode node4 = new BookNode("ren", 4);
        BookNode node5 = new BookNode("ren", 5);
        BookNode node6 = new BookNode("ren", 6);
        BookNode node7 = new BookNode("ren", 7);
        BookNode node8 = new BookNode("ren", 8);
        BookNode node9 = new BookNode("ren", 9);
        BookNode node10 = new BookNode("ren", 10);

        // 尾插测试
        singleLinkedList.pushOrder(node0);
        singleLinkedList.pushOrder(node1);
        singleLinkedList.pushOrder(node2);
        singleLinkedList.pushOrder(node3);
        singleLinkedList.pushOrder(node4);
        singleLinkedList.len();
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
        singleLinkedList.remove(node2);
        singleLinkedList.remove(node7);
        singleLinkedList.len();
        singleLinkedList.forEach();

    }
}
