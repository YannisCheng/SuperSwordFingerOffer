package java_vm.thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
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
 * 5）workQueue      ：工作队列-4种
 * <p>
 * 6）threadFactory  ：线程工厂-自定义
 * <p>
 * 7）handler        ：拒绝策略-4种
 *
 * <br><p>
 * 线程池线程数量设置：
 * Nthreads=CPU数量
 * Ucpu=目标CPU的使用率，0<=Ucpu<=1
 * W/C=任务等待时间与任务计算时间的比率
 * Nthreads = Ncpu*Ucpu*(1+W/C);
 * <br><p>
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 16:52
 */
public class ThreadFactoryTestUtils {
    public static void main(String[] args) {
        // 线程池参数配置：
        // 1：4种不同任务队列的使用
        // 2：4种不同拒绝策略的使用
        // 3：自定义ThreadFactory
        // 4：ThreadPoolExecutor扩展
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(4),
                //Executors.defaultThreadFactory(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        System.out.println("线程: " + r.hashCode() + "被创建");
                        return new Thread(r, "threadPool: " + r.hashCode());
                    }
                },
                new ThreadPoolExecutor.DiscardOldestPolicy()) {
            // ThreadPoolExecutor扩展
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
                System.out.println("线程池中任务运行前执行,准备执行：" + t.getName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                System.out.println("线程池中任务运行完毕后执行,执行完毕：");
            }

            @Override
            protected void terminated() {
                super.terminated();
                System.out.println("线程池退出后执行,线程池退出");
            }
        };

        for (int i = 0; i < 10; i++) {
            executor.execute(new ThreadTaskArray(i));
        }

        // 当线程池调用该方法后，线程池中不再接受后续添加的任务。
        // 但是，此时线程池不会立刻退出，直到添加到线程池中的任务都已经处理完成，才会退出。
        executor.shutdown();
    }

    /**
     * workQueue类型为：SynchronousQueue，拒绝策略：AbortPolicy，运行结果为：
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
     *
     * ~ 拒绝策略：AbortPolicy，运行结果为:
     * index:0, ThreadName:pool-1-thread-1
     * index:2, ThreadName:pool-1-thread-3
     * index:1, ThreadName:pool-1-thread-2
     * index:4, ThreadName:main
     * index:3, ThreadName:pool-1-thread-4
     * index:7, ThreadName:pool-1-thread-4
     * index:9, ThreadName:main
     * index:5, ThreadName:pool-1-thread-3
     * index:8, ThreadName:pool-1-thread-1
     * index:6, ThreadName:pool-1-thread-2
     */

    /**
     * workQueue类型为：ArrayBlockingQueue，拒绝策略：AbortPolicy，运行结果为：
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
     *
     * ~ 拒绝策略：CallerRunsPolicy，运行结果为:
     * index:6, ThreadName:pool-1-thread-3
     * index:8, ThreadName:main
     * index:7, ThreadName:pool-1-thread-4
     * index:0, ThreadName:pool-1-thread-1
     * index:1, ThreadName:pool-1-thread-2
     * index:2, ThreadName:pool-1-thread-3
     * index:4, ThreadName:pool-1-thread-1
     * index:3, ThreadName:pool-1-thread-4
     * index:5, ThreadName:pool-1-thread-2
     * index:9, ThreadName:pool-1-thread-3
     *
     *  ~ 拒绝策略：DiscardOldestPolicy，运行结果为:
     * index:7, ThreadName:pool-1-thread-4
     * index:0, ThreadName:pool-1-thread-1
     * index:6, ThreadName:pool-1-thread-3
     * index:1, ThreadName:pool-1-thread-2
     * index:4, ThreadName:pool-1-thread-4
     * index:9, ThreadName:pool-1-thread-2
     * index:8, ThreadName:pool-1-thread-3
     * index:5, ThreadName:pool-1-thread-1
     */

    /**
     * workQueue类型为：LinkedBlockingQueue，拒绝策略：AbortPolicy，运行结果为：
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
     * workQueue类型为：PriorityBlockingQueue时，拒绝策略：AbortPolicy，运行结果为：
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
