package base.algorithms.sort;

import java.util.Arrays;

/**
 * SortOther 排序 - 其他
 * 1、计数排序（必学）
 * 2、希尔排序
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 16:37
 */
public class SortOther {
    public static final int[] num = {3, 5, 1, 9, 2, 1, 4, 7, 2};

    public static void main(String[] args) {
        countSort(num);
    }

    private static void countSort(int[] ints) {
        int maxInt = 0;
        // 第1步，取数组中的最大值
        for (int item : ints) {
            maxInt = Math.max(maxInt, item);
        }
        System.out.println("max int is = " + maxInt);

        // 第2步，创建计数数组
        int[] countArray = new int[maxInt + 1];

        // 第3步，为计数数组赋值
        for (int item : ints) {
            countArray[item]++;
            System.out.printf("countArray[%d]=%d\n",item,countArray[item]);
        }
        System.out.println("统计数组："+Arrays.toString(countArray));
        // 第4步，创建结果数组
        int[] result = new int[ints.length];
        int resultIndex = 0;
        for (int i = 0; i < countArray.length; i++) {
            System.out.println("value="+countArray[i]+", i="+i);
            while (countArray[i]>0) {
                result[resultIndex++] = i;
                countArray[i]--;
            }
        }
        System.out.println("结果数组："+Arrays.toString(result));

    }
}
