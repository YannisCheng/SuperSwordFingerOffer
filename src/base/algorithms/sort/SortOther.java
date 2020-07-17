package base.algorithms.sort;

import java.util.Arrays;

/**
 * SortOther 排序 - 其他
 * 1、计数排序（必学）
 * 2、希尔排序
 *
 * <p>
 * 计数排序，两个前提需要满足：
 * 1. 是需要排序的元素必须是整数；
 * 2. 是排序元素的取值要在一定范围内，并且比较集中。
 * 只有这两个条件都满足，才能最大程度发挥计数排序的优势。
 * </P>
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 16:37
 */
public class SortOther {
    public static final int[] num = {30, 50, 25, 44, 29, 20, 34, 37, 23};

    public static void main(String[] args) {
        //countSort1QueryMax(num);
        countSort2QueryMaxAndMin(num);
    }

    /**
     * 第1种版本：存在'100-109'范围时，前'0-99'的空间浪费了。
     *
     * @param ints 。
     */
    private static void countSort1QueryMax(int[] ints) {
        int maxInt = Integer.MIN_VALUE;
        // 第1步，取数组中的最大值
        for (int item : ints) {
            maxInt = Math.max(maxInt, item);
        }
        System.out.println("查找 max value is = " + maxInt);

        // 第2步，创建计数数组
        int[] countArray = new int[maxInt + 1];

        // 第3步，为计数数组赋值
        for (int item : ints) {
            countArray[item]++;
            System.out.printf("countArray[%d]=%d\n", item, countArray[item]);
            System.out.println("当前排序结果：" + Arrays.toString(countArray));
        }
        System.out.println("最终统计数组：" + Arrays.toString(countArray));
        // 第4步，创建结果数组
        int[] result = new int[ints.length];
        int resultIndex = 0;
        for (int i = 0; i < countArray.length; i++) {
            System.out.println("value=" + countArray[i] + ", i=" + i);
            while (countArray[i] > 0) {
                result[resultIndex++] = i;
                countArray[i]--;
            }
        }
        System.out.println("排序结果数组：" + Arrays.toString(result));
    }

    /**
     * 第2种版本：解决第1种版本中存在缺陷，即：当存在'100-109'范围时，前'0-99'的空间浪费了。
     *
     * @param ints .
     */
    private static void countSort2QueryMaxAndMin(int[] ints) {

        int maxInt = Integer.MIN_VALUE;
        // 获取最小值
        int minInt = Integer.MAX_VALUE;
        // 第1步，取数组中的最大值
        for (int item : ints) {
            maxInt = Math.max(maxInt, item);
            minInt = Math.min(minInt, item);
        }
        System.out.println("查找 max value is = " + maxInt);
        System.out.println("查找 min value is = " + minInt);
        System.out.println("maxInt - minInt + 1 = " + (maxInt - minInt + 1));

        // 第2步，创建计数数组
        int[] countArray = new int[maxInt - minInt + 1];

        // 第3步，为计数数组赋值
        for (int item : ints) {
            // 注意：
            // 此处countArray[]的index是原数组中的元素。
            // 但是countArray[]的长度已经是经过"maxInt - minInt + 1"处理的。因此如果直接存放元数组的元素中较大的值就会发生"数组越界"异常。
            // 所以：需要存放元素的（item - minInt）值，以保持和数组长度的统一。
            countArray[item - minInt]++;
            System.out.printf("countArray[%d]=%d\n", item - minInt, countArray[item - minInt]);
            System.out.println("当前排序结果：" + Arrays.toString(countArray));
        }
        System.out.println("最终统计数组：" + Arrays.toString(countArray));

        // 第4步，创建结果数组
        int[] result = new int[ints.length];
        int resultIndex = 0;
        for (int i = 0; i < countArray.length; i++) {
            System.out.println("value=" + countArray[i] + ", i=" + i);
            while (countArray[i] > 0) {
                // 注意：
                // 此处对应于 第3步 中的（-minInt）操作。在输出数据阶段必须要恢复"原"元素的大小。，
                result[resultIndex++] = i + minInt;
                countArray[i]--;
            }
        }
        System.out.println("排序结果数组：" + Arrays.toString(result));
    }

    /*
     * version1SingleMaxValue() 运行结果：
     * 查找 max value is = 50
     * countArray[30]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     * countArray[50]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
     * countArray[25]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
     * countArray[44]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * countArray[29]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * countArray[20]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * countArray[34]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * countArray[37]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * countArray[23]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * 最终统计数组：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * value=0, i=0
     * value=0, i=1
     * value=0, i=2
     * value=0, i=3
     * value=0, i=4
     * value=0, i=5
     * value=0, i=6
     * value=0, i=7
     * value=0, i=8
     * value=0, i=9
     * value=0, i=10
     * value=0, i=11
     * value=0, i=12
     * value=0, i=13
     * value=0, i=14
     * value=0, i=15
     * value=0, i=16
     * value=0, i=17
     * value=0, i=18
     * value=0, i=19
     * value=1, i=20
     * value=0, i=21
     * value=0, i=22
     * value=1, i=23
     * value=0, i=24
     * value=1, i=25
     * value=0, i=26
     * value=0, i=27
     * value=0, i=28
     * value=1, i=29
     * value=1, i=30
     * value=0, i=31
     * value=0, i=32
     * value=0, i=33
     * value=1, i=34
     * value=0, i=35
     * value=0, i=36
     * value=1, i=37
     * value=0, i=38
     * value=0, i=39
     * value=0, i=40
     * value=0, i=41
     * value=0, i=42
     * value=0, i=43
     * value=1, i=44
     * value=0, i=45
     * value=0, i=46
     * value=0, i=47
     * value=0, i=48
     * value=0, i=49
     * value=1, i=50
     * 排序结果数组：[20, 23, 25, 29, 30, 34, 37, 44, 50]
     *
     */

    /*
     * 第2种方式结果：
     * 查找 max value is = 50
     * 查找 min value is = 20
     * maxInt - minInt + 1 = 31
     * countArray[10]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     * countArray[30]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
     * countArray[5]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
     * countArray[24]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * countArray[9]=1
     * 当前排序结果：[0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * countArray[0]=1
     * 当前排序结果：[1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * countArray[14]=1
     * 当前排序结果：[1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * countArray[17]=1
     * 当前排序结果：[1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * countArray[3]=1
     * 当前排序结果：[1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * 最终统计数组：[1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
     * value=1, i=0
     * value=0, i=1
     * value=0, i=2
     * value=1, i=3
     * value=0, i=4
     * value=1, i=5
     * value=0, i=6
     * value=0, i=7
     * value=0, i=8
     * value=1, i=9
     * value=1, i=10
     * value=0, i=11
     * value=0, i=12
     * value=0, i=13
     * value=1, i=14
     * value=0, i=15
     * value=0, i=16
     * value=1, i=17
     * value=0, i=18
     * value=0, i=19
     * value=0, i=20
     * value=0, i=21
     * value=0, i=22
     * value=0, i=23
     * value=1, i=24
     * value=0, i=25
     * value=0, i=26
     * value=0, i=27
     * value=0, i=28
     * value=0, i=29
     * value=1, i=30
     * 排序结果数组：[20, 23, 25, 29, 30, 34, 37, 44, 50]
     */
}
