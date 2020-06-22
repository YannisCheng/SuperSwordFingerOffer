package base.data_structure.queue.structure;

/**
 * 队列 - 数组环 实现方式
 * 2020-6-21 21:12:04
 */
public class QueueByCircleArray {

    private int maxSize;
    private int font;
    private int rear;
    private String[] queue = null;

    public QueueByCircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new String[maxSize];
    }

    /**
     * 是否已满
     *
     * @return true：满
     */
    public boolean isFull() {

    }

    /**
     * 是否为空
     *
     * @return true 空
     */
    public boolean isEmpty() {

    }

    public boolean push(String item){

    }

    public String pop(){

    }

    public void forEach(){

    }

}
