package base.algorithms;

import java.util.Arrays;

/**
 * ExercisePad 算法练手板
 *
 * @author yannischeng  cwj1714@163.com
 * @date 2020/6/28 - 16:55
 */
public class ExercisePad {
    private static final int[] ARR = {3, 5, 1, 9, 6, 8, 4, 7, 2};
    private static final int[] TEMP = new int[ARR.length];

    public static void main(String[] args) {
        mergeSort(ARR, 0, ARR.length - 1, TEMP);

    }

    private static void mergeSort(int[] num, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(num, left, mid, temp);
            mergeSort(num, mid + 1, right, temp);
            merge(num, left, right, mid, temp);
        }
    }

    private static void merge(int[] num, int left, int right, int mid, int[] temp) {
        int leftStart = left;
        int rightStart = mid + 1;
        int tempIndex = 0;

        while (leftStart <= mid && rightStart <= right) {
            if (num[leftStart] < num[rightStart]) {
                temp[tempIndex++] = num[leftStart++];
            } else {
                temp[tempIndex++] = num[rightStart++];
            }
        }

        while (leftStart <= mid) {
            temp[tempIndex++] = num[leftStart++];
        }

        while (rightStart <= right) {
            temp[tempIndex++] = num[rightStart++];
        }

        // ---- 运行到此处的结果是：将[left-right]index范围内的数据进行排序，结果存放在temp[]中 ----

        tempIndex = 0;
        while (left <= right) {
            num[left++] = temp[tempIndex++];
        }
        showSort();
    }

    public static void showSingleSort(int i) {
        System.out.println("第" + (i + 1) + "次的结果为：" + Arrays.toString(ARR));
    }

    public static void showSort() {
        System.out.println(Arrays.toString(ARR));
    }
}
