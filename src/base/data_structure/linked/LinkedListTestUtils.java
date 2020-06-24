package base.data_structure.linked;

import base.data_structure.linked.bean.BookNode;
import base.data_structure.linked.bean.DoublyBookNode;
import base.data_structure.linked.structure.DoublyLinkedList;
import base.data_structure.linked.structure.SingleLinkedList;

/**
 * 链表测试工具类
 * 2020-6-19 21:13:22
 * <p>
 * 共3种链表构建方式
 * 1：单向链表 {@link SingleLinkedList}
 * 2：双向链表 {@link base.data_structure.linked.structure.DoublyLinkedList}
 * 3：状状链表 {@link base.data_structure.linked.structure.CircleLinkedList}
 */
public class LinkedListTestUtils {

    public static void main(String[] args) {
        //singleLinkedListTest();
        doublyLinkedListTest();
    }

    private static void doublyLinkedListTest() {
        DoublyLinkedList list = new DoublyLinkedList();
        // 有问题的popEnd()测试
        /*list.pushEnd(new DoublyBookNode("end：one"));
        list.pushEnd(new DoublyBookNode("end：two"));
        list.pushHead(new DoublyBookNode("head：zero"));
        list.pushEnd(new DoublyBookNode("end：three"));
        list.pushHead(new DoublyBookNode("head：four"));
        list.pushHead(new DoublyBookNode("head：five"));
        list.froEach();
        list.size();
        list.popHead();
        list.froEach();
        list.size();
        list.popHead();
        list.froEach();
        list.size();
        list.popEnd();
        list.froEach();
        list.size();
        // 当链表长度为：3时，测试数字：0，1，3，2
        list.popIndex(2);
        list.froEach();
        list.size();*/

        list.pushEnd(new DoublyBookNode("one"));
        list.pushEnd(new DoublyBookNode("two"));
        list.pushEnd(new DoublyBookNode("three"));
        list.pushEnd(new DoublyBookNode("four"));
        list.popIndex(2);
        list.froEach();
        list.size();
    }

    private static void singleLinkedListTest() {
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
        BookNode node10 = new BookNode(10);

        // 尾插测试
        singleLinkedList.pushEnd(node0);
        singleLinkedList.pushEnd(node1);
        singleLinkedList.pushEnd(node2);
        singleLinkedList.pushEnd(node3);
        singleLinkedList.pushEnd(node4);
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
        singleLinkedList.removeEnd(node2);
        singleLinkedList.removeEnd(node7);
        singleLinkedList.len();
        singleLinkedList.forEach();
        singleLinkedList.reverse();
        singleLinkedList.forEach();
        singleLinkedList.deleteFront();
        singleLinkedList.forEach();
        System.out.println("---------------");
        node3.setNumIndex(33);
        singleLinkedList.upDataNode(node4);
        singleLinkedList.forEach();

        System.out.println("---------------");
        singleLinkedList.reversePrint();
    }
}
