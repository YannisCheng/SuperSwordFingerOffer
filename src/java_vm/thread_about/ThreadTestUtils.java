package java_vm.thread_about;

/**
 * ThreadTestUtils 线程测试工具类
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 16:53
 */
public class ThreadTestUtils {


    public static void main(String[] args) throws InterruptedException {

        ThreadJoin threadJoin = new ThreadJoin();
        threadJoin.save();
    }


    public static void showThreadState(Thread thread) {
        System.out.println(thread.getName() + "'s state is :" + thread.getState());
    }

}
