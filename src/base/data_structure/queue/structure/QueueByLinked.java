package base.data_structure.queue.structure;

import base.data_structure.queue.bean.QueueNode;

/**
 * 队列 - 链表 实现方式
 * 2020-6-21 21:12:34
 */
public class QueueByLinked<T> {


    /**
     * 队列容量
     */
    private int size = 0;


    public QueueByLinked() {

    }

    /**
     * 添加节点
     * @param node 待添加的节点
     */
    public void push(QueueNode<T> node){
        if (isEmpty()) {

        } else {

        }
    }

    /**
     * 检出节点
     */
    public QueueNode<T> pop(){

    }

    private boolean isEmpty(){

    }

    public int getSize(){
        return size;
    }
}
