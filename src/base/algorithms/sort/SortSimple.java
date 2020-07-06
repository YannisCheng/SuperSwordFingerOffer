package base.algorithms.sort;

import java.util.Arrays;

/**
 * SortSimple 排序 - 简单
 * 1、冒泡排序
 * 2、选择排序
 * 3、插入排序
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020-06-19 09:26:53 周五
 */
public class SortSimple {

    /**
     * 排序：01 - 冒泡
     */
    public static void sortMaoPao(int[] arrNum) {
        // 外层循环控制次数
        for (int i = 0; i < arrNum.length - 1; i++) {

            boolean isChange = false;
            // 内层循环进行相邻2个元素间的大小排序（因为在数组元素取值时需要使用：j + 1，所以要-1）
            for (int j = 0; j < arrNum.length - 1 - i; j++) {
                if (arrNum[j] > arrNum[j + 1]) {
                    int temp = arrNum[j];
                    arrNum[j] = arrNum[j + 1];
                    arrNum[j + 1] = temp;
                    isChange = true;
                }
            }

            if (!isChange) {
                System.out.println("提前结束：经过第" + (i + 1) + "轮选择后，数组为" + Arrays.toString(arrNum));
                return;
            }
            showSingleSort(i, arrNum);
        }
        showSort(arrNum);
    }

    /*
     * 排序：02 - 选择
     * 复杂度：n*n
     *
     * 顺序：从小到大
     */
    public static void sortChoose(int[] arrNum) {
        // 使用max记录当前的最大值
        int max = 0;
        // index记录最大元素的index
        int index = 0;
        // 外层控制循环次数
        for (int i = 0; i < arrNum.length - 1; i++) {
            // 内层将max的值依次与数组中的元素进行比较
            for (int j = 0; j < arrNum.length - i; j++) {
                if (max < arrNum[j]) {
                    max = arrNum[j];
                    index = j;
                }
            }

            // 每次选择完成后，max中存放的是第i次选出的最大值
            // 将max的元素与未排序数组的最后一位进行位置替换
            System.out.println("经过第" + (i + 1) + "轮选择后，当前max is：" + max);
            System.out.println("经过第" + (i + 1) + "轮选择后，当前index is：" + index);
            System.out.println("经过第" + (i + 1) + "轮选择后，当前temp is：" + arrNum[arrNum.length - 1 - i]);
            int temp = arrNum[arrNum.length - 1 - i];
            arrNum[arrNum.length - 1 - i] = max;
            arrNum[index] = temp;

            // 恢复初始状态
            max = 0;
            index = 0;
            showSingleSort(i, arrNum);
        }
        showSort(arrNum);
    }

    /**
     * 排序：03 - 插入
     * <p>
     * 参考：
     * https://www.cnblogs.com/xiaoming0601/p/5862793.html
     * https://blog.csdn.net/qq_28081081/article/details/80594386
     * <p>
     * 时间复杂度O(n2)
     * {3, 5, 1, 9, 6, 8, 4, 7, 2};
     */
    public static void sortInsertion(int[] arrNum) {
        int index = 0;
        int temp = 0;
        //假定第一个元素被放到了正确的位置上,
        //这样，仅需遍历下标："1 -> (n-1)"
        for (int i = 1; i < arrNum.length; i++) {
            // 4
            index = i;
            // 6
            temp = arrNum[i];
            while (index > 0 && temp < arrNum[index - 1]) {
                arrNum[index] = arrNum[index - 1];
                index--;
            }
            arrNum[index] = temp;
        }
        showSort(arrNum);
    }

    public static void showSingleSort(int i, int[] arr) {
        System.out.println("第" + (i + 1) + "次的排序结果为：" + Arrays.toString(arr));
    }

    public static void showSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
