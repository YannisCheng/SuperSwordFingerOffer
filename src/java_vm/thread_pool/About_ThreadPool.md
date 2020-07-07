# 关于ThreadPool

2020-7-2 21:48:08 周四

参考：https://www.cnblogs.com/dafanjoy/p/9729358.html


## 概念

### Executors

- Executors.newCachedThreadPool() （无限线程池，具有自动线程回收）
- Executors.newFixedThreadPool(int) （固定大小的线程池）
- Executors.newSingleThreadExecutor()（单个后台线程）

### ThreadPoolExecutor

 corePoolSize   ：核心线程数（最小线程数），设置了 `allowCoreThreadTimeOut()`后核心线程会被销毁

 maximumPoolSize：最大线程数

 keepAliveTime  ：空闲线程存活时间

 unit           ：空闲线程存活时间单位

 workQueue      ：工作队列
                 - 直接提交队列：SynchronousQueue。没有容量，每执行一个插入操作就会阻塞，需要再执行一个删除操作才会被唤醒，反之每一个删除操作也都要等待对应的插入操作。
                 - 有界任务队列：ArrayBlockingQueue。需设置 "初始容量"。
                 - 无界任务队列：LinkedBlockingQueue。任务队列可以无限制的添加新的任务，最大线程数为corePoolSize值，此时maximumPoolSize的值是无效的，先进先出的规则
                 - 优先任务队列：PriorityBlockingQueue。特殊的无界队列，自定义规则，根据任务的优先级顺序先后执行

 threadFactory  ：线程工厂- 自定义

 handler        ：拒绝策略（处理线程池"超载"的情况）
                - AbortPolicy策略：该策略会直接抛出异常，阻止系统正常工作；
                - CallerRunsPolicy策略：如果线程池的线程数量达到上限，该策略会把任务队列中的任务放在调用者线程当中运行；
                - DiscardOledestPolicy策略：该策略会丢弃任务队列中最老的一个任务（也就是当前任务队列中最先被添加进去的，马上要被执行的那个任务）并尝试再次提交；
                - DiscardPolicy策略：该策略会默默丢弃无法处理的任务，不予任何处理。当然使用此策略，业务场景中需允许任务的丢失；
                
 ThreadPoolExecutor扩展:
 
 1. beforeExecute：线程池中任务运行前执行
 2. afterExecute：线程池中任务运行完毕后执行
 3. terminated：线程池退出后执行
 
## 使用

 
## 原理