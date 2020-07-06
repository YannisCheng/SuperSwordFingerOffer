package java_vm.thread_pool;

public class ThreadTaskArray implements Runnable {

    private int index;

    public ThreadTaskArray(int mIndex) {
        this.index = mIndex;
    }


    @Override
    public void run() {
        try {
            //让线程阻塞，使后续任务进入缓存队列
            Thread.sleep(10);
            System.out.println("index:" + this.index + ", ThreadName:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
