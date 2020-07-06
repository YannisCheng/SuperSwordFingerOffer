package java_vm.thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadFactoryTestUtils 线程池测试工具类
 *
 * <br><p>
 * 线程池的7个参数；
 * <p>
 * 1）corePoolSize   ：核心线程数
 * <p>
 * 2）maximumPoolSize：最大线程数
 * <p>
 * 3）keepAliveTime  ：空闲线程存活时间
 * <p>
 * 4）unit           ：空闲线程存活时间单位
 * <p>
 * 5）workQueue      ：工作队列
 * <p>
 * 6）threadFactory  ：线程工厂
 * <p>
 * 7）handler        ：拒绝策略
 *
 * <br><p>
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 16:52
 */
public class ThreadFactoryTestUtils {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            executor.execute(new ThreadTaskArray(i));
        }
    }

    /**
     * workQueue类型为：SynchronousQueue，运行结果为：
     *
     * Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java_vm.thread_pool.ThreadTaskArray@61bbe9ba rejected from java.util.concurrent.ThreadPoolExecutor@610455d6[Running, pool size = 4, active threads = 4, queued tasks = 0, completed tasks = 0]
     * 	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2047)
     * 	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:823)
     * 	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1369)
     * 	at java_vm.thread_pool.ThreadFactoryTestUtils.main(ThreadFactoryTestUtils.java:42)
     * index:1, ThreadName:pool-1-thread-2
     * index:0, ThreadName:pool-1-thread-1
     * index:2, ThreadName:pool-1-thread-3
     * index:3, ThreadName:pool-1-thread-4
     */

    /**
     * workQueue类型为：ArrayBlockingQueue，运行结果为：
     *
     * Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java_vm.thread_pool.ThreadTaskArray@6e0be858 rejected from java.util.concurrent.ThreadPoolExecutor@61bbe9ba[Running, pool size = 4, active threads = 4, queued tasks = 4, completed tasks = 0]
     * 	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2047)
     * 	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:823)
     * 	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1369)
     * 	at java_vm.thread_pool.ThreadFactoryTestUtils.main(ThreadFactoryTestUtils.java:42)
     * index:0, ThreadName:pool-1-thread-1
     * index:7, ThreadName:pool-1-thread-4
     * index:6, ThreadName:pool-1-thread-3
     * index:1, ThreadName:pool-1-thread-2
     * index:2, ThreadName:pool-1-thread-1
     * index:5, ThreadName:pool-1-thread-2
     * index:4, ThreadName:pool-1-thread-3
     * index:3, ThreadName:pool-1-thread-4
     */

    /**
     * workQueue类型为：LinkedBlockingQueue，运行结果为：
     *
     * index:0, ThreadName:pool-1-thread-1
     * index:1, ThreadName:pool-1-thread-2
     * index:3, ThreadName:pool-1-thread-2
     * index:2, ThreadName:pool-1-thread-1
     * index:5, ThreadName:pool-1-thread-1
     * index:4, ThreadName:pool-1-thread-2
     * index:7, ThreadName:pool-1-thread-2
     * index:6, ThreadName:pool-1-thread-1
     * index:8, ThreadName:pool-1-thread-2
     * index:9, ThreadName:pool-1-thread-1
     */

    /**
     * workQueue类型为：PriorityBlockingQueue时，运行结果为：
     *
     * priority:1,ThreadName:pool-1-thread-2
     * priority:0,ThreadName:pool-1-thread-1
     * priority:8,ThreadName:pool-1-thread-1
     * priority:9,ThreadName:pool-1-thread-2
     * priority:7,ThreadName:pool-1-thread-1
     * priority:6,ThreadName:pool-1-thread-2
     * priority:4,ThreadName:pool-1-thread-2
     * priority:5,ThreadName:pool-1-thread-1
     * priority:3,ThreadName:pool-1-thread-2
     * priority:2,ThreadName:pool-1-thread-1
     */
}
