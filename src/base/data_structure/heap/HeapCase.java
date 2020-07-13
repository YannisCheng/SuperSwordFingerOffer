package base.data_structure.heap;

import java.util.Arrays;

/**
 * HeapCase 数据结构 - 堆
 * 关键：数组index与二叉树位置关系的映射关系
 * "堆"数据结构操作：
 * 1、建堆
 * 2、删除堆中元素
 *
 * "堆排序"：
 * 1、建堆
 * 2、移除元素
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/7/10 16:10
 */
public class HeapCase {

    public static void main(String[] args) {
        //test();
        sort();
    }

    private static void sort() {
        int[] temp = {2, 5, 1, 9, 0, 4, 6, 3};
        HeapCase heapCase = new HeapCase(temp.length);
        for (int i = 0; i < temp.length; i++) {
            heapCase.insert(temp[i]);
        }

        for (int i = 0; i < heapCase.data.length; i++) {
            heapCase.removeMax();
        }
    }

    private static void test() {
        int[] temp = {2, 5, 1, 9, 0, 4, 6, 3};
        HeapCase heapCase = new HeapCase(temp.length);
        for (int i = 0; i < temp.length; i++) {
            heapCase.insert(temp[i]);
        }
        System.out.println(Arrays.toString(heapCase.getTempArr()));

        heapCase.removeMax();
        System.out.println(Arrays.toString(heapCase.getTempArr()));
        heapCase.removeMax();
        System.out.println(Arrays.toString(heapCase.getTempArr()));
    }

    /**
     * "堆" 数据结构容器
     */
    private int[] data;

    /**
     * "堆" 数据结构容器的容量
     */
    private int allNum;

    /**
     * "堆" 中已经存放的元素数量（下标：index）
     */
    private int currentNum;

    public HeapCase(int allNum) {
        // 构建 "堆" 数据结构时，下标index是从1开始的，因此要将规定的的数组容量+1
        data = new int[allNum + 1];
        this.allNum = allNum;
        // 下标index是从1开始的
        currentNum = 1;
    }

    /**
     * 插入单个数值
     * -> 构造"堆"数据结构
     */
    public void insert(int item) {
        if (currentNum > allNum) {
            return;
        }
        //先将节点插入堆尾
        data[currentNum] = item;
        int tempIndex = currentNum;
        System.out.print(tempIndex + ",i/2=" + (tempIndex / 2));
        //再自下向上堆化，直到堆顶或者父节点比子节点大为止
        System.out.printf(", data[%d]=%d, data[%d]=%d\n", tempIndex, data[tempIndex], tempIndex / 2, data[tempIndex / 2]);
        while (tempIndex / 2 > 0 && data[tempIndex] > data[tempIndex / 2]) {
            //交换位置
            int temp = data[tempIndex / 2];
            data[tempIndex / 2] = data[tempIndex];
            data[tempIndex] = temp;
            System.out.println("swap: " + Arrays.toString(data));
            //更新下标
            tempIndex = tempIndex / 2;
        }
        currentNum++;

        /*
         * 1,i/2=0, data[1]=2, data[0]=0
         * 2,i/2=1, data[2]=5, data[1]=2
         * swap: [0, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0]
         * 3,i/2=1, data[3]=1, data[1]=5
         * 4,i/2=2, data[4]=9, data[2]=2
         * swap: [0, 5, 9, 1, 2, 0, 0, 0, 0, 0, 0]
         * swap: [0, 9, 5, 1, 2, 0, 0, 0, 0, 0, 0]
         * 5,i/2=2, data[5]=0, data[2]=5
         * 6,i/2=3, data[6]=4, data[3]=1
         * swap: [0, 9, 5, 4, 2, 0, 1, 0, 0, 0, 0]
         * 7,i/2=3, data[7]=6, data[3]=4
         * swap: [0, 9, 5, 6, 2, 0, 1, 4, 0, 0, 0]
         * 8,i/2=4, data[8]=3, data[4]=2
         * swap: [0, 9, 5, 6, 3, 0, 1, 4, 2, 0, 0]
         * [0, 9, 5, 6, 3, 0, 1, 4, 2, 0, 0]
         */
    }

    public int[] getTempArr() {
        return data;
    }

    public void removeMax() {
        if (currentNum == 1) {
            return;
        }
        System.out.println("移除元素："+data[1]);
        currentNum--;
        data[1] = data[currentNum];
        data[currentNum] = 0;
        heapIfy(data, currentNum, 1);
        System.out.println(currentNum);
    }

    private void heapIfy(int[] data, int n, int i) {
        while (true) {
            int currentMax = i;
            if (2 * i <= n && data[i] < data[2 * i]) {
                currentMax = 2 * i;
            }

            if (2 * i + 1 <= n && data[currentMax] < data[2 * i + 1]) {
                currentMax = 2 * i + 1;
            }
            if (currentMax == i) {
                break;
            }

            int temp = data[i];
            data[i] = data[currentMax];
            data[currentMax] = temp;

            i = currentMax;
        }
        /*
         * 运行结果：
         * 移除元素：9
         * 8
         * [0, 6, 5, 4, 3, 0, 1, 2, 0]
         * 移除元素：6
         * 7
         * [0, 5, 3, 4, 2, 0, 1, 0, 0]
         */
    }
}
