# 排序算法总结

[常用十大排序算法总结](https://blog.csdn.net/MLcongcongAI/article/details/88081244?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase)

[九大排序算法再总结](https://blog.csdn.net/MLcongcongAI/article/details/88081244?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase)

 排序的分类方式：
 
 - 比较（非线性时间比较类排序）：冒泡、选择、插入、快速排序、归并排序、堆排序、希尔排序
 - 非比较（线性时间非比较类排序）：计数排序、基数排序、桶排序
 
 概念：
 
 - 稳定：如果a原本在b前面，且a=b，排序之后 a 仍然在 b 的前面。
 - 不稳定：如果a原本在b的前面，且a=b，排序之后 a 可能会出现在 b 的后面。

## 算法策略

 - *分治(Divide and Conquer)*

 - *归并(Merge)*

 - *递归(Recursive)*
 
 ### 分治法
 
 #### 释义
 
 把一个复杂的问题分解成 两个 或 多个相同或相似 的子问题，再把子问题分成更小的子问题……直到最后子问题可以简单的 直接求解（各个击破）。那么原问题的解即子问题的解的合并。
 
 #### 步骤
 
 1. *分*：（原问题）分解（子问题）
 2. *治*：求（子问题）解
 3. 合并（子问题解）
 
 #### "分"的策略
 
 把原问题P分解成K个规模较小的子问题，这个步骤是分支算法的基础和关键。需要遵循两个原则：
 
 1. 平衡子问题原则：分解出的k个子问题规模最好大致相当；
 2. 独立子问题原则：分解出的k个子问题之间重叠越少越好，最好k个子问题相互独立，不存在重叠子问题。

## /sort文件夹中的文件说明

 -- SortSimple           —— 简单排序：冒泡排序(Bubble Sort)√、选择排序(Selection Sort)、插入排序(Insertion Sort)
 -- SortDivideAndConquer —— 分治排序：快速排序(Quick Sort)（关注中轴的选取方式）、归并排序(Merge Sort)√
 -- SortDistribution     —— 分配排序：桶排序(Bucket Sort)、基数排序(Radix Sort)
 -- SortTreeShape        —— 树状排序：堆排序(Heap Sort)√
 -- SortOther            —— 其他排序：计数排序(Counting Sort)√、希尔排序(Shell Sort)
                       
