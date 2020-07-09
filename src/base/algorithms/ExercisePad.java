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
        quickSort(ARR, 0, ARR.length - 1);
        showSort();
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = arr[(start + end) / 2];

        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left<=right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right++;
            }
        }
    }

    public static void showSingleSort(int i) {
        System.out.println("第" + (i + 1) + "次的结果为：" + Arrays.toString(ARR));
    }

    public static void showSort() {
        System.out.println(Arrays.toString(ARR));
    }
}
