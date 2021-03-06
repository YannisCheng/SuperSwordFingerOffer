package base.data_structure.queue.bean;

/**
 * 队列测试对象用例
 * 2020年6月21日23:32:30
 */
public class PersonCase {
    private String name;
    private int index;

    public PersonCase(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "PersonCase{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
