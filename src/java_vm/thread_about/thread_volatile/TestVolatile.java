package java_vm.thread_about.thread_volatile;

public class TestVolatile {
    int a = 1;
    boolean status = false;

    /**
     * 状态切换为true
     */
    public void changeStatus() {
        a = 2;//1
        status = true;
    }

    /**
     * 若状态为true，则running。
     */
    public void run() {
        if (status) {
            int b = a + 1;//4
            System.out.println("running....b value is : " + b);
        }
    }
}
