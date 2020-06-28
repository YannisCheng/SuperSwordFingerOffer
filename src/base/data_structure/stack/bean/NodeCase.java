package base.data_structure.stack.bean;

/**
 * 栈 - 链表实现方式
 *
 * @param <T> 具体数据类型
 */
public class NodeCase<T> {

    private String data;
    private NodeCase<T> next = null;

    public NodeCase(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public NodeCase<T> getNext() {
        return next;
    }

    public void setNext(NodeCase<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeCase{" +
                "data='" + data + '\'' +
                ", next=" + next +
                '}';
    }
}
