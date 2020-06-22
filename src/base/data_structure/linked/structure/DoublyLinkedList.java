package base.data_structure.linked.structure;

import base.data_structure.linked.bean.DoublyBookNode;

/**
 * 双向链表
 * 2020-6-21 14:50:28
 */
public class DoublyLinkedList {

    private DoublyBookNode head  = new DoublyBookNode("");

    /**
     * 是否为空
     * @return true：空
     */
    public boolean isEmpty(){
        return head.getNext() == null && head.getPrev() == null;
    }

    /**
     * 添加元素 - 链首添加
     */
    public void pushHead(DoublyBookNode node){
        node.setNext(head);
        head.setPrev(node);
        head = node;
    }

    /**
     * 添加元素 - 链首添加
     */
    public void pushEnd(DoublyBookNode node){
        DoublyBookNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPrev(temp);
    }

    /**
     * 弹出元素
     */
    public void pop(){

    }

    /**
     * 遍历元素
     */
    // 遍历双向链表的方法
    // 显示链表[遍历]
    public void froEach() {
        // 判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        DoublyBookNode temp = head.getNext();
        while (temp != null) {
            // 输出节点的信息
            System.out.println(temp);
            // 将temp后移， 一定小心
            temp = temp.getNext();
        }
    }
}
