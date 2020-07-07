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

    public static void main(String[] args) {
        chooseSort(ARR);

    }

    private static void chooseSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i;
            while (index>0 && temp < arr[index-1]) {
                arr[index]= arr[index-1];
                index--;
            }
            arr[index] = temp;
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
