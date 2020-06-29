package java_vm.thread_about.bean;

/**
 * Ticker 票
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/29 - 08:26
 */
public class Ticker {

    private int count;

    public Ticker(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "count=" + count +
                '}';
    }
}
