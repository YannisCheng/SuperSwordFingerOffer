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
    public static final int[] auk = new int[num.length];
    private static int count = 0;

    public static void main(String[] args) {

        //System.out.println("result is :" + dcSum(num, 0, num.length - 1));

        // 最大子序列求和问题。
        // aboutMaxChildSubsequence();
        // 归并排序
        sort(num, 0, num.length - 1, auk);
    }

    private static void sort(int[] num, int left, int right, int[] auk) {
        if (left < right) {
            int mid = (left + right) / 2;
            System.out.println("mid --> " + mid);
            System.out.println("left: " + left + ",mid: " + mid);
            sort(num, left, mid, auk);
            System.out.println("(mid+1): " + (mid + 1) + ",right: " + right);
            sort(num, mid + 1, right, auk);
            merge(num, left, mid, right, auk);
        }
    }

    private static void merge(int[] num, int left, int mid, int right, int[] auk) {
        int tempL = left;
        int tempR = mid + 1;
        int temp = 0;

        while (tempL <= mid && tempR <= right) {
            if (num[tempL] < num[tempR]) {
                auk[temp++] = num[tempL++];
            } else {
                auk[temp++] = num[tempR++];
            }
        }

        while (tempL <= mid) {
            auk[temp++] = num[tempL++];
            System.out.println("tempR <= right-<<<-"+num[tempL++]);
        }

        while (tempR <= right) {
            auk[temp++] = num[tempR++];
            System.out.println("tempR <= right->>>-"+num[tempR++]);
        }
        temp = 0;

        while (left <= right) {
            num[left++] = auk[temp++];
            System.out.println("auk[temp++]-->-->-"+auk[temp++]);
        }

        System.out.println("auk array is : " + Arrays.toString(auk));
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
