package base.algorithms.sort;

import java.util.Arrays;

/**
 * SortDivideAndConquer 排序 - 分治
 * 1、快速排序（关注中轴的选取方式）
 * 2、归并排序
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 16:34
 */
public class SortDivideAndConquer {

    public static final int[] num = {3, 5, 1, 9, 6, 8, 4, 7, 2};
    public static final int[] temp = new int[num.length];
    private static int count = 0;

    public static void main(String[] args) {

        //System.out.println("result is :" + dcSum(num, 0, num.length - 1));

        // 最大子序列求和问题。
        // aboutMaxChildSubsequence();
        // 归并排序
        //sort(num, 0, num.length - 1, temp);
        System.out.println("array is : " + Arrays.toString(num));
        sort2(num, 0, num.length - 1, temp);
    }

    private static void sort(int[] num, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            System.out.println("mid --> " + mid);
            System.out.println("left: " + left + ",mid: " + mid);
            sort(num, left, mid, temp);
            System.out.println("(mid+1): " + (mid + 1) + ",right: " + right);
            sort(num, mid + 1, right, temp);
            merge(num, left, mid, right, temp);
        }
    }

    private static void sort2(int[] num, int left, int right, int[] temp) {
        System.out.printf("oLeft=%d,oRight=%d -> ", left, right);
        if (left < right) {
            count++;
            System.out.printf("count=%d : ", count);
            int mid = (left + right) / 2;
            System.out.printf("left=%d,right=%d,mid--> %d ", left, right, mid);
            for (int i = left; i < mid; i++) {
                System.out.printf("num[%d]=%d, ", i, num[i]);
            }
            System.out.println();
            sort2(num, left, mid, temp);
            sort2(num, mid + 1, right, temp);
            System.out.println();
            merge(num, left, mid, right, temp);
        }
    }

    private static void merge(int[] num, int left, int mid, int right, int[] temp) {
        System.out.println("-----merge()------,left:" + left + ", right:" + right + ", mid:" + mid + ", mid+1:" + (mid + 1));
        // 治：左侧开始的位置
        int leftStart = left;
        // 治：右侧开始的位置
        int rightStart = mid + 1;
        // 记录每个小单位的排序结果
        int tempIndex = 0;

        // 如果拆分后左右2侧的数据都还存在。那么就比较"左右2侧"中的数据的大小
        while (leftStart <= mid && rightStart <= right) {
            // 比较两块数据的大小，然后赋值，并且移动下标
            System.out.printf("num[%d]=%d, num[%d]=%d\n",leftStart,num[leftStart],rightStart,num[rightStart]);
            if (num[leftStart] < num[rightStart]) {
                System.out.println("&&-- <");
                // 先赋值，再执行++,
                // temp[tempIndex++] = num[leftStart++] 等价于：
                // temp[tempIndex] = num[leftStart]
                // tempIndex++;
                // leftStart++
                temp[tempIndex++] = num[leftStart++];
            } else {
                System.out.println("&&-- >");
                temp[tempIndex++] = num[rightStart++];
            }
        }
        System.out.println("&& temp array is : " + Arrays.toString(temp));

        // 在只有左侧的数据块中，进行排序
        // 直接赋值到记录下标
        while (leftStart <= mid) {
            System.out.printf("leftStart <= mid: leftStart=%d, mid=%d\n",leftStart,mid);
            temp[tempIndex++] = num[leftStart++];
            System.out.println("leftStart <= mid --> temp array is : " + Arrays.toString(temp));
        }

        // 在只有右侧的数据块中，进行排序
        // 直接赋值到记录下标
        while (rightStart <= right) {
            System.out.printf("rightStart <= right: right=%d, mid=%d\n",rightStart,right);
            temp[tempIndex++] = num[rightStart++];
            System.out.println("rightStart <= right --> temp array is : " + Arrays.toString(temp));
        }

        System.out.println("temp array is : " + Arrays.toString(temp));
        // ---- 运行到此处的结果是：将[left-right]index范围内的数据进行排序，结果存放在tempIndex[]中 ----
        tempIndex = 0;
        while (left <= right) {
            System.out.printf("left <= right:num[%d]=%d\n", left, temp[tempIndex]);
            num[left++] = temp[tempIndex++];
        }
        System.out.println("num array is : " + Arrays.toString(num));
        /**
         * 运行结果：
         * array is : [3, 5, 1, 9, 6, 8, 4, 7, 2]
         * oLeft=0,oRight=8 -> count=1 : left=0,right=8,mid--> 4 num[0]=3, num[1]=5, num[2]=1, num[3]=9,
         * oLeft=0,oRight=4 -> count=2 : left=0,right=4,mid--> 2 num[0]=3, num[1]=5,
         * oLeft=0,oRight=2 -> count=3 : left=0,right=2,mid--> 1 num[0]=3,
         * oLeft=0,oRight=1 -> count=4 : left=0,right=1,mid--> 0
         * oLeft=0,oRight=0 -> oLeft=1,oRight=1 ->
         * -----merge()------,left:0, right:1, mid:0, mid+1:1
         * temp array is : [3, 5, 0, 0, 0, 0, 0, 0, 0]
         * left <= right:num[0]=3
         * left <= right:num[1]=5
         * num array is : [3, 5, 1, 9, 6, 8, 4, 7, 2]
         * oLeft=2,oRight=2 ->
         * -----merge()------,left:0, right:2, mid:1, mid+1:2
         * temp array is : [1, 3, 5, 0, 0, 0, 0, 0, 0]
         * left <= right:num[0]=1
         * left <= right:num[1]=3
         * left <= right:num[2]=5
         * num array is : [1, 3, 5, 9, 6, 8, 4, 7, 2]
         * oLeft=3,oRight=4 -> count=5 : left=3,right=4,mid--> 3
         * oLeft=3,oRight=3 -> oLeft=4,oRight=4 ->
         * -----merge()------,left:3, right:4, mid:3, mid+1:4
         * temp array is : [6, 9, 5, 0, 0, 0, 0, 0, 0]
         * left <= right:num[3]=6
         * left <= right:num[4]=9
         * num array is : [1, 3, 5, 6, 9, 8, 4, 7, 2]
         *
         * -----merge()------,left:0, right:4, mid:2, mid+1:3
         * temp array is : [1, 3, 5, 6, 9, 0, 0, 0, 0]
         * left <= right:num[0]=1
         * left <= right:num[1]=3
         * left <= right:num[2]=5
         * left <= right:num[3]=6
         * left <= right:num[4]=9
         * num array is : [1, 3, 5, 6, 9, 8, 4, 7, 2]
         * oLeft=5,oRight=8 -> count=6 : left=5,right=8,mid--> 6 num[5]=8,
         * oLeft=5,oRight=6 -> count=7 : left=5,right=6,mid--> 5
         * oLeft=5,oRight=5 -> oLeft=6,oRight=6 ->
         * -----merge()------,left:5, right:6, mid:5, mid+1:6
         * temp array is : [4, 8, 5, 6, 9, 0, 0, 0, 0]
         * left <= right:num[5]=4
         * left <= right:num[6]=8
         * num array is : [1, 3, 5, 6, 9, 4, 8, 7, 2]
         * oLeft=7,oRight=8 -> count=8 : left=7,right=8,mid--> 7
         * oLeft=7,oRight=7 -> oLeft=8,oRight=8 ->
         * -----merge()------,left:7, right:8, mid:7, mid+1:8
         * temp array is : [2, 7, 5, 6, 9, 0, 0, 0, 0]
         * left <= right:num[7]=2
         * left <= right:num[8]=7
         * num array is : [1, 3, 5, 6, 9, 4, 8, 2, 7]
         *
         * -----merge()------,left:5, right:8, mid:6, mid+1:7
         * temp array is : [2, 4, 7, 8, 9, 0, 0, 0, 0]
         * left <= right:num[5]=2
         * left <= right:num[6]=4
         * left <= right:num[7]=7
         * left <= right:num[8]=8
         * num array is : [1, 3, 5, 6, 9, 2, 4, 7, 8]
         *
         * -----merge()------,left:0, right:8, mid:4, mid+1:5
         * temp array is : [1, 2, 3, 4, 5, 6, 7, 8, 9]
         * left <= right:num[0]=1
         * left <= right:num[1]=2
         * left <= right:num[2]=3
         * left <= right:num[3]=4
         * left <= right:num[4]=5
         * left <= right:num[5]=6
         * left <= right:num[6]=7
         * left <= right:num[7]=8
         * left <= right:num[8]=9
         * num array is : [1, 2, 3, 4, 5, 6, 7, 8, 9]
         *
         * 小范围比较过程：
         * array is : [3, 5, 1]
         * oLeft=0,oRight=2 -> count=1 : left=0,right=2,mid--> 1 num[0]=3,
         * oLeft=0,oRight=1 -> count=2 : left=0,right=1,mid--> 0
         * oLeft=0,oRight=0 -> oLeft=1,oRight=1 ->
         * -----merge()------,left:0, right:1, mid:0, mid+1:1
         * num[0]=3, num[1]=5
         * &&-- <
         * && temp array is : [3, 0, 0]
         * rightStart <= right: right=1, mid=1
         * rightStart <= right --> temp array is : [3, 5, 0]
         * temp array is : [3, 5, 0]
         * left <= right:num[0]=3
         * left <= right:num[1]=5
         * num array is : [3, 5, 1]
         * oLeft=2,oRight=2 ->
         * -----merge()------,left:0, right:2, mid:1, mid+1:2
         * num[0]=3, num[2]=1
         * &&-- >
         * && temp array is : [1, 5, 0]
         * leftStart <= mid: leftStart=0, mid=1
         * leftStart <= mid --> temp array is : [1, 3, 0]
         * leftStart <= mid: leftStart=1, mid=1
         * leftStart <= mid --> temp array is : [1, 3, 5]
         * temp array is : [1, 3, 5]
         * left <= right:num[0]=1
         * left <= right:num[1]=3
         * left <= right:num[2]=5
         * num array is : [1, 3, 5]
         */
    }

    /**
     * 最大子序列求和问题。
     * 参考：https://blog.csdn.net/zzl913657644/article/details/52431011?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase
     */
    private static void aboutMaxChildSubsequence() {
        exhaustive(num);
    }

    /**
     * 暴力穷举法
     */
    private static void exhaustive(int[] an) {

        // 数组中的3个连续相连的数据组成的序列中，取序列和最大的一个。
        // continuousOrder(an);

        // 各种序列中的取最大值
        //allContinuousOrder(an);
        allContinuousOrder2(an);
    }

    private static void continuousOrder(int[] an) {
        int max = 0;
        int index1 = 0, index2 = 0, index3 = 0;
        for (int i = 0; i < an.length - 2; i++) {
            System.out.printf("a[%d] + a[%d] +a[%d] = %d", i, i + 1, i + 2, (an[i] + an[i + 1] + an[i + 2]));
            System.out.println();
            int thisMax = an[i] + an[i + 1] + an[i + 2];
            if (max < thisMax) {
                max = thisMax;
                index1 = i;
                index2 = i + 1;
                index3 = i + 2;
            }
        }

        System.out.printf("max value is : %d,index1 = %d,index2 = %d,index3 = %d", max, index1, index2, index3);
        /*
         * a[0] + a[1] +a[2] = 9
         * a[1] + a[2] +a[3] = 15
         * a[2] + a[3] +a[4] = 16
         * a[3] + a[4] +a[5] = 23
         * a[4] + a[5] +a[6] = 18
         * a[5] + a[6] +a[7] = 19
         * a[6] + a[7] +a[8] = 13
         * max value is : 23,index1 = 3,index2 = 4,index3 = 5
         */
    }

    private static void allContinuousOrder(int[] an) {
        int maxValue = 0;
        for (int i = 0; i < an.length; i++) {
            System.out.println("count i is : " + i);
            for (int j = i; j < j + 2; j++) {
                System.out.println("current index j is : " + j);
                int thisMax = 0;
                for (int k = i; k < j; k++) {
                    System.out.println("add k is : " + k);
                    thisMax += an[k];
                    System.out.println("thisMax is : " + thisMax);
                }
                if (maxValue < thisMax) {
                    maxValue = thisMax;
                }
            }
        }
        System.out.println("maxValue is : " + maxValue);
    }

    private static void allContinuousOrder2(int[] an) {
        int maxValue = 0;
        for (int i = 0; i < an.length; i++) {
            System.out.println("count i ---> " + i);
            int thisMax = 0;
            for (int j = i; j < an.length; j++) {
                System.out.println("current j is : " + j);
                thisMax += an[j];
                System.out.println("thisMax is : " + thisMax);
            }
            if (maxValue < thisMax) {
                maxValue = thisMax;
            }
        }
        System.out.println("maxValue is : " + maxValue);
    }


    /**
     * 分治策略求和
     */
    private static int dcSum(int[] numArr, int left, int right) {
        count++;
        System.out.println("count --> " + count);
        System.out.println("left = " + left + ", right = " + right);
        if (numArr.length == 0) {
            throw new IllegalStateException("Array can not be Null");
        }

        if (left == right) {
            return numArr[left];
        }

        if (left == right - 1) {
            return numArr[left] + numArr[right];
        }

        int mid = (left + right) / 2;
        System.out.println("mid is : " + mid);

        return dcSum(num, left, mid) + dcSum(num, mid + 1, right);
        /*
         * 运行结果：
         * count --> 1
         * left = 0, right = 8
         * mid is : 4
         * count --> 2
         * left = 0, right = 4
         * mid is : 2
         * count --> 3
         * left = 0, right = 2
         * mid is : 1
         * count --> 4
         * left = 0, right = 1
         * count --> 5
         * left = 2, right = 2
         * count --> 6
         * left = 3, right = 4
         * count --> 7
         * left = 5, right = 8
         * mid is : 6
         * count --> 8
         * left = 5, right = 6
         * count --> 9
         * left = 7, right = 8
         * result is :45
         */
    }


}
