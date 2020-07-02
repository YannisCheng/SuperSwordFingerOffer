# 关于ThreadPool

2020-7-2 21:48:08 周四


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

 threadFactory  ：线程工厂

 handler        ：拒绝策略
 
## 使用

 
## 原理